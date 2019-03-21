package com.dummy.myerp.business.impl.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dummy.myerp.business.contrat.manager.IJournalComptableManager;

public class JournalComptableManagerImplTestIT {

	// Load XML spring Bean configuration contexts
	private String[] contextArray = new String[] {"classpath:/com/dummy/myerp/consumer/applicationContext.xml", "classpath:/com/dummy/myerp/business/applicationContext.xml"};
	@SuppressWarnings("unused")
	private ApplicationContext context = new ClassPathXmlApplicationContext(contextArray);

	private IJournalComptableManager manager = new JournalComptableManagerImpl();

	@Test
	public final void test1getListJournalComptable() {
		assertFalse(manager.getListJournalComptable().isEmpty());
	}

}
