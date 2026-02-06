<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if item??>Editar ITEM<#else>Crear ITEM</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#if item??>
        <h1>EDITAR ITEM</h1>
    <#else>
        <h1>CREAR ITEM</h1>
    </#if>
    
    <a href="/lista-items">Regresar al inventario</a>

    <br/><br/>

    <#if mensajeError??>
        <div class="error">${mensajeError}</div>
    </#if>

    <#assign destino = "/crea-item">
    <#assign nombre = "">
    <#assign id = 0>
    <#assign cantidad = 0>
    <#assign imagen = "">
    <#if item??>
        <#assign destino = "/edita-item/"+item.id>
        <#assign nombre = item.nombre>
        <#assign id = item.id>
        <#assign cantidad = item.cantidad>
        <#assign imagen = item.imagen>
    </#if>
    
    <form action="${destino}" method="POST" enctype="multipart/form-data">
        <div class="container">
            <div class="w75">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" value="${nombre}">
            </div>
            <div class="w25 center">
                <label for="id">ID</label>
                <input type="text" name="id" id="id" value="${id}" disabled="disabled">
            </div>
        </div>

        <label for="cantidad">Cantidad</label>
        <textarea name="cantidad" id="cantidad">${cantidad}</textarea>

        <img src="${imagen}">
        <label for="imagen">Imagen</label>
        <input type="file" id="imagen" name="imagen">

        <input type="submit" value="Guardar">
    </form>

</body>
</html>