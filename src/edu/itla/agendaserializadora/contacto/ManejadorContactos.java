package edu.itla.agendaserializadora.contacto;

import java.util.ArrayList;
import java.util.Scanner;

import edu.itla.agendaserializadora.serializadora.Serializadora;

public class ManejadorContactos {
	
	private ArrayList<Contacto> contactos = new Serializadora().getContactos();
	private Scanner lectorTeclado = new Scanner (System.in);
	private String nombre;
	private String numero;
	private byte numeroAEliminar;
	private Serializadora serializar = new Serializadora();
	
	public boolean cargarContactos() {
		
		System.out.println("\n**********************************************\n");
		
		if (contactos.size() == 0) {
			System.out.println("Agenda Vacia");
		} else {
			System.out.println("Listado de Contactos \n");
			for (int x = 0 ; x < contactos.size(); x++) {
				System.out.println((x+1) + ". " + contactos.get(x).getNombre() + 
						" " + contactos.get(x).getNumero());
			}
			System.out.println("**********************************************\n");
			return true;
		}
		
		System.out.println("**********************************************\n");
		
		return false;
		
	}
	
	public void agregarContacto() {
		
		long revisionNumero = 0;
		boolean correctoRevision = false;
		
		System.out.println("\nIntroduccion de Contacto\n");
		System.out.print("Introduzca el nombre del contacto: ");
		nombre = lectorTeclado.nextLine();
		System.out.print("\nIntroduzca el numero de " + nombre + " : ");
		
		while (correctoRevision == false) {
			do {
				numero = lectorTeclado.nextLine();
				try {
					revisionNumero = Long.parseLong(numero);
					correctoRevision = true;
				} catch (Exception e) {
					System.out.println("El valor introducido no es un numero valido, intente de nuevo");
					revisionNumero = 0;
				}
			} while (revisionNumero == 0);
		}
		
		contactos.add(new Contacto(nombre, numero));
		serializar.serializar(contactos);
		
		System.out.println("\nContacto Agregado Sastifactoriamente !!!");
		presionarEnter();
	}
	
	public void listarContacto() {
		
		cargarContactos();
		presionarEnter();
	}
	
	public void presionarEnter() {
		
		lectorTeclado = new Scanner (System.in);
		System.out.println(" -- Presione ENTER para regresar al Menu Principal -- ");
		try {
			lectorTeclado.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarContacto() {
		
		System.out.println("Eliminado de Contacto\n");
		if (cargarContactos() == true) {
			System.out.print("Elija el contacto que desea eliminar ==> ");
			
			try {
				numeroAEliminar = lectorTeclado.nextByte();
			} catch (Exception e) {
				numeroAEliminar = -1;
			}
			
			if (numeroAEliminar <= 0 || numeroAEliminar > contactos.size()) {
				System.out.println("ERROR: El Numero introducido no es un contacto listado");
			} else {
				contactos.remove(numeroAEliminar-1);
				serializar.serializar(contactos);
				System.out.println("\nContacto Eliminado Sastifactoriamente !!!");
				presionarEnter();
			}
		} else {
			presionarEnter();
		}
	}
}
