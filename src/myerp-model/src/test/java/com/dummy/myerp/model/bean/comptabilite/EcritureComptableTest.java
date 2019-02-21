package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;


public class EcritureComptableTest {

	private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
		
		BigDecimal vDebit = pDebit == null || pDebit.isEmpty() ? null : new BigDecimal(pDebit); 
		BigDecimal vCredit = pCredit == null || pCredit.isEmpty() ? null : new BigDecimal(pCredit);
		
		String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
				.subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
		LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
				vLibelle,
				vDebit, vCredit);
		return vRetour;
	}

	@Test
	public void isEquilibree() {
		EcritureComptable vEcriture;
		vEcriture = new EcritureComptable();

		vEcriture.setLibelle("Equilibrée");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
		
		Assert.assertTrue(vEcriture.toString(), vEcriture.isEquilibree());

		vEcriture.getListLigneEcriture().clear();
		vEcriture.setLibelle("Non équilibrée");
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
		vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "31"));
		vEcriture.getListLigneEcriture().add(this.createLigne(2, "1", "2"));

		Assert.assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
	}

	@Test
	public void getTotalDebit() {
		EcritureComptable ecriture = new EcritureComptable();


		ecriture.getListLigneEcriture().add(createLigne(1, "102.5", "100.4"));
		ecriture.getListLigneEcriture().add(createLigne(1, null, "100.4"));
		ecriture.getListLigneEcriture().add(createLigne(2, "120", "100.4"));

		Assert.assertEquals(new BigDecimal(222.5), ecriture.getTotalDebit());

		ecriture.getListLigneEcriture().clear();

		Assert.assertEquals(new BigDecimal(0), ecriture.getTotalDebit());

		ecriture.getListLigneEcriture().add(createLigne(1, null, "100.4"));
		ecriture.getListLigneEcriture().add(createLigne(1, null, "100.4"));
		ecriture.getListLigneEcriture().add(createLigne(2, null, "100.4"));

		Assert.assertEquals(new BigDecimal(0), ecriture.getTotalDebit());

		ecriture.getListLigneEcriture().clear();

		ecriture.getListLigneEcriture().add(createLigne(1, "11.6", "100.4"));
		ecriture.getListLigneEcriture().add(createLigne(1, "", "100.4"));
		ecriture.getListLigneEcriture().add(createLigne(2, "12.4", "100.4"));

		Assert.assertEquals(new BigDecimal("24.0"), ecriture.getTotalDebit());		
	}

}
