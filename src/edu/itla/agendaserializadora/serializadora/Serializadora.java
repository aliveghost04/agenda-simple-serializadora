package edu.itla.agendaserializadora.serializadora;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.itla.agendaserializadora.contacto.Contacto;

public class Serializadora {
	
	public void serializar(ArrayList<Contacto> contactos) {
		try {
			FileOutputStream fos = new FileOutputStream("data.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contactos);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Contacto> getContactos() {
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		try {
			FileInputStream fis = new FileInputStream("data.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			contactos = (ArrayList<Contacto>) ois.readObject();
			ois.close();
			fis.close();
			return contactos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return contactos;
		}
	}
}
