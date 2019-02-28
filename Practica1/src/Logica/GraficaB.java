package Logica;

import java.util.LinkedList;

public class GraficaB {
	
	public String id ;
	public String titulo;
	public LinkedList<String>  ejex ; 
	public String titulox;
	public String tituloy;
	public LinkedList<Integer> ejey;  
	public LinkedList<Punto>  puntos;
	
	
	public GraficaB() {
		super();
		this.id = "NULL";
		this.titulo = "NULL";
		this.ejex = new LinkedList<String>();
		this.titulox = "NULL";
		this.tituloy = "NULL";
		this.ejey = new LinkedList<Integer>(); 
		this.puntos =new LinkedList<Punto>();
	}  
	
	

	
}
