package com.dummy.myerp.consumer.dao.contrat;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
/**
 * Interface de DAO pour les accès à la table MYERP.journal_comptable
 * @author Titouan
 *
 */
public interface IJournalComptableDao {
	/**
     * Renvoie la liste des Journaux Comptables
     * @return {@link List}
     */
    List<JournalComptable> getListJournalComptable();
}
