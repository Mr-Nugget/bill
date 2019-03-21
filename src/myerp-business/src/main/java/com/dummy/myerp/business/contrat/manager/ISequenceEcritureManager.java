package com.dummy.myerp.business.contrat.manager;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

public interface ISequenceEcritureManager {
	
	/**
     * Renvoie la liste des séquences écritures comptables
     * @return {@link List}
     */
    List<SequenceEcritureComptable> getListSequenceEcritureComptable();
	/**
     * Renvoie la sequence associé à l'année et au code journal associé
     * @param annee
     * @param year
     * @return
     */
    SequenceEcritureComptable getSequenceEcritureComptable(String code, Integer year);
	
	/**
     * Supprime la séquence écriture associé au code journal et à l'année
     * @param code
     * @param annee
     */
    void deleteSequenceEcritureComptable(String code, Integer annee);
}
