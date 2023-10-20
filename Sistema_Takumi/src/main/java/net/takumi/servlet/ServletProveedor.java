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

import net.takumi.dao.ProveedorDAO;
import net.takumi.entidades.Proveedor;
import net.takumi.interfaces.IProveedor;

/**
 * Servlet implementation class ServletProveedor
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProveedor dao = new ProveedorDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarProveedor(request,response);
		else if(tipo.equals("EDITAR"))
			actualizarProveedor(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarProveedor(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarProveedor(request,response);
		else if(tipo.equals("LISTAR"))
			listarProveedor(request,response); 
	}

	private void listarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Proveedor> lista = dao.listarProveedores();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

	private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_elim, msj="";
		cod_elim = request.getParameter("codigo-eliminar-proveedor");
		
		int salida;
		salida = dao.eliminarProveedor(Integer.parseInt(cod_elim));
		if(salida>0)
			msj="Proveedor eliminado correctamente";
		else
			msj="Ya no hay productos";
		
		response.sendRedirect(".jsp?MENSAJE="+msj);
	}

	private void agregarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_prv, nom_prv, des_prv, telf_prv, msj="";
		cod_prv=request.getParameter("codigo-proveedor");
		nom_prv=request.getParameter("nombre-proveedor");
		des_prv=request.getParameter("descripcion-proveedor");
		telf_prv=request.getParameter("descripcion-proveedor");
		
		Proveedor prv = new Proveedor();
		prv.setNombre_prov(nom_prv);
		prv.setDescripcion_prov(des_prv);
		prv.setTelefono_prov(telf_prv);
		
		if(Integer.parseInt(cod_prv)==0) {
			int estado;
			estado = dao.agregarProveedor(prv);
			if(estado>0)
				msj="Categoria agregada correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect(".jsp?MENSAJE="+msj);
	}

	private void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_prv, nom_prv, des_prv, telf_prv, msj="";
		cod_prv=request.getParameter("codigo-proveedor");
		nom_prv=request.getParameter("nombre-proveedor");
		des_prv=request.getParameter("descripcion-proveedor");
		telf_prv=request.getParameter("descripcion-proveedor");
		
		Proveedor prv = new Proveedor();
		prv.setNombre_prov(nom_prv);
		prv.setDescripcion_prov(des_prv);
		prv.setTelefono_prov(telf_prv);
		
		if(Integer.parseInt(cod_prv)!=0) {
			int estado;
			estado = dao.actualizarProveedor(prv);
			if(estado>0)
				msj="Categoria agregada correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect(".jsp?MENSAJE="+msj);
	}

	private void buscarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo = request.getParameter("codigo-proveedor");
		Proveedor data = dao.buscarProveedor(Integer.parseInt(codigo));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
}