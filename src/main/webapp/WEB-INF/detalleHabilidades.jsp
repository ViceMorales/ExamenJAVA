<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Aplicación de películas </title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/detalle.css" rel="stylesheet"/>
	</head>
	<body>
		<div class="container m3">
        <div class="row">
        	<div class="col-6">
			    <h1> Habilidades </h1>
			    <h2>${Habilidades.detalleHabilidades.nombreHabilidad}</h2>
             </div>
    
             	<form class="col-2 p-5" action="/inicio" method="GET">
                    <button class="btn ">Habilidades</button>
                </form>
                <form class="col-2 p-5" action="/agrega/habilidades" method="GET">
                    <button class="btn ">Agregar Habilidades</button>
                </form>
                <form class="col-2 p-5" action="/elimiar/sesion" method="GET">
                    <button class="btn ">Logout</button>
                </form>
		            </div>
		        </div>
		       <div class="container m3"> 
		<h3> ${detalleHabilidades.nombreHabilidad} </h3>
			<div class="row">
				<div class="col-7 container-sm border rounded text-rigth">
					<div class="row">
						<div class="col-6">
							<p> Categoria</p>
							<b>${detalleHabilidades.categoria}</b>
							
							<p> Descripcion </p>
							<b>${detalleHabilidades.descripcion} </b>
						</div>
						<div class="col-6">
							<img class="pelicula-imagen" src="${detalleHabilidades.imagenPortada}" alt="Imagen ${detalleHabilidades.nombreHabilidad}"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row mt-2">
				  <form class="col-6" action="/habilidades/eliminar/${detalleHabilidades.id}" method="POST">
			          <input type="hidden" name="_method" value="DELETE"/>
			          <button class="botonEliminar btn btn-danger btn-lg">
						Eliminar</button>
		         </form>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>