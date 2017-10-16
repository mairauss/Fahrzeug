package at.ac.univie.swe2016.fm.fahrzeuge;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public class PKW extends Fahrzeug
{
    private static final long serialVersionUID = 1L;
	public String s;
    public int Ueberpruefungsdatum;
    public String Datum;
    
    /**
     * Konstruktor von class PKW
     * @param Id int
     * @param Marke String
     * @param Modell String
     * @param Baujahr int
     * @param Grundpreis double
     * @param s String
     */
       public PKW (int Id, String Marke, String Modell, 
			int Baujahr, double Grundpreis, String s) throws ParseException
    {
    	super(Id,Marke,Modell,Baujahr,Grundpreis);
    	getCalendar(s);
     }
                  
       /**
        * @param s String
        * @return cal;
        */
       public Calendar getCalendar(String s) {
       	String[] parts = s.split("-");
       	Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));    		
       	@SuppressWarnings("unused")
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
           java.util.Calendar cal = java.util.Calendar.getInstance();
           int Ueberpruefungsdatum = calendar.get(Calendar.YEAR);
           Datum =calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"+calendar.get(Calendar.DAY_OF_MONTH);
           setUeberpruefungsdatum(Ueberpruefungsdatum);
           return cal;
       }
          
       /**
        * getUeberpruefungsdatum von PKW
        * @return Ueberpruefungsdatum;
        */
   	public int getUeberpruefungsdatum() {
   	  return Ueberpruefungsdatum;
	}
   	
   	
   	/**
   	 * setUeberpruefungsdatum von PKW
   	 * @param ueberpruefungsdatum int
   	 * @throws IllegalArgumentException wenn Baujahr ist groesser als Ueberpruefungsdatum
   	 */
	public void setUeberpruefungsdatum(int ueberpruefungsdatum) {
		if(ueberpruefungsdatum > getBaujahr())
		{
			Ueberpruefungsdatum = ueberpruefungsdatum;
		}
		else
		{
			 throw new IllegalArgumentException("Baujahr ist groesser als Ueberpruefungsdatum!");
	    }
	}
	
	/**
	 * getRabatt Methode von class Fahrzeug wird in class PKW implementiert
	 * @return gerechnete Rabatt
	 */
   public double getRabatt() 
	{   java.util.Calendar cal = java.util.Calendar.getInstance();
        int Datum = cal.get(java.util.Calendar.YEAR);
      
		double Rabatt = (5*(getAlter())+2*(Datum-getUeberpruefungsdatum()));
		if(Rabatt<=15 && Rabatt>0)
		{
			return (100-Rabatt)/100;
		}
		else if (Rabatt>15)
		{ 
		return 0.85;
		}
	    else return 0;
	}
	
    /**
     * toString class PKW
     */
	public String toString()
    {
		String grundPreis = new DecimalFormat("0.00").format(getGrundpreis());
		String Preis = new DecimalFormat("0.00").format(getPrise());
				
     	return "Typ: "+ "PKW" + "\n" + "Id: " + getId() +"\n"+"Marke: " + getMarke()+ "\n"+ "Modell: "
		+ getModell()+"\n" + "Baujahr: "+getBaujahr() + "\n" + "Grundpreis: "
		+grundPreis.replace(',', '.') + "\n" + "Ueberpruefungsdatum: " + Datum
		+"\n" + "Preis: " + Preis.replace(',', '.') +"\n"+"\n";
	}
}