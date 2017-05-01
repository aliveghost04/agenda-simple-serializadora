package edu.itla.agendaserializadora.iu;
import java.util.Scanner;

import edu.itla.agendaserializadora.contacto.ManejadorContactos;

public class Menu {
	
	Scanner lectorTeclado;
	
	public Menu() {
		
		ManejadorContactos mngC = new ManejadorContactos();
		byte eleccion;
		boolean continuar = true;
		
		while (continuar == true) {
			lectorTeclado = new Scanner(System.in);
			System.out.println("Bienvenido a la Agenda de Erick Serializadora\n");
			System.out.println("1. Agregar Contacto");
			System.out.println("2. Listar Contacto");
			System.out.println("3. Eliminar Contacto");
			System.out.println("4. Salir\n");
			System.out.print("Elija una opcion ==> ");
			
			try {
				eleccion = lectorTeclado.nextByte();
			} catch (Exception e) {
				eleccion = 0;
			}
			
			switch (eleccion) {
			case 1:
				mngC.agregarContacto();
			break;
			case 2:
				mngC.listarContacto();
			break;
			case 3:
				mngC.eliminarContacto();
			break;
			case 4:
				continuar = false;
				System.out.println("Adios :(");
			break;
			default:
				System.out.println("*** Elija una opcion valida ***");
			break;
			}
		}
	}
}
