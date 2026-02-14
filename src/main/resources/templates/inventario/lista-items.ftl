<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Inventario</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Inventario</h1>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <a class="btn" href="/crea-item">Añadir objeto</a>
</div>
<br/><br/>
<div>
    <!-- MODO MOLON --> 
    <div style="display: flex;justify-content: center;align-items: center;">
        <div class="izquierda"><a><</a> </div>
        <div style="width: 25vw; overflow: hidden;">
            <div style="display: flex;" class="desplazable">
                <#assign visibilidad = "inline">
                <#list items as item>
                    <div style="width: 25vw;">
                        <div style="position: relative;">
                            <img class="img-item" src="${item.imagen}">
                            <span style="position: relative; top: -4px; left: -15px; color: white; font-weight: bold;">${item.cantidad}</span>
                        </div>
                        <div>
                            <span class="name-item">${item.nombre}</span>(<a href="/edita-item/${item.id}">editar</a>)
                        </div>
                    </div>
                    <#assign visibilidad = "none">
                </#list>
            </div>
        </div>
        <div> <a class="derecha">></a> </div>
    </div>
</div>
</body>
</html>