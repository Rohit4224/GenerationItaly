package factory;

import entities.Allevatore;
import entities.Animale;

// PATTERN Factory: il suo scopo è quello di centralizzare la creazione di oggetti, limitando a
// 					questa classe l'uso di new Class()
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
				throw new IllegalArgumentException(classe + " sconosciuta");
		}
	}
}