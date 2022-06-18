package co.empresa.odontologia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.odontologia.dao.ProcesoDao;
import co.empresa.odontologia.dao.ProcesoDaoFactory;
import co.empresa.odontologia.modelo.Proceso;

/**
 * Servlet implementation class ProcesoServlet
 */
@WebServlet(name="ProcesoServlet", urlPatterns={"/ProcesoServlet"})
public class ProcesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProcesoDao procesoDao;
	
    public ProcesoServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.procesoDao = ProcesoDaoFactory.getProcesoDao("postgresql");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			switch(action) {
			case "newProcess":
				showNewForm(request, response);
				break;
			case "insert":
				insertarProceso(request,response);
				break;
			case "list":
				listProcess(request,response);
				break;
			case "delete":
				deleteProcess(request,response);
				break;
			case "cerrar":
				cerrarSesion(request,response);
				break;
			default:
				listProcess(request, response);
				break;
		}
	}catch(SQLException e) {
			throw new ServletException(e);
    }
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarProceso.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarProceso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		Date dat = new Date();
		java.sql.Date sqlDate = new java.sql.Date(dat.getTime());
		
	    int paci_id = (int) request.getSession().getAttribute("paci_id");
	    
		String name = request.getParameter("processname");
		String codigo = request.getParameter("codigo");
		int value = Integer.parseInt(request.getParameter("value"));
		String observation = request.getParameter("observation");
		
		Proceso proceso = new Proceso(name, paci_id, sqlDate, value, observation, codigo);
		procesoDao.insert(proceso);
		request.getRequestDispatcher("ProcesoServlet?action=list").forward(request,response);
	}
	
	private void deleteProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		procesoDao.delete(id);
		request.getRequestDispatcher("ProcesoServlet?action=list").forward(request,response);
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		request.getSession().invalidate();
		request.getRequestDispatcher("OdontologoServlet?action=logeo").forward(request,response);
	}
	
	private void listProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException{
		
		List<Proceso> listProcesos = procesoDao.selectAll();
		List<Proceso> listP = new ArrayList<>();
		int paci_id = (int) request.getSession().getAttribute("paci_id");
		listProcesos.forEach((process) -> {
			if(process.getPaciente_id() == paci_id) {
				listP.add(process);
			}
		});
		request.getSession().setAttribute("listProcesos", listP);
		request.getRequestDispatcher("dashboardPaci.jsp").forward(request, response);
		
	}

}
