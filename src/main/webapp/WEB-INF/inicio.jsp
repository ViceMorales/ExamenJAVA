<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Aplicación de Habilidades </title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/inicio2.css" rel="stylesheet"/>
	</head>
	<body>
		<div class="container m3">
        <div class="row">
        	<div class="col-6">
			    <h1> Habilidades </h1>
			    <h2> Bienvenid@ de vuelta ${nombre_usuario}</h2>
             </div>
             	<form class="col-2 p-5" action="/inicio" method="GET">
                    <button class="btn ">Habilidades</button>
                </form>
                <form class="col-2 p-5" action="/agrega/habilidades" method="GET">
                    <button class="btn ">Agregar habilidades</button>
                </form>
                <form class="col-2 p-5" action="/elimiar/sesion" method="GET">
                    <button class="btn">Logout</button>
                </form>
		            </div>
		        </div>
		        <div class="container-sm border rounded">
		        <table class="table table-sm ">
				  <thead>
				    <tr>
				      <th class="text-secondary" scope="col">Titulo</th>
				      <th class="text-secondary" scope="col">Detalle</th>
				       <th class="text-secondary" scope="col">Agregar a perfil</th>
				    </tr>
				  </thead>
				  <tbody>
				   <c:forEach items="${habilidades}" var="habilidad">
				    <tr>
				      <td>${habilidad.nombreHabilidad}</td>	
				      <td> 
				      <form action="/detalle/habilidades/${habilidad.id}" method="GET">
                     <button class="btn">Ver</button>
                     </form></td>
				       <td >
				        
                     	<button class="botonAgrega btn" onclick="agrega(this)">Agregar</button>
                     	</td>
				    </tr>
				     </c:forEach>
				  </tbody>
				</table>
				</div>
				<a href="/usuario/editar/${id_usuario}">
				<button type="button" class="botonPerfil btn btn-secondary btn-lg">
				Mi perfil</button></a>
		<script src="/js/index.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>