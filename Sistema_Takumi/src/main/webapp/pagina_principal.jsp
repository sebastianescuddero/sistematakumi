<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" rel="stylesheet"/>
    
	<link rel="stylesheet" href="css/pagina_principal.css">
	
    <title>Principal</title>
  </head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Sistema Takumi</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="pagina_principal.jsp" title="pagina_principal">Inicio</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="control_inventario.jsp" title="control_inventario">Control Inventario</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="gestion_ventas.jsp" title="gestion_ventas">Gestión Ventas</a>
					</li>
				</ul>
				<ul class="navbar-nav" style="margin-inline-start: auto;">
					<li class="nav-item">
					  <a class="nav-link" href="#">Perfil</a>
					</li>
					<li class="nav-item">
					  <a class="nav-link" href="#">Cerrar Sesión</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
</body>
</html>