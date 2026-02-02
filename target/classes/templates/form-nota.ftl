<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Nota<#else>Editar Nota</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#assign destino = "/edita-nota/"+nota.id> 
    <#if (agregar)>
        <h1>CREAR NOTA</h1>
        <#assign destino = "/crea-nota"> 
    <#else>    
        <h1>EDITAR NOTA</h1>
    </#if>
    
    
    <a href="/lista-notas">Regresar al listado</a>
    <br/><br/>

    <#if (mensajeError??)>
        <div class="error">MENSAJE DE ERROR CUANDO LO HAYA</div>    
    </#if>
    

    <!-- TIENE QUE SER POST -->
    <form action="${destino}" method="POST">
        <#if (agregar)>
            <#assign titulo = ""> 
            <#assign id = " "> 
            <#assign contenido = ""> 
        <#else>
            <#assign titulo = nota.titulo> 
            <#assign id = nota.id> 
            <#assign contenido = nota.contenido> 
        </#if>
    
        <div class="container">
            <div class="w75">
                <label for="titulo">Titulo</label>
                <input type="text" name="titulo" value=${titulo}>
            </div>
            <#if (!agregar)>
                <div class="w25 center">
                    <label for="id">Id</label>
                    <input type="text" name="id" value=${id} disabled="disabled">
                </div>    
            </#if>
            
        </div>

        <label for="contenido">Contenido</label>
        <textarea name="contenido">${contenido}</textarea>

        <div class="container">
            <div class="w50 center">
                <label for="creado">Creado</label>
                <input type="text" name="creado" value="${nota.modificado}" disabled="disabled">
            </div>
            <div class="w50 center">
                <label for="creado">Actualizado</label>
                <input type="text" name="creado" value="${nota.creado}" disabled="disabled">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>