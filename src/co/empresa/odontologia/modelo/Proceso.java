package co.empresa.odontologia.modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proceso {

	private Integer id;
	
	private String codigo;
	
	private Integer paciente_id;
	
	private String processname;
	
	private Date date_process;
	
	private Integer value;
	
	private String observation;
	
	public Proceso (String processname, Date date_process, Integer value, String observation,String codigo) {
	
		this.processname = processname;
		this.date_process = date_process;
		this.value = value;
		this.observation = observation;
		this.codigo = codigo;
	}
	
	public Proceso (String processname, Integer paciente_id, Date date_process, Integer value, String observation,String codigo) {
		
		this.processname = processname;
		this.paciente_id = paciente_id;
		this.date_process = date_process;
		this.value = value;
		this.observation = observation;
		this.codigo = codigo;
	}
	
	
}
