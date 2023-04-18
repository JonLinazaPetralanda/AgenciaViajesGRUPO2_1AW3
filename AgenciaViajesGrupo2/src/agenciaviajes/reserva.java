package agenciaviajes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class reserva implements Serializable{
	
	private int id_reserva;
	private int id_estancia;
	private int id_vuelo;
	private int precio;
	private Date dia_inicio;
	private Date dia_fin;
	
	public reserva() {
		this.id_reserva=0;
		this.id_estancia=0;
		this.id_vuelo=0;
		this.precio=0;
		this.dia_inicio=new Date(0-0-0);
		this.dia_fin=new Date(0-0-0);
	}
	public reserva(int r,int e,int v,int p,Date diai,Date diaf) {
		this.id_reserva=r;
		this.id_estancia=e;
		this.id_vuelo=v;
		this.precio=p;
		this.dia_inicio=diai;
		this.dia_fin=diaf;
	}
	
	public int getId_reserva() {
		return id_reserva;
	}
	public int getId_estancia() {
		return id_estancia;
	}
	public int getId_vuelo() {
		return id_vuelo;
	}
	public int getPrecio() {
		return precio;
	}
	public Date getDia_inicio() {
		return dia_inicio;
	}
	public Date getDia_fin() {
		return dia_fin;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public void setId_estancia(int id_estancia) {
		this.id_estancia = id_estancia;
	}
	public void setId_vuelo(int id_vuelo) {
		this.id_vuelo = id_vuelo;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setDia_inicio(Date dia_inicio) {
		this.dia_inicio = dia_inicio;
	}
	public void setDia_fin(Date dia_fin) {
		this.dia_fin = dia_fin;
	}
	
	public String toString() {
		return "reserva= ID de la reserva= "+id_reserva+", ID de la estancia="+id_estancia+", ID de vuelo="+id_vuelo
				+", Precio total="+precio+", Dia que inicia="+dia_inicio+", Dia que finaliza="+dia_fin+".";
			}

	public void pantailaratuReserva() {
		System.out.println("******************");
		System.out.println("ID de la reserva: "+this.id_reserva);
		System.out.println("ID de estancia: "+this.id_estancia);
		System.out.println("ID de vuelo: "+this.id_vuelo);
		System.out.println("Precio: "+this.precio);
		System.out.println("Cuando empieza: "+this.dia_inicio);
		System.out.println("Cuando acaba: "+this.dia_fin);
	}
	public void leerReserva(Scanner sc) {
		System.out.println("Introduce tu correspondiente ID de la reserva: ");
		this.id_reserva=sc.nextInt();
		System.out.println("Ahora la ID de la estancia: ");
		this.id_estancia=sc.nextInt();
		System.out.println("Por ultimo la ID del vuelo: ");
		this.id_vuelo=sc.nextInt();
		System.out.println("Precio total ");
		this.precio=sc.nextInt();		
		System.out.println("Dia de inicio: ");
		try {
			this.dia_inicio= (Date) new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
		}	
		catch (ParseException e){
			e.printStackTrace();
		}
		System.out.println("Dia final: ");
		try {
			this.dia_fin= (Date) new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
		}	
		catch (ParseException e){
			e.printStackTrace();
		}
	}
}
