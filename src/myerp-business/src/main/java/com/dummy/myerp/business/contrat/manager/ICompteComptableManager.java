package com.dummy.myerp.business.contrat.manager;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

public interface ICompteComptableManager {
	/**
     * Renvoie la liste des comptes comptables.
     *
     * @return {@link List}
     */
    List<CompteComptable> getListCompteComptable();
}
