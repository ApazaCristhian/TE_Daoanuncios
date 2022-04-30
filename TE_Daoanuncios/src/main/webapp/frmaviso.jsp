<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
    Aviso aviso = (Aviso) request.getAttribute("aviso");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <title>Formulario de avisos</title>
    </head>
    <body class="borde">
        <div class="form-container"> 
            <div class="login-container">
                <h2>Registro de Avisos</h2>
                <p>Bienvenido no olvide llenar los campos</p>
                <form action="AvisoController" method="post">
                    <input type="hidden" name="id" value="${aviso.id}"/>
                    <p>
                        <label> Titulo </label>
                        <input class="input" type="text" name="titulo" value="${aviso.titulo}" placeholder="Ingrese su nombre"/>
                    </p>
                    <p>
                        <label> Contenido </label>
                        <textarea class="input" name="contenido">${aviso.contenido}</textarea>
                    </p>
                    <p>
                        <input class="btn btn-login" type="submit" value="Registrar" />
                    </p> 
                    
                </form>
                    <a class="btn3 btn-red" href="index.jsp">Volver a Inicio</a>
            </div>      
        </div>
                   
    </body>
</html>
