package org.myerp.consumer.test;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

public class ComptabiliteDaoImplIT {

	private ComptabiliteDaoImpl comptDAO = ComptabiliteDaoImpl.getInstance();
	private ApplicationContext context = 
    		new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	// ========================= CompteComptable ========================
	@Test
	public void getListCompteComptableTest() {
		List<CompteComptable> listeCC =  comptDAO.getListCompteComptable();
		assertFalse(listeCC.isEmpty());
	}
	
	
	// ==================== Sequence Ecriture Comptable ==================
	
	@Test
	public void getSequenceEcritureCompotableTest() {
		SequenceEcritureComptable sEC = comptDAO.getSequenceEcritureComptable("AC", 2016);
		assertEquals(new Integer(2016), sEC.getAnnee());
		
		sEC = comptDAO.getSequenceEcritureComptable("", 0);
		
		assertEquals(null, sEC);
	}
	
	@Test
	public void insertSequenceEcritureComptableTest() {
		//comptDAO.insertSequenceEcritureComptable("AC", 2019, 12);
	}
	
	@Test
	public void updateSequenceEcritureComptableTest() {
		comptDAO.updateSequenceEcritureComptable("AC", 2019, 4);
	}
	

}
