<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Aplicación de habilidades </title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link href="/css/inicio2.css" rel="stylesheet"/>
	</head>
	<body>
	<div class="container m3">
        <div class="row">
        	<div class="col-8">
			    <h1> Habilidades </h1>
			    <h2> Registro</h2>
             </div>
    
             	<form class="col-2 p-5" action="/login" method="GET">
                    <button class="btn btn-secondary">Login</button>
                </form>
                <form class="col-2 p-5" action="/registro" method="GET">
                    <button class="btn btn-secondary">Registro</button>
                </form>
		            </div>
		        </div>
		<div class="container mt-3">
			<div class="row">
				<form:form class="col-6 p-8" action="/procesa/registro" method="POST" modelAttribute="usuario">
					<div>
						<form:label class="form-label" path="nombre" for="nombre">Nombre</form:label>
						<form:input class="form-control" path="nombre" type="text" id="nombre" name="nombre" />
						<form:errors class="alet alert-danger d-block" path="nombre" />
					</div>
					<div>
						<form:label class="form-label" path="apellido" for="apellido">Apellido</form:label>
						<form:input class="form-control" path="apellido" type="text" id="apellido" name="apellido" />
						<form:errors class="alet alert-danger d-block" path="apellido" />
					</div>
					<div>
						<form:label class="form-label" path="correo"> Correo: </form:label>
						<form:input class="form-control" path="correo" />
						<form:errors class="alert alert-danger d-block" path="correo" /> 
					</div>
					<div>
						<form:label class="form-label" path="contrasena"> Constraseña: </form:label>
						<form:input class="form-control" path="contrasena" type="password"/>
						<form:errors class="alert alert-danger d-block" path="contrasena" /> 
					</div>
					<div>
						<form:label class="form-label" path="confirmacionContrasena" for="confirmacionContrasena">Confirma Contraseña</form:label>
						<form:input class="form-control" path="confirmacionContrasena" type="password" id="confirmacionContrasena" name="confirmacionContrasena" />
						<form:errors class="alet alert-danger d-block" path="confirmacionContrasena" />
					</div>
					<button class="btn btn-primary">
						Registrarse
					</button>
				</form:form>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>