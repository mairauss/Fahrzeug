package at.ac.univie.swe2016.fm;

import java.util.ArrayList;

import swe2016.fm.fahrzeuge.dao.FahrzeugDAO;
import swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public class FahrzeugManagement {
	public FahrzeugDAO fahrzeugDAO;
	
	/**
	 * Konstruktor von class FahrzeugManagement
	 * @param pfad String
	 */
	public FahrzeugManagement(String pfad) {
		 this.fahrzeugDAO= new SerializedFahrzeugDAO(pfad);
	}

	/**
	 * getFahrzeugDAO
	 * @return fahrzeugDAO;
	 */
	public FahrzeugDAO getFahrzeugDAO() {
		
		return fahrzeugDAO;
	}

	/**
	 * @param fahrzeugDAO FahrzeugDAO
	 */
	public void setFahrzeugDAO(FahrzeugDAO fahrzeugDAO) {
		this.fahrzeugDAO = fahrzeugDAO;
	}

	/**
	 * getFahrzeugList zeigt Alle Daten von Autos
	 * @throws java.lang.ClassNotFoundException
	 * @return fahrzeugDAO.getFahrzeugList();
    */
	public ArrayList<Fahrzeug> getFahrzeugList() throws ClassNotFoundException, Exception
	{
      	return fahrzeugDAO.getFahrzeugList();
	}
	
	/**
	 * getFahrzeugbyId zeigt ein bestimmtes Auto mit Hilfe des Ids
	 * @param Id int
	 * @return fahrzeugDAO.getFahrzeugbyId(Id);
	 */
	public Fahrzeug getFahrzeugbyId(int Id) throws ClassNotFoundException, Exception
	{
		if(fahrzeugDAO.getFahrzeugbyId(Id).equals(null))
		{
			throw new IllegalArgumentException("Id existiert nicht! ");
		}
		else return fahrzeugDAO.getFahrzeugbyId(Id);
	}
		/**
	 * speichereFahrzeug speichert Neue Fahrzeuge
	 * @param speicher Fahrzeug
	 */
	public void speichereFahrzeug(Fahrzeug speicher) throws ClassNotFoundException, Exception
	{
		fahrzeugDAO.speichereFahrzeug(speicher);
	}
	
	/**
	 * loescheFahrzeug loescht Bestehende Fahrzeuge
	 * @param Id int
	 */
	public void loeschbyId(int Id) throws ClassNotFoundException, Exception
	{
	  fahrzeugDAO.loescheFahrzeug(fahrzeugDAO.getFahrzeugbyId(Id));
	}
	
	public void loeschbyData(int data) throws ClassNotFoundException, Exception
	{
	  fahrzeugDAO.loescheFahrzeugData(fahrzeugDAO.getFahrzeugbyData(data));
	}
	
	/**
	 * anzahlAllAuto berechnet Gesamtzahl der erfassten Fahrzeuge
	 * @return j;
	 */
	public int anzahlAllAuto() throws ClassNotFoundException, Exception
	{
       	ArrayList<Fahrzeug> fahrzeuglist =fahrzeugDAO.getFahrzeugList();
     	int j=0;
     	for(int i=0; i < fahrzeuglist.size();i++)
        {
    	if(fahrzeuglist.get(i) instanceof Fahrzeug ) 
    	{  
    	++j;
    	}
      }
     return j;
     }
   
	/**
	 * anzahlPKW berechnet Gesamtzahl der PKW
	 * @return j;
	 */
    public int anzahlPKW() throws ClassNotFoundException, Exception{
    	ArrayList<Fahrzeug> fahrzeuglist =fahrzeugDAO.getFahrzeugList();
    	int j=0;
        for(int i=0; i < fahrzeuglist.size();i++)
            {
        	if(fahrzeuglist.get(i) instanceof PKW ) 
        	{  
        	++j;
        	}
          }
        return j;
        }
    
    /**
     * anzahlLKW berechnet Gesamtzahl der LKW
     * @return j;
     */
    public int anzahlLKW() throws ClassNotFoundException, Exception{
    	ArrayList<Fahrzeug> fahrzeuglist =fahrzeugDAO.getFahrzeugList();
    	int j=0;
        for(int i=0; i < fahrzeuglist.size();i++)
            {
        	if(fahrzeuglist.get(i) instanceof LKW )  {  
        	++j;
        	}
          }
        return j;
        }
    
    /**
     * preisAllAuto berechnet Durchschnittspreis aller Fahrzeuge
     * @return Preis/i; i ist Anzahl von Fahrzeuge
     */
  public double preisAllAuto() throws ClassNotFoundException, Exception
  {
	  double Preis=0;
	  ArrayList<Fahrzeug> fahrzeuglist =fahrzeugDAO.getFahrzeugList();
	  int i=0;
	  for(; i < fahrzeuglist.size();i++)
	  {
		Preis +=fahrzeuglist.get(i).getPrise();
	  }
	  return Preis/i;
}

  /**
   * preisPKW berechnet Durchschnittspreis aller PKW 
   * @return Preis/i; i ist Anzahl von PKW Autos
   */
  public double preisPKW() throws ClassNotFoundException, Exception
  {
	double Preis=0;
	ArrayList<Fahrzeug> fahrzeuglist =fahrzeugDAO.getFahrzeugList();
	  int i=0;
	  for(; i < fahrzeuglist.size();i++)
	  {
		  if(fahrzeuglist.get(i) instanceof PKW){
		Preis += fahrzeuglist.get(i).getPrise();
		  }
	  }
	  return Preis/i;
}

  /**
   * preisLKW berechnet Durchschnittspreis aller LKW 
   * @return Preis/i; i ist Anzahl von LKW Autos
   */
public double preisLKW() throws ClassNotFoundException, Exception
{
	double Preis=0;
	ArrayList<Fahrzeug> fahrzeuglist =fahrzeugDAO.getFahrzeugList();
	  int i=0;
	  for(; i < fahrzeuglist.size();i++)
	  {
		  if(fahrzeuglist.get(i) instanceof LKW){
		Preis += fahrzeuglist.get(i).getPrise();
		  }
	  }
	  return Preis/i;
}

/**
 * alterAllAuto berechnet Durchschnittsalter aller Fahrzeuge
 * @return Alt/i; i ist Anzahl von Fahrzeuge
 */
public double alterAllAuto() throws ClassNotFoundException, Exception
{
	double Alt=0;
	ArrayList<Fahrzeug> fahrzeuglist = fahrzeugDAO.getFahrzeugList();
	  int i=0;
	  for(; i < fahrzeuglist.size();i++)
	  {
		Alt += fahrzeuglist.get(i).getAlter();
	  }
	  return Alt/i;
	}

/**
 * aelteste sucht Aelteste(s) Fahrzeug(e)
 */
	public void aelteste() throws ClassNotFoundException, Exception
	{
	ArrayList<Fahrzeug> fahrzeuglist = fahrzeugDAO.getFahrzeugList();
		
	int b=0,n=0;
	for(int i=0; i < fahrzeuglist.size();i++)
	{
		if(b < fahrzeuglist.get(i).getAlter())
		{
			b=fahrzeuglist.get(i).getAlter();
		}
	}
	for(int i=0; i < fahrzeuglist.size();i++)
	{
		if(b == fahrzeuglist.get(i).getAlter())
		{n=fahrzeuglist.get(i).getId();
			
			System.out.println("Id: " + n);
		}
	}
  }

}