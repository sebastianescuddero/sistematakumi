package net.takumi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.takumi.dao.ControIngresoDAO;
import net.takumi.entidades.ControIngreso;
import net.takumi.entidades.DetControIngreso;
import net.takumi.interfaces.IControIngreso;

/**
 * Servlet implementation class ServletControIngreso
 */
@WebServlet("/ServletControIngreso")
public class ServletControIngreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControIngreso dao = new ControIngresoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControIngreso() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarDetalleControIng(request,response);
		else if(tipo.equals("DETALLE"))
			detalleControIng(request,response);
		else if(tipo.equals("ELIMINAR-DETALLE"))
			eliminarDetalleControIng(request,response);
		else if(tipo.equals("ADICIONAR"))
			adicionarIngreso(request,response);
		else if(tipo.equals("EDITAR-DETALLE"))
			editarDetalleControIng(request,response);
		else if(tipo.equals("ELIMINAR-CONTROL"))
			eliminarControIng(request,response);
		else if(tipo.equals("REGISTRAR"))
			registrarControIng(request,response);
		else if(tipo.equals("LISTAR"))
			listarControlesIng(request,response);
		else if(tipo.equals("LISTAR-SEMANA"))
			listarControlesIngSemana(request,response);
		else if(tipo.equals("LISTAR-DETALLES-CONTROL"))
			listarDetalleControIng(request,response);
		else if(tipo.equals("NUMERO-CONTROL"))
			generarNumeroControIng(request,response);
		else if(tipo.equals("CODIGO-CONTROL"))
			generarCodigoControIng(request,response);
	}

	private void generarCodigoControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control_ing = dao.generarCodigoControlIngreso();
		Gson gson=new Gson();
		String json=gson.toJson(codigo_control_ing);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void generarNumeroControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero_control_ing = dao.generarNumeroControlIngreso();
		Gson gson=new Gson();
		String json=gson.toJson(numero_control_ing);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarDetalleControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con = request.getParameter("codigo-control");
		List<DetControIngreso> lista = dao.listarDetalleControlIng(Integer.parseInt(cod_con));
		Gson gson=new Gson();
		String info=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}

	private void listarControlesIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ControIngreso> lista = dao.listarControlesIng();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}
	
	private void listarControlesIngSemana(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ControIngreso> lista_semana = dao.listarControlesIngSemana();
		Gson gson=new Gson();
		String json=gson.toJson(lista_semana);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void registrarControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_ing, num_control_ing;
		cod_control_ing = request.getParameter("codigo-control-ing");
		num_control_ing = request.getParameter("numero-control-ing");
		
		ControIngreso ci = new ControIngreso();
		
		ci.setCodigo_control_ing(Integer.parseInt(cod_control_ing));
		ci.setNumero_control_ing(num_control_ing);
		
		List<DetControIngreso> data = (List<DetControIngreso>) request.getSession().getAttribute("detalle-control-ing");
		int det = dao.agregarControlIng(ci, data);
		
		if(det > 0){
			data.clear();
			request.getSession().setAttribute("detalle-control-ing", data);
			response.sendRedirect("gestion_ventas.jsp?MENSAJE=Control de almacen registrado");
		}
		else
			response.sendRedirect("gestion_ventas.jsp?MENSAJE=Error");
	}

	private void eliminarControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_elim, msj="";
		cod_control_elim = request.getParameter("codigo-control-eliminar");
		
		int salida;
		salida = dao.eliminarControlIng(Integer.parseInt(cod_control_elim));
		if(salida>0)
			msj="Control eliminado correctamente";
		else
			msj="Error";
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}

	private void editarDetalleControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, cod_met_pag, mon_ing, desc_otro_ing, msj="";
		cod_con = request.getParameter("codigo-control-edit");
		num_det = request.getParameter("numero-detalle-control-edit");
		mon_ing = request.getParameter("monto-ingreso-edit");
		cod_met_pag = request.getParameter("codigo-metodo-pago-edit");
		desc_otro_ing = request.getParameter("descripcion-otro-ingreso-edit");
		
		DetControIngreso dci = new DetControIngreso();
		
		dci.setCodigo_control_ing(Integer.parseInt(cod_con));
		dci.setNumero_detalle_control_ing(num_det);
		dci.setMonto_ing(Double.parseDouble(mon_ing));
		dci.setCodigo_met_pago(Integer.parseInt(cod_met_pag));
		dci.setDescripcion_otro_ing(desc_otro_ing);
		
		if(num_det == dci.getNumero_detalle_control_ing()) {
			int estado;
			estado = dao.actualizarDetalleControlIng(dci);
			if( estado > 0)
				msj="Detalle actualizado correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	@SuppressWarnings("unchecked")
	private void adicionarIngreso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, mon_ing, cod_met_pag, met_pag, desc_otro_ing;
		cod_con = request.getParameter("codigo-control-ing");
		num_det = request.getParameter("numero-detalle");
		mon_ing = request.getParameter("monto-ingreso");
		cod_met_pag = request.getParameter("codigo-metodo-pago");
		met_pag = request.getParameter("metodo-pago");
		desc_otro_ing = request.getParameter("descripcion-otro-ingreso");
		
		List<DetControIngreso> lista = null;
		
		if(request.getSession().getAttribute("detalle-control-ing") == null) {
			lista = new ArrayList<DetControIngreso>();
		}
		else {
			lista=(List<DetControIngreso>) request.getSession().getAttribute("detalle-control-ing");
		}	
		
		DetControIngreso dci = new DetControIngreso();
		
		dci.setCodigo_control_ing(Integer.parseInt(cod_con));
		dci.setNumero_detalle_control_ing(num_det);
		dci.setMonto_ing(Double.parseDouble(mon_ing));
		dci.setCodigo_met_pago(Integer.parseInt(cod_met_pag));
		dci.setMet_pago(met_pag);
		dci.setDescripcion_otro_ing(desc_otro_ing);
			
		lista.add(dci);

		request.getSession().setAttribute("detalle-control-ing", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void eliminarDetalleControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num_det;
		num_det = request.getParameter("numero-detalle");

		List<DetControIngreso> lista=(List<DetControIngreso>) request.getSession().getAttribute("detalle-control-ing");
		
		for(DetControIngreso d:lista) {
			if(num_det != null) {
				lista.remove(d);
				break;
			}
		}
		
		request.getSession().setAttribute("detalle-control-ing", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void detalleControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetControIngreso> list = (List<DetControIngreso>) request.getSession().getAttribute("detalle-control-ing");
		Gson gson=new Gson();
		String json=gson.toJson(list);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void buscarDetalleControIng(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control=request.getParameter("codigo-control");
		String numero_detalle=request.getParameter("numero-detalle");
		DetControIngreso data = dao.buscarDetalleControlIng(Integer.parseInt(codigo_control), numero_detalle);
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
}