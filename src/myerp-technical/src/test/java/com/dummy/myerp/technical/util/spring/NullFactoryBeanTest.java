package com.dummy.myerp.technical.util.spring;


import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NullFactoryBeanTest {
	
	private static NullFactoryBean<Integer> nullBean;
	
	@Test
	public final void test1NullFactoryBean() {
		nullBean = new NullFactoryBean<>(Integer.class);
	}

	@Test
	public final void test2GetObject() throws Exception {
		assertEquals(null, nullBean.getObject());
	}

	@Test
	public final void test3GetObjectType() {
		assertEquals(Integer.class, nullBean.getObjectType());
	}

	@Test
	public final void test4IsSingleton() {
		assertFalse(nullBean.isSingleton());
	}

}
