<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/index.css">
	<title>Examen LM</title>
</head>
<body>

    <div id="bag">
        <div class="bag-section">
            <div class="bag-slot">
                <img src="img/classes/dps.png">
            </div>
            <div class="bag-slot selected">
                <img src="img/classes/mage.png">
            </div>
            <div class="bag-slot">
                <img src="img/classes/tank.png">
            </div>
            <div class="bag-slot">
                <img src="img/classes/priest.png">
            </div>
            <div class="bag-slot">
                <img src="img/classes/pets.png">
            </div>
        </div>

        <#assign cantidadItems = items?size>

        <#-- SE PODRIA MODIFICAR SI SE HACE EL INVENTARIOCONTROLLER -->

        <#list items as item>
            <#assign selected = "">
            <#if selectedItem??>
                <#if item.id == selectedItem.id>
                    <#assign selected = "selected">
                </#if>
            </#if>
            <div class="bag-container">
                <div class="bag-slot">
                <img src="${item.imagen}">
                <span class="level">${item.cantidad}</span>
            </div>
        <7#list>

        <#if cantidadItems lt 18>
            <#list cantidadItems .. 17 as x>
                <div class="bag-container">
                
                </div>
            </#list>
        </#if>
    </div>

    <#-- HAY QUE HACER ESTO DINAMICO 
        el panel se debe mostrar solo cuando un item este seleccionado
        tambien faltan 2 botones para crear y editar/borrar items

        El boton crear debe aparecer siempre y el boton de editar/borrar cuando hay un item seleccionado
    -->
    
    <div id="detail-panel">
        <div>
            <div class="bag-slot selected">
                <img src="img/abilities/frost-ball.png">
            </div>
            <div>
                <span>Bola de Hielo (nivel 2)</span>
            </div>
        </div>
        <div class="hability-info">
            <div>
                25 Maná
            </div>
            <div>
                Hab. Mágica
            </div>
        </div>
        <div>
            <span>Inflinge 40 de daño hielo y tiene una probabilidad del 20% de congelar al enemigo durante 1 turno.</span>
        </div>
    </div>
</body>
</html>