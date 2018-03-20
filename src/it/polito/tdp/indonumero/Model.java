package it.polito.tdp.indonumero;

import java.security.*;
import java.util.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model {

	private int NMAX = 100;
	private int TMAX = 7;
	
	private int segreto;
	//private int tentativi; tentativi fatti
	
	private IntegerProperty tentativi=new SimpleIntegerProperty(); // sempre un intero, ma osservabile e da altre classi (si modifica da solo quindi)
	// IntegerPoperty è diverso da int ma se tu usi set() e get() sono delle funzioni di IntegerPoperty che lavora con int quindi usa quelli e sei apposto
	
	private boolean inGame=false;


	public Model() {
		this.inGame=false;
	}
	
	 public final IntegerProperty tentativiProperty() {
		 return this.tentativi; //restituisce oggetto IngeterPoperty
	 }
	 
	 
	
	/**
		 * Avvia partita, generando un nuovo numero segreto
		 */
	public void newGame() {
		
		this.segreto=(int)(Math.random()*NMAX)+1;  
    	this.tentativi.set(0); //tentativi è un IntegerPoperty ma se uso set() e get() lavoro in int quindi apposto
    	this.inGame=true;
		
	}
	
	
	
	
	/**
		 * Fai un tentativo di indovinare numero segreto
		 * @param t, valore numerico del tentativo
		 * @return 0 se indovinato, +1 se troppo grande, -1 se troppo piccolo
		 * 
		 */
	public int tentativo(int t) {
		
		
		if(!inGame) 
			throw new IllegalStateException("Partita non attiva!!");
		
		//controllo inutile perche controllo gia prima quando creo il tentativo nel controller.
		if(t<1 || t>this.NMAX) 
			throw new InvalidParameterException("Tentativo fuori range");
		
		
		this.tentativi.set(this.tentativi.get()+1);
		if(this.tentativi.get()==TMAX) {
			inGame=false;
		}
		
		if(t==this.segreto) {
			this.inGame=false;
			return 0;
			}
		
		if(t<this.segreto)
			return -1;
		
		if(t>this.segreto)
			return 1;
		
		return 1;
	}
	
	


	public int getSegreto() {
		return this.segreto;
	}
	
	public boolean valoreValido(int tentativo) {
		return tentativo>=1 && tentativo<=NMAX;
	}
	
	//public int getTentativi() {
	//	return tentativi;
	//}
	public final int getTentativi() {
		 return this.tentativi.get(); //restituisce int perche agiamo sull'IntegerPoperty con il metodo .get() che ci restituisce un intero
	 }
	
	public boolean isInGame() {
		return inGame;
	}
	public int getNMAX() {
		return NMAX;
	}
	public int getTMAX() {
		return TMAX;
	}
	
	
}
