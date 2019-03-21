package com.dummy.myerp.business.impl.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.business.contrat.manager.ICompteComptableManager;

public class CompteComptableManagerImplTestIT {
	
	// Load XML spring Bean configuration contexts
	private String[] contextArray = new String[] {"classpath:/com/dummy/myerp/consumer/applicationContext.xml", "classpath:/com/dummy/myerp/business/applicationContext.xml"};
	@SuppressWarnings("unused")
	private ApplicationContext context = new ClassPathXmlApplicationContext(contextArray);
	
	private ICompteComptableManager manager = new CompteComptableManagerImpl();
	
	@Test
	public final void test1getListCompteComptable() {
		assertFalse(manager.getListCompteComptable().isEmpty());
	}
}
