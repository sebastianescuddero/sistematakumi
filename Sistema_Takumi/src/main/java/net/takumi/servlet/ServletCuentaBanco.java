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

import net.takumi.entidades.CuentaBanco;
import net.takumi.entidades.DetCuentaBanco;
import net.takumi.interfaces.ICuentaBanco;
import net.takumi.dao.CuentaBancoDAO;

/**
 * Servlet implementation class ServletCuentaBanco
 */
@WebServlet("/ServletCuentaBanco")
public class ServletCuentaBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICuentaBanco dao = new CuentaBancoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCuentaBanco() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("LISTAR"))
			listarCuentasBanco(request,response);
		else if(tipo.equals("LISTAR-MOVIMIENTOS-BCP"))
			listarMovimientosBcp(request,response);
		else if(tipo.equals("LISTAR-MOVIMIENTOS-BBVA"))
			listarMovimientosBbva(request,response); 
		else if(tipo.equals("LISTAR-MOVIMIENTOS-INTBNK"))
			listarMovimientosInterbank(request,response); 
		else if(tipo.equals("LISTAR-CUENTAS-BCP"))
			listarCuentasBcp(request,response); 
		else if(tipo.equals("LISTAR-CUENTAS-BBVA"))
			listarCuentasBbva(request,response); 
		else if(tipo.equals("LISTAR-CUENTAS-INTBNK"))
			listarCuentasInterbank(request,response); 
	}

	private void listarCuentasInterbank(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CuentaBanco> lista = dao.listarCuentasInterbank();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarCuentasBbva(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CuentaBanco> lista = dao.listarCuentasBbva();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarCuentasBcp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CuentaBanco> lista = dao.listarCuentasBcp();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarCuentasBanco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<CuentaBanco> lista = dao.listarCuentasBanco();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarMovimientosInterbank(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetCuentaBanco> lista = dao.listarMovimientosBancoInterbank();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);	
	}

	private void listarMovimientosBbva(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetCuentaBanco> lista = dao.listarMovimientosBancoBbva();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarMovimientosBcp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetCuentaBanco> lista = dao.listarMovimientosBancoBcp();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);	
	}
}
