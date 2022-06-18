package co.empresa.odontologia.dao;

public class OdontologoDaoFactory {

public static OdontologoDao getOdontologoDao(String type) {
		
		switch(type)
		{
			
		case "postgresql":
			return new OdontologoDaoPostgreSQL();
			
		default:
			break;
		}
		return null;
	}
}
