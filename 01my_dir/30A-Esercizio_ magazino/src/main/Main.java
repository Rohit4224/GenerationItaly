package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		CONSEGNA
//
//		Dovete creare un programma che lette delle bolle di consegna di materiali gestisca il magazzino.
//		Dei materiali sapete:
//		nome,quantità,prezzoalPezzo,tassaAlPubblico,eventualiComponentiTerzi(saranno papabilmente molte informazioni),colori
//		(ESEMPIO: SET tavolo Giardino,45,90.50,22,sedie-tovaglia,nero-grigio-vedone)
//
//		Creare un menù per l'azienda che permetta di:
//		Vedere le schede di tutti i prodotti presenti in magazzino
//		Vedere i nomi dei prodotti da ordinare (si ordina quando la quantità è minore o uguale a 5 pezzi)
//		Vedere i nomi dei prodotti con il costo al pubblico maggiori
//		Vedere i nomi dei prodotti meno tassati
//		Vedere i nomi dei prodotti disponibili nella maggior gamma di colori
//		Cercare un prodotto tramite il suo nome (voglio poi vedere la scheda)
//		Cercare un prodotto tramite un budjet (lista dei prodotti che potrò acquistare con i soldi indicati)
//		Prezzo medio dei prodotti con almeno 3 componenti terze
//		Vedere i nomi dei prodotti il cui rapporto componentiTerze:prezzoTassato è superiore alla media
//		Ipotizzando di vendere tutti i pezzi in magazzino al pubblico, quanto incasserà l'azienda?
//		Ipotizzando di dover ricomprare tutto, quanto spenderà l'azienda?

		
		//Blocco 1
		// leggere il file
		//D
		Scanner data;

        String  []names;
        int [] quantities;
        double [] singlePrize;
        double [] tax;
        String [] thirdComponents;
        String [] colors;
        int dimension;
        int index; //variabile globale
        //I
        data= new Scanner(new File("src/res/File.txt"));
        dimension = Integer.parseInt(data.nextLine());

        names = new String [dimension];
        quantities = new int  [dimension];
        singlePrize = new double [dimension];
        tax = new double [dimension];
        thirdComponents = new String [dimension];
        colors = new String [dimension];
        index=0;
        //C
        while (data.hasNextLine())    {
            String [] infoLine = data.nextLine().split(",");

            names [index]= infoLine[0];
            quantities [index]= Integer.parseInt(infoLine[1]);
            singlePrize [index]= Double.parseDouble(infoLine[2]);
            tax [index]= Double.parseDouble(infoLine[3]);
            thirdComponents [index]= infoLine[4];
            colors [index]= infoLine[5];
            index++;
        }
        data.close();
        
        
//BLOCCO2----------------------------------------------------------------------------------------
        //Creare il menu
        //D
        String menu;
        
        //I
        menu =  "\n\tLegenda:"+
                "\n1.Visualizza le schede dei prodotti"											+
                "\n2.Visualizza i prodotti da ordinare"											+
                "\n3.Visualizza i prodotti con costo al pubblico maggiore"						+
                "\n4.Visualizza i prodotti meno tassati"										+
                "\n5.Visualizza il prodotto con la maggiore gamma di colori"					+
                "\n6.Cerca per nome"															+
                "\n7.Cerca per budget"															+
                "\n8.Prezzo medio dei prodotti con almeno tre componenti terze"					+
                "\n9.Visualizza i prodotti con rapporto componenti/prezzo superiore alla media"	+
                "\n10.Incasso totale stimato"													+
                "\n11.Prezzo totale della merce"												+
                "\nM.visualizza il menù"														+
                "\n0 Esci " ;
//BLOCCO3----------------------------------------------------------------------------------------
      //Calcoli
        Scanner input;
        String cmd;
        String answer;
        
        input = new Scanner(System.in);
      
      
        
        do {
        	System.out.println("Inserisci un comando" + menu);
        	answer = "";
        	cmd = input.nextLine();
        	
        	
        	switch(cmd.toLowerCase())
        	{
        	case "1":
        		for(int i=0; i<names.length; i++)
        		{
	        		answer += "\n\n\tProdotto n° " 					+(i+1) 					+ 
	        					  "\nNome: "     					+ names[i] 				+
	        					  "\nQuantita "  					+ quantities[i] 		+
	        					  "\nPrezzo singolo: " 				+ singlePrize[i] 		+
	        					  "\nTasse: " 						+ tax[i] 				+
	        					  "\nComponenti inclusi nel SET: "  + thirdComponents[i] 	+
	        					  "\nColori disponibili: " 			+ colors[i] 			+
	        					  "\n---------------------------------------------------------------";
        		}
        		
        		break;
        	case "2":
        		String productOrdering;
        		productOrdering = "";
        		for (int i= 0; i<quantities.length; i++)
        		{
        			if (quantities[i] <= 5)
        				productOrdering += names[i] + ", ";
        		}
        		answer = productOrdering.substring(0, productOrdering.length() - 2);
        		break;
        	case"3": //Visualizza i prodotti con costo al pubblico maggiore"
                //D

                double publicPriceTaxed;
                double maxPrize;
                //I

                publicPriceTaxed=0;
                maxPrize=0;

                //C
                for (int i=0; i<singlePrize.length;i++) {
                    publicPriceTaxed = (singlePrize[i]/100*tax[i])+singlePrize[i];

                    if (publicPriceTaxed > maxPrize)    {
                        maxPrize = publicPriceTaxed;
                        answer = names[i];
                    }else if (publicPriceTaxed == maxPrize)
                        answer += ", " + names[i] ;
                }
//                answer = answer.substring(0, answer.length()-2);
                answer = "I prodotti con il costo maggiore sono: "    +     answer;
                //O
        		break;
        	case "4":
        		//D
        		double minPrice;
        		//I
        		minPrice = Double.MAX_VALUE;
        		
        		//C
        		for(int i = 0;i<tax.length;i++)
        		{
        			if (tax[i] < minPrice)
        			{
        				minPrice = tax[i];
        				answer = names[i];
        			}
        			else if(tax[i] == minPrice)
        				answer += ", " + names[i];
        		}
        		answer = "I prodotti meno tassati sono: " + answer;
        		break;
        	case "5":
//        		Vedere i nomi dei prodotti disponibili nella maggior gamma di colori
                int max = 0;

                for(int i = 0; i < colors.length; i++)
                {
                    String[] colorSplit = colors[i].split("-");
                    if(colorSplit.length > max)
                    {
                        max = colorSplit.length;
                        answer = names[i];
                    }//if
                    else if(colorSplit.length == max)
                        answer += " , " + names[i];
                }//for
                answer = "I prodotti disponibili nella maggior gamma di colori sono: " + answer;
                break;
        	case "6":
//        		Cercare un prodotto tramite il suo nome (voglio poi vedere la scheda)
        		System.out.println("Scrivi il prodotto per cercare: ");
        		String choosenName = input.nextLine();
        		for(int i=0; i<names.length; i++)
        		{
        			if (choosenName.equalsIgnoreCase(names[i]))
        			{
        				answer += "\n\n\tProdotto n° " 					+(i+1) 					+ 
        						"\nNome: "     							+ names[i] 				+
        						"\nQuantita "  							+ quantities[i] 		+
        						"\nPrezzo singolo: " 					+ singlePrize[i] 		+
        						"\nTasse: " 							+ tax[i] 				+
        						"\nComponenti inclusi nel SET: "  		+ thirdComponents[i] 	+
        						"\nColori disponibili: " 				+ colors[i] 			+
        						"\n---------------------------------------------------------------";
        			}
        		}
        		if (answer.isEmpty())
        			answer = "Non trovato\n";
        		break;
        	case "7":
//        		Cercare un prodotto tramite un budjet (lista dei prodotti che potrò acquistare con i soldi indicati)
        		System.out.println("Scrivi il budget per cercare: ");
        		double choosenBudget = Double.parseDouble(input.nextLine());
        		for(int i=0; i<names.length; i++)
        		{
        			if (choosenBudget >= (singlePrize[i]/100*tax[i])+singlePrize[i])
        			{
        				answer += "\n\n\tProdotto n° " 						+(i+1) 					+ 
        						"\nNome: "     								+ names[i] 				+
        						"\nQuantita "  								+ quantities[i] 		+
        						"\nPrezzo singolo: " 						+ singlePrize[i] 		+
        						"\nTasse: " 								+ tax[i] 				+
        						"\nComponenti inclusi nel SET: "  			+ thirdComponents[i] 	+
        						"\nColori disponibili: " 					+ colors[i] 			+
        						"\n---------------------------------------------------------------";
        			}
        		}
        		if (answer.isEmpty())
        			answer = "Non trovato\n";
        		//answer = "Lista dei prodotti che puoi acquistare con i soldi indicati: \n\n" + answer;
        		break;
        	case "8":
//        		Prezzo medio dei prodotti con almeno 3 componenti terze
        		
        		int cont = 0;
        		double totPrezzo = 0;

                for(int i = 0; i < colors.length; i++)
                {
                	publicPriceTaxed = (singlePrize[i]/100*tax[i])+singlePrize[i];
                    String[] componentSplit = thirdComponents[i].split("-");
                    if(componentSplit.length >= 3) 
                    {
                    	cont++;
                    	totPrezzo += publicPriceTaxed; 
                    }
                }
                answer = "Media: " + totPrezzo/cont;
        		break;
        	case "9":
        		double sum = 0;
        		int total = 0;
        		String ratioText = "";
        		double average = 0;
        		double ratio[] = new double[thirdComponents.length];
        		
//        		Vedere i nomi dei prodotti il cui rapporto componentiTerze:prezzoTassato è superiore alla media
//        		No, il rapporto è calcolato tra il numero di componenti terzi e il prezzo di vendita al cliente. 
//        		Voi fate la media di questo rapporto per tutti i prodotti e poi mi trovate i prodotti il cui rapporto è superiore alla media calcolata
//        		Quindi se ho un prodotto con 3 componenti terzi e un prezzo di vendita al cliente di 300 il rapporto è 0.01
//        		Voglio la media dei singoli risultati e poi i prodotti il cui rapporto è superiore
        		for(int i = 0; i < thirdComponents.length; i++)
                {
                	publicPriceTaxed = (singlePrize[i]/100*tax[i])+singlePrize[i];
                    String[] info = thirdComponents[i].split("-");
                    ratio[i] = publicPriceTaxed / info.length;
                    ratioText += "\nIl rapporto per " + names[i] + " e' di " + ratio[i];
                    
                    sum += info.length/publicPriceTaxed;
                }
        		
        		average = sum/thirdComponents.length;
        		
        		for (int i = 0;i < thirdComponents.length;i++)
        		{
        			if (ratio[i] > average)
        				answer += names[i] + ", ";        		
        		}
        		if (!answer.isEmpty())
        		{
        			answer = "I nomi dei prodotti il cui rapporto componentiTerze:prezzoTassato è superiore alla media: \n" + answer;
        			answer = answer.substring(0, answer.length() - 2);
        		}
        		break;
        	case "10":
//        		Ipotizzando di vendere tutti i pezzi in magazzino al pubblico, quanto incasserà l'azienda?
        		publicPriceTaxed = 0;
        		for(int i = 0; i < thirdComponents.length; i++)
                {
                	publicPriceTaxed += ((singlePrize[i]/100*tax[i])+singlePrize[i]) * quantities[i];
                }
        		answer = "L'incasso totale stimato e': " + publicPriceTaxed;
        		break;
        	case "11":
//        		Ipotizzando di dover ricomprare tutto, quanto spenderà l'azienda?
        		publicPriceTaxed = 0;
        		for(int i = 0; i < thirdComponents.length; i++)
                {
                	publicPriceTaxed += singlePrize[i] * quantities[i];
                }
        		answer = "Deve spendere: " + publicPriceTaxed;
        		break;
        	case "m":
        		answer = menu;
        		break;
        	case "0":
        		answer = "Arrivederci !!";
        		break;
        	default: 
        		answer = "Comando non disponibile";
        		
        	}
        	System.out.println(answer);	
        }while(!cmd.equalsIgnoreCase("0"));
      
        input.close();
        System.out.println("END");
	}

}
