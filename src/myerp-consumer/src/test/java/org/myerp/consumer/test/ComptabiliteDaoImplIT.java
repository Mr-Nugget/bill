package org.myerp.consumer.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComptabiliteDaoImplIT {

	private ComptabiliteDaoImpl comptDAO = ComptabiliteDaoImpl.getInstance();
	@SuppressWarnings("unused")
	private ApplicationContext context = 
    		new ClassPathXmlApplicationContext("classpath:/com/dummy/myerp/consumer/applicationContext.xml");
	
	
	// ========================= CompteComptable ========================
	@Test
	public void getListCompteComptableTest() {
		List<CompteComptable> listeCC =  comptDAO.getListCompteComptable();
		assertFalse(listeCC.isEmpty());
	}
	
	
	// ==================== Sequence Ecriture Comptable ==================
	
	@Test
	public void Test2getSequenceEcritureCompotable() {
		SequenceEcritureComptable sEC = comptDAO.getSequenceEcritureComptable("AC", 2016);
		assertEquals(new Integer(2016), sEC.getAnnee());
		
		sEC = comptDAO.getSequenceEcritureComptable("", 0);
		
		assertEquals(null, sEC);
	}
	
	@Test
	public void Test1insertSequenceEcritureComptable() {
		comptDAO.insertSequenceEcritureComptable("AC", 2045, 12);
	}
	
	@Test
	public void Test3updateSequenceEcritureComptable() {
		comptDAO.updateSequenceEcritureComptable("AC", 2045, 4);
		
		SequenceEcritureComptable sEC = comptDAO.getSequenceEcritureComptable("AC", 2045);
		
		assertEquals(new Integer(4), sEC.getDerniereValeur());
	}
}
