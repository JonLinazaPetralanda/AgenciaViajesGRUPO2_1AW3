package agenciaviajes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class agenciaMain {

	public static void main(String[] args) {
		/*
		 * Documentacion del main
		 * 
		 * @author Grupo2: Jon Linaza, Asier Murillo, Gaizka Mendez
		 * @version: 17.04.2023
		 */
		Scanner sc=new Scanner(System.in);
		ArrayList<reserva> reservas=new ArrayList<reserva>();
		ArrayList<socio> clientesocio=new ArrayList<socio>();
		ArrayList<estancia> estancias=new ArrayList<estancia>();
		ArrayList<vuelo> vuelos=new ArrayList<vuelo>();
		reserva re1;
		estancia es1;
		vuelo vu1;
		/*
		 * Las matrices de cada clase creadas para almacenar los datos correspondientes
		 * En estancias se almacenara datos que se introdujeron en estancia.
		 */
		int menu;
		boolean seguir=true;
		boolean vue=false;
		boolean est=false;
		boolean res=false;
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM agenciaviaje_taw.reserva;");
			while (rs.next())	{
				reserva r=new reserva(rs.getInt("id_reserva"),rs.getInt("id_estancia"),rs.getInt("id_vuelo"),rs.getInt("precio"),rs.getDate("dia_inicio"),rs.getDate("dia_fin"));	
				reservas.add(r);
			}
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM agenciaviaje_taw.socio;");
			while (rs1.next())	{
				socio s=new socio(rs1.getInt("id_cliente"),rs1.getString("nombre"),rs1.getString("apellidos"),rs1.getString("telefono"),rs1.getString("descuento"));	
				clientesocio.add(s);
			}
			
			ResultSet rs2 = st.executeQuery("SELECT * FROM agenciaviaje_taw.estancia;");
			while (rs2.next())	{
				estancia e=new estancia(rs2.getInt("id_estancia"),rs2.getString("direccion"),rs2.getString("ciudad"),rs2.getString("pais"),rs2.getInt("estrella"),rs2.getInt("precio"));	
				estancias.add(e);
			}
			
			ResultSet rs3 = st.executeQuery("SELECT * FROM agenciaviaje_taw.vuelo;");
			while (rs3.next())	{
				vuelo v=new vuelo(rs3.getInt("id_vuelo"),rs3.getString("hora_salida"),rs3.getString("hora_llegada"),rs3.getString("ciudad_salida"),rs3.getString("ciudad_llegada"));	
				vuelos.add(v);
			}
			
			rs.close();
			rs1.close();
			rs2.close();
			rs3.close();
			st.close();
			conexion.close();

		}	catch (SQLException e){
				e.printStackTrace();
				System.exit(0);
		}
		
		do {
			System.out.println("1. Estantzia berri bat erregistratu");
			System.out.println("2. Hegaldi bat erregistratu");
		    System.out.println("3. Erreserba berri bat erregistratu:");
		    System.out.println("4. Estantzia datuak erakutsi");
		    System.out.println("5. Hegaldi datuak erakutsi");
		    System.out.println("6. Erreserba datuak erakutsi");
		    System.out.println("0. Atera programatik");
		    System.out.println("******************************");
		    System.out.println("Zer egin nahi duzu?");
		    menu=sc.nextInt();

		    switch (menu) {
		    	case 0:
		    		System.exit(0);
		    		break;
		    	case 1:
		    		estancia e1=new estancia();
		    			e1.leerEstancia(sc);
		    			estancias.add(e1);
		    			est=true;
		    		break;
		    	
		    	case 2:
		       		vuelo v1=new vuelo();
		       			v1.leerVuelo(sc);
		    			vuelos.add(v1);
		    			vue=true;
		    		break;

		    	case 3:
		    		reserva r1=new reserva();
		    			r1.leerReserva(sc);
		    			reservas.add(r1);
		    			res=true;
		            break;
		        
		    	case 4:
		        	for(estancia e2 : estancias) {
		        		e2.pantailaratuEstancia();
			        }
			        break;
		            	
		    	case 5:
		        	for(vuelo v2 : vuelos) {
		        		v2.pnatailaratuVuelo();
		        	}
		        	break;
			            
		        case 6:
			        for(reserva r2: reservas) {
			        	r2.pantailaratuReserva();
			        }
			        break;
		 
		    }
            System.out.println("¿Jarraitu nahi duzu? Ez/Bai");
            char continuar = sc.next().charAt(0);
            if (continuar == 'e' || continuar == 'E') {
                seguir = false;
            }	
		
		 if (vue) {
			try {
				String url = "jdbc:mysql://localhost/agenciaviaje_taw";
				String user = "root";
				String password = "";
				Connection conexion = DriverManager.getConnection(url, user, password);
				Statement st = conexion.createStatement();
				//String consulta = "";
				//consulta = "delete FROM vuelo;";
				//st.executeUpdate(consulta);
				for (int pos = 0; pos < vuelos.size(); pos++) {
					vu1=vuelos.get(pos);
					int id_vuelo = vu1.getId_vuelo();
					String hora_salida = vu1.getHora_salida();
					String hora_llegada = vu1.getHora_llegada();
					String ciudad_salida = vu1.getCiudad_salida();
					String ciudad_llegada = vu1.getCiudad_llegada();
					st.executeUpdate("insert into vuelo values ("+id_vuelo+",'"+hora_salida+"','"+ hora_llegada +"','"+ciudad_salida+"','"+ciudad_llegada+");");
					
				}
				st.close();
				conexion.close();
			} catch (SQLException e) {
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de Conexión");
			}
		}	
		
		if (est) {
			try {
				String url = "jdbc:mysql://localhost/agenciaviaje_taw";
				String user = "root";
				String password = "";
				Connection conexion = DriverManager.getConnection(url, user, password);
				Statement st = conexion.createStatement();
			//	String consulta = "";
			//	consulta = "delete FROM estancia;";
			//	st.executeUpdate(consulta);
			
				for (int pos = 0; pos < estancias.size(); pos++) {
					es1=estancias.get(pos);
					int id_estancia = es1.getId_estancia();
					String direccion = es1.getDireccion();
					String ciudad = es1.getCiudad();
					String pais = es1.getPais();
					int estrella = es1.getEstrella();
					int precio = es1.getPrecio();
					st.executeUpdate("insert into estancia values ("+id_estancia+",'"+direccion+"','"+ ciudad +"','"+pais+"','"+estrella+"','"+precio+");");
					
				}
				st.close();
				conexion.close();
			} catch (SQLException e) {
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de Conexión");
			}
		}	
		
		if (res) {
			try {
				String url = "jdbc:mysql://localhost/agenciaviaje_taw";
				String user = "root";
				String password = "";
				Connection conexion = DriverManager.getConnection(url, user, password);
				Statement st = conexion.createStatement();
			//	String consulta = "";
			//	consulta = "delete FROM reserva;";
			//	st.executeUpdate(consulta);
			//  consulta = "delete FROM estancia;";
			//	st.executeUpdate(consulta);
			//	consulta = "delete FROM vuelo;";
			//	st.executeUpdate(consulta);
							
				
				for (int pos = 0; pos < reservas.size(); pos++) {
					re1=reservas.get(pos);
					int id_reserva = re1.getId_reserva();
					int id_estancia = re1.getId_estancia();
					int id_vuelo = re1.getId_vuelo();
					int precio = re1.getPrecio();
					Date dia_inicio = (Date) re1.getDia_inicio();
					Date dia_fin = (Date) re1.getDia_fin();
					
					es1=estancias.get(pos);
				//	int id_estancia = es1.getId_estancia();
					String direccion = es1.getDireccion();
					String ciudad = es1.getCiudad();
					String pais = es1.getPais();
					int estrella = es1.getEstrella();
				//	int precio = es1.getPrecio();
					
					vu1=vuelos.get(pos);
				//	int id_vuelo = vu1.getId_vuelo();
					String hora_salida = vu1.getHora_salida();
					String hora_llegada = vu1.getHora_llegada();
					String ciudad_salida = vu1.getCiudad_salida();
					String ciudad_llegada = vu1.getCiudad_llegada();
			
					st.executeUpdate("insert into estancia values ("+id_estancia+",'"+direccion+"','"+ ciudad +"','"+pais+"','"+estrella+"','"+precio+");");
					st.executeUpdate("insert into vuelo values ("+id_vuelo+",'"+hora_salida+"','"+ hora_llegada +"','"+ciudad_salida+"','"+ciudad_llegada+");");
					st.executeUpdate("insert into reserva values ("+id_reserva+",'"+id_estancia+"','"+ id_vuelo +"','"+precio+"','"+dia_inicio+"','"+dia_fin+");");
					
				}
				st.close();
				conexion.close();
			} catch (SQLException e) {
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de Conexión");
			}
		}
		
	}
		while (seguir);	
	}

}
