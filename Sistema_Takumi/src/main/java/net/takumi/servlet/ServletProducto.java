package net.takumi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.takumi.dao.ProductoDAO;
import net.takumi.entidades.Producto;
import net.takumi.interfaces.IProducto;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProducto dao = new ProductoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarProducto(request,response);
		else if(tipo.equals("CODIGO"))
			generarCodigoProducto(request,response); 
		else if(tipo.equals("ACTUALIZAR"))
			actualizarProducto(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarProducto(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarProducto(request,response);
		else if(tipo.equals("LISTAR"))
			listarProductos(request,response); 
	}
    
    private void generarCodigoProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String codigo_producto = dao.generarCodigoProducto();
		Gson gson=new Gson();
		String json=gson.toJson(codigo_producto);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws IOException { 
		List<Producto> lista = dao.listarProductos();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}
	
	private void buscarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo_pro=request.getParameter("codigo-producto");
		Producto data = dao.buscarProducto(Integer.parseInt(codigo_pro));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
	
	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_pro, prod, cat, prov, can, des_can, fec_ven, msj="";
		cod_pro=request.getParameter("codigo-producto");
		prod=request.getParameter("nombre-producto");
		cat=request.getParameter("categoria");
		prov=request.getParameter("proveedor");
		can=request.getParameter("cantidad");
		des_can=request.getParameter("descripcion-cantidad");
		fec_ven=request.getParameter("fecha-vencimiento");
		
		Producto pro = new Producto();
		pro.setCodigo_pro(Integer.parseInt(cod_pro));
		pro.setNombre_pro(prod);
		pro.setCodigo_cat(Integer.parseInt(cat));
		pro.setCodigo_prov(Integer.parseInt(prov));
		pro.setCantidad(Integer.parseInt(can));
		pro.setDescripcion_can(des_can);
		pro.setFecha_ven(Date.valueOf(fec_ven));
		
		if(Integer.parseInt(cod_pro) != 0) {
			int estado;
			estado = dao.agregarProducto(pro);
			if(estado>0)
				msj="Producto registrado correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}
	
	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_pro, nom_pro, cat, prov, can, des_can, fec_ven, msj="";
		cod_pro=request.getParameter("codigo-producto-edit");
		nom_pro=request.getParameter("nombre-producto-edit");
		cat=request.getParameter("categoria-edit");
		prov=request.getParameter("proveedor-edit");
		can=request.getParameter("cantidad-edit");
		des_can=request.getParameter("descripcion-cantidad-edit");
		fec_ven=request.getParameter("fecha-vencimiento-edit");
		
		Producto pro = new Producto();
		pro.setCodigo_pro(Integer.parseInt(cod_pro));
		pro.setNombre_pro(nom_pro);
		pro.setCodigo_cat(Integer.parseInt(cat));
		pro.setCodigo_prov(Integer.parseInt(prov));
		pro.setCantidad(Integer.parseInt(can));
		pro.setDescripcion_can(des_can);
		pro.setFecha_ven(Date.valueOf(fec_ven));
		
		if(Integer.parseInt(cod_pro)!= 0) {
			int estado;
			estado = dao.actualizarProducto(pro);
			if(estado>0)
				msj="Producto actualizado correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}
	
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException { 
		String cod_elim, msj="";
		cod_elim = request.getParameter("codigo-eliminar");
		
		int salida;
		salida = dao.eliminarProducto(Integer.parseInt(cod_elim));
		if(salida>0)
			msj="Producto eliminado correctamente";
		else
			msj="Ya no hay productos";
		
		response.sendRedirect("control_inventario.jsp?MENSAJE="+msj);
	}
}