package com.dummy.myerp.business.impl.manager;

import java.util.List;

import com.dummy.myerp.business.contrat.manager.ISequenceEcritureManager;
import com.dummy.myerp.business.impl.AbstractBusinessManager;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

public class SequenceEcritureManagerImpl extends AbstractBusinessManager implements ISequenceEcritureManager {

	@Override
	public List<SequenceEcritureComptable> getListSequenceEcritureComptable() {
		return getDaoProxy().getSequenceDao().getListSequenceEcritureComptable();
	}

	@Override
	public SequenceEcritureComptable getSequenceEcritureComptable(String code, Integer year) {
		return getDaoProxy().getSequenceDao().getSequenceEcritureComptable(code, year);
	}

	@Override
	public void deleteSequenceEcritureComptable(String code, Integer annee) {
		getDaoProxy().getSequenceDao().deleteSequenceEcritureComptable(code, annee);

	}

}
