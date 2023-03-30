package agenciaviajes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class agenciaMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<reserva> reservas=new ArrayList<reserva>();
		ArrayList<socio> clientesocio=new ArrayList<socio>();
		ArrayList<estancia> estancias=new ArrayList<estancia>();
		ArrayList<vuelo> vuelos=new ArrayList<vuelo>();
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
		    System.out.println("******************************");
		    System.out.println("Zer egin nahi duzu?");
		    menu=sc.nextInt();

		    switch (menu) {
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
            System.out.println("¿Jarraitu nahi duzu? (S/N)");
            char continuar = sc.next().charAt(0);
            if (continuar == 'n' || continuar == 'N') {
                seguir = false;
            }	
		
		 if (vue) {
			try {
				String consulta = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
				Statement st = conexion.createStatement();
				consulta = "delete FROM vuelo;";
				st.executeUpdate(consulta);
				int id_vuelo;
				String hora_salida;
				String hora_llegada;
				String ciudad_salida;
				String ciudad_llegada;
				for (int pos = 0; pos < vuelos.size(); pos++) {
					id_vuelo = vuelos.get(pos).getId_vuelo();
					hora_salida = vuelos.get(pos).getHora_salida();
					hora_llegada = vuelos.get(pos).getHora_llegada();
					ciudad_salida = vuelos.get(pos).getCiudad_salida();
					ciudad_llegada = vuelos.get(pos).getCiudad_llegada();
					
					consulta = "insert into vuelo values ("+id_vuelo+",'"+hora_salida+"','"+ hora_llegada +"','"+ciudad_salida+"','"+ciudad_salida+"','"+ciudad_llegada+");";
					st.executeUpdate(consulta);
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
				String consulta = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
				Statement st = conexion.createStatement();
				consulta = "delete FROM estancia;";
				st.executeUpdate(consulta);
				int id_estancia;
				String direccion;
				String ciudad;
				String pais;
				int estrella;
				int precio;
				for (int pos = 0; pos < estancias.size(); pos++) {
					id_estancia = estancias.get(pos).getId_estancia();
					direccion = estancias.get(pos).getDireccion();
					ciudad = estancias.get(pos).getCiudad();
					pais = estancias.get(pos).getPais();
					estrella = estancias.get(pos).getEstrella();
					precio = estancias.get(pos).getPrecio();
					consulta = "insert into estancia values ("+id_estancia+",'"+direccion+"','"+ ciudad +"','"+pais+"','"+estrella+"','"+precio+");";
					st.executeUpdate(consulta);
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
				String consulta = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
				Statement st = conexion.createStatement();
				consulta = "delete FROM reserva;";
				st.executeUpdate(consulta);
				int id_reserva;
				int id_estancia;
				int id_vuelo;
				int precio;
				Date dia_inicio;
				Date dia_fin;
				for (int pos = 0; pos < reservas.size(); pos++) {
					id_reserva = reservas.get(pos).getId_reserva();
					id_estancia = reservas.get(pos).getId_estancia();
					id_vuelo = reservas.get(pos).getId_vuelo();
					precio = reservas.get(pos).getPrecio();
					dia_inicio = reservas.get(pos).getDia_inicio();
					dia_fin = reservas.get(pos).getDia_fin();
					consulta = "insert into reservas values ("+id_reserva+",'"+id_estancia+"','"+ id_vuelo +"','"+precio+"','"+dia_inicio+"','"+dia_fin+");";
					st.executeUpdate(consulta);
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
