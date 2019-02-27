package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JournalComptableTest {
	
	@Test
	public final void testGetByCode() {
		List<JournalComptable> lJournal = new ArrayList<>();
		
		// Instanciation de journaux comptables de test
		JournalComptable journal1 = new JournalComptable("1234", "LibelleTest");
		JournalComptable journal2 = new JournalComptable("4567", "LibelleTest");
		JournalComptable journal3 = new JournalComptable("891", "LibelleTest");
		JournalComptable journal1bis = new JournalComptable("1234", "Un libelle différent");
		
		// Ajout à la liste de journaux
		lJournal.add(journal1);
		lJournal.add(journal2);
		lJournal.add(journal3);
		lJournal.add(journal1bis);
		
		// Appel de la méthode à tester
		JournalComptable vRetour = JournalComptable.getByCode(lJournal, "1234");
		// La méthode doit renvoyer le premier élement trouvé correspont au bon code, ici le journal1
		assertEquals(vRetour, journal1);
		// Donc vRetour n'est pas égal à journal1bis malgré le code identique
		assertNotEquals(vRetour, journal1bis);
		
		// Test avec un code erroné
		vRetour = JournalComptable.getByCode(lJournal, "0");
		assertEquals(null, vRetour);
		
		// Retour à la liste vide
		lJournal.clear();
		
		// La méthode doit retourner null si la liste est vide ou s'il ne trouve pas d'élément correspondant
		vRetour = JournalComptable.getByCode(lJournal, "1234");
		assertEquals(null, vRetour);
		
	}

}
