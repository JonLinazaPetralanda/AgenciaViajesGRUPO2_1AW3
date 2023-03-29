package agenciaviajes;

import java.util.Scanner;

public class estancia {
	private int id_estancia;
	private String direccion;
	private String ciudad;
	private String pais;
	private int estrella;
	private int precio;

	public estancia() {
		this.id_estancia=0;
		this.direccion="";
		this.ciudad="";
		this.pais="";
		this.estrella=0;
		this.precio=0;
	}
	
	public estancia(int e,String d,String c,String p,int es,int pr) {
		this.id_estancia=e;
		this.direccion=d;
		this.ciudad=c;
		this.pais=p;
		this.estrella=es;
		this.precio=pr;
	}	

	public int getId_estancia() {
		return id_estancia;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getPais() {
		return pais;
	}
	public int getEstrella() {
		return estrella;
	}
	public int getPrecio() {
		return precio;
	}

	
	public void setId_estancia(int id_estancia) {
		this.id_estancia = id_estancia;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setEstrella(int estrella) {
		this.estrella = estrella;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void pantailaratu() {
		System.out.println("ID estancia: "+this.id_estancia);
		System.out.println("Descripcion: "+this.direccion);
		System.out.println("Ciudad: "+this.ciudad);
		System.out.println("Pais "+this.pais);
		System.out.println("Estrella "+this.estrella);
		System.out.println("Precio"+this.precio);
	}
	
	public void leer1(Scanner sc) {
		System.out.println("ID estancia: ");
		this.id_estancia=sc.nextInt();
		System.out.println("Direccion: ");
		this.direccion=sc.next();
		System.out.println("Ciudad: ");
		this.ciudad = sc.next();
		System.out.println("Pais: ");
		this.pais=sc.next();
		System.out.println("Estrellas: ");
		this.estrella=sc.nextInt();
		System.out.println("Precio: ");
		this.precio=sc.nextInt();
	}
	
	
}
