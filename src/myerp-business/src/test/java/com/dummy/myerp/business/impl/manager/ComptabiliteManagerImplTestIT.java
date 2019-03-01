package com.dummy.myerp.business.impl.manager;


import java.math.BigDecimal;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComptabiliteManagerImplTestIT {
	
	
	ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();

	@Test
	public void test1InsertEcritureComptable() throws FunctionalException {
		EcritureComptable ecritureTest = new EcritureComptable();
		ecritureTest.setDate(new Date());
		ecritureTest.setLibelle("Libelle Test");
		ecritureTest.setReference("TEST-2019/00001");
		ecritureTest.setJournal(new JournalComptable("TEST", "Libelle du journal Test"));
		
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
				null, new BigDecimal(123),
				null));
		ecritureTest.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
				null, null,
				new BigDecimal(123)));
		
		ecritureTest.setId(42);
		
		manager.insertEcritureComptable(ecritureTest);
		
	}
	
	@Test
	public void test2DeleteEcritureComptable() {
		manager.deleteEcritureComptable(42);
	}

}
