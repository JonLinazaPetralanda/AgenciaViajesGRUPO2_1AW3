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
				reserva r1=new reserva(rs.getInt("id_reserva"),rs.getInt("id_estancia"),rs.getInt("id_vuelo"),rs.getInt("precio"),rs.getDate("dia_inicio"),rs.getDate("dia_fin"));	
				reservas.add(r1);
			}
			
			ResultSet rs1 = st.executeQuery("SELECT * FROM agenciaviaje_taw.socio;");
			while (rs1.next())	{
				socio s1=new socio(rs1.getInt("id_cliente"),rs1.getString("nombre"),rs1.getString("apellidos"),rs1.getString("telefono"),rs1.getString("descuento"));	
				clientesocio.add(s1);
			}
			
			ResultSet rs2 = st.executeQuery("SELECT * FROM agenciaviaje_taw.estancia;");
			while (rs2.next())	{
				estancia e1=new estancia(rs2.getInt("id_estancia"),rs2.getString("direccion"),rs2.getString("ciudad"),rs2.getString("pais"),rs2.getInt("estrella"),rs2.getInt("precio"));	
				estancias.add(e1);
			}
			
			ResultSet rs3 = st.executeQuery("SELECT * FROM agenciaviaje_taw.vuelo;");
			while (rs3.next())	{
				vuelo v1=new vuelo(rs3.getInt("id_vuelo"),rs3.getString("hora_salida"),rs3.getString("hora_llegada"),rs3.getString("ciudad_salida"),rs3.getString("ciudad_llegada"));	
				vuelos.add(v1);
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
			System.out.println("Ongi etorri Traveling Around World bidai agentziara");
			System.out.println("1. Estantzia berri bat erregistratu");
			System.out.println("2. Hegaldi bat erregistratu");
		    System.out.println("3. Erreserba berri bat erregistratu:");
		    System.out.println("4. Hegaldi datuak erakutsi");
		    System.out.println("5. Estantzia datuak erakutsi");
		    System.out.println("6. Erreserba datuak erakutsi");
		    System.out.println("******************************");
		    System.out.println("Zer egin nahi duzu?");
		    menu=sc.nextInt();

		    switch (menu) {
		    	case 1:
		    		estancia e2=new estancia();
		    		e2.leer1(sc);
		    		e2.setId_estancia(estancias.get(estancias.size()-1).getId_estancia()+1);
		    		estancias.add(e2);
		    			break;
		    	
		    	case 2:
		    	for(int j=0;j<vuelos.size();j++) {
		    		vuelo v2=new vuelo();
		    		v2.leer2(sc);
		    		vuelos.add(v2);
		    	}
		    			break;

		    	case 3:
		    		reserva r2=new reserva();
		    		r2.leer(sc);
		    		reservas.add(r2);
		            	break;
		        case 4:
		        	for(int i=0;i<vuelos.size();i++)
		        	System.out.println(vuelos.get(i));
		        		break;
		            
		        case 5:
			        for(int i=0;i<estancias.size();i++)
			        System.out.println(estancias.get(i));
			            break;
			            
		        case 6:
			        for(int i=0;i<reservas.size();i++)
			        System.out.println(reservas.get(i));
			            break;
		   
		    }
            System.out.println("¿Jarraitu nahi duzu? (S/N)");
            char continuar = sc.next().charAt(0);
            if (continuar == 'n' || continuar == 'N') {
                seguir = false;
            }
		
		if (vue) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
				Statement st = conexion.createStatement();
				col = "INSERT FROM cliente;";
				st.executeUpdate(col);
				int id_vuelo;
				String hora_salida;
				String hora_llegada;
				String ciudad_salida;
				String ciudad_llegada;
				for (int pos = 0; pos < reservas.size(); pos++) {
					id_vuelo = vuelos.get(pos).getId_vuelo();
					hora_salida = vuelos.get(pos).getHora_salida();
					hora_llegada = vuelos.get(pos).getHora_llegada();
					ciudad_salida = vuelos.get(pos).getCiudad_salida();
					ciudad_llegada = vuelos.get(pos).getCiudad_llegada();
					col = "insert into vuelo values ("+id_vuelo+",'"+hora_salida+"','"+ hora_llegada +"','"+ciudad_salida+"','"+ciudad_salida+"','"+ciudad_llegada+");";
					st.executeUpdate(col);
				}
				conexion.close();
			} catch (SQLException e) {
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de Conexión");
			}
		}
		
		if (est) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
				Statement st = conexion.createStatement();
				col = "INSERT FROM cliente;";
				st.executeUpdate(col);
				int id_estancia;
				String direccion;
				String ciudad;
				String pais;
				int estrella;
				int precio;
				for (int pos = 0; pos < reservas.size(); pos++) {
					id_estancia = estancias.get(pos).getId_estancia();
					direccion = estancias.get(pos).getDireccion();
					ciudad = estancias.get(pos).getCiudad();
					pais = estancias.get(pos).getPais();
					estrella = estancias.get(pos).getEstrella();
					precio = estancias.get(pos).getPrecio();
					col = "insert into estancia values ("+id_estancia+",'"+direccion+"','"+ ciudad +"','"+pais+"','"+estrella+"','"+precio+");";
					st.executeUpdate(col);
				}
				conexion.close();
			} catch (SQLException e) {
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de Conexión");
			}
		}
		
		if (res) {
			try {
				String col = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviaje_taw", "root", "");
				Statement st = conexion.createStatement();
				col = "INSERT FROM cliente;";
				st.executeUpdate(col);
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
					col = "insert into reservas values ("+id_reserva+",'"+id_estancia+"','"+ id_vuelo +"','"+precio+"','"+dia_inicio+"','"+dia_fin+");";
					st.executeUpdate(col);
				}
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
