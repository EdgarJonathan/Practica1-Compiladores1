package Logica;

import java.util.LinkedList;

public class Linea {

	public String nombre;
	public String color;
	public Integer grosor;
	public LinkedList<Punto> puntos;
	
	public Linea()
	{
		this.nombre = "NULL";
		this.color = "NULL";
		this.grosor = 0;
		this.puntos = new LinkedList<Punto>();
		
	}
}
