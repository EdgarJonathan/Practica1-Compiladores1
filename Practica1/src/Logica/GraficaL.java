package Logica;

import java.util.LinkedList;

public class GraficaL {

	public String id;
	public String titulo;
	public String titulox;
	public String tituloy;
	public LinkedList<Linea> lineas;
	
	public GraficaL() 
	{
		
		this.id  ="NULL";
		this.titulo= "NULL";
		this.titulox = "NULL";
		this.tituloy = "NULL";
		this.lineas =new LinkedList<Linea>();
	}
	
}
