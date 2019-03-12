package com.dummy.myerp.consumer.dao.impl.db.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dummy.myerp.consumer.dao.contrat.ICompteComptableDao;
import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.CompteComptableRM;
import com.dummy.myerp.consumer.db.AbstractDbConsumer;
import com.dummy.myerp.consumer.db.DataSourcesEnum;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

public class CompteComptableDaoImpl extends AbstractDbConsumer implements ICompteComptableDao {
	
	private static final CompteComptableDaoImpl INSTANCE = new CompteComptableDaoImpl();
	
	public static CompteComptableDaoImpl getInstance() {
		return INSTANCE;
	}
	protected CompteComptableDaoImpl() {
		super();
	}
	
	
	/** SQLgetListCompteComptable */
	private static String SQLgetListCompteComptable;
	public void setSQLgetListCompteComptable(String pSQLgetListCompteComptable) {
		SQLgetListCompteComptable = pSQLgetListCompteComptable;
	}
	@Override
	public List<CompteComptable> getListCompteComptable() {
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(this.getDataSource(DataSourcesEnum.MYERP));
		CompteComptableRM vRM = new CompteComptableRM();
		List<CompteComptable> vList = vJdbcTemplate.query(SQLgetListCompteComptable, vRM);
		return vList;
	}

}
