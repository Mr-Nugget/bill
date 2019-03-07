package com.dummy.myerp.main;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

public class TestDataSource {

	@Inject
	@Named("dataSourceMYERP")
	public static DataSource ds;
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ComptabiliteDao cdao  = ComptabiliteDaoImpl.getInstance();
		
		List<CompteComptable> lcc = cdao.getListCompteComptable();

	}
	

}
