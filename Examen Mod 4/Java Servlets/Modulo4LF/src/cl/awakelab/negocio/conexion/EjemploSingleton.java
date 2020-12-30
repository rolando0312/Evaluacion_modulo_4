package cl.awakelab.negocio.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploSingleton {

    // Propiedades
    private static Connection conn = null;
 
    // Constructor
    private EjemploSingleton(){ 
		String url = 
		"jdbc:oracle:thin:@localhost:1521:xe";
		
		String driver = 
		"oracle.jdbc.driver.OracleDriver";
		
		String usuario = "capacitacion";
		String password = "1234";
	  
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection
			(url, usuario, password);
		}
		catch (ClassNotFoundException 
				| SQLException e){
			e.printStackTrace();
		}
	} // Fin constructor

	// M�todos
	public static Connection getConnection(){
		if (conn == null){
			new EjemploSingleton();
		}
	  
		return conn;
	} // Fin getConnection
}