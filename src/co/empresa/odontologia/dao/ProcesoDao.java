package co.empresa.odontologia.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.odontologia.modelo.Proceso;

public interface ProcesoDao {
	
public void insert(Proceso proceso) throws SQLException;
	
	public Proceso select(String codigo);
	
	public List <Proceso> selectAll();
	
	public void delete(int id) throws SQLException;
	
	public void update(Proceso proceso) throws SQLException;

}
