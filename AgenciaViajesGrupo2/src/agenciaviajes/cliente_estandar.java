package agenciaviajes;

import java.util.Scanner;

public class cliente_estandar extends cliente{
	private String promocion;

	public cliente_estandar() {
		super();
		this.promocion="";
	}
	
	public cliente_estandar(int id,String n,String a,String t,String p) {
		super(id,n,a,t);
		this.promocion=p;
	}
	
	public String getPromocion() {
		return promocion;
	}

	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}
	
	public String toString() {
		return super.toString()+"cliente_estandar [promocion=" + promocion + "]";
	}

	public void pantailaratu() {
		System.out.println("ID cliente: "+this.id_cliente);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Apellidos: "+this.apellidos);
		System.out.println("Telefono: "+this.telefono);
		System.out.println("Promocion: "+this.promocion);
	}
	
	public void leer(Scanner sc) {
		System.out.println("ID cliente: ");
		this.id_cliente=sc.nextInt();	
		System.out.println("Nombre: ");
		this.nombre=sc.next();
		System.out.println("Apellidos: ");
		this.apellidos=sc.next();
		System.out.println("Telefono: ");
		this.telefono=sc.next();	
		System.out.println("Promocion: ");
		this.promocion=sc.next();
	}
	
	
}
