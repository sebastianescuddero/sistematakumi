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

import net.takumi.dao.TipoEgresoDAO;
import net.takumi.entidades.TipoEgreso;
import net.takumi.interfaces.ITipoEgreso;

/**
 * Servlet implementation class ServletTipoEgreso
 */
@WebServlet("/ServletTipoEgreso")
public class ServletTipoEgreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITipoEgreso dao = new TipoEgresoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTipoEgreso() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarTipoEgreso(request,response);
		else if(tipo.equals("CODIGO"))
			generarCodigoTipoEgreso(request,response); 
		else if(tipo.equals("ACTUALIZAR"))
			actualizarTipoEgreso(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarTipoEgreso(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarTipoEgreso(request,response);
		else if(tipo.equals("LISTAR"))
			listarTipoEgreso(request,response); 
	}

	private void listarTipoEgreso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<TipoEgreso> lista = dao.listarTiposEgreso();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void eliminarTipoEgreso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void agregarTipoEgreso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarTipoEgreso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void generarCodigoTipoEgreso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarTipoEgreso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}