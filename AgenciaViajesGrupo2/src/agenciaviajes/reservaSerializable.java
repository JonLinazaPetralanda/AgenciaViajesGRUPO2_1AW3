package agenciaviajes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class reservaSerializable {
	public static void main(String[] args) {
		
		reserva r = new reserva();
		
		try {
			FileOutputStream fos = new FileOutputStream("reserva.dat");
			ObjectOutputStream oos = new ObjectOutputStream (fos);	

			oos.writeObject(r);

			oos.close();
			fos.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream("reserva.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			r = (reserva) ois.readObject(); 

			System.out.println("reserva leido: "+r);

			ois.close();
			fis.close();
			
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error archivo reserva.dat No encontrado.");
		} catch (IOException ioe) {
			System.out.println("Error de Entrada / Salida");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error Clase No Encontrada");
		}
	}
}



