package com.springbasics.scuola.entities;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Entity {
    private int id;

    public Map<String, String> toMap() {

		Map<String, String> ris = new HashMap<String, String>();


		String keyProp = "";
		String valueProp = "";
		boolean check = false;


		for(Method m : this.getClass().getMethods()) {
			check = false;


			if(m.getName().startsWith("get") && !"getClass".equals(m.getName())) {
				keyProp = m.getName().substring(3);
				check = true;
			} else if(m.getName().startsWith("is")) {
				keyProp = m.getName().substring(2);
				check = true;
			}

			if(check) {
				try {
					valueProp = m.invoke(this)+""; // this.get
				} catch (Exception e) {
					System.err.println("Errore nel metodo toMap di " + this.getClass().getName());
					e.printStackTrace();
				} 
				ris.put(keyProp, valueProp);
			}

		}

		return ris;
	}

	public Entity fromMap(Map<String, String> param) {

		String nomeProp;
		String valoreProp;

		for(Method m : this.getClass().getMethods()) {

			if(m.getName().startsWith("set")) {
				nomeProp = m.getName().substring(3).toLowerCase();

				if(param.containsKey(nomeProp)) {

					valoreProp = param.get(nomeProp);

					String tipo = m.getParameters()[0].getType().getSimpleName();


					try {
						switch (tipo.toLowerCase()) {
						case "string":
							m.invoke(this, valoreProp);
							break;

						case "int":
							m.invoke(this, Integer.parseInt(valoreProp));
							break;

						case "date":
							m.invoke(this, Date.valueOf(valoreProp));
							break;

						case "boolean"	:
							m.invoke(this,	valoreProp.equals("1")		||
									valoreProp.equalsIgnoreCase("true")	||
									valoreProp.equalsIgnoreCase("t")	||
									valoreProp.equalsIgnoreCase("vero")	||
									valoreProp.equalsIgnoreCase("v")	||
									valoreProp.equalsIgnoreCase("si")	||
									valoreProp.equalsIgnoreCase("s")	||
									valoreProp.equalsIgnoreCase("sì")	||
									valoreProp.equalsIgnoreCase("y"))	;
							break;

						default:
							System.err.println("Non ho riconosciuto il tipo: " + tipo);
							break;
						}

					}catch (Exception e) {
						System.err.println("Errore nel metodo fromMap di " + this.getClass().getName());
						e.printStackTrace();
					}
				}
			}
		}
		return this;
	}
}
