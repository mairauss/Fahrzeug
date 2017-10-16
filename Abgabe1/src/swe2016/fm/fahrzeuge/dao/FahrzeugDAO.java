package swe2016.fm.fahrzeuge.dao;

import java.util.ArrayList;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public interface FahrzeugDAO {
	 public ArrayList<Fahrzeug> getFahrzeugList() throws ClassNotFoundException, Exception;
	 public Fahrzeug getFahrzeugbyId(int Id) throws ClassNotFoundException, Exception;
	 public void speichereFahrzeug(Fahrzeug speicher) throws ClassNotFoundException, Exception;
	 public void loescheFahrzeug(Fahrzeug loeschen);
	 public void loescheFahrzeugData(ArrayList<Fahrzeug> arrayList);
	 public ArrayList<Fahrzeug> getFahrzeugbyData(int data) throws ClassNotFoundException, Exception;
}