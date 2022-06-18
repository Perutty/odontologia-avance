package co.empresa.odontologia.dao;

public class ProcesoDaoFactory {

public static ProcesoDao getProcesoDao(String type) {
		
		switch(type)
		{
			
		case "postgresql":
			return new ProcesoDaoPostgreSQL();
			
		default:
			break;
		}
		return null;
	}
}
