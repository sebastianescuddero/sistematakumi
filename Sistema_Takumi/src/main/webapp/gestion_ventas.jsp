<jsp:include page="pagina_principal.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" rel="stylesheet"/>

    <title>Gestion Ventas</title>
</head>
<body style="background:#f3f3f3; font-family: 'Courier New', Courier, monospace;">
    <div class="container-fluid">
      <div class="header-top">
          <div class="titulo" style="padding: 20px;">
            <h2><strong>Gestión de Ventas</strong></h2>
          </div>
      </div>
      <div style="background-color: white; padding: 10px; border-top: 5px solid gainsboro; margin-top:25px;">
        <div style="padding: 10px;">
          <h4 style="margin: 0;">¿Qué desea realizar?</h4>
        </div>
        <div class="row" style="padding: 10px; text-align: center; justify-content: space-evenly;">
            <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px;">
              <a type="button" data-bs-toggle="modal" data-bs-target="#modal-boton-nuevo" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-money-check-alt" style="display: block;
                  inline-size: -webkit-fill-available;"></i>Nuevo</a>
            </div>
            <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-pagos-tarjeta" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-credit-card" style="display: block;
                    inline-size: -webkit-fill-available;"></i>Pagos tarjeta</a>
            </div>
            <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px;">
            <a type="button" data-bs-toggle="modal" data-bs-target="#modal-bancos" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-university" style="display: block;
                inline-size: -webkit-fill-available;"></i>Bancos</a>
            </div>
            <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px;">
                <a type="button" class="btn btn-caja" data-bs-toggle="modal" data-bs-target="#modal-cajas" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-inbox" style="display: block;
                    inline-size: -webkit-fill-available;"></i>Cajas</a>
            </div>
        </div>
      </div>
      
      <!-- Modal -->
	<div class="modal fade" id="modal-boton-nuevo" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header" style="background-color: slategrey;">
	        <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Nuevo</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <div class="row" style="padding: 10px; text-align: center; justify-content: space-evenly;">
              <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; border-radius: 10px; padding: 10px 0px; width: 200px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-nuevo-ingreso" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-money-check-alt" style="display: block;
                inline-size: -webkit-fill-available;"></i>Ingreso</a>
              </div>
              <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; border-radius: 10px; padding: 10px 0px; width: 200px;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-nuevo-egreso" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-hand-holding-usd" style="display: block;
                inline-size: -webkit-fill-available;"></i>Egreso</a>
              </div>
            </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

      <!-- Modal Ingreso-->
      <div class="modal fade" id="modal-nuevo-ingreso" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Nuevo Control Ingresos</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form class="row" id="form-nuevo-ingreso" action="ServletControIngreso?accion=REGISTRAR" method="post">
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">CÓDIGO</label>
                  <input type="text" class="form-control" id="id-codigo-control-ing" name="codigo-control-ing" readonly>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">N° CONTROL</label>
                  <input type="text" class="form-control" id="id-numero-control-ing" name="numero-control-ing" readonly>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">N° DETALLE</label>
                  <select class="form-control" id="id-numero-detalle-control-ing" name="numero-detalle-control-ing">
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
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">MONTO</label>
                  <input type="text" class="form-control" id="id-monto-ingreso" name="monto-ingreso" >
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2">
                  <label class="form-label">MÉTODO PAGO</label>
                  <select class="form-control" id="id-metodo-pago-ing" name="metodo-pago-ing">
                  </select>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2">
                  <label class="form-label">DESCRIPCIÓN OTRO (*)</label>
                  <input type="text" class="form-control" id="id-descripcion-otro-ing" name="descripcion-otro-ing" >
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2" style="align-content: flex-end; display: grid;">
                    <button type="button" class="btn btn-outline-success btn-adicionar-ingreso">Agregar</button>
                </div>
                <div class="col-12 table-responsive" style="padding: 10px;">
                  <table id="table-detalle-ingreso" class="table table-striped" style="width:100%;">
                    <thead>
                      <tr>
                        <th scope="col">N° Detalle</th>
                        <th scope="col">Monto</th>
                        <th scope="col">Método Pago</th>
                        <th scope="col">Descripción</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                    </tbody>
                  </table>
                </div>
	            <div class="modal-footer">
	              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	              <button type="submit" class="btn btn-primary">Registrar</button>
	            </div>
              </form>
            </div>
          </div>
        </div>
      </div>

      <!-- Fin Modal Ingreso-->

      <!-- Modal Egreso-->
      <div class="modal fade" id="modal-nuevo-egreso" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Nuevo Control Egresos</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form class="row" id="form-nuevo-egreso" action="ServletControlEgreso?accion=REGISTRAR" method="post">
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">CÓDIGO</label>
                  <input type="text" class="form-control" id="id-codigo-control-egr" name="codigo-control-egr" readonly>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">N° CONTROL</label>
                  <input type="text" class="form-control" id="id-numero-control-egr" name="numero-control-egr" readonly>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">N° DETALLE</label>
                  <select class="form-control" id="id-numero-detalle-control-egr" name="numero-detalle-control-egr">
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
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">MONTO</label>
                  <input type="text" class="form-control" id="id-monto-egreso" name="monto-egreso">
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
                  <label class="form-label">DESCRIPCIÓN EGRESO</label>
                  <input type="text" class="form-control" id="id-descripcion-razon-egreso" name="descripcion-razon-egreso">
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2">
                  <label class="form-label">TIPO EGRESO</label>
                  <select class="form-control" id="id-tipo-egreso" name="tipo-egreso">
                  </select>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2">
                  <label class="form-label">MÉTODO PAGO</label>
                  <select class="form-control" id="id-metodo-pago-egr" name="metodo-pago-egr">
                  </select>
                </div>                
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2" style="align-self: flex-end; display: grid;">
                    <button type="button" class="btn btn-outline-success btn-adicionar-egreso">Agregar</button>
                </div>
                <div class="col-12 table-responsive" style="padding: 10px;">
                  <table id="table-detalle-egreso" class="table table-striped" style="width:100%;">
                    <thead>
                      <tr>
                        <th scope="col">N° Detalle</th>
                        <th scope="col">Monto</th>
                        <th scope="col">Descripción Egreso</th>
                        <th scope="col">Tipo Egreso</th>
                        <th scope="col">Método Pago</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                    </tbody>
                  </table>
                </div>
	            <div class="modal-footer">
	              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
	              <button type="submit" class="btn btn-primary">Registrar</button>
	            </div>
              </form>
            </div>
          </div>
        </div>
      </div>

      <!-- Fin Modal Egreso-->

      <!-- Modal Pagos Tarjeta-->
      <div class="modal fade" id="modal-pagos-tarjeta" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Control Pagos Tarjeta</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form class="row g-3" id="form-pagos-tarjeta" action="ServletPagoTarjeta?accion=REGISTRAR" method="post">
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">CÓDIGO</label>
                  <input type="text" class="form-control" id="id-codigo-control-pago-tarj" name="codigo-control-pago-tarj" readonly>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">N° CONTROL</label>
                  <input type="text" class="form-control" id="id-numero-control-pago-tarj" name="numero-control-pago-tarj" readonly>
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">N° DETALLE</label>
                  <select class="form-control" id="id-numero-detalle-control-pago-tarj" name="numero-detalle-control-pago-tarj">
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
                <div class="col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 mb-2">
                  <label class="form-label">MONTO</label>
                  <input type="text" class="form-control" id="id-monto-total-pos" name="monto-total-pos">
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2">
                  <label class="form-label">POS</label>
                  <select class="form-control" id="id-codigo-pos" name="codigo-pos">
                  </select>
                </div>              
                <div class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 mb-2" style="align-self: flex-end; display: grid;">
                    <button type="button" class="btn btn-outline-success btn-adicionar-pago-tarj">Agregar</button>
                </div>
                <div class="col-12 table-responsive" style="padding: 10px;">
                  <table id="table-detalle-pagos-tarjeta" class="table table-striped" style="width:100%;">
                    <thead>
                      <tr>
                        <th scope="col">N° Detalle</th>
                        <th scope="col">Monto</th>
                        <th scope="col">Pos</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                    </tbody>
                  </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                  <button type="submit" class="btn btn-primary">Registrar</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>

      <!-- Fin Modal Pagos Tarjeta-->

      <!-- Modal Bancos-->
      <div class="modal fade" id="modal-bancos" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Bancos</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row" style="justify-content: space-evenly; padding: 10px; text-align: center;">
                <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: cornflowerblue; border-radius: 10px; padding: 10px; width: 150px;">
                  <a type="button" class="btn btn-banco-bbva" data-bs-toggle="modal" data-bs-target="#modal-banco-bbva" style="text-decoration: none; color: whitesmoke;">BBVA</a>
                </div>
                <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: coral; border-radius: 10px; padding: 10px; width: 150px;">
                <a type="button" class="btn btn-banco-bcp" data-bs-toggle="modal" data-bs-target="#modal-banco-bcp" style="text-decoration: none; color: whitesmoke;">BCP</a>
                </div>
                <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: seagreen; border-radius: 10px; padding: 10px; width: 150px;">
                    <a type="button" class="btn btn-banco-interbank" data-bs-toggle="modal" data-bs-target="#modal-banco-interbank" style="text-decoration: none; color: whitesmoke;">Interbank</a>
                </div>
                <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 mb-2" style="background-color: slategrey; border-radius: 10px; padding: 10px; width: 150px;">
                    <a type="button" data-bs-toggle="modal" data-bs-target="#modal-cuentas" style="text-decoration: none; color: whitesmoke;">Cuentas</a>
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      <!-- Fin Modal Bancos-->

      <!-- Modal Banco BBVA-->
      <div class="modal fade" id="modal-banco-bbva" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: cornflowerblue;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">BBVA</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row align-items-center">
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Movimientos</strong></h5>
	                  <div class="table-responsive">
	                    <table id="table-detalle-banco-bbva" class="table table-striped">
	                      <thead>
	                        <tr>
	                          <th scope="col">Cuenta</th>
	                          <th scope="col">Ingreso</th>
	                          <th scope="col">Egreso</th>
	                          <th scope="col">Fecha</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Estado de Banco</strong></h5>
	                  <div class="form-group">
	                  	<label class="form-label">Saldo Disponible</label>
	                    <input class="form-control form-control-lg" type="text" id="id-estado-banco-bbva" name="estado-banco-bbva" readonly>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Cuentas Asociadas</strong></h5>
	                  <div class="table-responsive">
	                    <table id="table-cuentas-bbva" class="table table-striped">
	                      <thead>
	                        <tr>
	                          <th scope="col">#</th>
	                          <th scope="col">Cuenta</th>
	                          <th scope="col">N° Cuenta</th>
	                          <th scope="col">Suma Ingresos</th>
                              <th scope="col">Suma Egresos</th>
	                          <th scope="col">Balance</th>
	                          <th scope="col"></th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
              </div>
            </div>
            <div class="modal-footer">
              <div class="btn btn-primary" style="background-color: cornflowerblue; border: none; text-align:center;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#" style="text-decoration: none; color: whitesmoke;">Nuevo Movimiento</a>
              </div>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      <!-- Fin Modal Banco BBVA -->

      <!-- Modal Banco BCP-->
      <div class="modal fade" id="modal-banco-bcp" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: coral;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;"><strong>BCP</strong></h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row align-items-center">
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Movimientos</strong></h5>
	                  <div class="table-responsive">
	                    <table id="table-detalle-banco-bcp" class="table table-striped">
	                      <thead>
	                        <tr>
	                          <th scope="col">Cuenta</th>
	                          <th scope="col">Ingreso</th>
	                          <th scope="col">Egreso</th>
	                          <th scope="col">Fecha</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Estado de Banco</strong></h5>
	                  <div class="form-group">
	                  	<label class="form-label">Saldo Disponible</label>
	                    <input class="form-control form-control-lg" type="text" id="id-estado-banco-bcp" name="estado-banco-bcp" readonly>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Cuentas Asociadas</strong></h5>
	                  <div class="table-responsive">
	                    <table id="table-cuentas-bcp" class="table table-striped">
	                      <thead>
	                        <tr>
	                          <th scope="col">#</th>
	                          <th scope="col">Cuenta</th>
	                          <th scope="col">N° Cuenta</th>
	                          <th scope="col">Suma Ingresos</th>
                              <th scope="col">Suma Egresos</th>
	                          <th scope="col">Balance</th>
	                          <th scope="col"></th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
              </div>
            </div>
            <div class="modal-footer">
              <div class="btn btn-primary" style="background-color: coral; border: none; text-align:center;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#" style="text-decoration: none; color: whitesmoke;">Nuevo Movimiento</a>
              </div>
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      <!-- Fin Modal Bancos BCP-->

      <!-- Modal Bancos INTERBANK-->
      <div class="modal fade" id="modal-banco-interbank" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: seagreen;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Interbank</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row align-items-center">
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Movimientos</strong></h5>
	                  <div class="table-responsive">
	                    <table id="table-detalle-banco-interbank" class="table table-striped">
	                      <thead>
	                        <tr>
	                          <th scope="col">Cuenta</th>
	                          <th scope="col">Ingreso</th>
	                          <th scope="col">Egreso</th>
	                          <th scope="col">Fecha</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Estado de Banco</strong></h5>
	                  <div class="form-group">
	                  	<label class="form-label">Saldo Disponible</label>
	                    <input class="form-control form-control-lg" type="text" id="id-estado-banco-interbank" name="estado-banco-interbank" readonly>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Cuentas Asociadas</strong></h5>
	                  <div class="table-responsive">
	                    <table class="table table-striped" id="table-cuentas-interbank">
	                      <thead>
	                        <tr>
	                          <th scope="col">#</th>
	                          <th scope="col">Cuenta</th>
	                          <th scope="col">N° Cuenta</th>
	                          <th scope="col">Suma Ingresos</th>
                        	  <th scope="col">Suma Egresos</th>
	                          <th scope="col">Balance</th>
	                          <th scope="col"></th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      <!-- Fin Modal Bancos INTERBANK-->
      
      <!-- Modal Cuentas-->
      <div class="modal fade" id="modal-cuentas" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-fullscreen">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategray;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Cuentas</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row">
                <div class="table-responsive">
                  <table class="table table-striped" id="table-cuentas">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Cuenta</th>
                        <th scope="col">N° Cuenta</th>
                        <th scope="col">Suma Ingresos</th>
                        <th scope="col">Suma Egresos</th>
                        <th scope="col">Balance</th>
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
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      <!-- Fin Modal Cuentas-->

      <!-- Modal Caja-->
      <div class="modal fade" id="modal-cajas" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Cajas</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="row" style="justify-content: space-around;">
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Estado Caja Mayor</strong></h5>
	                  <div class="form-group">
	                  	<label class="form-label">Dinero Disponible</label>
	                    <input class="form-control form-control-lg" type="text" id="id-estado-caja-mayor" name="estado-caja-mayor" readonly>
	                  </div>
	                </div>
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Estado Caja Secundaria</strong></h5>
	                  <div class="form-group">
	                  	<label class="form-label">Dinero Disponible</label>
	                    <input class="form-control form-control-lg" type="text" id="id-estado-caja-secundaria" name="estado-caja-secundaria" readonly>
	                  </div>
	                </div>
	              </div>
	            </div>
                <div class="col-12 mb-2">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title"><strong>Movimientos</strong></h5>
	                  <div class="table-responsive">
	                    <table id="table-detalle-caja" class="table table-striped">
	                      <thead>
	                        <tr>
	                          <th scope="col">Caja</th>
	                          <th scope="col">Ingreso</th>
	                          <th scope="col">Egreso</th>
	                          <th scope="col">Fecha</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	            </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      <!-- Fin Modal Caja -->
      
      <!-- Modal Registro Ingresos -->
      
      <div class="modal fade" id="modal-lista-control-ingresos" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-fullscreen">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Control Ingresos</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="col-12 table-responsive" style="padding: 10px;">
                <table id="table-lista-control-ingresos" class="table table-striped" style="width:100%;">
                  <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">N° Control</th>
                        <th scope="col">Monto Efectivo</th>
                        <th scope="col">Monto Electrónico</th>
                        <th scope="col">Monto Total</th>
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
      
      <!-- Fin Modal Registro Ingresos -->
      
      <!-- Modal Registro Egresos -->
      
      <div class="modal fade" id="modal-lista-control-egresos" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-fullscreen">
          <div class="modal-content">
            <div class="modal-header" style="background-color: slategrey;">
              <h5 class="modal-title" id="staticBackdropLabel" style="color: white;">Control Egresos</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="col-12 table-responsive" style="padding: 10px;">
                <table id="table-lista-control-egresos" class="table table-striped" style="width:100%;">
                  <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">N° Control</th>
                        <th scope="col">Monto Efectivo</th>
                        <th scope="col">Monto Electrónico</th>
                        <th scope="col">Monto Total</th>
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
      
      <!-- Fin Modal Registro Egresos -->

      <div class="row" style="margin-top: 10px;">
        <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2 mb-2">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Ingresos de la semana</h5>
              <div class="table-responsive">
                <table id="table-ingresos-semana" class="table table-striped">
                  <thead>
                    <tr>
                        <th scope="col">Fecha</th>
                        <th scope="col">Efectivo</th>
                        <th scope="col">Electrónico</th>
                        <th scope="col">Total</th>
                      </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>
              </div>
              <div class="col-12" style="background-color: slategrey; border-radius: 10px; padding: 10px; width: 200px; margin-inline: auto; text-align:center;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-lista-control-ingresos" style="text-decoration: none; color: whitesmoke;">Abrir registro</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 mb-2 mb-2">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Egresos de la semana</h5>
              <div class="table-responsive">
                <table id="table-egresos-semana" class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">Fecha</th>
                      <th scope="col">Efectivo</th>
                      <th scope="col">Electrónico</th>
                      <th scope="col">Total</th>
                    </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>
              </div>
              <div class="col-12" style="background-color: slategrey; border-radius: 10px; padding: 10px; width: 200px; margin-inline: auto; text-align:center;">
                <a type="button" data-bs-toggle="modal" data-bs-target="#modal-lista-control-egresos" style="text-decoration: none; color: whitesmoke;">Abrir registro</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col mb-2">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Balance</h5>
                <p>

                </p>
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
    cargarNumeroControlIngresoGenerado();
    cargarCodigoControlIngresoGenerado();
    cargarNumeroControlEgresoGenerado();
    cargarCodigoControlEgresoGenerado();
    cargarNumeroControlPagoTarjGenerado()
    cargarCodigoControlPagoTarjGenerado()
    cargarMetodosPago();
    cargarTipoEgreso();
    cargarPos();
    listarControlesIngresos();
    listarControlesIngresosSemana();
    listarControlesEgresos();
    listarControlesEgresosSemana();
    listarMovimientosBancoBcp();
    listarMovimientosBancoBbva();
    listarMovimientosBancoInterbank();
    listarCuentasBanco();
    listarCuentasBcp();
    listarCuentasBbva()
    listarCuentasInterbank();
    listarDetCaja();
    
    $(document).on("click",".btn-caja",function(){
    	let cod_caja=1;
    	$.get("ServletCaja?accion=BUSCAR&codigo-caja="+cod_caja,function(response){
			console.log(response);
			$("#id-estado-caja-mayor").val(response.balance_caja);
		})
	})
    
    $(document).on("click",".btn-banco-bcp",function(){
    	let cod_banc=1;
    	$.get("ServletBanco?accion=BUSCAR&codigo-banco="+cod_banc,function(response){
			console.log(response);
			$("#id-estado-banco-bcp").val(response.balance_banc);
		})
	})
    
    $(document).on("click",".btn-banco-bbva",function(){
    	let cod_banc=2;
    	$.get("ServletBanco?accion=BUSCAR&codigo-banco="+cod_banc,function(response){
			console.log(response);
			$("#id-estado-banco-bbva").val(response.balance_banc);
		})
	})
	
	$(document).on("click",".btn-banco-interbank",function(){
    	let cod_banc=3;
    	$.get("ServletBanco?accion=BUSCAR&codigo-banco="+cod_banc,function(response){
			console.log(response);
			$("#id-estado-banco-interbank").val(response.balance_banc);
		})
	})
    
    $(document).on("click",".btn-adicionar-ingreso",function(){
		let cod_con_ing, num_det_ing, mont_ing, cod_met_pag, met_pag, desc_otro_ing;
		cod_con_ing=$("#id-codigo-control-ing").val();
		num_det_ing=$("#id-numero-detalle-control-ing").val();
		mont_ing=$("#id-monto-ingreso").val();
		cod_met_pag=$("#id-metodo-pago-ing").val();
		met_pag=$("#id-metodo-pago-ing option[value='" + cod_met_pag + "']").text();
		desc_otro_ing=$("#id-descripcion-otro-ing").val();
		let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-ingreso'>Eliminar</button>";
		$("#table-detalle-ingreso tbody").empty();
		$.get("ServletControIngreso?accion=ADICIONAR&codigo-control-ing="+cod_con_ing+"&numero-detalle="+num_det_ing+"&monto-ingreso="+mont_ing+
				"&codigo-metodo-pago="+cod_met_pag+"&metodo-pago="+met_pag+"&descripcion-otro-ingreso="+desc_otro_ing,function(response){
			$.each(response,function(index,item){
				$("#table-detalle-ingreso").append("<tr>"+
													"<td>"+item.numero_detalle_control_ing+"</td>"+
													"<td>"+item.monto_ing+"</td>"+
													"<td>"+item.met_pago+"</td>"+
													"<td>"+item.descripcion_otro_ing+"</td>"+
													"<td>"+boton_eliminar+"</td>"+
													"</tr>");
			})
		})	
	})
	
	$(document).on("click",".btn-eliminar-ingreso",function(){
		let num_det;
		num_det=$(this).parents("tr").find("td")[0].innerHTML;
		let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-ingreso'>Eliminar</button>";
		$("#table-detalle-ingreso tbody").empty();
		$.get("ServletControIngreso?accion=ELIMINAR-DETALLE&numero-detalle="+num_det,function(response){
			$.each(response,function(index,item){
				$("#table-detalle-ingreso").append("<tr>"+
													"<td>"+item.numero_detalle_control_ing+"</td>"+
													"<td>"+item.monto_ing+"</td>"+
													"<td>"+item.met_pago+"</td>"+
													"<td>"+item.descripcion_otro_ing+"</td>"+
													"<td>"+boton_eliminar+"</td>"+
													"</tr>");
			})
		})
	})
	
	$(document).on("click",".btn-adicionar-egreso",function(){
		let cod_con_egr, num_det_egr, mont_egr, desc_razon_egr, cod_tip_egr, tip_egr, cod_met_pag, met_pag;
		cod_con_egr=$("#id-codigo-control-egr").val();
		num_det_egr=$("#id-numero-detalle-control-egr").val();
		mont_egr=$("#id-monto-egreso").val();
		desc_razon_egr=$("#id-descripcion-razon-egreso").val();
		cod_tip_egr=$("#id-tipo-egreso").val();
		tip_egr=$("#id-tipo-egreso option[value='" + cod_tip_egr + "']").text();
		cod_met_pag=$("#id-metodo-pago-egr").val();
		met_pag=$("#id-metodo-pago-egr option[value='" + cod_met_pag + "']").text();
		let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-egreso'>Eliminar</button>";
		$("#table-detalle-egreso tbody").empty();
		$.get("ServletControlEgreso?accion=ADICIONAR&codigo-control-egr="+cod_con_egr+"&numero-detalle-egr="+num_det_egr+"&monto-egreso="+mont_egr+
				"&descripcion-razon-egreso="+desc_razon_egr+"&codigo-tipo-egreso="+cod_tip_egr+"&tipo-egreso="+tip_egr+"&codigo-metodo-pago="+cod_met_pag+"&metodo-pago="+met_pag,function(response){
			$.each(response,function(index,item){
				$("#table-detalle-egreso").append("<tr>"+
													"<td>"+item.numero_detalle_control_egr+"</td>"+
													"<td>"+item.monto_egr+"</td>"+
													"<td>"+item.descripcion_razon_egr+"</td>"+
													"<td>"+item.tip_egr+"</td>"+
													"<td>"+item.met_pago+"</td>"+
													"<td>"+boton_eliminar+"</td>"+
													"</tr>");
			})
		})	
	})
	
	$(document).on("click",".btn-eliminar-egreso",function(){
		let num_det;
		num_det=$(this).parents("tr").find("td")[0].innerHTML;
		let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-egreso'>Eliminar</button>";
		$("#table-detalle-egreso tbody").empty();
		$.get("ServletControlEgreso?accion=ELIMINAR-DETALLE&numero-detalle="+num_det,function(response){
			$.each(response,function(index,item){
				$("#table-detalle-egreso").append("<tr>"+
													"<td>"+item.numero_detalle_control_egr+"</td>"+
													"<td>"+item.monto_egr+"</td>"+
													"<td>"+item.descripcion_razon_egr+"</td>"+
													"<td>"+item.tip_egr+"</td>"+
													"<td>"+item.met_pago+"</td>"+
													"<td>"+boton_eliminar+"</td>"+
													"</tr>");
			})
		})
	})
	
	$(document).on("click",".btn-adicionar-pago-tarj",function(){
		let cod_con_pag_tar, num_det_par_tar, mont_pos, cod_pos, pos;
		cod_con_pag_tar=$("#id-codigo-control-pago-tarj").val();
		num_det_par_tar=$("#id-numero-detalle-control-pago-tarj").val();
		mont_pos=$("#id-monto-total-pos").val();
		cod_pos=$("#id-codigo-pos").val();
		pos=$("#id-codigo-pos option[value='" + cod_pos + "']").text();
		let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-pago-tarj'>Eliminar</button>";
		$("#table-detalle-pagos-tarjeta tbody").empty();
		$.get("ServletPagoTarjeta?accion=ADICIONAR&codigo-control-pago-tarj="+cod_con_pag_tar+"&numero-detalle-pago-tarj="
				+num_det_par_tar+"&monto-pos="+mont_pos+"&codigo-pos="+cod_pos+"&pos="+pos,function(response){
			$.each(response,function(index,item){
				$("#table-detalle-pagos-tarjeta").append("<tr>"+
															"<td>"+item.numero_detalle_pago_tarj+"</td>"+
															"<td>"+item.monto_pos+"</td>"+
															"<td>"+item.pos+"</td>"+
															"<td>"+boton_eliminar+"</td>"+
															"</tr>");
			})
		})	
	})
	
	$(document).on("click",".btn-eliminar-pago-tarj",function(){
		let num_det;
		num_det=$(this).parents("tr").find("td")[0].innerHTML;
		let boton_eliminar="<button type='button' class='btn btn-danger btn-eliminar-pago-tarj'>Eliminar</button>";
		$("#table-detalle-pagos-tarjeta tbody").empty();
		$.get("ServletPagoTarjeta?accion=ELIMINAR-DETALLE&numero-detalle="+num_det,function(response){
			$.each(response,function(index,item){
				$("#table-detalle-pagos-tarjeta").append("<tr>"+
													"<td>"+item.numero_detalle_pago_tarj+"</td>"+
													"<td>"+item.monto_pos+"</td>"+
													"<td>"+item.pos+"</td>"+
													"<td>"+boton_eliminar+"</td>"+
													"</tr>");
			})
		})
	})
	
	function listarControlesIngresos() {
		$.get("ServletControIngreso?accion=LISTAR",function(e){
			$.each(e,function(i,item){
				$("#table-lista-control-ingresos").append("<tr>"+
											"<td>"+item.codigo_control_ing+"</td>"+
											"<td>"+item.numero_control_ing+"</td>"+		
											"<td>"+item.monto_total_efec+"</td>"+
											"<td>"+item.monto_total_elec+"</td>"+
											"<td>"+item.monto_total_ing+"</td>"+
											"<td>"+item.fecha_reg_form+"</td>"+
											"<td><button type='button' class='btn btn-info btn-detalle-control-ing' data-bs-toggle='modal' data-bs-target='#'>Detalle</button></td>"+
											"<td><button type='button' class='btn btn-danger btn-eliminar-control-ing' data-bs-toggle='modal' data-bs-target='#'>Eliminar</button></td>"+
											"</tr>");
			})
			$('#table-lista-control-ingresos').DataTable();
		})
	}
	
	function listarControlesIngresosSemana() {
		$.get("ServletControIngreso?accion=LISTAR-SEMANA",function(e){
			$.each(e,function(i,item){
				$("#table-ingresos-semana").append("<tr>"+
											"<td>"+item.fecha_reg_form+"</td>"+
											"<td>"+item.monto_total_efec+"</td>"+		
											"<td>"+item.monto_total_elec+"</td>"+
											"<td>"+item.monto_total_ing+"</td>"+
											"</tr>");
			})
		})
	}
    
    function listarControlesEgresos() {
		$.get("ServletControlEgreso?accion=LISTAR",function(e){
			$.each(e,function(i,item){
				$("#table-lista-control-egresos").append("<tr>"+
															"<td>"+item.codigo_control_egr+"</td>"+
															"<td>"+item.numero_control_egr+"</td>"+		
															"<td>"+item.monto_total_efec+"</td>"+
															"<td>"+item.monto_total_elec+"</td>"+
															"<td>"+item.monto_total_egr+"</td>"+
															"<td>"+item.fecha_reg_form+"</td>"+
															"<td><button type='button' class='btn btn-info btn-detalle-control-egr' data-bs-toggle='modal' data-bs-target='#'>Detalle</button></td>"+
															"<td><button type='button' class='btn btn-danger btn-eliminar-control-egr' data-bs-toggle='modal' data-bs-target='#'>Eliminar</button></td>"+
															"</tr>");
			})
			$('#table-lista-control-egresos').DataTable();
		})
	}
	
    function listarControlesEgresosSemana() {
		$.get("ServletControlEgreso?accion=LISTAR",function(e){
			$.each(e,function(i,item){
				$("#table-egresos-semana").append("<tr>"+
													"<td>"+item.fecha_reg_form+"</td>"+
													"<td>"+item.monto_total_efec+"</td>"+		
													"<td>"+item.monto_total_elec+"</td>"+
													"<td>"+item.monto_total_egr+"</td>"+
													"</tr>");
			})
		})
	}
    
    function listarMovimientosBancoBcp() {
		$.get("ServletCuentaBanco?accion=LISTAR-MOVIMIENTOS-BCP",function(e){
			$.each(e,function(i,item){
				$("#table-detalle-banco-bcp").append("<tr>"+
														"<td>"+item.nombre_cuenta_banc+"</td>"+
														"<td>"+item.ingreso+"</td>"+		
														"<td>"+item.egreso+"</td>"+
														"<td>"+item.fecha_reg_form+"</td>"+
														"</tr>");
			})
		})
	}
    
    function listarMovimientosBancoBbva() {
		$.get("ServletCuentaBanco?accion=LISTAR-MOVIMIENTOS-BBVA",function(e){
			$.each(e,function(i,item){
				$("#table-detalle-banco-bbva").append("<tr>"+
														"<td>"+item.nombre_cuenta_banc+"</td>"+
														"<td>"+item.ingreso+"</td>"+		
														"<td>"+item.egreso+"</td>"+
														"<td>"+item.fecha_reg_form+"</td>"+
														"</tr>");
			})
		})
	}
    
    function listarMovimientosBancoInterbank() {
		$.get("ServletCuentaBanco?accion=LISTAR-MOVIMIENTOS-INTBNK",function(e){
			$.each(e,function(i,item){
				$("#table-detalle-banco-interbank").append("<tr>"+
															"<td>"+item.nombre_cuenta_banc+"</td>"+
															"<td>"+item.ingreso+"</td>"+		
															"<td>"+item.egreso+"</td>"+
															"<td>"+item.fecha_reg_form+"</td>"+
															"</tr>");
			})
		})
	}
    
    function listarCuentasBanco() {
		$.get("ServletCuentaBanco?accion=LISTAR",function(e){
			$.each(e,function(i,item){
				$("#table-cuentas").append("<tr>"+
													"<td>"+item.codigo_cuenta_banc+"</td>"+
													"<td>"+item.cuenta_banc+"</td>"+		
													"<td>"+item.numero_cuenta_banc+"</td>"+
													"<td>"+item.ingreso_total_cuenta+"</td>"+
													"<td>"+item.egreso_total_cuenta+"</td>"+
													"<td>"+item.balance_cuenta+"</td>"+
													"<td><button type='button' class='btn btn-info btn-detalle-cuenta'>Detalle</button></td>"+
													"<td><button type='button' class='btn btn-danger btn-eliminar-cuenta'>Eliminar</button></td>"+
													"</tr>");
			})
			$('#table-cuentas').DataTable();
		})
	}
    
    function listarCuentasBcp() {
		$.get("ServletCuentaBanco?accion=LISTAR-CUENTAS-BCP",function(e){
			$.each(e,function(i,item){
				$("#table-cuentas-bcp").append("<tr>"+
													"<td>"+item.codigo_cuenta_banc+"</td>"+
													"<td>"+item.cuenta_banc+"</td>"+		
													"<td>"+item.numero_cuenta_banc+"</td>"+
													"<td>"+item.ingreso_total_cuenta+"</td>"+
													"<td>"+item.egreso_total_cuenta+"</td>"+
													"<td>"+item.balance_cuenta+"</td>"+
													"<td><button type='button' class='btn btn-info btn-detalle-cuenta-bcp'>Detalle</button></td>"+
													"</tr>");
			})
		})
	}
    
    function listarCuentasBbva() {
		$.get("ServletCuentaBanco?accion=LISTAR-CUENTAS-BBVA",function(e){
			$.each(e,function(i,item){
				$("#table-cuentas-bbva").append("<tr>"+
													"<td>"+item.codigo_cuenta_banc+"</td>"+
													"<td>"+item.cuenta_banc+"</td>"+		
													"<td>"+item.numero_cuenta_banc+"</td>"+
													"<td>"+item.ingreso_total_cuenta+"</td>"+
													"<td>"+item.egreso_total_cuenta+"</td>"+
													"<td>"+item.balance_cuenta+"</td>"+
													"<td><button type='button' class='btn btn-info btn-detalle-cuenta-bbva'>Detalle</button></td>"+
													"</tr>");
			})
		})
	}
    
    function listarCuentasInterbank() {
		$.get("ServletCuentaBanco?accion=LISTAR-CUENTAS-INTBNK",function(e){
			$.each(e,function(i,item){
				$("#table-cuentas-interbank").append("<tr>"+
														"<td>"+item.codigo_cuenta_banc+"</td>"+
														"<td>"+item.cuenta_banc+"</td>"+		
														"<td>"+item.numero_cuenta_banc+"</td>"+
														"<td>"+item.ingreso_total_cuenta+"</td>"+
														"<td>"+item.egreso_total_cuenta+"</td>"+
														"<td>"+item.balance_cuenta+"</td>"+
														"<td><button type='button' class='btn btn-info btn-detalle-cuenta-intbnk'>Detalle</button></td>"+
														"</tr>");
			})
		})
	}
    
    function listarDetCaja() {
		$.get("ServletCaja?accion=LISTAR-DETALLES",function(e){
			$.each(e,function(i,item){
				$("#table-detalle-caja").append("<tr>"+
														"<td>"+item.det_nombre_caja+"</td>"+
														"<td>"+item.ingreso_caja+"</td>"+		
														"<td>"+item.egreso_caja+"</td>"+
														"<td>"+item.fecha_reg_form+"</td>"+
														"</tr>");
			})
		})
	}
    
	function cargarTipoEgreso(){
      $.get("ServletTipoEgreso?accion=LISTAR",function(response){
	    $.each(response,function(index,item){
		  $("#id-tipo-egreso").append("<option value='"+item.codigo_tipo_egr+"'>"+item.tipo_egr+"</option>");
	    })
      })
	}
	
	function cargarMetodosPago(){
      $.get("ServletMetodoPago?accion=LISTAR",function(response){
	    $.each(response,function(index,item){
		  $("#id-metodo-pago-ing").append("<option value='"+item.codigo_met_pago+"'>"+item.nombre_met_pago+"</option>");
		  $("#id-metodo-pago-egr").append("<option value='"+item.codigo_met_pago+"'>"+item.nombre_met_pago+"</option>");
	    })
      })
	}
	function cargarPos(){
	      $.get("ServletPos?accion=LISTAR",function(response){
		    $.each(response,function(index,item){
			  $("#id-codigo-pos").append("<option value='"+item.codigo_pos+"'>"+item.pos+"("+item.numero_pos+")"+"</option>");
		    })
	      })
		}
    
    function cargarNumeroControlIngresoGenerado(){
		$.get("ServletControIngreso?accion=NUMERO-CONTROL",function(response){
			$("#id-numero-control-ing").val(response);		
		})	
	}   
    
    function cargarCodigoControlIngresoGenerado(){
		$.get("ServletControIngreso?accion=CODIGO-CONTROL",function(response){
			$("#id-codigo-control-ing").val(response);		
		})	
	}   
    
    function cargarNumeroControlEgresoGenerado(){
		$.get("ServletControlEgreso?accion=NUMERO-CONTROL",function(response){
			$("#id-numero-control-egr").val(response);		
		})	
	}   
    
    function cargarCodigoControlEgresoGenerado(){
		$.get("ServletControlEgreso?accion=CODIGO-CONTROL",function(response){
			$("#id-codigo-control-egr").val(response);		
		})	
	} 
    
    function cargarNumeroControlPagoTarjGenerado(){
		$.get("ServletPagoTarjeta?accion=NUMERO-CONTROL",function(response){
			$("#id-numero-control-pago-tarj").val(response);		
		})	
	}   
    
    function cargarCodigoControlPagoTarjGenerado(){
		$.get("ServletPagoTarjeta?accion=CODIGO-CONTROL",function(response){
			$("#id-codigo-control-pago-tarj").val(response);		
		})	
	}   

  </script>
</body>
</html>