package com.dummy.myerp.main;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.consumer.dao.impl.DaoProxyImpl;
import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

public class TestDataSource {

	public static void main(String[] args) {
		
		
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("classpath:/com/dummy/myerp/consumer/applicationContext.xml");
		
		DaoProxy proxy = DaoProxyImpl.getInstance();
		
		List<CompteComptable> lcc = proxy.getCompteDao().getListCompteComptable();

		for(CompteComptable cc : lcc) {
			System.out.println(cc.toString());
		}
	}
	

}
