package com.dummy.myerp.business.impl.manager;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;

/** Les tests sont lancés dans un ordre précis, permettant de tester les methodes logiquement
 Un ajout en base, une mise a jour et en dernier lieux une suppression plus d'éventuelles méthode
 de "check" en fonction de la persistance

 @author Titouan
 **/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EcritureComptableManagerImplTestIT {


	private EcritureComptableManagerImpl ecritureManager = new EcritureComptableManagerImpl();
	private SequenceEcritureManagerImpl sequenceManager = new SequenceEcritureManagerImpl();

	// Load XML spring Bean configuration contexts
	private String[] contextArray = new String[] {"classpath:/com/dummy/myerp/consumer/applicationContext.xml", "classpath:/com/dummy/myerp/business/applicationContext.xml"};
	@SuppressWarnings("unused")
	private ApplicationContext context = new ClassPathXmlApplicationContext(contextArray);

	private static Integer idTest;
	private static int numberEcriture;

	@Test
	public void test1InsertEcritureComptable() throws Exception{

		numberEcriture = ecritureManager.getListEcritureComptable().size();

		EcritureComptable ecritureTest = new EcritureComptable();
		ecritureTest.setJournal(new JournalComptable("AC", "Test"));
		ecritureTest.setDate(new GregorianCalendar(2045, Calendar.MARCH, 12).getTime());
		ecritureTest.setLibelle("Libelle");
		ecritureTest.setReference("AC-2045/00007");
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
				null, new BigDecimal(123),
				null));
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
				null, null,
				new BigDecimal(123)));


		// Call checkEcritureComptable
		ecritureManager.insertEcritureComptable(ecritureTest);

		assertEquals(numberEcriture + 1, ecritureManager.getListEcritureComptable().size());

		idTest = ecritureTest.getId();
	}

	@Test(expected=FunctionalException.class)
	public void test2CheckEcritureComptableRG6() throws Exception{

		EcritureComptable ecritureTest = new EcritureComptable();
		// Same reference
		ecritureTest.setReference("AC-2045/00007");

		ecritureManager.checkEcritureComptableContext(ecritureTest);

	}
	
	@Test
	public void test3CheckEcritureComptableRG6() throws Exception{

		EcritureComptable ecritureTest = new EcritureComptable();
		// Unknown reference
		ecritureTest.setReference("");
		// Should not throw a functional exception
		ecritureManager.checkEcritureComptableContext(ecritureTest);
	}

	@Test
	public void test4addReference() {
		// Same ecriture 
		EcritureComptable ecritureTest = new EcritureComptable();
		ecritureTest.setJournal(new JournalComptable("AC", "Test"));
		ecritureTest.setDate(new GregorianCalendar(2045, Calendar.MARCH, 12).getTime());
		ecritureTest.setLibelle("Libelle");
		ecritureTest.setReference("AC-2045/00007");
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
				null, new BigDecimal(123),
				null));
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
				null, null,
				new BigDecimal(123)));

		ecritureManager.addReference(ecritureTest);

		// Get the new sequence associated to the ecritureTest saved into the DB
		SequenceEcritureComptable sequenceTest = 
				sequenceManager.getSequenceEcritureComptable(ecritureTest.getJournal().getCode(), 2045);

		// Insert the new sequence, there is no lastValue so it should be 1
		assertEquals(new Integer(1), sequenceTest.getDerniereValeur());
		// Same for the reference
		assertEquals("AC-2045/00001", ecritureTest.getReference());

		for(int i = 2; i < 11; i++) {
			ecritureManager.addReference(ecritureTest);
			sequenceTest = sequenceManager.getSequenceEcritureComptable(ecritureTest.getJournal().getCode(), 2045);

			assertEquals(new Integer(i), sequenceTest.getDerniereValeur());
			if(i >= 10) {
				assertEquals("AC-2045/000"+i, ecritureTest.getReference());
			}else {
				assertEquals("AC-2045/0000"+i, ecritureTest.getReference());
			}
		}

		sequenceManager.deleteSequenceEcritureComptable(ecritureTest.getJournal().getCode(), 2045);

	}
	
	@Test
	public void test5updateEcritureComptable() throws FunctionalException {
		EcritureComptable ecritureTest = new EcritureComptable();
		ecritureTest.setJournal(new JournalComptable("AC", "Test"));
		ecritureTest.setDate(new GregorianCalendar(2022, Calendar.MARCH, 12).getTime());
		ecritureTest.setLibelle("Nouveau Libelle");
		ecritureTest.setReference("AC-2022/00007");
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
				null, new BigDecimal(123),
				null));
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
				null, null,
				new BigDecimal(123)));
		ecritureTest.setId(idTest);
		
		ecritureManager.updateEcritureComptable(ecritureTest);
		
		List<EcritureComptable> lec = ecritureManager.getListEcritureComptable();
		
		for(EcritureComptable ec : lec) {
			if(ec.getId().equals(idTest)) {
				ecritureTest = ec;
			}
		}
		
		assertEquals("Nouveau Libelle", ecritureTest.getLibelle());
		assertEquals("AC-2022/00007", ecritureTest.getReference());
	}
	
	@Test
	public void test6deleteEcritureComptable() {
		// Delete the ecriture test
		ecritureManager.deleteEcritureComptable(idTest);

		assertEquals(numberEcriture, ecritureManager.getListEcritureComptable().size());

	}

}
