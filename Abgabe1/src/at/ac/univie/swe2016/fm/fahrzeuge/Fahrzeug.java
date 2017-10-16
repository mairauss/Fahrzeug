package at.ac.univie.swe2016.fm.fahrzeuge;

import java.io.Serializable;
/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public abstract class Fahrzeug implements Serializable{ 
	
    private static final long serialVersionUID = 1L;
	private String Marke; 
	private String Modell; 
	private int Baujahr; 
	private double Grundpreis;
	private int Id;

	/**
	 * Konstruktor von class Fahrzeug
	 * @param Id int
	 * @param Marke String
	 * @param Modell String
	 * @param Baujahr int
	 * @param Grundpreis double
	 */
	
    public Fahrzeug( int Id, String Marke, String Modell, 
			int Baujahr, double Grundpreis)
	{
    	setId(Id);
    	setMarke(Marke);
		setModell(Modell);
		setBaujahr(Baujahr);
		setGrundpreis(Grundpreis);
	}
    
    /**
     * @return Marke;
     */
   	public String getMarke() {
		return Marke;
	}
   	
   	/**
  	 * @param marke String
   	 */
	public void setMarke(String marke) {
		Marke = marke;
	}

	/**
	 * @return Modell;
	 */
	public String getModell() {
		return Modell;
	}

	/**
	 * @param modell String
	 */
	public void setModell(String modell) {
		Modell = modell;
	}

	/**
	 * @return Baujahr;
	 */
	public int getBaujahr() {
	   return Baujahr;
	}

	/**
	 * @param Baujahr int
	 * @throws IllegalArgumentException wenn Baujahr groesser als Datum ist;
	 */
	public void setBaujahr(int Baujahr) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
	    int Datum = cal.get(java.util.Calendar.YEAR);
	    
		if(Baujahr>Datum)
		{
			 throw new IllegalArgumentException("Falsch!");
	   	}
		else this.Baujahr=Baujahr;	
	}

	/**
	 * @return Grundpreis;
	 */
	public double getGrundpreis() {
		
		return Grundpreis;
	}
 
	/**
	 * @param grundpreis double
	 * @throws IllegalArgumentException wenn grundpreis groesser als 100.0 Euro;
	 */
	public void setGrundpreis(double grundpreis) {
		if (grundpreis<100.0)
		{
		 throw new IllegalArgumentException("Falsch!");
		}
		else Grundpreis = grundpreis;
	}

	/**
	 * @return Id;
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id int
	 */
	public void setId(int id) {
		Id = id;
	}
	
	/**
	 * getAlter von Fahrzeug
	 * @return Datum-getBaujahr();
	 */
	public int getAlter()
	{
   	java.util.Calendar cal = java.util.Calendar.getInstance();
    int Datum = cal.get(java.util.Calendar.YEAR);
		return Datum-getBaujahr();
	}
	
	/**
	 * abstract Methode getRabatt()
	 */
	public abstract double getRabatt();
	
	/**
	 * Preis mit Rabatt von Fahrzeug
	 * @throws IllegalArgumentException wenn Grundpreis*getRabatt() kleiner als 0 ist
	 * @return getGrundpreis()*getRabatt() oder wenn getRabatt()== 0,ist return getGrundpreis();
	 */
    public double getPrise()
    {  
    	if(Grundpreis*getRabatt()<0)
    	{
    		throw new IllegalArgumentException("Falsch!");
    	}
    	else if (getRabatt()== 0)
    	{
    		return getGrundpreis();
    	}
    	else return getGrundpreis()*getRabatt();
    }
}
