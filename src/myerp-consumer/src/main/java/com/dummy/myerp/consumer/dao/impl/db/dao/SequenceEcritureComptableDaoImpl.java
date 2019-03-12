package com.dummy.myerp.consumer.dao.impl.db.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dummy.myerp.consumer.dao.contrat.ISequenceEcritureComptableDao;
import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.SequenceEcritureComptableRM;
import com.dummy.myerp.consumer.db.AbstractDbConsumer;
import com.dummy.myerp.consumer.db.DataSourcesEnum;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;

public class SequenceEcritureComptableDaoImpl extends AbstractDbConsumer implements ISequenceEcritureComptableDao {
	
	
	private static final SequenceEcritureComptableDaoImpl INSTANCE = new SequenceEcritureComptableDaoImpl();
	
	

	//================ Sequence Ecriture Comptable GET ================

	protected SequenceEcritureComptableDaoImpl() {
		super();
	}

	public static SequenceEcritureComptableDaoImpl getInstance() {
		return INSTANCE;
	}


	private static String SQLgetSequenceEcritureComptable;
	public void setSQLgetSequenceEcritureComptable(String sQLgetSequenceEcritureComptable) {
		SQLgetSequenceEcritureComptable = sQLgetSequenceEcritureComptable;
	}

	@Override
	public SequenceEcritureComptable getSequenceEcritureComptable(String code, Integer year) {

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource(DataSourcesEnum.MYERP));
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("journal_code", code, Types.VARCHAR);
		sqlParams.addValue("annee", year, Types.INTEGER);

		SequenceEcritureComptable sequenceReturn = null;
		SequenceEcritureComptableRM sRM = new SequenceEcritureComptableRM();
		try {
			sequenceReturn = jdbcTemplate.queryForObject(SQLgetSequenceEcritureComptable, sqlParams, sRM);
		}catch(EmptyResultDataAccessException e) {
			// It's ok if there is nothing in the DB
		}

		return sequenceReturn;
	}


	private static String SQLgetListSequenceEcritureComptable;
	public void setSQLgetListSequenceEcritureComptable(String sQLgetListSequenceEcritureComptable) {
		SQLgetListSequenceEcritureComptable = sQLgetListSequenceEcritureComptable;
	}

	@Override
	public List<SequenceEcritureComptable> getListSequenceEcritureComptable() {
		JdbcTemplate template = new JdbcTemplate(getDataSource(DataSourcesEnum.MYERP));
		SequenceEcritureComptableRM rowMapper = new SequenceEcritureComptableRM();
		List<SequenceEcritureComptable> listSEC = template.query(SQLgetListSequenceEcritureComptable, rowMapper);

		return listSEC;
	}


	//================ Sequence Ecriture Comptable UPDATE ================

	private static String SQLupdateSequenceEcritureComptable;
	public void setSQLupdateSequenceEcritureComptable(String sQLupdateSequenceEcritureComptable) {
		SQLupdateSequenceEcritureComptable = sQLupdateSequenceEcritureComptable;
	}

	@Override
	public void updateSequenceEcritureComptable(String code, Integer year, Integer newValue) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource(DataSourcesEnum.MYERP));
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("journal_code", code, Types.VARCHAR);
		sqlParams.addValue("annee", year, Types.INTEGER);
		sqlParams.addValue("new_value", newValue, Types.INTEGER);

		jdbcTemplate.update(SQLupdateSequenceEcritureComptable, sqlParams);
	}


	//================ Sequence Ecriture Comptable INSERT ================

	private static String SQLinsertSequenceEcritureComptable;
	public void setSQLinsertSequenceEcritureComptable(String sQLinsertSequenceEcritureComptable) {
		SQLinsertSequenceEcritureComptable = sQLinsertSequenceEcritureComptable;
	}

	@Override
	public void insertSequenceEcritureComptable(String code, Integer year, Integer lastValue) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource(DataSourcesEnum.MYERP));
		MapSqlParameterSource sqlParams = new MapSqlParameterSource();
		sqlParams.addValue("journal_code", code, Types.VARCHAR);
		sqlParams.addValue("annee", year, Types.INTEGER);
		sqlParams.addValue("derniere_valeur", lastValue, Types.INTEGER);

		jdbcTemplate.update(SQLinsertSequenceEcritureComptable, sqlParams);

	}

	//================ Sequence Ecriture Comptable DELETE ================

	private static String SQLdeleteSequenceEcritureComptable;
	public void setSQLdeleteSequenceEcritureComptable(String sQLdeleteSequenceEcritureComptable) {
		SQLdeleteSequenceEcritureComptable = sQLdeleteSequenceEcritureComptable;
	}

	@Override
	public void deleteSequenceEcritureComptable(String code, Integer year) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource(DataSourcesEnum.MYERP));
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("annee", year);
		params.addValue("journal_code", code);

		jdbcTemplate.update(SQLdeleteSequenceEcritureComptable, params);

	}

}
