package com.dummy.myerp.consumer.dao.impl.db.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dummy.myerp.consumer.dao.contrat.IJournalComptableDao;
import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.JournalComptableRM;
import com.dummy.myerp.consumer.db.AbstractDbConsumer;
import com.dummy.myerp.consumer.db.DataSourcesEnum;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;

public class JournalComptableDaoImpl extends AbstractDbConsumer implements IJournalComptableDao {
	
	
	private final static JournalComptableDaoImpl INSTANCE = new JournalComptableDaoImpl();
	
	protected JournalComptableDaoImpl() {
		super();
	}
	
	public static JournalComptableDaoImpl getInstance() {
		return JournalComptableDaoImpl.INSTANCE;
	}
	
	
	/** SQLgetListJournalComptable */
    private static String SQLgetListJournalComptable;
    public void setSQLgetListJournalComptable(String pSQLgetListJournalComptable) {
        SQLgetListJournalComptable = pSQLgetListJournalComptable;
    }
    @Override
    public List<JournalComptable> getListJournalComptable() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(this.getDataSource(DataSourcesEnum.MYERP));
        JournalComptableRM vRM = new JournalComptableRM();
        List<JournalComptable> vList = vJdbcTemplate.query(SQLgetListJournalComptable, vRM);
        return vList;
    }

}
