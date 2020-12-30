package cl.awakelab.negocio.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleCon {
	public static void main(String args[]){  

		try{  
			//paso 1: carga la clase del controlador
			Class.forName
			("oracle.jdbc.driver.OracleDriver");  

			//paso 2: crear la conexi�n con el objeto  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe",
			"capacitacion",
			"1234");
			
			//paso 3: crear objeto statement  
			Statement stmt=con.createStatement();  

			//paso 4: ejecutar query
			ResultSet rs = stmt.executeQuery
			("select * from capacitacion");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + 
				"  " + rs.getString(2) + 
				"  " + rs.getString(3));  
			}
			
			//paso 5: cierra el objeto de conexi�n  
			con.close();    
		}
		catch(Exception e){
			System.out.println(e);
		}    
	}

}
