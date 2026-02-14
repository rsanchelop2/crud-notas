<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/inventario.css">
	<title>Examen LM</title>
</head>
<body>

    <div id="bag">
        <div class="bag-section">
            <div class="bag-slot">
                <img src="/imgs/swap-bag.png">
            </div>
            <div class="bag-slot selected">
                <img src="/imgs/swap-bag.png">
            </div>
            <div class="bag-slot">
                <img src="/imgs/swap-bag.png">
            </div>
            <div class="bag-slot">
                <img src="/imgs/swap-bag.png">
            </div>
            <div class="bag-slot">
                <img src="/imgs/swap-bag.png">
            </div>
        </div>
        <div class="bag-container">

            <#list itemsInventario as item>
                <#assign selected = "">
                <#if selectedItem??>
                    <#if item.id == selectedItem.id>
                        <#assign selected="selected">
                    </#if>
                </#if>
                <div class="bag-slot ${selected}">
                    <a href="/inventario/${item.id}">
                        <img src="${item.imagen}">
                        <span class="level">${item.cantidad}</span>
                    </a>
                </div>
            </#list>
            <#list slotsVacios as item>
                <div class="bag-slot">
                
                </div>
            </#list>
            
        </div>
    </div>
    <div class="acciones-item">
        <a href="/crea-item" class="boton">Crear Item</a>
    </div>
    <#if selectedItem??>
        <div id="detail-panel">
            <div>
                <div class="bag-slot selected">
                    <img src="${selectedItem.imagen}">
                </div>
                <div>
                    <span>${selectedItem.nombre}</span>
                </div>
            </div>
            <div class="hability-info">
                <div>
                    Cantidad: ${selectedItem.cantidad}
                </div>
                <div>
                    ID: ${selectedItem.id}
                </div>
            </div>
            <div>
                <span>LOREM IPSUM</span>
            </div>
        </div>
        <div class="acciones-item">
            <a href="/edita-item/${selectedItem.id}" class="boton">Editar</a>
            <a href="/elimina-item/${selectedItem.id}" class="boton">Eliminar</a>
        </div>
    </#if>
    
</body>
</html>