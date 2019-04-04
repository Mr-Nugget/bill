package com.dummy.myerp.consumer.dao.impl.dao;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.consumer.dao.impl.db.dao.SequenceEcritureComptableDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceEcritureComptableDaoImplIT {
	
	// Load XML spring Bean configuration contexts
	private String[] contextArray = new String[] {"classpath:/com/dummy/myerp/consumer/applicationContext.xml"};
	@SuppressWarnings("unused")
	private ApplicationContext context = new ClassPathXmlApplicationContext(contextArray);
	
	private static SequenceEcritureComptableDaoImpl dao = SequenceEcritureComptableDaoImpl.getInstance();
	private static int size = 0;

	// Test update and get
	@Test
	public final void test2UpdateSequenceEcritureComptable() {
		dao.updateSequenceEcritureComptable("AC", 2098, 29);
		assertEquals(new Integer(29), dao.getSequenceEcritureComptable("AC", 2098).getDerniereValeur());
	}

	// Test insert and getList
	@Test
	public final void test1InsertSequenceEcritureComptable() {
		
		size = dao.getListSequenceEcritureComptable().size();
		
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2098, 25);
		
		dao.insertSequenceEcritureComptable("AC", sequence.getAnnee(), sequence.getDerniereValeur());
		
		assertEquals(size + 1, dao.getListSequenceEcritureComptable().size());
				
	}
	
	// Test delete and getList
	@Test
	public final void test3DeleteSequenceEcritureComptable() {
		dao.deleteSequenceEcritureComptable("AC", 2098);
		
		assertEquals(size, dao.getListSequenceEcritureComptable().size());		
	}

}
