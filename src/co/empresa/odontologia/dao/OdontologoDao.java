package co.empresa.odontologia.dao;

import java.sql.SQLException;

import co.empresa.odontologia.modelo.Odontologo;


public interface OdontologoDao {
	
	public void insert(Odontologo odontologo) throws SQLException;
	
	public Odontologo select(String username, String pass);
	
	public void delete(int id) throws SQLException;
	
	public void update(Odontologo odontologo) throws SQLException;

}
