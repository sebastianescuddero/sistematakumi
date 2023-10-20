<jsp:include page="pagina_principal.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Document</title>
    
   	<style>
   		.section_text {
		    padding: 10px;
		}
		
		section {
		    padding: 40px;
		    margin-bottom: 10px; 
		    display: inline-flex; 
		    text-align: center;
		}
   	</style>
</head>
<body style="background:#f3f3f3; font-family: 'Courier New', Courier, monospace;">
    <div class="container" style="width: fit-content;">
        <div class="header-top">
            <div class="titulo" style="display: inline-flex; align-items: baseline; padding: 20px;">
              <h2><strong>Reporte de Frutas</strong></h2>
            </div>
            <div class="botones" style="display:inline-flex; padding: 10px; text-align: center; float: right;">
                <div style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px; margin-right: 5px;">
                  <a type="button" data-bs-toggle="modal" data-bs-target="#" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-file-export" style="display: block;
                      inline-size: -webkit-fill-available;"></i>Generar Reporte</a>
                </div>
                <div style="background-color: slategrey; width: 200px; border-radius: 10px; padding: 10px 0px; margin-left: 5px;">
                  <a type="button" data-bs-toggle="modal" data-bs-target="#reporte-fruta" style="text-decoration: none; color: whitesmoke;"><i class="fas fa-file-alt" style="display: block;
                      inline-size: -webkit-fill-available;"></i>Visualizar Reporte</a>
                </div>
            </div>
        </div>
        
        <div class="modal fade" id="reporte-fruta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
              <div class="modal-content">
                <div class="modal-header" style="background-color: slategrey;">
                  <h5 class="modal-title" id="exampleModalLabel" style="color:white;"><strong>Reporte de la Semana</strong></h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
        </div>
        
        <div class="section_frutas" style="width: 100%; background-color: white; padding: 10px; border-top: 5px solid gainsboro; margin-top: 25px; text-align:center;">
            <h4 style="text-align:left; padding:inherit;">Bolsas Disponibles</h4>
            <div style="padding: inherit; margin-bottom: 10px; display: inline-flex; text-align: center;">
              <div class="section_text">
                <h5>Papaya</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              <div class="section_text">
                <h5>Papaya con piña</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              <div class="section_text"> 
                <h5>Papaya con mango</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
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
            <div style="padding: inherit; margin-bottom: 10px; display: inline-flex; text-align: center;">
              <div class="section_text">
                <h5>Fresa</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              <div class="section_text">
                <h5>Piña</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>        
              </div>
              <div class="section_text">
                <h5>Mango</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
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
            <div style="padding: inherit; margin-bottom: 10px; display: inline-flex; text-align: center;">
              <div class="section_text">
                <h5>Lucuma</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              <div class="section_text">
                <h5>Surtido</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              <div class="section_text">
                <h5>Especial</h5>
                <div class="col">
                  <div class="card">
                    <div class="card-body">
                      <table class="table" class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">FRUTA USADA</th>
                              <th scope="col">CANTIDAD BOLSAS</th>
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
    </div>

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"></script>
    
</body>
</html>