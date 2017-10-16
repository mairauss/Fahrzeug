import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public class FahrzeugClient{

	public static void main(String[] args) throws ParseException {
			FahrzeugManagement fm = new FahrzeugManagement(args[0]);
					
		try{
			if(args.length==3)
			{
				if(args[1].equals("show"))
				{
					System.out.println(fm.getFahrzeugbyId(Integer.parseInt(args[2])));
				}
				if(args[1].equals("del"))
				{
					fm.loeschbyId(Integer.parseInt(args[2]));
				}
				
				if(args[1].equals("count"))
				{
					if(args.length==3 && args[2].equals("lkw"))
		            {
					System.out.println(fm.anzahlLKW());
					}
					else if(args.length==3 && args[2].equals("pkw"))
				    {
					System.out.println(fm.anzahlPKW());
				    }
				}
				if(args[1].equals("meanprice"))
				{
					if (args[2].equals("lkw"))
					{
						String PreisLKW = new DecimalFormat("0.00").format(fm.preisLKW());
						System.out.println(PreisLKW.replace(',','.'));
					}
					else if (args[2].equals("pkw"))
					{
					    String PreisPKW = new DecimalFormat("0.00").format(fm.preisPKW());
						System.out.println(PreisPKW.replace(',','.'));
					}
				}
			}
			else if(args.length>4){
				if(args[1].equals("add"))
				{
					if (args[2].equals("lkw")){
						Fahrzeug newLkw = new LKW(Integer.parseInt(args[3]), args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]));
						fm.speichereFahrzeug(newLkw);
					} 
					else if(args[2].equals("pkw")){
						Fahrzeug newPKW = new PKW(Integer.parseInt(args[3]), args[4], args[5],Integer.parseInt(args[6]),Double.parseDouble(args[7]), args[8]);
						fm.speichereFahrzeug(newPKW);
					}
				}			
			}
			else if(args.length==4)
			{
				if(args[1].equals("del") && args[2].equals("since"))
				{
					fm.loeschbyData(Integer.parseInt(args[3]));
				}
			}
			else if(args.length==2)
			{
				if(args[1].equals("show"))
				{
					ArrayList<Fahrzeug> fahrzeuglist = fm.getFahrzeugList();
					for(int i=0; i<fahrzeuglist.size(); i++)
					{
					System.out.println(fahrzeuglist.get(i).toString());
					}
				}
				if(args[1].equals("count"))
				{
					System.out.println(fm.anzahlAllAuto());
				}
				if(args[1].equals("meanage"))
				{
					String AlterAllAuto = new DecimalFormat("0.00").format(fm.alterAllAuto());
					System.out.println(AlterAllAuto.replace(',', '.'));
				}
			    if(args[1].equals("meanprice"))
			    {
			    	String PreisAllAuto = new DecimalFormat("0.00").format(fm.preisAllAuto());
				    System.out.println(PreisAllAuto.replace(',','.'));
			    }
			    if(args[1].equals("oldest"))
				{
					fm.aelteste();
				}		    
			}
			else if(args.length<=1)
			{
	    		throw new IllegalArgumentException("Keine Parametern");
			}
			
		  }
			catch(Exception i)
			{
				   i.printStackTrace();
				   System.exit(1);
			}
	 }
}




