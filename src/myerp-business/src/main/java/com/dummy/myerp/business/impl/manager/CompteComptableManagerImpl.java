package com.dummy.myerp.business.impl.manager;

import java.util.List;

import com.dummy.myerp.business.contrat.manager.ICompteComptableManager;
import com.dummy.myerp.business.impl.AbstractBusinessManager;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

public class CompteComptableManagerImpl extends AbstractBusinessManager implements ICompteComptableManager{

	@Override
	public List<CompteComptable> getListCompteComptable() {
		return getDaoProxy().getCompteDao().getListCompteComptable();
	}

}
