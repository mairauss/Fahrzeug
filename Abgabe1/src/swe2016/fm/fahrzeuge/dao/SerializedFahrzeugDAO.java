package swe2016.fm.fahrzeuge.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;

/**
 * 
 * @author Maira Ussenbayeva : 1468802
 *
 */
public class SerializedFahrzeugDAO implements FahrzeugDAO {
private String pfad;
private File file;
ArrayList<Fahrzeug> fahrzeug;

@SuppressWarnings("unchecked")
/**
 * Konstruktor von class SerializedFahrzeugDAO
 * @param pfad String
 */
public SerializedFahrzeugDAO (String pfad)
{
this.pfad = pfad;
fahrzeug = new ArrayList<Fahrzeug>();
file = new File(pfad);
if(file.exists()){
	try {
		FileInputStream fileIn=new FileInputStream(pfad+".ser");
		ObjectInputStream in=new ObjectInputStream(fileIn);
		fahrzeug= new ArrayList<Fahrzeug>((ArrayList<Fahrzeug>) in.readObject());
		in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.exit(1);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.exit(1);
	} catch (IOException e) {
		e.printStackTrace();
		System.exit(1);
	}
  }
}

@SuppressWarnings("unchecked")
/**
 * getFahrzeugList zeigt alle Fahrzeuge, die gespeichert wurden
 * @return fahrzeug;
 */
public ArrayList<Fahrzeug> getFahrzeugList() throws ClassNotFoundException, Exception
{
	try{
		FileInputStream fileIn=new FileInputStream(pfad+".ser");
		ObjectInputStream in=new ObjectInputStream(fileIn);
		fahrzeug= new ArrayList<Fahrzeug>((ArrayList<Fahrzeug>) in.readObject());
		in.close();
		} catch(IOException ex)
		{
			System.out.println(ex);
		}
	return fahrzeug;
}

/**
 * getFahrzeugbyId zeigt bestimmtes Auto, die gespeichert wurde
 * @param Id int
 */
public Fahrzeug getFahrzeugbyId(int Id) throws ClassNotFoundException, Exception
{
	getFahrzeugList();
	for(int i=0; i < fahrzeug.size(); i++)
	{
		if( fahrzeug.get(i).getId()== Id)
		{
			return fahrzeug.get(i);
		}
	}
	return null;
}


/**
 * speichereFahrzeug speichert ein Auto in file 
 * @param speicher Fahrzeug
 * @throws IllegalArgumentException wenn ein Wert fehlt und wenn Id schon besetzt ist
 */
public void speichereFahrzeug(Fahrzeug speicher) throws ClassNotFoundException, Exception {
	for (int i = 0; i < fahrzeug.size(); i++) {
		if (fahrzeug.get(i).getModell().isEmpty() || fahrzeug.get(i).getMarke().isEmpty()) {
			throw new IllegalArgumentException("Ein Wert fehlt!");
		}
		if (fahrzeug.get(i).getBaujahr() == 0 || fahrzeug.get(i).getGrundpreis() == 0
				|| fahrzeug.get(i).getId() == 0) {
			throw new IllegalArgumentException("Ein Wert fehlt!");
		}
		}
	
	try {
		getFahrzeugList();
		for (int i = 0; i < fahrzeug.size(); i++) {
		if( speicher.getId()==fahrzeug.get(i).getId())
		{
    		throw new IllegalArgumentException("Id ist schon besetzt!");
    	}
		}
		fahrzeug.add(speicher);
	    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pfad+".ser")));
		oos.writeObject(fahrzeug);
		oos.close();
		System.out.println("Fahrzeug wurde gespeichert :) ");
	} catch (IOException i) {
		i.printStackTrace();
		System.exit(1);
	}
}

@SuppressWarnings("resource")
/**
 * loescheFahrzeug loescht ein Auto aus file 
 * @param loeschen Fahrzeug
 * @throws IllegalArgumentException, wenn Fahrzeug mit diesem Id nicht existiert
 */
public void loescheFahrzeug(Fahrzeug loeschen) { 
  try {
	 ObjectInputStream ois= new ObjectInputStream( new FileInputStream(pfad+".ser"));
	  boolean gibt = false;
	 for(int i=0;i<fahrzeug.size();i++)
	{
		if(loeschen.getId()==fahrzeug.get(i).getId())
		{
			gibt = true;
			break;
    	}
	}
	if(gibt == true)
	{
		 fahrzeug.remove(loeschen);
		  saveList();
		  System.out.println("Fahrzeug wurde geloescht :) ");
		  ois.close();
	}
	else throw new IllegalArgumentException("Fahrzeug mit diesem Id existiert nicht!");
    }
  catch (Exception i) {
   System.out.println("Fahrzeug mit diesem Id existiert nicht!");
   System.exit(1);
   }
}

/*public void loescheFahrzeugData(Fahrzeug loeschen) { 
	  try {
		 ObjectInputStream ois= new ObjectInputStream( new FileInputStream(pfad+".ser"));
     	  int count =0;
		
		 for(int i=0;i<fahrzeug.size();i++)
			{
			 fahrzeug.remove(loeschen);
			  count++;
			}
		  System.out.println(count + " Fahrzeuge wurden geloescht :) ");
		  saveList();
		  ois.close();
	    }
	  catch (Exception i) {
	   System.out.println("DATA FALSCH!");
	   System.exit(1);
	   }
	}*/

public void saveList() {
  try {
  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pfad+".ser"));
  oos.writeObject(fahrzeug);
  oos.close();
  } catch (IOException i) {
    i.printStackTrace();
    System.exit(1);
    }
  }

public ArrayList<Fahrzeug> getFahrzeugbyData(int data)throws ClassNotFoundException, Exception
{
	getFahrzeugList();
	ArrayList<Fahrzeug> f = new ArrayList<Fahrzeug>();
	for(int i=0; i < fahrzeug.size(); i++)
	{
		if( fahrzeug.get(i).getBaujahr()>=data)
		{
			f.add(fahrzeug.get(i));
		}
	}
	return f;
}

public void loescheFahrzeugData(ArrayList<Fahrzeug> loeschen) {
	  try {
			 ObjectInputStream ois= new ObjectInputStream( new FileInputStream(pfad+".ser"));
	     	  int count =0;
			
			 for(int i=0;i<loeschen.size();i++)
				{
				 fahrzeug.remove(loeschen.get(i));
				  count++;
				}
			  System.out.println(count + " Fahrzeuge wurden geloescht :) ");
			  saveList();
			  ois.close();
		    }
		  catch (Exception i) {
		   System.out.println("DATA FALSCH!");
		   System.exit(1);
		   }
	
}
}

