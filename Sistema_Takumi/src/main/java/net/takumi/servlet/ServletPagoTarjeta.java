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

import net.takumi.dao.PagoTarjetaDAO;
import net.takumi.entidades.DetPagoTarjeta;
import net.takumi.entidades.PagoTarjeta;
import net.takumi.interfaces.IPagoTarjeta;

/**
 * Servlet implementation class ServletPagoTarjeta
 */
@WebServlet("/ServletPagoTarjeta")
public class ServletPagoTarjeta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPagoTarjeta dao = new PagoTarjetaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPagoTarjeta() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarDetalleControlPagoTarj(request,response);
		else if(tipo.equals("DETALLE"))
			detalleControlPagoTarj(request,response);
		else if(tipo.equals("ELIMINAR-DETALLE"))
			eliminarDetalleControlPagoTarj(request,response);
		else if(tipo.equals("ADICIONAR"))
			adicionarPagoTarjeta(request,response);
		else if(tipo.equals("EDITAR-DETALLE"))
			editarDetalleControlPagoTarj(request,response);
		else if(tipo.equals("ELIMINAR-CONTROL"))
			eliminarControlPagoTarj(request,response);
		else if(tipo.equals("REGISTRAR"))
			registrarControlPagoTarj(request,response);
		else if(tipo.equals("LISTAR"))
			listarControlesPagoTarj(request,response);
		else if(tipo.equals("LISTAR-DETALLES-CONTROL"))
			listarDetalleControlPagoTarj(request,response);
		else if(tipo.equals("NUMERO-CONTROL"))
			generarNumeroControlPagoTarj(request,response);
		else if(tipo.equals("CODIGO-CONTROL"))
			generarCodigoControlPagoTarj(request,response);
	}

	private void generarCodigoControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control_pago_tarj = dao.generarCodigoControlPagoTarj();
		Gson gson=new Gson();
		String json=gson.toJson(codigo_control_pago_tarj);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void generarNumeroControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero_control_pago_tarj = dao.generarNumeroControlPagoTarj();
		Gson gson=new Gson();
		String json=gson.toJson(numero_control_pago_tarj);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarDetalleControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con = request.getParameter("codigo-control");
		List<DetPagoTarjeta> lista = dao.listarDetalleControlPagoTarj(Integer.parseInt(cod_con));
		Gson gson=new Gson();
		String info=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}

	private void listarControlesPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<PagoTarjeta> lista = dao.listarControlesPagoTarj();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void registrarControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_pago_tarj, num_control_pago_tarj;
		cod_control_pago_tarj = request.getParameter("codigo-control-pago-tarj");
		num_control_pago_tarj = request.getParameter("numero-control-pago-tarj");
		
		PagoTarjeta pt = new PagoTarjeta();
		
		pt.setCodigo_control_pago_tarj(Integer.parseInt(cod_control_pago_tarj));
		pt.setNumero_control_pago_tarj(num_control_pago_tarj);
		
		List<DetPagoTarjeta> data = (List<DetPagoTarjeta>) request.getSession().getAttribute("detalle-control-pago-tarj");
		int det = dao.agregarControlPagoTarj(pt, data);
		
		if(det > 0){
			data.clear();
			request.getSession().setAttribute("detalle-control-pago-tarj", data);
			response.sendRedirect("gestion_ventas.jsp?MENSAJE=Control de almacen registrado");
		}
		else
			response.sendRedirect("gestion_ventas.jsp?MENSAJE=Error");
	}

	private void eliminarControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_elim, msj="";
		cod_control_elim = request.getParameter("codigo-control-eliminar");
		
		int salida;
		salida = dao.eliminarControlPagoTarj(Integer.parseInt(cod_control_elim));
		if(salida>0)
			msj="Control eliminado correctamente";
		else
			msj="Error";
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}

	private void editarDetalleControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, mon_pos, cod_pos, msj="";
		cod_con = request.getParameter("codigo-control-edit");
		num_det = request.getParameter("numero-detalle-edit");
		mon_pos = request.getParameter("monto-pos-edit");
		cod_pos = request.getParameter("codigo-pos-edit");
		
		DetPagoTarjeta dpt = new DetPagoTarjeta();
		
		dpt.setCodigo_control_pago_tarj(Integer.parseInt(cod_con));
		dpt.setNumero_detalle_pago_tarj(num_det);
		dpt.setMonto_pos(Double.parseDouble(mon_pos));
		dpt.setCodigo_pos(Integer.parseInt(cod_pos));
		
		if(num_det == dpt.getNumero_detalle_pago_tarj()) {
			int estado;
			estado = dao.actualizarDetalleControlPagoTarj(dpt);
			if(estado > 0)
				msj="Detalle actualizado correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect("gestion_ventas.jsp?MENSAJE="+msj);
	}

	@SuppressWarnings("unchecked")
	private void adicionarPagoTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, mon_pos, cod_pos, pos;
		cod_con = request.getParameter("codigo-control-pago-tarj");
		num_det = request.getParameter("numero-detalle-pago-tarj");
		mon_pos = request.getParameter("monto-pos");
		cod_pos = request.getParameter("codigo-pos");
		pos = request.getParameter("pos");
		
		List<DetPagoTarjeta> lista = null;
		
		if(request.getSession().getAttribute("detalle-control-pago-tarj") == null) {
			lista = new ArrayList<DetPagoTarjeta>();
		}
		else {
			lista=(List<DetPagoTarjeta>) request.getSession().getAttribute("detalle-control-pago-tarj");
		}	
		
		DetPagoTarjeta dpt = new DetPagoTarjeta();
		
		dpt.setCodigo_control_pago_tarj(Integer.parseInt(cod_con));
		dpt.setNumero_detalle_pago_tarj(num_det);
		dpt.setMonto_pos(Double.parseDouble(mon_pos));
		dpt.setCodigo_pos(Integer.parseInt(cod_pos));
		dpt.setPos(pos);
			
		lista.add(dpt);

		request.getSession().setAttribute("detalle-control-pago-tarj", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void eliminarDetalleControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String num_det;
		num_det = request.getParameter("numero-detalle");

		List<DetPagoTarjeta> lista=(List<DetPagoTarjeta>) request.getSession().getAttribute("detalle-control-pago-tarj");
		
		for(DetPagoTarjeta d:lista) {
			if(num_det != null) {
				lista.remove(d);
				break;
			}
		}
		
		request.getSession().setAttribute("detalle-control-pago-tarj", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void detalleControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetPagoTarjeta> list = (List<DetPagoTarjeta>) request.getSession().getAttribute("detalle-control-pago-tarj");
		Gson gson=new Gson();
		String json=gson.toJson(list);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void buscarDetalleControlPagoTarj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control=request.getParameter("codigo-control");
		String numero_detalle=request.getParameter("numero-detalle");
		DetPagoTarjeta data = dao.buscarDetalleControlPagoTarj(Integer.parseInt(codigo_control), numero_detalle);
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
}