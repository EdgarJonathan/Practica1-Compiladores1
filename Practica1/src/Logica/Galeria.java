package Logica;

import java.util.LinkedList;

public class Galeria {

	public String titulo;
	public  LinkedList<String> Nombres ;
	
	public Galeria() 
	{
		this.Nombres = new LinkedList<String>();
		this.titulo="NULL";
	}

	public Galeria(String titulo, LinkedList<String> nombres) {
	
		this.titulo = titulo;
		Nombres = nombres;
	}

	
	
}
