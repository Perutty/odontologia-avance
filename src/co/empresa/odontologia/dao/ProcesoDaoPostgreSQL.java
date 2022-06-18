package co.empresa.odontologia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.odontologia.modelo.Proceso;
import co.empresa.odontologia.utilidad.ConexionPostgreSQL;

public class ProcesoDaoPostgreSQL implements ProcesoDao {

private ConexionPostgreSQL conexion;
	
	private static final String INSERT_PROCESO_SQL = "INSERT INTO proceso(processname, paciente_id, date_process, value, observation, codigo) VALUES (?,?,?,?,?,?);";
	private static final String UPDATE_PROCESO_SQL = "UPDATE proceso SET processname = ?, paciente_id = ?, date_process = ?, value = ?, observation = ?, codigo = ?, WHERE id = ?;";
	private static final String DELETE_PROCESO_SQL = "DELETE FROM proceso WHERE id = ?;";
	private static final String SELECT_PROCESO_BY_COD = "SELECT * FROM proceso WHERE codigo = ?;";
	private static final String SELECT_ALL_PROCESOS = "SELECT * FROM proceso;";
	
	public ProcesoDaoPostgreSQL() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}
	
	public void insert(Proceso proceso) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_PROCESO_SQL);
			preparedStatement.setString(1, proceso.getProcessname());
			preparedStatement.setInt(2, proceso.getPaciente_id());
			preparedStatement.setDate(3, (Date)proceso.getDate_process());
			preparedStatement.setInt(4, proceso.getValue());
			preparedStatement.setString(5, proceso.getObservation());
			preparedStatement.setString(6, proceso.getCodigo());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	
	public void update(Proceso proceso) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_PROCESO_SQL);
			preparedStatement.setString(1, proceso.getProcessname());
			preparedStatement.setInt(2, proceso.getValue());
			preparedStatement.setString(3, proceso.getObservation());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_PROCESO_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e){
		
		}
	}
	
	public List<Proceso> selectAll(){
		List <Proceso> procesos = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_PROCESOS);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("processname");
				int paci_id = rs.getInt("paciente_id");
				Date fecha = rs.getDate("date_process");
				Integer value = rs.getInt("value");
				String observation = rs.getString("observation");
				String cod = rs.getString("codigo");
				procesos.add(new Proceso(id,cod, paci_id, name, fecha, value, observation));
			}
			
		}catch(SQLException e) {
			
		}
		
		return procesos;
 	}
	
	public Proceso select(String codigo){
		Proceso p = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_PROCESO_BY_COD);
			preparedStatement.setString(1, codigo);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String name = rs.getString("processname");
				Date fecha = rs.getDate("date_process");
				Integer value = rs.getInt("value");
				String observation = rs.getString("observation");
				String cod = rs.getString("codigo");
				p = new Proceso(name,fecha,value, observation,cod);
			}
			
		}catch(SQLException e) {
			
		}
		return p;
 	}
}
