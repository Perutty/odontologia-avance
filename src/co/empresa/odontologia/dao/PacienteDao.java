package co.empresa.odontologia.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.odontologia.modelo.Paciente;

public interface PacienteDao {
	
	public void insert(Paciente paciente) throws SQLException;
	
	public Paciente select(String cedula);
	
	public List <Paciente> selectAll();
	
	public void delete(int id) throws SQLException;
	
	public void update(Paciente paciente) throws SQLException;

}
