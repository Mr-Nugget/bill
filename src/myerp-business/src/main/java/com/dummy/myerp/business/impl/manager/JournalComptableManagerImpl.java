package com.dummy.myerp.business.impl.manager;

import java.util.List;

import com.dummy.myerp.business.contrat.manager.IJournalComptableManager;
import com.dummy.myerp.business.impl.AbstractBusinessManager;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;

public class JournalComptableManagerImpl extends AbstractBusinessManager implements IJournalComptableManager {

	@Override
	public List<JournalComptable> getListJournalComptable() {
		return getDaoProxy().getJournalDao().getListJournalComptable();
	}

}
