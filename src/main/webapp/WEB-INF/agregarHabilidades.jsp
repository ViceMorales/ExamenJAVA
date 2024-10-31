<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="/css/inicio2.css" rel="stylesheet"/>
<title>Agregar habilidades</title>
</head>
<body>
	<div class="container m3">
        <div class="row">
        	<div class="col-6">
			    <h1> Habilidades </h1>
			    <h2> Agregar habilidad</h2>
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
		    </div>
		<div>
			<div class="container mt-3 ">
			<div class="row">
			<form:form class= "contenedorAgrega col-6 p-8 border rounded" action="/procesar/habilidades/agregar" method="POST" modelAttribute="habilidades">
				<div>
					<form:label class="form-label" path="nombreHabilidad" for="nombreHabilidad">Nombre</form:label>
					<form:input class="form-control" path="nombreHabilidad" type="text" id="nombreHabilidad" name="nombreHabilidad" />
					<form:errors class="alert alert-danger d-block" path="nombreHabilidad" />
				</div>
				<div>
					<form:label class="form-label" path="descripcion" for="descripcion">Descripcion</form:label>
					<form:input class="desc form-control" path="descripcion" type="descripcion" id="descripcion" name="descripcion" />
					<form:errors class="alert alert-danger d-block" path="descripcion" />
				</div>
				<div>
					<form:label class="form-label" path="categoria" for="categoria">Categoria</form:label>
					<form:input class="form-control" path="categoria" type="categoria" id="categoria" name="categoria" />
					<form:errors class="alert alert-danger d-block" path="categoria" />
				</div>
				<div>
					<form:label class="form-label" path="imagenPortada" for="imagenPortada">URL a imagen</form:label>
					<form:input class="form-control" path="imagenPortada" type="text" id="imagenPortada" name="imagenPortada" />
				
					<form:errors class="alert alert-danger d-block" path="imagenPortada" />
				<div>
				</div>
				<button Class="agrega btn btn-primary btn-lg">Agregar</button>
				</div>
		</form:form>
		
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>