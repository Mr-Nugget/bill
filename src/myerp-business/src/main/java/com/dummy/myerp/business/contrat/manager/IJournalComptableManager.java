package com.dummy.myerp.business.contrat.manager;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.JournalComptable;

public interface IJournalComptableManager {
	/**
     * Renvoie la liste des journaux comptables.
     *
     * @return {@link List}
     */
    List<JournalComptable> getListJournalComptable();
}
