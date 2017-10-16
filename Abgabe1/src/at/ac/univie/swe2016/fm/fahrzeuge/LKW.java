package at.ac.univie.swe2016.fm.fahrzeuge;

import java.text.DecimalFormat;

/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public class LKW extends Fahrzeug
{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor von class LKW
	 * @param Id int
	 * @param Marke String
	 * @param Modell String
	 * @param Baujahr int
	 * @param Grundpreis double
	 */
	public LKW (int Id, String Marke, String Modell, 
				int Baujahr, double Grundpreis)
	    {
	    	super(Id,Marke,Modell,Baujahr,Grundpreis);
	    }
	
	/**
	 * getRabatt Methode von class Fahrzeug wird in class PKW implementiert
	 * @return gerechnete Rabatt
	 */
	public double getRabatt()
	{
		double Rabatt = 5*(getAlter());
		if(Rabatt<=20 && Rabatt>0)
		{
			return (100-Rabatt)/100;
		}
		else if (Rabatt>20)
			{ 
			return 0.8;
			}
		else return 0; 
	}
	
	 /**
     * toString class LKW
     */
	public String toString()
    {		
		String grundPreis = new DecimalFormat("0.00").format(getGrundpreis());
		String Preis = new DecimalFormat("0.00").format(getPrise()); 
	
	return "Typ: "+ "LKW" + "\n" +"Id: " + getId() +"\n"+"Marke: " + getMarke()+ "\n"+ "Modell: "
    + getModell()+"\n" + "Baujahr: "+getBaujahr() + "\n" + "Grundpreis: "
    +grundPreis.replace(',', '.') + "\n" + "Preis: " + Preis.replace(',', '.')+"\n"+"\n";
   }
}