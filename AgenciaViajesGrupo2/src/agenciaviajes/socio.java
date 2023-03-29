package agenciaviajes;

import java.util.Scanner;

public class socio extends cliente {
	private String descuento;
	
	public socio() {
		super();
		this.descuento="";
	}
	
	public socio(int id,String n,String a,String t,String d) {
		super(id,n,a,t);
		this.descuento=d;
	}
	
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	

	@Override
	public String toString() {
		return super.toString()+"socio [descuento=" + descuento + "]";
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
		System.out.println("Descuentos: ");
		this.descuento=sc.next();
	}

}
