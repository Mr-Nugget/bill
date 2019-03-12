package com.dummy.myerp.consumer.dao.contrat;

import java.util.List;

import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;


/**
 * Interface de DAO pour les accès à la table MYERP.sequence_ecritre_comptable
 * @author Titouan
 *
 */
public interface ISequenceEcritureComptableDao {
	/**
	 * Renvoie la séquence associée au code journal et à l'année
	 * @param code
	 * @return sequenceEcritureComptable
	 */
	SequenceEcritureComptable getSequenceEcritureComptable(String code, Integer year);

	/**
	 * Renvoie la liste de toutes les séquences
	 * @return liste sequenceEcritureComptable
	 */
	List<SequenceEcritureComptable> getListSequenceEcritureComptable();

	/**
	 * Met à jour la séquence associée au code journal et à l'année
	 * @param code
	 */
	void updateSequenceEcritureComptable(String code, Integer year, Integer newValue);


	/**
	 * Insert une nouvelle sequence d'écriture dans la table
	 * @param sequence
	 */
	void insertSequenceEcritureComptable(String code, Integer year, Integer lastValue);

	/**
	 * Supprime une sequence par sa clef primaire (code journal et année)
	 * @param code
	 * @param year
	 */
	void deleteSequenceEcritureComptable(String code, Integer year);
}
