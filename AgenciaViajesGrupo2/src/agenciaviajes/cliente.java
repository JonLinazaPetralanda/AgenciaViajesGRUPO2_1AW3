package agenciaviajes;

import java.util.Scanner;

public abstract class cliente {
	protected int id_cliente;
	protected String nombre;
	protected String apellidos;
	protected String telefono;
	
	public cliente() {
		this.id_cliente=0;
		this.nombre="";
		this.apellidos="";
		this.telefono="";
	}
	
	public cliente(int id,String n,String a,String t) {
		this.id_cliente=0;
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
	}	
	
	public int getId_cliente() {
		return id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return "cliente [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + "]";
	}
	
	public abstract void leerCliente(Scanner sc);
	
	public void pantailaratuCliente() {
		System.out.println("ID cliente "+this.id_cliente);
		System.out.println("Nombre "+this.nombre);
		System.out.println("Apellidos "+this.apellidos);
		System.out.println("Telefono"+this.telefono);
	}
	
	
	
}
