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

import net.takumi.dao.PosDAO;
import net.takumi.entidades.POS;
import net.takumi.interfaces.IPos;

/**
 * Servlet implementation class ServletPos
 */
@WebServlet("/ServletPos")
public class ServletPos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPos dao = new PosDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPos() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarPos(request,response);
		else if(tipo.equals("CODIGO"))
			generarCodigoPos(request,response); 
		else if(tipo.equals("ACTUALIZAR"))
			actualizarPos(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarPos(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarPos(request,response);
		else if(tipo.equals("LISTAR"))
			listarPos(request,response); 
	}

	private void listarPos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<POS> lista = dao.listarPOS();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void eliminarPos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void agregarPos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarPos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void generarCodigoPos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarPos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
