<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Listado de notas</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Listado de notas</h1>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <a class="btn" href="/crea-nota">Añadir nota</a>
</div>
<br/><br/>
<div>
    <table id="notas">
        <tbody>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Actualizar</th>
                <th>Eliminar</th>
            </tr>
            <#list items as item>
                <tr>
                    <td>${item.nombre}</td>
                    <td>${item.cantidad}</td>
                    <td><a href="/edita-item/${item.nombre}">Editar</a></td>
                    <td><a href="/elimina-item/${item.nombre}">Borrar</a></td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>
</body>
</html>