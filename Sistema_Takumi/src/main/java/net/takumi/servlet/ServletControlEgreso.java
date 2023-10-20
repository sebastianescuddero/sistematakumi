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

import net.takumi.dao.ControlEgresoDAO;
import net.takumi.entidades.ControlEgreso;
import net.takumi.entidades.DetControlEgreso;
import net.takumi.interfaces.IControlEgreso;

/**
 * Servlet implementation class ServletControlEgreso
 */
@WebServlet("/ServletControlEgreso")
public class ServletControlEgreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControlEgreso dao = new ControlEgresoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlEgreso() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarDetalleControlEgr(request,response);
		else if(tipo.equals("DETALLE"))
			detalleControlEgr(request,response);
		else if(tipo.equals("ELIMINAR-DETALLE"))
			eliminarDetalleControlEgr(request,response);
		else if(tipo.equals("ADICIONAR"))
			adicionarEgreso(request,response);
		else if(tipo.equals("EDITAR-DETALLE"))
			editarDetalleControlEgr(request,response);
		else if(tipo.equals("ELIMINAR-CONTROL"))
			eliminarControlEgr(request,response);
		else if(tipo.equals("REGISTRAR"))
			registrarControlEgr(request,response);
		else if(tipo.equals("LISTAR"))
			listarControlesEgr(request,response);
		else if(tipo.equals("LISTAR-SEMANA"))
			listarControlesEgrSemana(request,response);
		else if(tipo.equals("LISTAR-DETALLES-CONTROL"))
			listarDetalleControlEgr(request,response);
		else if(tipo.equals("NUMERO-CONTROL"))
			generarNumeroControlEgr(request,response);
		else if(tipo.equals("CODIGO-CONTROL"))
			generarCodigoControlEgr(request,response);
	}

	private void generarCodigoControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control_egr = dao.generarCodigoControlEgreso();
		Gson gson=new Gson();
		String json=gson.toJson(codigo_control_egr);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void generarNumeroControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero_control_egr = dao.generarNumeroControlEgreso();
		Gson gson=new Gson();
		String json=gson.toJson(numero_control_egr);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarDetalleControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con = request.getParameter("codigo-control");
		List<DetControlEgreso> lista = dao.listarDetalleControlEgr(Integer.parseInt(cod_con));
		Gson gson=new Gson();
		String info=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
		
	}

	private void listarControlesEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ControlEgreso> lista = dao.listarControlesEgr();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}
	
	private void listarControlesEgrSemana(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ControlEgreso> lista_semana = dao.listarControlesEgrSemana();
		Gson gson=new Gson();
		String json=gson.toJson(lista_semana);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void registrarControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_egr, num_control_egr;
		cod_control_egr = request.getParameter("codigo-control-egr");
		num_control_egr = request.getParameter("numero-control-egr");
		
		ControlEgreso ce = new ControlEgreso();
		
		ce.setCodigo_control_egr(Integer.parseInt(cod_control_egr));
		ce.setNumero_control_egr(num_control_egr);
		
		List<DetControlEgreso> data = (List<DetControlEgreso>) request.getSession().getAttribute("detalle-control-egr");
		int det = dao.agregarControlEgr(ce, data);
		
		if(det > 0){
			data.clear();
			request.getSession().setAttribute("detalle-control-egr", data);
			response.sendRedirect("gestion_ventas.jsp?MENSAJE=Control de almacen registrado");
		}
		else
			response.sendRedirect("gestion_ventas.jsp?MENSAJE=Error");
	}

	private void eliminarControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_elim, msj="";
		cod_control_elim = request.getParameter("codigo-control-eliminar");
		
		int salida;
		salida = dao.eliminarControlEgr(Integer.parseInt(cod_control_elim));
		if(salida>0)
			msj="Control eliminado correctamente";
		else
			msj="Error";
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}

	private void editarDetalleControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, mon_egr, desc_razon_egr, cod_tip_egr, cod_met_pag, msj="";
		cod_con = request.getParameter("codigo-control-edit");
		num_det = request.getParameter("numero-detalle-control-edit");
		mon_egr = request.getParameter("monto-egreso-edit");
		desc_razon_egr = request.getParameter("descripcion-razon-egreso-edit");
		cod_tip_egr = request.getParameter("codigo-tipo-egreso-edit");
		cod_met_pag = request.getParameter("codigo-metodo-pago-edit");
		
		DetControlEgreso dce = new DetControlEgreso();
		
		dce.setCodigo_control_egr(Integer.parseInt(cod_con));
		dce.setNumero_detalle_control_egr(num_det);
		dce.setMonto_egr(Double.parseDouble(mon_egr));
		dce.setDescripcion_razon_egr(desc_razon_egr);
		dce.setCodigo_tip_egr(Integer.parseInt(cod_tip_egr));
		dce.setCodigo_met_pago(Integer.parseInt(cod_met_pag));
		
		
		if(num_det == dce.getNumero_detalle_control_egr()) {
			int estado;
			estado = dao.actualizarDetalleControlEgr(dce);
			if( estado > 0)
				msj="Detalle actualizado correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	@SuppressWarnings("unchecked")
	private void adicionarEgreso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, mon_egr, desc_razon_egr, cod_tip_egr, tip_egr, cod_met_pag, met_pag;
		cod_con = request.getParameter("codigo-control-egr");
		num_det = request.getParameter("numero-detalle-egr");
		mon_egr = request.getParameter("monto-egreso");
		desc_razon_egr = request.getParameter("descripcion-razon-egreso");
		cod_tip_egr = request.getParameter("codigo-tipo-egreso");
		tip_egr = request.getParameter("tipo-egreso");
		cod_met_pag = request.getParameter("codigo-metodo-pago");
		met_pag = request.getParameter("metodo-pago");
		
		
		List<DetControlEgreso> lista = null;
		
		if(request.getSession().getAttribute("detalle-control-egr") == null) {
			lista = new ArrayList<DetControlEgreso>();
		}
		else {
			lista=(List<DetControlEgreso>) request.getSession().getAttribute("detalle-control-egr");
		}	
		
		DetControlEgreso dce = new DetControlEgreso();
		
		dce.setCodigo_control_egr(Integer.parseInt(cod_con));
		dce.setNumero_detalle_control_egr(num_det);
		dce.setMonto_egr(Double.parseDouble(mon_egr));
		dce.setDescripcion_razon_egr(desc_razon_egr);
		dce.setCodigo_tip_egr(Integer.parseInt(cod_tip_egr));
		dce.setTip_egr(tip_egr);
		dce.setCodigo_met_pago(Integer.parseInt(cod_met_pag));
		dce.setMet_pago(met_pag);
		
		lista.add(dce);

		request.getSession().setAttribute("detalle-control-egr", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void eliminarDetalleControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num_det;
		num_det = request.getParameter("numero-detalle");

		List<DetControlEgreso> lista=(List<DetControlEgreso>) request.getSession().getAttribute("detalle-control-egr");
		
		for(DetControlEgreso d:lista) {
			if(num_det != null) {
				lista.remove(d);
				break;
			}
		}
		
		request.getSession().setAttribute("detalle-control-egr", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void detalleControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetControlEgreso> list = (List<DetControlEgreso>) request.getSession().getAttribute("detalle-control-egr");
		Gson gson=new Gson();
		String json=gson.toJson(list);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void buscarDetalleControlEgr(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control=request.getParameter("codigo-control");
		String numero_detalle=request.getParameter("numero-detalle");
		DetControlEgreso data = dao.buscarDetalleControlEgr(Integer.parseInt(codigo_control), numero_detalle);
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
}