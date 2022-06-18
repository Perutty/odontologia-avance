package co.empresa.odontologia.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String username;
	
	private String pass;
	
	private String email;
	
	private String telefono;
	
	private String consultorio;


	public Odontologo(int id, String username, String pass) {
		
		this.id = id;
		this.username = username;
		this.pass = pass;
	}
	
	public Odontologo(String username, String pass, String email, String telefono, String consultorio) {
		
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.telefono = telefono;
		this.consultorio = consultorio;
	}
	
public Odontologo(Integer id, String pass, String email, String telefono, String consultorio) {
		
		this.id = id;
		this.pass = pass;
		this.email = email;
		this.telefono = telefono;
		this.consultorio = consultorio;
	}
}
