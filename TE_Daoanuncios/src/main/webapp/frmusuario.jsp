<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Usuarios"%>
<%
    Usuarios usuario = (Usuarios) request.getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <title>Formulario de Usuarios</title>
    </head>
    <body class="borde">

    <div class="form-container"> 
        <div class="login-container">
            <h2>Registro Usuarios</h2>
            <p>Bienvenido no olvide llenar los campos</p>
            <form action="UsuarioController" method="post">
                <input type="hidden" name="id" value="${usuario.id}"/>
                <p>
                    <label> Nombre </label>
                    <input class="input"  type="text" name="nombre" value="${usuario.nombre}" placeholder="Ingrese su nombre"/>
                </p>
                <p>
                    <label> Correo </label>
                    <input class="input" type="text" name="correo" value="${usuario.correo}" placeholder="Ingrese su correo"/>
                </p>
                <p>
                    <label> Clave </label>
                    <input class="input" type="password" name="clave" value="${usuario.clave}" placeholder="Ingrese su clave"/>
                </p>
                <p>
                    <input class="btn btn-login" type="submit" value="Registrar Usuario" />
                </p>
            </form> 
                <a class="btn3 btn-red" href="index.jsp">Volver a Inicio</a>
        </div>    
    </div> 
        
</body>
</html>
