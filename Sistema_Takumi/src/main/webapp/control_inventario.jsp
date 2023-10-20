<jsp:include page="pagina_principal.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" rel="stylesheet"/>

    <title>Control de Inventario</title>
</head>
<body style="background:#f3f3f3; font-family: 'Courier New', Courier, monospace;">
    <div class="container-fluid" style="text-align: -webkit-center;">
        <div class="row mt-3">
            <h1><strong>Control de Inventario</strong></h1>
            <div class="row text-center mt-3" style="justify-content: space-evenly;">
              <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#nuevo-control-alm" style="text-decoration: none; color: whitesmoke;"><i class="fa-solid fa-truck-ramp-box" style="display: block;
                   inline-size: -webkit-fill-available;"></i>Nuevo Control</a>
              </div>
              <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px; margin-left: 10px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#lista-controles-alm" style="text-decoration: none; color: whitesmoke;"><i class="fa-solid fa-clipboard-list" style="display: block;
                   inline-size: -webkit-fill-available;"></i>Lista de Controles</a>
              </div>
              <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3"  style="display: inline-flex; background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px; float: right;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#nuevo-producto" style="text-decoration: none; text-align: center; width: 100%; color: whitesmoke;"><i class="fa-solid fa-box" style="display: block;
                  inline-size: -webkit-fill-available;"></i>Nuevo Producto</a>
              </div>
              <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3" style="background-color: sandybrown; width: 200px; border-radius: 10px; padding: 10px 0px; margin-left: 10px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-avisos" style="text-decoration: none; color: whitesmoke;"><i class="fa-solid fa-message" style="display: block;
                   inline-size: -webkit-fill-available;"></i>Avisos</a>
              </div>
              <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px; margin-left: 10px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-categoria" style="text-decoration: none; color: whitesmoke;"><i class="fa-solid fa-bars-staggered" style="display: block;
                   inline-size: -webkit-fill-available;"></i>Categoria</a>
              </div>
              <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px; margin-left: 10px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-proveedor" style="text-decoration: none; color: whitesmoke;"><i class="fa-solid fa-truck-field" style="display: block;
                   inline-size: -webkit-fill-available;"></i>Proveedor</a>
              </div>
            </div>
        </div>
        
        <!-- Lista Productos -->
        <div class="row text-center" style="width: 100%; background-color: white; margin-top: 25px; padding: 10px; border-top: 5px solid gainsboro;">
            <div class="row text-center">
            <h4><strong>Lista de Productos</strong></h4>
            <div class="table-responsive">
	            <table class="table table-striped" id="table-productos" style="width: 100%;">
	                <thead>
	                  <tr>
	                    <th scope="col">#</th>
	                    <th scope="col">Producto</th>
	                    <th scope="col">Categoría</th>
	                    <th scope="col">Proveedor</th>
	                    <th scope="col">Cantidad</th>
	                    <th scope="col">Descripción Cantidad</th>
	                    <th scope="col">N° Lote</th>
	                    <th scope="col">Fecha Vencimiento</th>
	                    <th scope="col"></th>
	                    <th scope="col"></th>
	                  </tr>
	                </thead>
	                <tbody>
	                </tbody>
	              </table>
            </div>
          </div>
        </div>
        
        <!-- Nuevo Producto -->
        <div class="modal fade" id="nuevo-producto" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-xl">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Nuevo Producto</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-nuevo-producto" action="ServletProducto?accion=AGREGAR" method="post">
                  <div class="col-md-1">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-producto" name="codigo-producto" readonly>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">PRODUCTO</label>
                    <input type="text" class="form-control" id="id-nombre-producto" name="nombre-producto">
                  </div>
                  <div class="col-md-3">
                    <label class="form-label">CATEGORÍA</label>
                    <select class="form-control" id="id-categoria" name="categoria" >
                    </select>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">PROVEEDOR</label>
                    <select class="form-control" id="id-proveedor" name="proveedor" >
                    </select>
                  </div>
                  <div class="col-md-2">
                    <label class="form-label">CANTIDAD</label>
                    <input type="text" class="form-control" id="id-cantidad" name="cantidad">
                  </div>	
                  <div class="col-md-4">
                    <label class="form-label">DESCRIPCIÓN CANTIDAD</label>
                    <input type="text" class="form-control" id="id-descripcion-cantidad" name="descripcion-cantidad">
                  </div>
                  <div class="col-md-3">
                    <label class="form-label">NÚMERO LOTE</label>
                    <select class="form-control" id="id-numero-lote" name="numero-lote" >
                      <option value="Lote-01">Lote-01</option>
			  	      <option value="Lote-02">Lote-02</option>
			  	      <option value="Lote-03">Lote-03</option>
			  	      <option value="Lote-04">Lote-04</option>
			  	      <option value="Lote-05">Lote-05</option>
                    </select>
                  </div>			  
                  <div class="col-md-3">
                    <label class="form-label">FECHA VENCIMIENTO</label>
                    <input type="date" class="form-control"  id="id-fecha-vencimiento" name="fecha-vencimiento">
                  </div>
                  <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	                <button type="submit" class="btn btn-primary">Grabar</button>
              	  </div>
                </form>
              </div>
            </div>
          </div>
      </div>
      
      <!-- Editar Producto -->
        <div class="modal fade" id="editar-producto" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-xl">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Editar Producto</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-editar-producto" action="ServletProducto?accion=ACTUALIZAR" method="post">
                  <div class="col-md-1">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-producto-edit" name="codigo-producto-edit" readonly>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">PRODUCTO</label>
                    <input type="text" class="form-control" id="id-nombre-producto-edit" name="nombre-producto-edit">
                  </div>
                  <div class="col-md-3">
                    <label class="form-label">CATEGORÍA</label>
                    <select class="form-control" id="id-categoria-edit" name="categoria-edit" >
                    </select>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">PROVEEDOR</label>
                    <select class="form-control" id="id-proveedor-edit" name="proveedor-edit" >
                    </select>
                  </div>
                  <div class="col-md-2">
                    <label class="form-label">CANTIDAD</label>
                    <input type="text" class="form-control" id="id-cantidad-edit" name="cantidad-edit">
                  </div>	  
                  <div class="col-md-4">
                    <label class="form-label">DESCRIPCIÓN CANTIDAD</label>
                    <input type="text" class="form-control" id="id-descripcion-cantidad-edit" name="descripcion-cantidad-edit">
                  </div>
                  <div class="col-md-3">
                    <label class="form-label">NÚMERO LOTE</label>
                    <select class="form-control" id="id-numero-lote-edit" name="numero-lote-edit" >
                      <option value="Lote-01">Lote-01</option>
			  	      <option value="Lote-02">Lote-02</option>
			  	      <option value="Lote-03">Lote-03</option>
			  	      <option value="Lote-04">Lote-04</option>
			  	      <option value="Lote-05">Lote-05</option>
                    </select>
                  </div>		  
                  <div class="col-md-3">
                    <label class="form-label">FECHA VENCIMIENTO</label>
                    <input type="date" class="form-control"  id="id-fecha-vencimiento-edit" name="fecha-vencimiento-edit">
                  </div>
                  <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	                <button type="submit" class="btn btn-primary">Grabar</button>
              	  </div>
                </form>
              </div>
            </div>
          </div>
      </div>
      
        <!-- Eliminar Producto -->
	    <div class="modal fade" id="eliminar-producto" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header" style="background-color: slategrey;">
		        <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Eliminar Producto</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="form-eliminar-producto" action="ServletProducto?accion=ELIMINAR" method="post">
		        	<h4>¿Eliminar el producto?</h4>
				    <input type="text" class="form-control" id="id-codigo-eliminar" name="codigo-eliminar" readonly>
				  <div class="modal-footer">
			      	<button type="submit" class="btn btn-primary">Aceptar</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
        
		<!-- Nuevo Control -->
        <div class="modal fade" id="nuevo-control-alm" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-fullscreen">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Nuevo Control</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-nuevo-control-alm" action="ServletControlAlmacen?accion=REGISTRAR" method="post">
                  <div class="col-md-1">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-control-alm" name="codigo-control-alm" readonly>
                  </div>
               	  <div class="col-md-2">
                    <label class="form-label">N° CONTROL</label>
                    <input type="text" class="form-control" id="id-numero-control-alm" name="numero-control-alm" readonly>
                  </div>
                  <div class="col-md-2">
                    <label class="form-label">N° DETALLE</label>
                    <select class="form-control" id="id-numero-detalle-control" name="numero-detalle-control">
                      <option value="DET-001">DET-001</option>
                      <option value="DET-002">DET-002</option>
                      <option value="DET-003">DET-003</option>
                      <option value="DET-004">DET-004</option>
                      <option value="DET-005">DET-005</option>
                      <option value="DET-006">DET-006</option>
                      <option value="DET-007">DET-007</option>
                      <option value="DET-008">DET-008</option>
                      <option value="DET-009">DET-009</option>
                      <option value="DET-010">DET-010</option>
                    </select>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">PRODUCTO</label>
                    <select class="form-control" id="id-producto-control" name="producto-control" >
                    </select>
                  </div>
                  <div class="col-md-3">
                    <label class="form-label">CANTIDAD</label>
                    <input type="text" class="form-control" id="id-cantidad-control" name="cantidad-control">
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">TIPO CONTROL</label>
                    <select class="form-control" id="id-tipo-control" name="tipo-control" >
                   	  <option value="Ingreso">Ingreso</option>
			  	      <option value="Salida">Salida</option>
                    </select>
                  </div>				  
                  <div class="col-md-4">
                    <label class="form-label">USUARIO</label>
                    <select class="form-control" id="id-usuario-control" name="usuario-control">
                    </select>
                  </div>
                  <div class="col-md-4" style="align-self: flex-end; display:grid;">
                     <button type="button" class="btn btn-outline-success btn-adicionar-producto">Agregar</button>
                  </div>
                  <div class="col-12 table-responsive" style="padding: 10px;">
                    <table id="table-detalle-control" class="table table-striped" style="width:100%;">
                      <thead>
                        <tr>
                          <th scope="col">#</th>
                          <th scope="col">N° Detalle</th>
                          <th scope="col">Producto</th>
                          <th scope="col">Cantidad</th>
                          <th scope="col">Tipo Control</th>
                          <th scope="col">Usuario</th>
                          <th scope="col"></th>
                        </tr>
                      </thead>
                      <tbody>
                      </tbody>
              	    </table>
                  </div>
		          <div class="modal-footer" style="margin-top: none;">
		            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
		            <button type="submit" class="btn btn-primary">Registrar</button>
		          </div>
                </form>
              </div>
            </div>
      	  </div>
        </div>
        
		<!-- Lista Controles -->
        <div class="modal fade" id="lista-controles-alm" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-fullscreen">
              <div class="modal-content">
                <div class="modal-header" style="background-color: slategrey;">
                  <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Lista de Controles</strong></h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="col-12 table-responsive" style="padding: 10px;">
                    <table id="table-control-alm" class="table table-striped" style="width:100%;">
                      <thead>
                          <tr>
                              <th scope="col">#</th>
                              <th scope="col">N° Control</th>
                              <th scope="col">Fecha Registro</th>
                              <th scope="col"></th>
                              <th scope="col"></th>
                          </tr>
                      </thead>
                      <tbody>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
        </div>
        
        <!-- Eliminar Control -->
	    <div class="modal fade" id="eliminar-control-alm" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header" style="background-color: slategrey;">
		        <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Eliminar Control de Almacen</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form id="form-eliminar-control-alm" action="ServletControlAlmacen?accion=ELIMINAR-CONTROL" method="post">
		        	<h4>¿Eliminar el control de almacen?</h4>
				    <input type="text" class="form-control" id="id-codigo-control-eliminar" name="codigo-control-eliminar" readonly>
				  <div class="modal-footer">
			      	<button type="submit" class="btn btn-primary">Aceptar</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			      </div>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
        
        <!-- Detalle Control -->
        <div class="modal fade" id="detalle-control-alm" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-fullscreen">
              <div class="modal-content">
                <div class="modal-header" style="background-color: #585f66;">
                  <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Detalle del Control</strong></h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="col-12 table-responsive" style="padding: 10px;">
                    <table id="table-detalle-control-alm" class="table table-striped" style="width:100%;">
                      <thead>
                          <tr>
                              <th scope="col">#</th>
                              <th scope="col">N° Detalle</th>
                              <th scope="col">Producto</th>
                              <th scope="col">Cantidad</th>
                              <th scope="col">Tipo Control</th>
                              <th scope="col">Fecha Vencimiento</th>
                              <th scope="col">Usuario</th>
                              <th scope="col"></th>
                              <th scope="col"></th>
                          </tr>
                      </thead>
                      <tbody>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
        </div>
        
        <!-- Editar Detalle -->
        <div class="modal fade" id="editar-detalle-control-alm" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Editar Detalle</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-editar-detalle-control-alm" action="ServletControlAlmacen?accion=EDITAR-DETALLE" method="post">
                  <div class="col-md-1">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-control-edit" name="codigo-control-edit" readonly>
                  </div>
                  <div class="col-md-3">
                    <label class="form-label">N° DETALLE</label>
                    <input type="text" class="form-control" id="id-numero-detalle-control-edit" name="numero-detalle-control-edit" readonly>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">PRODUCTO</label>
                    <select class="form-control" id="id-producto-control-edit" name="producto-control-edit" >
                    </select>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">CANTIDAD</label>
                    <input type="text" class="form-control" id="id-cantidad-control-edit" name="cantidad-control-edit">
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">TIPO CONTROL</label>
                    <select class="form-control" id="id-tipo-control-edit" name="tipo-control-edit" >
                      <option value="Ingreso">Ingreso</option>
			  	      <option value="Salida">Salida</option>
                    </select>
                  </div>				  
                  <div class="col-md-4">
                    <label class="form-label">FECHA VENCIMIENTO</label>
                    <input type="date" class="form-control"  id="id-fecha-vencimiento-control-edit" name="fecha-vencimiento-control-edit" readonly>
                  </div>
                  <div class="col-md-4">
                    <label class="form-label">USUARIO</label>
                    <select class="form-control" id="id-usuario-control-edit" name="usuario-control-edit">
                    </select>
                  </div>
		          <div class="modal-footer" style="margin-top: none;">
		            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
		            <button type="submit" class="btn btn-primary">Grabar</button>
		          </div>
                </form>
              </div>
            </div>
      	  </div>
        </div>
        
        <!-- Modal Categoria -->
        <div class="modal fade" id="modal-categoria" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-fullscreen">
              <div class="modal-content">
                <div class="modal-header" style="background-color: slategrey;">
                  <h5 class="modal-title" id="staticBackdropLabel" style="color:white;">Categoría</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="col-12 table-responsive" style="padding: 10px;">
                    <table id="table-categoria" class="table table-striped" style="width:100%;">
                      <thead>
                          <tr>
                              <th scope="col">#</th>
                              <th scope="col">Categoría</th>
                              <th scope="col">Descripción</th>
                              <th scope="col"></th>
                              <th scope="col"></th>
                          </tr>
                      </thead>
                      <tbody>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-nueva-categoria">Nueva Categoría</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
        </div>
        
        <!-- Nueva Categoria -->
        <div class="modal fade" id="modal-nueva-categoria" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Nueva Categoría</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-nueva-categoria" action="ServletCategoria?accion=AGREGAR" method="post">
                  <div class="mb-3">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-categoria" name="codigo-categoria" readonly>
                  </div>
                  <div class="mb-3">
                    <label class="form-label">CATEGORÍA</label>
                    <input type="text" class="form-control" id="id-nombre-categoria" name="nombre-categoria">
                  </div>
                  <div class="mb-3">
                    <label class="form-label">DESCRIPCIÓN</label>
                    <input type="text" class="form-control" id="id-descripcion-categoria" name="descripcion-categoria">
                  </div>
                  <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	                <button type="submit" class="btn btn-primary">Grabar</button>
              	  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Editar Categoria -->
        <div class="modal fade" id="modal-editar-categoria" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Editar Categoría</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-editar-categoria" action="ServletCategoria?accion=EDITAR" method="post">
                  <div class="mb-3">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-categoria-edit" name="codigo-categoria-edit" readonly>
                  </div>
                  <div class="mb-3">
                    <label class="form-label">CATEGORÍA</label>
                    <input type="text" class="form-control" id="id-nombre-categoria-edit" name="nombre-categoria-edit">
                  </div>
                  <div class="mb-3">
                    <label class="form-label">DESCRIPCIÓN</label>
                    <input type="text" class="form-control" id="id-descripcion-categoria-edit" name="descripcion-categoria-edit">
                  </div>
                  <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	                <button type="submit" class="btn btn-primary">Grabar</button>
              	  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Modal Proveedor -->
        <div class="modal fade" id="modal-proveedor" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-fullscreen">
              <div class="modal-content">
                <div class="modal-header" style="background-color: slategrey;">
                  <h5 class="modal-title" id="staticBackdropLabel" style="color:white;">Proveedor</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="col-12 table-responsive" style="padding: 10px;">
                    <table id="table-proveedor" class="table table-striped" style="width:100%;">
                      <thead>
                          <tr>
                              <th scope="col">#</th>
                              <th scope="col">Proveedor</th>
                              <th scope="col">Descripción</th>
                              <th scope="col">Teléfono</th>
                              <th scope="col"></th>
                              <th scope="col"></th>
                              <th scope="col"></th>
                          </tr>
                      </thead>
                      <tbody>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-nuevo-proveedor">Nuevo Proveedor</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
        </div>
        
        <!-- Nuevo Proveedor -->
        <div class="modal fade" id="modal-nuevo-proveedor" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Nuevo Proveedor</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-nuevo-proveedor" action="ServletProveedor?accion=AGREGAR" method="post">
                  <div class="mb-3">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-proveedor" name="codigo-proveedor" readonly>
                  </div>
                  <div class="mb-3">
                    <label class="form-label">PROVEEDOR</label>
                    <input type="text" class="form-control" id="id-nombre-proveedor" name="nombre-proveedor">
                  </div>
                  <div class="mb-3">
                    <label class="form-label">DESCRIPCIÓN</label>
                    <input type="text" class="form-control" id="id-descripcion-proveedor" name="descripcion-proveedor">
                  </div>
                  <div class="mb-3">
                    <label class="form-label">TELÉFONO</label>
                    <input type="text" class="form-control" id="id-telefono-proveedor" name="telefono-proveedor">
                  </div>
                  <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	                <button type="submit" class="btn btn-primary">Grabar</button>
              	  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Editar Proveedor -->
        <div class="modal fade" id="modal-editar-proveedor" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header" style="background-color: slategrey;">
                <h5 class="modal-title" id="staticBackdropLabel" style="color:white;"><strong>Editar Proveedor</strong></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form class="row g-3" id="form-editar-proveedor" action="ServletProveedor?accion=EDITAR" method="post">
                  <div class="mb-3">
                    <label class="form-label">CÓDIGO</label>
                    <input type="text" class="form-control" id="id-codigo-proveedor-edit" name="codigo-proveedor-edit" readonly>
                  </div>
                  <div class="mb-3">
                    <label class="form-label">PROVEEDOR</label>
                    <input type="text" class="form-control" id="id-nombre-proveedor-edit" name="nombre-proveedor-edit">
                  </div>
                  <div class="mb-3">
                    <label class="form-label">DESCRIPCIÓN</label>
                    <input type="text" class="form-control" id="id-descripcion-proveedor-edit" name="descripcion-proveedor-edit">
                  </div>
                  <div class="mb-3">
                    <label class="form-label">TELÉFONO</label>
                    <input type="text" class="form-control" id="id-telefono-proveedor-edit" name="telefono-proveedor-edit">
                  </div>
                  <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	                <button type="submit" class="btn btn-primary">Grabar</button>
              	  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Modal Avisos -->
        <div class="modal fade" id="modal-avisos" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
              <div class="modal-content">
                <div class="modal-header" style="background-color: sandybrown;">
                  <h5 class="modal-title" id="staticBackdropLabel" style="color:white;">Avisos</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

    <script defer src="https://use.fontawesome.com/releases/v6.4.2/js/all.js"></script>

    <script>
        listarControlesAlm();
        listarProductos();
        listarProveedores();
        listarCategorias();
        cargarUsuarios();
        cargarProductos();
        cargarCategorias();
        cargarProveedores();
        cargarNumeroControlAlmacenGenerado();
        cargarCodigoControlAlmacenGenerado();
        cargarCodigoProductoGenerado();
        
        $(document).on("click",".btn-eliminar-control",function(){
			let cod_con;
			cod_con = $(this).parents("tr").find("td")[0].innerHTML;
			$("#id-codigo-control-eliminar").val(cod_con);
		})
        
        $(document).on("click",".btn-editar-detalle",function(){
			let cod_con, num_det;
			cod_con = $(this).parents("tr").find("td")[0].innerHTML;
			num_det = $(this).parents("tr").find("td")[1].innerHTML;
			$.get("ServletControlAlmacen?accion=BUSCAR&codigo-control="+cod_con+"&numero-detalle="+num_det,function(response){
				console.log(response);
				$("#id-codigo-control-edit").val(response.codigo_control_alm);
				$("#id-numero-detalle-control-edit").val(response.numero_detalle_control_alm);
				$("#id-producto-control-edit").val(response.codigo_pro);
				$("#id-cantidad-control-edit").val(response.cantidad_pro);
				$("#id-tipo-control-edit").val(response.tipo_control_alm);
				$("#id-fecha-vencimiento-control-edit").val(response.fecha_ven_form);
				$("#id-usuario-control-edit").val(response.codigo_usu);
			})
		})
        
        $(document).on("click",".btn-detalle-control",function(){
			let cod_con;
			cod_con=$(this).parents("tr").find("td")[0].innerHTML;
			let boton_editar_detalle="<button type='button' class='btn btn-light btn-editar-detalle' data-bs-toggle='modal' data-bs-target='#editar-detalle-control-alm'>Editar</button>";
			let boton_eliminar_detalle="<button type='button' class='btn btn-danger btn-eliminar-control'>Eliminar</button>";
			$("#table-detalle-control-alm tbody").empty();
			$.get("ServletControlAlmacen?accion=LISTAR-DETALLES-CONTROL&codigo-control="+cod_con,function(response){
				$.each(response,function(index,item){
					$("#table-detalle-control-alm").append("<tr>"+
															"<td>"+item.codigo_control_alm+"</td>"+
															"<td>"+item.numero_detalle_control_alm+"</td>"+
															"<td>"+item.nombre_pro+"</td>"+
															"<td>"+item.cantidad_pro+"</td>"+
															"<td>"+item.tipo_control_alm+"</td>"+
															"<td>"+item.fecha_ven_form+"</td>"+
															"<td>"+item.nombre_usu+"</td>"+
															"<td>"+boton_editar_detalle+"</td>"+
															"<td>"+boton_eliminar_detalle+"</td>"+
															"</tr>");
				})
				$('#table-detalle-control-alm').DataTable();
			})
		})
		
		$(document).on("click",".btn-adicionar-producto",function(){
			let cod_con, num_det, cod_pro, nom_pro, des_can, tipo_con, fec_ven, cod_usu, nom_usu;
			cod_con=$("#id-codigo-control-alm").val();
			num_det=$("#id-numero-detalle-control").val();
			cod_pro=$("#id-producto-control").val();
			nom_pro=$("#id-producto-control option[value='" + cod_pro + "']").text();
			can_pro=$("#id-cantidad-control").val();
			tipo_con=$("#id-tipo-control").val();
			cod_usu=$("#id-usuario-control").val();
			nom_usu=$("#id-usuario-control option[value='" + cod_usu + "']").text();
			let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-producto'>Eliminar</button>";
			$("#table-detalle-control tbody").empty();
			$.get("ServletControlAlmacen?accion=ADICIONAR&codigo-control-alm="+cod_con+"&numero-detalle="+num_det+"&codigo-producto="+cod_pro+"&nombre-producto="+nom_pro+
					"&cantidad-producto="+can_pro+"&tipo-control="+tipo_con+"&codigo-usuario="+cod_usu+"&nombre-usuario="+nom_usu,function(response){
				$.each(response,function(index,item){
					$("#table-detalle-control").append("<tr>"+
														"<td>"+item.codigo_pro+"</td>"+
														"<td>"+item.numero_detalle_control_alm+"</td>"+
														"<td>"+item.nombre_pro+"</td>"+
														"<td>"+item.cantidad_pro+"</td>"+
														"<td>"+item.tipo_control_alm+"</td>"+
														"<td>"+item.nombre_usu+"</td>"+
														"<td>"+boton_eliminar+"</td>"+
														"</tr>");
				})
				$('#table-detalle-control').DataTable();
			})	
		})
		
		$(document).on("click",".btn-eliminar-producto",function(){
			let cod_pro;
			cod_pro=$(this).parents("tr").find("td")[0].innerHTML;
			let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-producto'>Eliminar</button>";
			$("#table-detalle-control tbody").empty();
			$.get("ServletControlAlmacen?accion=ELIMINAR-DETALLE&codigo-producto="+cod_pro,function(response){
				$.each(response,function(index,item){
					$("#table-detalle-control").append("<tr>"+
														"<td>"+item.codigo_pro+"</td>"+
														"<td>"+item.numero_detalle_control_alm+"</td>"+
														"<td>"+item.nombre_pro+"</td>"+
														"<td>"+item.cantidad_pro+"</td>"+
														"<td>"+item.tipo_control_alm+"</td>"+
														"<td>"+item.nombre_usu+"</td>"+
														"<td>"+boton_eliminar+"</td>"+
														"</tr>");
				})
			})
		})
		
		function listarControlesAlm() {
			$.get("ServletControlAlmacen?accion=LISTAR",function(e){
				$.each(e,function(i,item){
					$("#table-control-alm").append("<tr>"+
												"<td>"+item.codigo_control_alm+"</td>"+		
												"<td>"+item.numero_control_alm+"</td>"+
												"<td>"+item.fecha_reg_form+"</td>"+
												"<td><button type='button' class='btn btn-info btn-detalle-control' data-bs-toggle='modal' data-bs-target='#detalle-control-alm'>Detalle</button></td>"+
												"<td><button type='button' class='btn btn-danger btn-eliminar-control' data-bs-toggle='modal' data-bs-target='#eliminar-control-alm'>Eliminar</button></td>"+
												"</tr>");
				})
				$('#table-control-alm').DataTable();
			})
		}
        
        $(document).on("click",".btn-eliminar",function(){
			let cod_elim;
			cod_elim = $(this).parents("tr").find("td")[0].innerHTML;
			$("#id-codigo-eliminar").val(cod_elim);
		})
		
		$(document).on("click",".btn-editar",function(){
			let cod_pro;
			cod_pro = $(this).parents("tr").find("td")[0].innerHTML;
			$.get("ServletProducto?accion=BUSCAR&codigo-producto="+cod_pro,function(response){
				console.log(response);
				$("#id-codigo-producto-edit").val(response.codigo_pro);
				$("#id-nombre-producto-edit").val(response.nombre_pro);
				$("#id-categoria-edit").val(response.codigo_cat);
				$("#id-proveedor-edit").val(response.codigo_prov);
				$("#id-cantidad-edit").val(response.cantidad);
				$("#id-descripcion-cantidad-edit").val(response.descripcion_can);
				$("#id-numero-lote-edit").val(response.numero_lote);
				$("#id-fecha-vencimiento-edit").val(response.fecha_ven_form);
			})
		})
		
        function listarProductos() {
			$.get("ServletProducto?accion=LISTAR",function(e){
				$.each(e,function(i,item){
					$("#table-productos").append("<tr>"+
												"<td>"+item.codigo_pro+"</td>"+
												"<td>"+item.nombre_pro+"</td>"+
												"<td>"+item.nombre_cat+"</td>"+
												"<td>"+item.nombre_prov+"</td>"+
												"<td>"+item.cantidad+"</td>"+
												"<td>"+item.descripcion_can+"</td>"+
												"<td>"+item.numero_lote+"</td>"+
												"<td>"+item.fecha_ven_form+"</td>"+
												"<td><button type='button' class='btn btn-light btn-editar' data-bs-toggle='modal' data-bs-target='#editar-producto'>Editar</button></td>"+
												"<td><button type='button' class='btn btn-danger btn-eliminar' data-bs-toggle='modal' data-bs-target='#eliminar-producto'>Eliminar</button></td>"+
												"</tr>");
				})
				$('#table-productos').DataTable();
			})
		}
        
        $(document).on("click",".btn-editar-categoria",function(){
			let cod_cat;
			cod_cat = $(this).parents("tr").find("td")[0].innerHTML;
			$.get("ServletCategoria?accion=BUSCAR&codigo-categoria="+cod_cat,function(response){
				console.log(response);
				$("#id-codigo-categoria-edit").val(response.codigo_cat);
				$("#id-nombre-categoria-edit").val(response.nombre_cat);
				$("#id-descripcion-categoria-edit").val(response.descripcion_cat);
			})
		})
        
        function listarCategorias() {
			$.get("ServletCategoria?accion=LISTAR",function(e){
				$.each(e,function(i,item){
					$("#table-categoria").append("<tr>"+
												"<td>"+item.codigo_cat+"</td>"+
												"<td>"+item.nombre_cat+"</td>"+
												"<td>"+item.descripcion_cat+"</td>"+
												"<td><button type='button' class='btn btn-light btn-editar-categoria' data-bs-toggle='modal' data-bs-target='#modal-editar-categoria'>Editar</button></td>"+
												"<td><button type='button' class='btn btn-danger btn-eliminar-categoria' data-bs-toggle='modal' data-bs-target='#'>Eliminar</button></td>"+
												"</tr>");
				})
				$('#table-categoria').DataTable();
			})
		}
        
        $(document).on("click",".btn-editar-proveedor",function(){
			let cod_prov;
			cod_prov = $(this).parents("tr").find("td")[0].innerHTML;
			$.get("ServletProveedor?accion=BUSCAR&codigo-proveedor="+cod_prov,function(response){
				console.log(response);
				$("#id-codigo-proveedor-edit").val(response.codigo_prov);
				$("#id-nombre-proveedor-edit").val(response.nombre_prov);
				$("#id-descripcion-proveedor-edit").val(response.descripcion_prov);
				$("#id-telefono-proveedor-edit").val(response.telefono_prov);
			})
		})
        
        function listarProveedores() {
			$.get("ServletProveedor?accion=LISTAR",function(e){
				$.each(e,function(i,item){
					$("#table-proveedor").append("<tr>"+
												"<td>"+item.codigo_prov+"</td>"+
												"<td>"+item.nombre_prov+"</td>"+
												"<td>"+item.descripcion_prov+"</td>"+
												"<td>"+item.telefono_prov+"</td>"+
												"<td><button type='button' class='btn btn-info btn-productos' data-bs-toggle='modal' data-bs-target='#'>Productos</button></td>"+
												"<td><button type='button' class='btn btn-light btn-editar-proveedor' data-bs-toggle='modal' data-bs-target='#modal-editar-proveedor'>Editar</button></td>"+
												"<td><button type='button' class='btn btn-danger btn-eliminar-proveedor' data-bs-toggle='modal' data-bs-target='#'>Eliminar</button></td>"+
												"</tr>");
				})
				$('#table-proveedor').DataTable();
			})
		}
        
        function cargarUsuarios() {
			$.get("ServletUsuario?accion=LISTAR",function(response){
				$.each(response,function(index,item){
					$("#id-usuario-control").append("<option value='"+item.codigo_usu+"'>"+item.nombre_usu+"</option>");
					$("#id-usuario-control-edit").append("<option value='"+item.codigo_usu+"'>"+item.nombre_usu+"</option>");
				})
			})
		}
        
        function cargarProductos() {
			$.get("ServletProducto?accion=LISTAR",function(response){
				$.each(response,function(index,item){
					$("#id-producto-control").append("<option value='"+item.codigo_pro+"'>"+item.nombre_pro+'('+item.numero_lote+')'+'('+item.fecha_ven_form+')'+"</option>");
					$("#id-producto-control-edit").append("<option value='"+item.codigo_pro+"'>"+item.nombre_pro+"</option>");
				})
			})
		}
        
        function cargarCategorias(){
			$.get("ServletCategoria?accion=LISTAR",function(response){
				$.each(response,function(index,item){
					$("#id-categoria").append("<option value='"+item.codigo_cat+"'>"+item.nombre_cat+"</option>");
					$("#id-categoria-edit").append("<option value='"+item.codigo_cat+"'>"+item.nombre_cat+"</option>");
				})
			})
		}
        function cargarProveedores(){
			$.get("ServletProveedor?accion=LISTAR",function(response){
				$.each(response,function(index,item){
					$("#id-proveedor").append("<option value='"+item.codigo_prov+"'>"+item.nombre_prov+"</option>");
					$("#id-proveedor-edit").append("<option value='"+item.codigo_prov+"'>"+item.nombre_prov+"</option>");
				})
			})
		}
        function cargarNumeroControlAlmacenGenerado(){
			$.get("ServletControlAlmacen?accion=NUMERO-CONTROL",function(response){
				$("#id-numero-control-alm").val(response);		
			})	
		}   
        function cargarCodigoControlAlmacenGenerado(){
			$.get("ServletControlAlmacen?accion=CODIGO-CONTROL",function(response){
				$("#id-codigo-control-alm").val(response);		
			})	
		}    
        function cargarCodigoProductoGenerado(){
			$.get("ServletProducto?accion=CODIGO",function(response){
				$("#id-codigo-producto").val(response);		
			})	
		}    
    </script>
</body>
</html>