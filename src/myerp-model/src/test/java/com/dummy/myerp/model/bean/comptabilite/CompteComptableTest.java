package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompteComptableTest {

	@Test
	public final void testGetByNumero() {
		List<CompteComptable> lComptes = new ArrayList<>();
		
		// Instanciation de comptes comptables de test
		CompteComptable compte1 = new CompteComptable(1, "LibelleTest");
		CompteComptable compte2 = new CompteComptable(2, "LibelleTest");
		CompteComptable compte3 = new CompteComptable(3, "LibelleTest");
		CompteComptable compte1bis = new CompteComptable(1, "Un autre libelle");
		
		// Ajout à la liste de comptes
		lComptes.add(compte1);
		lComptes.add(compte2);
		lComptes.add(compte3);
		lComptes.add(compte1bis);
		
		// Appel de la méthode à tester
		CompteComptable vRetour = CompteComptable.getByNumero(lComptes, 1);
		// La méthode renvoit le premier élement trouvé dans la liste
		assertEquals(vRetour, compte1);
		
		assertNotEquals(vRetour, compte1bis);
		
		// Test avec un numéro erroné
		vRetour = CompteComptable.getByNumero(lComptes, 0);
		assertEquals(null, vRetour);
		
		// Retour à la liste vide
		lComptes.clear();
		
		// La méthode doit retourner null si la liste est vide ou s'il ne trouve pas d'élément correspondant
		vRetour = CompteComptable.getByNumero(lComptes, 1);
		assertEquals(null, vRetour);
	}

}
