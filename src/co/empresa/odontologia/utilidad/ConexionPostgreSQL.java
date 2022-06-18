package co.empresa.odontologia.utilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSQL {
	
	private Connection con = null;
	private static ConexionPostgreSQL db;
	private PreparedStatement preparedStatement;
	
	private static final String url = "jdbc:postgresql://localhost:5432/";
	private static final String dbName = "odontologia";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "postgres";
	private static final String password = "1379";
	
	public ConexionPostgreSQL () {
		
		try {
			Class.forName(driver).newInstance();
			con = (Connection)DriverManager.getConnection(url+dbName,userName,password);
					
		}catch (InstantiationException | IllegalAccessException 
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		}
	
	public void cerrarConexion() {
		try {
			con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static ConexionPostgreSQL getConexion() {
		if(db == null){
			db = new ConexionPostgreSQL();
		}
		return db;
	}
	
	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	public int execute() throws SQLException{
		int result = preparedStatement.executeUpdate();
		return result;
	}
	
	public Connection getCon() {
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException{
	
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}

}
