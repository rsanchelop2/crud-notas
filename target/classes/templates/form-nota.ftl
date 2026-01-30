<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Nota<#else>Editar Nota</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <h1>CREAR O EDITAR NOTA</h1>
    <a href="/lista-notas">Regresar al listado</a>
    <br/><br/>

    <div class="error">MENSAJE DE ERROR CUANDO LO HAYA</div>

    <!-- TIENE QUE SER POST -->
    <form action="/crea-nota" method="GET">
        <#assign tituloNota = " ">
        <#assign contenidoNota = " ">
        <#assign idNota = 0>

        <#if (nota.id != null)>
            <#assign tituloNota = nota.titulo>
            <#assign contenidoNota = nota.contenido>
            <#assign idNota = nota.id>
        </#if>
    
        <div class="container">
            <div class="w75">
                <label for="titulo">Titulo</label>
                <input type="text" name="titulo" value="${tituloNota}">
            </div>
            <div class="w25 center">
                <label for="id">Id</label>
                <input type="text" name="id" value="${idNota}" disabled="disabled">
            </div>
        </div>

        <label for="contenido">Contenido</label>
        <textarea name="contenido">${contenidoNota}</textarea>

        <div class="container">
            <div class="w50 center">
                <label for="creado">Creado</label>
                <input type="text" name="creado" value="2026-01-29 13:17:15" disabled="disabled">
            </div>
            <div class="w50 center">
                <label for="creado">Actualizado</label>
                <input type="text" name="creado" value="2026-01-29 13:17:15" disabled="disabled">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>