package Logica;

public class Variable {

	public String tipo;
	public String nombreVariable;
	public String valorString;
	public int  ValorEntero;
	
	public Variable() {

		this.tipo = "NULL";
		this.nombreVariable = "NULL";
		this.valorString = "NULL";
		ValorEntero = 0;
	}

	public Variable(String tipo, String nombreVariable, String valorString) {
		super();
		this.tipo = tipo;
		this.nombreVariable = nombreVariable;
		this.valorString = valorString;
		ValorEntero = 0;
	}
	
	public Variable(String tipo, String nombreVariable, int valorEntero) {
		super();
		this.tipo = tipo;
		this.nombreVariable = nombreVariable;
		this.valorString = "NULL";
		ValorEntero = valorEntero;
	}
	
	
}
