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
    <div style="positiom: relative;">
        <#list items as item>
            ${item.id}
            
            <div>
                <img class="imt-item" src="..\..\public\imgs\images.jpg">
            </div>
            <div>
                <span class="name-item">${item.nombre}</span>
                <span class="name-item">${item.cantidad}</span>
            </div>
        </#list>
    </div>
    <#-- modo antiguo>
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
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.cantidad}</td>
                    <td><a href="/edita-item/${item.id}">Editar</a></td>
                    <td><a href="/elimina-item/${item.id}">Borrar</a></td>
                </tr>
            </#list>
        </tbody>
    </table>  -->
</div>
</body>
</html>