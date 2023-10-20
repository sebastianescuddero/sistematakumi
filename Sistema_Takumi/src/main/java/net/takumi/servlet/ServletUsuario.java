package net.takumi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.takumi.dao.UsuarioDAO;
import net.takumi.entidades.Usuario;
import net.takumi.interfaces.IUsuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuario dao = new UsuarioDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarUsuario(request,response);
		else if(tipo.equals("ACTUALIZAR"))
			actualizarUsuario(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarUsuario(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarUsuario(request,response);
		else if(tipo.equals("LISTAR"))
			listarUsuarios(request,response); 
	}

	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Usuario> lista = dao.listarUsuarios();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
