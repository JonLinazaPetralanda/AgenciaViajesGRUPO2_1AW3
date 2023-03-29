package agenciaviajes;

import java.util.Scanner;

public class vuelo {
	private int id_vuelo;
	private String hora_salida;
	private String hora_llegada;
	private String ciudad_salida;
	private String ciudad_llegada;
	
	public vuelo() {
		this.id_vuelo=0;
		this.hora_salida="";
		this.hora_llegada="";
		this.ciudad_salida="";
		this.ciudad_llegada="";
	}
	
	public vuelo(int id,String hs,String hl,String cs,String cl) {
		this.id_vuelo=id;
		this.hora_salida=hs;
		this.hora_llegada=hl;
		this.ciudad_salida=cs;
		this.ciudad_llegada=cl;
	}
	
	public int getId_vuelo() {
		return id_vuelo;
	}
	public String getHora_salida() {
		return hora_salida;
	}
	public String getHora_llegada() {
		return hora_llegada;
	}
	public String getCiudad_salida() {
		return ciudad_salida;
	}
	public String getCiudad_llegada() {
		return ciudad_llegada;
	}
	
	
	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}
	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}
	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public void setCiudad_salida(String ciudad_salida) {
		this.ciudad_salida = ciudad_salida;
	}
	public void setCiudad_llegada(String ciudad_llegada) {
		this.ciudad_llegada = ciudad_llegada;
	}

	public String toString() {
		return "vuelo [id_vuelo=" + id_vuelo + ", hora_salida=" + hora_salida + ", hora_llegada=" + hora_llegada
				+ ", ciudad_salida=" + ciudad_salida + ", ciudad_llegada=" + ciudad_llegada + "]";
	}
	
	public void pnatailaratuVuelo() {
		System.out.println("ID del vuelo: "+this.id_vuelo);
		System.out.println("Hora de salida: "+this.hora_salida);
		System.out.println("Hora estimada de llegada: "+this.hora_llegada);
		System.out.println("Ciudad de salida: "+this.ciudad_salida);
		System.out.println("Ciudad de llegada: "+this.ciudad_llegada);
	}
	
	public void leerVuelo (Scanner sc) {
		System.out.println("ID del vuelo: ");
		this.id_vuelo=sc.nextInt();
		System.out.println("Hora de salida: ");
		this.hora_salida=sc.next();
		System.out.println("Hora estimada de llegada: ");
		this.hora_llegada=sc.next();
		System.out.println("Ciudad de salida: ");
		this.ciudad_salida=sc.next();
		System.out.println("Ciudad de llegada: ");
		this.ciudad_llegada=sc.next();
	}
	
	
}
