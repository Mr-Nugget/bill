package com.dummy.myerp.consumer.dao.contrat;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

/**
 * Interface de DAO pour les accès à la table MYERP.compte_comptable
 * @author Titouan
 *
 */
public interface ICompteComptableDao {
	 /**
     * Renvoie la liste des Comptes Comptables
     * @return {@link List}
     */
    List<CompteComptable> getListCompteComptable();
}
