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

import net.takumi.dao.MetodoPagoDAO;
import net.takumi.entidades.MetodoPago;
import net.takumi.interfaces.IMetodoPago;

/**
 * Servlet implementation class ServletMetodoPago
 */
@WebServlet("/ServletMetodoPago")
public class ServletMetodoPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMetodoPago dao = new MetodoPagoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMetodoPago() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarMetPago(request,response);
		else if(tipo.equals("CODIGO"))
			generarCodigoMetPago(request,response); 
		else if(tipo.equals("ACTUALIZAR"))
			actualizarMetPago(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarMetPago(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarMetPago(request,response);
		else if(tipo.equals("LISTAR"))
			listarMetPago(request,response); 
	}

	private void listarMetPago(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<MetodoPago> lista = dao.listarMetodosPago();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void eliminarMetPago(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_met_pago, msj="";
		cod_met_pago = request.getParameter("codigo-met-pago-elim");
	
		int salida;
		salida = dao.eliminarMetodoPago(Integer.parseInt(cod_met_pago));
		if(salida>0)
			msj="Método de pago eliminado correctamente";
		else
			msj="Error al eliminar";
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	private void agregarMetPago(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_met_pago, cod_banc, nom_met_pago, msj="";
		cod_met_pago = request.getParameter("codigo-met-pago");
		cod_banc = request.getParameter("codigo-banco");
		nom_met_pago = request.getParameter("nombre-met-pago");
		
		MetodoPago mp = new MetodoPago();
		mp.setCodigo_banco(Integer.parseInt(cod_met_pago));
		mp.setCodigo_banco(Integer.parseInt(cod_banc));
		mp.setNombre_met_pago(nom_met_pago);
		
		if(Integer.parseInt(cod_met_pago) != 0) {
			int estado;
			estado = dao.agregarMetodoPago(mp);
			if(estado>0)
				msj="Método de pago agregado correctamente";
			else
				msj="Error al agregar un nuevo método de pago";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	private void actualizarMetPago(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_met_pago, cod_banc, nom_met_pago, msj="";
		cod_met_pago = request.getParameter("codigo-met-pago-edit");
		cod_banc = request.getParameter("codigo-banco-edit");
		nom_met_pago = request.getParameter("nombre-met-pago-edit");
		
		MetodoPago mp = new MetodoPago();
		mp.setCodigo_banco(Integer.parseInt(cod_met_pago));
		mp.setCodigo_banco(Integer.parseInt(cod_banc));
		mp.setNombre_met_pago(nom_met_pago);
		
		if(Integer.parseInt(cod_met_pago) == mp.getCodigo_met_pago()) {
			int estado;
			estado = dao.actualizarMetodoPago(mp);
			if(estado>0)
				msj="Método de pago actualizado correctamente";
			else
				msj="Error al agregar un nuevo método de pago";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);	
	}
	
	private void generarCodigoMetPago(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscarMetPago(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_met_pago = request.getParameter("codigo-met-pago");
		MetodoPago data = dao.buscarMetodoPago(Integer.parseInt(codigo_met_pago));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);	
	}
}