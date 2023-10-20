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

import net.takumi.dao.CategoriaDAO;
import net.takumi.entidades.Categoria;
import net.takumi.interfaces.ICategoria;

/**
 * Servlet implementation class ServletCategoria
 */
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICategoria dao = new CategoriaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategoria() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tipo=request.getParameter("accion");
		if(tipo.equals("BUSCAR"))
			buscarCategoria(request,response);
		else if(tipo.equals("EDITAR"))
			actualizarCategoria(request,response);
		else if(tipo.equals("AGREGAR"))
			agregarCategoria(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminarCategoria(request,response);
		else if(tipo.equals("LISTAR"))
			listarCategorias(request,response); 
	}
    
    private void listarCategorias(HttpServletRequest request, HttpServletResponse response) throws IOException { 
		List<Categoria> lista = dao.listarCategorias();
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}
	
	private void buscarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String codigo=request.getParameter("codigo-categoria");
		Categoria data = dao.buscarCategoria(Integer.parseInt(codigo));
		Gson gson=new Gson();
		String info=gson.toJson(data);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		salida.println(info);
	}
	
	private void agregarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_cat, nom_cat, des_cat, msj="";
		cod_cat=request.getParameter("codigo-categoria");
		nom_cat=request.getParameter("nombre-categoria");
		des_cat=request.getParameter("descripcion-categoria");
		
		Categoria cat = new Categoria();
		cat.setNombre_cat(nom_cat);
		cat.setDescripcion_cat(des_cat);
		
		if(Integer.parseInt(cod_cat)==0) {
			int estado;
			estado = dao.agregarCategoria(cat);
			if(estado>0)
				msj="Categoria agregada correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect(".jsp?MENSAJE="+msj);
	}
	
	private void actualizarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cod_cat, nom_cat, des_cat, msj="";
		cod_cat=request.getParameter("codigo-categoria");
		nom_cat=request.getParameter("nombre-categoria");
		des_cat=request.getParameter("descripcion-categoria");
		
		Categoria cat = new Categoria();
		cat.setNombre_cat(nom_cat);
		cat.setDescripcion_cat(des_cat);
		
		if(Integer.parseInt(cod_cat)!=0) {
			int estado;
			estado = dao.actualizarCategoria(cat);
			if(estado>0)
				msj="Categoria actualizada correctamente";
			else
				msj="Error";
		}
		
		response.sendRedirect(".jsp?MENSAJE="+msj);
	}
	
	private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException { 
		String cod_elim, msj="";
		cod_elim = request.getParameter("codigo-eliminar-categoria");
		
		int salida;
		salida = dao.eliminarCategoria(Integer.parseInt(cod_elim));
		if(salida>0)
			msj="Categoria eliminada correctamente";
		else
			msj="Ya no hay productos";
		
		response.sendRedirect(".jsp?MENSAJE="+msj);
	}
}
