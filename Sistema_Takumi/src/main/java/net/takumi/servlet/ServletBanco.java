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

import net.takumi.dao.BancoDAO;
import net.takumi.entidades.Banco;
import net.takumi.interfaces.IBanco;

/**
 * Servlet implementation class ServletBanco
 */
@WebServlet("/ServletBanco")
public class ServletBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBanco dao = new BancoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBanco() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarBanco(request,response);
		else if(tipo.equals("CODIGO"))
			generarCodigoBanco(request,response); 
		else if(tipo.equals("ACTUALIZAR"))
			actualizarBanco(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarBanco(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarBanco(request,response);
		else if(tipo.equals("LISTAR"))
			listarBancos(request,response); 
	}

	private void listarBancos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Banco> lista = dao.listarBancos();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void eliminarBanco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_banc, msj="";
		cod_banc = request.getParameter("codigo-banco-elim");
		
		int salida;
		salida = dao.eliminarBanco(Integer.parseInt(cod_banc));
		if(salida>0)
			msj="Banco eliminado correctamente";
		else
			msj="Ha sucedido un error";
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	private void agregarBanco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_banc, nom_banc, msj="";
		cod_banc = request.getParameter("codigo-banco");
		nom_banc = request.getParameter("nombre-banco");
		
		Banco b = new Banco();
		b.setCodigo_banc(Integer.parseInt(cod_banc));
		b.setNombre_banc(nom_banc);
		
		if(Integer.parseInt(cod_banc) != 0) {
			int estado;
			estado = dao.agregarBanco(b);
			if(estado>0)
				msj="Banco agregado correctamente";
			else
				msj="Ha sucedido un error";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);	
	}

	private void actualizarBanco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_banc, nom_banc, msj="";
		cod_banc = request.getParameter("codigo-banco-edit");
		nom_banc = request.getParameter("nombre-banco-edit");
		
		Banco b = new Banco();
		b.setCodigo_banc(Integer.parseInt(cod_banc));
		b.setNombre_banc(nom_banc);
		
		if(Integer.parseInt(cod_banc) == b.getCodigo_banc()) {
			int estado;
			estado = dao.actualizarBanco(b);
			if(estado>0)
				msj="Banco actualizado correctamente";
			else
				msj="Ha sucedido un error";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	private void generarCodigoBanco(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarBanco(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_banc = request.getParameter("codigo-banco");
		Banco data = dao.buscarBanco(Integer.parseInt(codigo_banc));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
}