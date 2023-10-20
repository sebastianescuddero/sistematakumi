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

import net.takumi.dao.ControlAlmacenDAO;
import net.takumi.entidades.ControlAlmacen;
import net.takumi.entidades.DetControlAlmacen;
import net.takumi.interfaces.IControlAlmacen;

/**
 * Servlet implementation class ServletControlAlmacen
 */
@WebServlet("/ServletControlAlmacen")
public class ServletControlAlmacen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControlAlmacen dao = new ControlAlmacenDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlAlmacen() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarDetalleControlAlm(request,response);
		else if(tipo.equals("DETALLE"))
			detalleControlAlm(request,response);
		else if(tipo.equals("ELIMINAR-DETALLE"))
			eliminarDetalleControlAlm(request,response);
		else if(tipo.equals("ADICIONAR"))
			adicionarProducto(request,response);
		else if(tipo.equals("EDITAR-DETALLE"))
			editarDetalleControlAlm(request,response);
		else if(tipo.equals("ELIMINAR-CONTROL"))
			eliminarControlAlm(request,response);
		else if(tipo.equals("REGISTRAR"))
			registrarControlAlm(request,response);
		else if(tipo.equals("LISTAR"))
			listarControlesAlm(request,response);
		else if(tipo.equals("LISTAR-DETALLES-CONTROL"))
			listarDetalleControlAlm(request,response);
		else if(tipo.equals("NUMERO-CONTROL"))
			generarNumeroControlAlm(request,response);
		else if(tipo.equals("CODIGO-CONTROL"))
			generarCodigoControlAlm(request,response);
	}

	private void generarCodigoControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control_alm = dao.generarCodigoControlAlmacen();
		Gson gson=new Gson();
		String json=gson.toJson(codigo_control_alm);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void generarNumeroControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numero_control_alm = dao.generarNumeroControl();
		Gson gson=new Gson();
		String json=gson.toJson(numero_control_alm);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarDetalleControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con = request.getParameter("codigo-control");
		List<DetControlAlmacen> lista = dao.listarDetalleControlAlm(Integer.parseInt(cod_con));
		Gson gson=new Gson();
		String info=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}

	private void listarControlesAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ControlAlmacen> lista = dao.listarControlesAlm();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void registrarControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_alm, num_control_alm;
		cod_control_alm = request.getParameter("codigo-control-alm");
		num_control_alm = request.getParameter("numero-control-alm");
		
		ControlAlmacen ca = new ControlAlmacen();
		
		ca.setCodigo_control_alm(Integer.parseInt(cod_control_alm));
		ca.setNumero_control_alm(num_control_alm);
		
		List<DetControlAlmacen> data = (List<DetControlAlmacen>) request.getSession().getAttribute("detalle-control-alm");
		int det = dao.agregarControlAlm(ca, data);
		
		if(det > 0){
			data.clear();
			request.getSession().setAttribute("detalle-control-alm", data);
			response.sendRedirect("control_inventario.jsp?MENSAJE=Control de almacen registrado");
		}
		else
			response.sendRedirect("control_inventario.jsp?MENSAJE=Error");
	}

	private void eliminarControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_control_elim, msj="";
		cod_control_elim = request.getParameter("codigo-control-eliminar");
		
		int salida;
		salida = dao.eliminarControlAlm(Integer.parseInt(cod_control_elim));
		if(salida>0)
			msj="Control eliminado correctamente";
		else
			msj="Error";
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}

	private void editarDetalleControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, cod_pro, can_pro, tip_con, cod_usu, msj="";
		cod_con = request.getParameter("codigo-control-edit");
		num_det = request.getParameter("numero-detalle-control-edit");
		cod_pro = request.getParameter("producto-control-edit");
		can_pro = request.getParameter("cantidad-control-edit");
		tip_con = request.getParameter("tipo-control-edit");
		cod_usu = request.getParameter("usuario-control-edit");
		
		DetControlAlmacen dca = new DetControlAlmacen();
		
		dca.setCodigo_control_alm(Integer.parseInt(cod_con));
		dca.setNumero_detalle_control_alm(num_det);
		dca.setCodigo_pro(Integer.parseInt(cod_pro));
		dca.setCantidad_pro(Integer.parseInt(can_pro));
		dca.setTipo_control_alm(tip_con);
		dca.setCodigo_usu(Integer.parseInt(cod_usu));
		dca.setNumero_detalle_control_alm(num_det);	
		
		if(num_det == dca.getNumero_detalle_control_alm()) {
			int estado;
			estado = dao.actualizarDetalleControlAlm(dca);
			if( estado > 0)
				msj="Detalle actualizado correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}

	@SuppressWarnings("unchecked")
	private void adicionarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_con, num_det, cod_pro, nom_pro, can_pro, tip_con, cod_usu, nom_usu;
		cod_con = request.getParameter("codigo-control-alm");
		num_det = request.getParameter("numero-detalle");
		cod_pro = request.getParameter("codigo-producto");
		nom_pro = request.getParameter("nombre-producto");
		can_pro = request.getParameter("cantidad-producto");
		tip_con = request.getParameter("tipo-control");
		cod_usu = request.getParameter("codigo-usuario");
		nom_usu = request.getParameter("nombre-usuario");
		
		List<DetControlAlmacen> lista = null;
		
		if(request.getSession().getAttribute("detalle-control-alm") == null) {
			lista = new ArrayList<DetControlAlmacen>();
		}
		else {
			lista=(List<DetControlAlmacen>) request.getSession().getAttribute("detalle-control-alm");
		}	
		
		DetControlAlmacen dca = new DetControlAlmacen();
		
		dca.setCodigo_control_alm(Integer.parseInt(cod_con));
		dca.setNumero_detalle_control_alm(num_det);
		dca.setCodigo_pro(Integer.parseInt(cod_pro));
		dca.setNombre_pro(nom_pro);
		dca.setCantidad_pro(Integer.parseInt(can_pro));
		dca.setTipo_control_alm(tip_con);
		dca.setCodigo_usu(Integer.parseInt(cod_usu));
		dca.setNombre_usu(nom_usu);
			
		lista.add(dca);

		request.getSession().setAttribute("detalle-control-alm", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);	
	}

	@SuppressWarnings("unchecked")
	private void eliminarDetalleControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_pro;
		cod_pro = request.getParameter("codigo-producto");

		List<DetControlAlmacen> lista=(List<DetControlAlmacen>) request.getSession().getAttribute("detalle-control-alm");
		
		for(DetControlAlmacen d:lista) {
			if(d.getCodigo_pro() == Integer.parseInt(cod_pro)) {
				lista.remove(d);
				break;
			}
		}
		
		request.getSession().setAttribute("detalle-control-alm", lista);
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	@SuppressWarnings("unchecked")
	private void detalleControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<DetControlAlmacen> list = (List<DetControlAlmacen>) request.getSession().getAttribute("detalle-control-alm");
		Gson gson=new Gson();
		String json=gson.toJson(list);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void buscarDetalleControlAlm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_control=request.getParameter("codigo-control");
		String numero_detalle=request.getParameter("numero-detalle");
		DetControlAlmacen data = dao.buscarDetalleControlAlm(Integer.parseInt(codigo_control), numero_detalle);
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
}
