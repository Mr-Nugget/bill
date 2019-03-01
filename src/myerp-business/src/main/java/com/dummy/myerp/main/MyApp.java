package com.dummy.myerp.main;

import java.util.List;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.manager.ComptabiliteManagerImpl;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;

public class MyApp {

	public static void main(String[] args) {
		ComptabiliteManager manager = new ComptabiliteManagerImpl();
		
		List<EcritureComptable> lec = manager.getListEcritureComptable();
		
		
		for(EcritureComptable ec : lec) {
			System.out.println(ec);
		}
	}

}
