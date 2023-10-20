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

import net.takumi.dao.CajaDAO;
import net.takumi.entidades.Caja;
import net.takumi.entidades.DetCaja;
import net.takumi.interfaces.ICaja;

/**
 * Servlet implementation class ServletCaja
 */
@WebServlet("/ServletCaja")
public class ServletCaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICaja dao = new CajaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCaja() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarCaja(request,response);
		else if(tipo.equals("LISTAR"))
			listarCajas(request,response);
		else if(tipo.equals("LISTAR-DETALLES"))
			listarDetallesCaja(request,response);  
	}

	private void buscarCaja(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_caja = request.getParameter("codigo-caja");
		Caja data = dao.buscarCaja(Integer.parseInt(codigo_caja));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}

	private void listarDetallesCaja(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetCaja> lista = dao.listarDetCaja();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarCajas(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Caja> lista = dao.listarCajas();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}
}
