package com.dummy.myerp.consumer.dao.contrat;


/**
 * Interface du Proxy d'accès à la couche DAO
 */
public interface DaoProxy {

    ICompteComptableDao getCompteDao();
    
    IJournalComptableDao getJournalDao();
    
    ISequenceEcritureComptableDao getSequenceDao();
    
    IEcritureComptableDao getEcritureDao();

}
