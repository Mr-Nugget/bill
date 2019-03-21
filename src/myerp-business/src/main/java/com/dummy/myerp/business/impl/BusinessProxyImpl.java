package com.dummy.myerp.business.impl;

import com.dummy.myerp.business.contrat.BusinessProxy;
import com.dummy.myerp.business.contrat.manager.ICompteComptableManager;
import com.dummy.myerp.business.contrat.manager.IEcritureComptableManager;
import com.dummy.myerp.business.contrat.manager.IJournalComptableManager;
import com.dummy.myerp.business.contrat.manager.ISequenceEcritureManager;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;


/**
 * <p>Implémentation du Proxy d'accès à la couche Business.</p>
 */
public class BusinessProxyImpl implements BusinessProxy {

    // ==================== Attributs Static ====================
    /** Le Proxy d'accès à la couche Consumer-DAO */
    private static DaoProxy daoProxy;


    // ==================== Attributs ====================
    /** The Comptabilite managers. */
    private ICompteComptableManager compteComptableManager;
    private IJournalComptableManager journalComptableManager;
    private IEcritureComptableManager ecritureComptableManager;
    private ISequenceEcritureManager sequenceEcritureManager;


    // ==================== Constructeurs ====================
    /** Instance unique de la classe (design pattern Singleton) */
    private static final BusinessProxyImpl INSTANCE = new BusinessProxyImpl();

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @return {@link BusinessProxyImpl}
     */
    protected static BusinessProxyImpl getInstance() {
        if (daoProxy == null) {
            throw new UnsatisfiedLinkError("La classe BusinessProxyImpl n'a pas été initialisée.");
        }
        return BusinessProxyImpl.INSTANCE;
    }

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @param pDaoProxy -
     * @param pTransactionManager -
     * @return {@link BusinessProxyImpl}
     */
    public static BusinessProxyImpl getInstance(DaoProxy pDaoProxy,
                                                TransactionManager pTransactionManager) {
        daoProxy = pDaoProxy;
        AbstractBusinessManager.configure(BusinessProxyImpl.INSTANCE, pDaoProxy, pTransactionManager);
        return BusinessProxyImpl.INSTANCE;
    }

    /**
     * Constructeur.
     */
    protected BusinessProxyImpl() {
        super();
    }


    // ==================== Getters/Setters ====================
	@Override
	public IEcritureComptableManager getEcritureComptableManager() {
		return ecritureComptableManager;
	}

	public void setEcritureComptableManager(IEcritureComptableManager ecritureComptableManager) {
		this.ecritureComptableManager = ecritureComptableManager;
	}

	@Override
	public IJournalComptableManager getJournalComptableManager() {
		return journalComptableManager;
	}

	public void setJournalComptableManager(IJournalComptableManager journalComptableManager) {
		this.journalComptableManager = journalComptableManager;
	}

	@Override
	public ICompteComptableManager getCompteComptableManager() {
		return compteComptableManager;
	}

	public void setCompteComptableManager(ICompteComptableManager compteComptableManager) {
		this.compteComptableManager = compteComptableManager;
	}

	@Override
	public ISequenceEcritureManager getSequenceEcritureManager() {
		return sequenceEcritureManager;
	}

	public void setSequenceEcritureManager(ISequenceEcritureManager sequenceEcritureManager) {
		this.sequenceEcritureManager = sequenceEcritureManager;
	}
}
