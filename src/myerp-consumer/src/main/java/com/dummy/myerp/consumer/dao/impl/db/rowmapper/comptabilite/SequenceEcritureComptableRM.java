package com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;


/**
 * Row Mapper pour la sequence ecriture comptable
 * @author Titouan
 *
 */
public class SequenceEcritureComptableRM implements RowMapper<SequenceEcritureComptable>{

	@Override
	public SequenceEcritureComptable mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SequenceEcritureComptable sequenceRes = new SequenceEcritureComptable();
		sequenceRes.setAnnee(rs.getInt("annee"));
		sequenceRes.setDerniereValeur(rs.getInt("derniere_valeur"));
		
		return sequenceRes;
	}

}
