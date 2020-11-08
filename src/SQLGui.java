

import java.sql.*;

import javax.swing.*;


public class SQLGui {
	
	
	
	public static Connection dbConnector()
	{
		
		Connection conn1 = null;
		Statement stmt = null;
		String database = "PowerSystem";
		String username = "root";
		String password = "root";

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn1 = DriverManager.getConnection("jdbc:mysql://localhost/" + database,username,password);
			return conn1;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Connection successful");
			return null;
		}
	}
	
	
	
	
	
}
