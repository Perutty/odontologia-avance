package co.empresa.odontologia.dao;

public class PacienteDaoFactory {

public static PacienteDao getPacienteDao(String type) {
		
		switch(type)
		{
			
		case "postgresql":
			return new PacienteDaoPostgreSQL();
			
		default:
			break;
		}
		return null;
	}
}
