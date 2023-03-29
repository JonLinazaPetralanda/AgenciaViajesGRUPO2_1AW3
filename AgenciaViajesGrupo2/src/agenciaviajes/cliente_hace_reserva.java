package agenciaviajes;

import java.util.Scanner;

public class cliente_hace_reserva {
	private int id_reserva;
	private int id_cliente;
	
	public cliente_hace_reserva() {
		this.id_reserva=0;
		this.id_cliente=0;
	}
	
	public cliente_hace_reserva(int r,int c) {
		this.id_reserva=r;
		this.id_cliente=c;
	}
	
	public int getId_reserva() {
		return id_reserva;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String toString() {
		return "cliente_hace_reserva [id_reserva=" + id_reserva + ", id_cliente=" + id_cliente + "]";
	}
	
	public void pantailaratu() {
		System.out.println("ID de reserva: "+this.id_reserva);
		System.out.println("ID de cliente: "+this.id_cliente);
	}
	
	public void leer(Scanner sc) {
		System.out.println("ID de reserva: ");
		this.id_reserva=sc.nextInt();
		System.out.println("ID de cliente: ");
		this.id_cliente=sc.nextInt();
	}
	
}
