package factory;

import entities.Allevatore;
import entities.Animale;

public class Factory 
{
	public static IFactory createObject(String classe)
	{
		switch(classe)
		{
			case "Animale" :
				return new Animale();
			case "Allevatore" :
				return new Allevatore();
			default :
				throw new IllegalArgumentException(classe + "sconosciuta");
				
			
		}
	}
}
