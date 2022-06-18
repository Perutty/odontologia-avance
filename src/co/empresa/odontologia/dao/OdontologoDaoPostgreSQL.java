package co.empresa.odontologia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.empresa.odontologia.modelo.Odontologo;
import co.empresa.odontologia.utilidad.ConexionPostgreSQL;

public class OdontologoDaoPostgreSQL implements OdontologoDao{
	
private ConexionPostgreSQL conexion;
	
	private static final String INSERT_ODONTOLOGO_SQL = "INSERT INTO odontologo	(username, pass, email, telefono, consultorio) VALUES (?,?,?,?,?);";
	private static final String UPDATE_ODONTOLOGO_SQL = "UPDATE odontologo SET username = ?, email = ?, pass = ?, telefono = ?, consultorio = ? WHERE id = ?;";
	private static final String DELETE_ODONTOLOGO_SQL = "DELETE FROM odontologo WHERE id = ?;";
	private static final String SELECT_ODONTOLOGO_BY_CREDENTIAL = "SELECT * FROM odontologo WHERE username = ? AND pass = ?;";
	
	public OdontologoDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}
	
	public void insert(Odontologo odontologo) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_ODONTOLOGO_SQL);
			preparedStatement.setString(1, odontologo.getUsername());
			preparedStatement.setString(2, odontologo.getPass());
			preparedStatement.setString(3, odontologo.getEmail());
			preparedStatement.setString(4, odontologo.getTelefono());
			preparedStatement.setString(5, odontologo.getConsultorio());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	
	public void update(Odontologo odontologo) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_ODONTOLOGO_SQL);
			preparedStatement.setString(1, odontologo.getPass());
			preparedStatement.setString(2, odontologo.getEmail());
			preparedStatement.setString(3, odontologo.getTelefono());
			preparedStatement.setString(4, odontologo.getConsultorio());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_ODONTOLOGO_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e){
		
		}
	}
	
	
	public Odontologo select(String username, String pass){
		Odontologo doc = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ODONTOLOGO_BY_CREDENTIAL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String p = rs.getString("pass");
				doc = new Odontologo(id,user, p);
			}
			
		}catch(SQLException e) {
			
		}
		return doc;
 	}

}
