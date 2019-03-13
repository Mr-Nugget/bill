package com.dummy.myerp.consumer.dao.impl;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.consumer.dao.contrat.ICompteComptableDao;
import com.dummy.myerp.consumer.dao.contrat.IEcritureComptableDao;
import com.dummy.myerp.consumer.dao.contrat.IJournalComptableDao;
import com.dummy.myerp.consumer.dao.contrat.ISequenceEcritureComptableDao;


/**
 * <p>Implémentation du Proxy d'accès à la couche DAO.</p>
 */
public final class DaoProxyImpl implements DaoProxy {

    // ==================== Attributs ====================
    /** {@link ComptabiliteDao} */
    private ComptabiliteDao comptabiliteDao;
    
    private IJournalComptableDao journalDao;
    private ICompteComptableDao compteDao;
    private IEcritureComptableDao ecritureDao;
    private ISequenceEcritureComptableDao sequenceDao;
    
    


    // ==================== Constructeurs ====================
    /** Instance unique de la classe (design pattern Singleton) */
    private static final DaoProxyImpl INSTANCE = new DaoProxyImpl();

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @return {@link DaoProxyImpl}
     */
    public static DaoProxyImpl getInstance() {
        return DaoProxyImpl.INSTANCE;
    }

    /**
     * Constructeur.
     */
    private DaoProxyImpl() {
        super();
    }


    // ==================== Getters/Setters ====================
    public ComptabiliteDao getComptabiliteDao() {
        return this.comptabiliteDao;
    }
    public void setComptabiliteDao(ComptabiliteDao pComptabiliteDao) {
        this.comptabiliteDao = pComptabiliteDao;
    }
    
    @Override
	public IJournalComptableDao getJournalDao() {
		return journalDao;
	}

	public void setJournalDao(IJournalComptableDao journalDao) {
		this.journalDao = journalDao;
	}
	@Override
	public ICompteComptableDao getCompteDao() {
		return compteDao;
	}

	public void setCompteDao(ICompteComptableDao compteDao) {
		this.compteDao = compteDao;
	}
	@Override
	public IEcritureComptableDao getEcritureDao() {
		return ecritureDao;
	}

	public void setEcritureDao(IEcritureComptableDao ecritureDao) {
		this.ecritureDao = ecritureDao;
	}
	@Override
	public ISequenceEcritureComptableDao getSequenceDao() {
		return sequenceDao;
	}

	public void setSequenceDao(ISequenceEcritureComptableDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}
    
}
