package agenciaviajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BDConexion {
	public static void main(String[] args)	{
		
	try{
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviajes_taw", "root", "");
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM vuelo;");

		while (rs.next())
		{
			System.out.println("ID_vuelo: "+rs.getObject("id_vuelo")+
							   ", hora_salida: "+rs.getObject("hora_salida")+
							   ", hora_llegada: "+rs.getObject("hora_llegada")+
							   ", ciudad_salida: "+rs.getObject("ciudad_salida")+
							   ", ciudad_llegada: "+rs.getObject("ciudad_llegada"));
		}
		
		rs.close();
		st.close();
		conexion.close();

		}	catch (SQLException e){
				e.printStackTrace();
				System.out.println("Error de Conexión");
		}
	
	try{
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviajes_taw", "root", "");
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM estancia;");

		while (rs.next())	{
			System.out.println("ID_estancia: "+rs.getObject("id_estancia")+
							   ", direccion: "+rs.getObject("direccion")+
							   ", ciudad: "+rs.getObject("ciudad")+
							   ", pais: "+rs.getObject("pais")+
							   ", estrella: "+rs.getObject("estrella")+
							   ", precio: "+rs.getObject("precio"));
		}
		
		rs.close();
		st.close();
		conexion.close();

		}	catch (SQLException e){
				e.printStackTrace();
				System.out.println("Error de Conexión");
		}
	
	try{
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciaviajes_taw", "root", "");
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM cliente;");

		while (rs.next())	{
			System.out.println("ID_cliente: "+rs.getObject("id_cliente")+
							   ", nombre: "+rs.getObject("nombre")+
							   ", apellidos: "+rs.getObject("apellidos")+
							   ", telefono: "+rs.getObject("telefono"));
		}	
		rs.close();
		st.close();
		conexion.close();
		}	
			catch (SQLException e){
				e.printStackTrace();
			System.out.println("Error de Conexión");
		}
	
	}
}
