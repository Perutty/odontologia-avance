package co.empresa.odontologia.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.empresa.odontologia.dao.OdontologoDao;
import co.empresa.odontologia.dao.OdontologoDaoFactory;
import co.empresa.odontologia.modelo.Odontologo;

/**
 * Servlet implementation class OdontologoServlet
 */
@WebServlet(name="OdontologoServlet", urlPatterns={"/OdontologoServlet"})
public class OdontologoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private OdontologoDao odontologoDao;
	
    public OdontologoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init(ServletConfig config) throws ServletException {
		this.odontologoDao = OdontologoDaoFactory.getOdontologoDao("postgresql");
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action==null) {
			action = "logeo";
		}
		
		try {
			switch(action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertarOdontologo(request, response);
				break;
			case "update":
				actualizarOdontologo(request, response);
				break;
			case "validar":
				System.out.println("Validar --- ");
				validarOdontologo(request, response);
				break;
			default:
				logeo(request,response);
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarDoc.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logeo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Logeo");
		System.out.println(request.getSession().getAttribute("doc_id"));
		if(request.getSession().getAttribute("doc_id") != null) {
			response.sendRedirect("PacienteServlet");
			//request.getRequestDispatcher("PacienteServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	private void insertarOdontologo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String consultorio = request.getParameter("consultorio");
		
		Odontologo odontologo = new Odontologo(username, pass, email, telefono, consultorio);
		odontologoDao.insert(odontologo);
		
		response.sendRedirect("logeo");
	}
	
	private void actualizarOdontologo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String consultorio = request.getParameter("consultorio");
		
		Odontologo odontologo = new Odontologo(id, pass, email, telefono, consultorio);
		odontologoDao.update(odontologo);
		
		response.sendRedirect("list");
	}
	
	private void validarOdontologo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		
		
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		Odontologo odontologo = odontologoDao.select(username, pass);
		
		if(odontologo != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("doc_id", odontologo.getId());
			session.setAttribute("username", odontologo.getUsername());
			response.sendRedirect("PacienteServlet?action=list");
		}
		else {
			request.setAttribute("loginError","Usuario o contraseña incorrecto");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		    dispatcher.forward(request, response);
		}

     }
}
