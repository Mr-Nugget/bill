package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComptabiliteManagerImplTestIT {
	
	
	private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
	
	// Load XML spring Bean configuration contexts
	private String[] contextArray = new String[] {"classpath:/com/dummy/myerp/consumer/applicationContext.xml", "classpath:/com/dummy/myerp/business/applicationContext.xml"};
	@SuppressWarnings("unused")
	private ApplicationContext context = new ClassPathXmlApplicationContext(contextArray);
	
	private static Integer idTest;


	
	@Test
	public void test1InsertEcritureComptable() throws Exception{
		
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
		manager.insertEcritureComptable(ecritureTest);
		
		idTest = ecritureTest.getId();
	}
	
	@Test(expected=FunctionalException.class)
	public void test2CheckEcritureComptableRG6() throws Exception{
		
		EcritureComptable ecritureTest = new EcritureComptable();
		// Same reference
		ecritureTest.setReference("AC-2045/00007");
		
		manager.checkEcritureComptableContext(ecritureTest);
		
	}
	
	@Test
	public void test999deleteEcritureComptable() {
		manager.deleteEcritureComptable(idTest);
	}
	
}
