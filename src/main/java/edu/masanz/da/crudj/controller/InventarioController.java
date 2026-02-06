package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dao.InventarioDao;
import edu.masanz.da.crudj.dto.Item;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventarioController {

    public static void listarItems(Context context) {
        Map<String, Object> model = new HashMap<>();

        List<Item> objetos = InventarioDao.obtenerItems();
        model.put("items", objetos);

        context.render("templates/inventario/lista-items.ftl", model);
    }

    public static void servirItem(Context context) {
        Map<String, Object> model = new HashMap<>();

        Map<String, String> pathParams = context.pathParamMap();
        if(pathParams.containsKey("id")){
            int id = Integer.parseInt(context.pathParam("id"));
            Item item = InventarioDao.obtenerItem(id);
            model.put("item", item);
        }

        context.render("templates/inventario/form-item.ftl", model);
    }

    public static void editarItem(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        String nombre = context.formParam("nombre");
        int cantidad = Integer.parseInt(context.formParam("cantidad"));

        InventarioDao.actualizarItem(new Item(id, nombre, cantidad));

        context.redirect("/lista-items");
    }

    public static void crearItem(Context context) {
        String nombreItem = context.formParam("nombre");
        int cantidad = Integer.parseInt(context.formParam("cantidad"));

        InventarioDao.crearItem(nombreItem, cantidad);

        context.redirect("/lista-items");
    }

    public static void eliminarItem(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        InventarioDao.eliminarItem(id);
        context.redirect("/lista-items");
    }
}