

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            background-color:#FAEBD7;
            text-align: center;
            font-family: Arial;}

    </style>
    <body>
        
        <h1>BIENVENIDO AL MENU PRINCIPAL</h1>
        <h3>Seleccione una Opcion</h3>
        <div class="main-container">

            <img src="imagenes/Aviso.png" alt="Avisos" width="200" height="200">
                <a href="AvisoController" class="btn2 btn-green">  Lista de Aviso</a>
            
            <img src="imagenes/usuario.png" alt="Avisos" width="200" height="200"> 
                <a href="UsuarioController" class="btn2 btn-red">Lista Usuarios</a>
            
        </div>
    </body>
</html>
