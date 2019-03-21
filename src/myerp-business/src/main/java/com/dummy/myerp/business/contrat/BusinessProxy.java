package com.dummy.myerp.business.contrat;

import com.dummy.myerp.business.contrat.manager.ICompteComptableManager;
import com.dummy.myerp.business.contrat.manager.IEcritureComptableManager;
import com.dummy.myerp.business.contrat.manager.IJournalComptableManager;
import com.dummy.myerp.business.contrat.manager.ISequenceEcritureManager;


/**
 * <p>Interface du Proxy d'accès à la couche Business</p>
 */
public interface BusinessProxy {

    // ==================== Managers ====================

    /**
     * Renvoie le manager EcritureComptable.
     *
     * @return IEcritureComptableManager
     */
    IEcritureComptableManager getEcritureComptableManager();
    /**
     * Renvoie le manager SequenceComptable.
     *
     * @return IJournalComptableManager
     */
    IJournalComptableManager getJournalComptableManager();
    /**
     * Renvoie le manager CompteComptable.
     *
     * @return ICompteComptableManager
     */
    ICompteComptableManager getCompteComptableManager();
    /**
     * Renvoie le manager SequenceEcritureComptable.
     *
     * @return ISequenceEcritureManager
     */
    ISequenceEcritureManager getSequenceEcritureManager();
}
