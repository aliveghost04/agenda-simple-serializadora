package edu.itla.agendaserializadora.contacto;

import java.io.Serializable;

public class Contacto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String numero;

	public String getNombre() {
		return nombre;
	}

	public Contacto(String nombre, String numero) {
		this.nombre = nombre;
		this.numero = numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
