package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dao.InventarioDao;
import edu.masanz.da.crudj.dto.Item;
import edu.masanz.da.crudj.util.ImageConvertor;
import io.javalin.http.Context;
import io.javalin.http.UploadedFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Base64;
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

        UploadedFile imagen = context.uploadedFile("imagen");
        System.out.println(imagen.toString());

        InventarioDao.actualizarItem(new Item(id, nombre, cantidad));

        context.redirect("/lista-items");
    }

    public static void crearItem(Context context) {
        String nombreItem = context.formParam("nombre");
        int cantidad = Integer.parseInt(context.formParam("cantidad"));
        String textoImagen = "";

        UploadedFile archivo = context.uploadedFile("imagen");
        if (archivo != null) {
            try {
                byte[] contenido = archivo.content().readAllBytes();
                String encodedString = Base64.getEncoder().encodeToString(contenido);
                textoImagen = "data:image/png;base64,"+encodedString;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        InventarioDao.crearItem(nombreItem, cantidad, textoImagen);

        context.redirect("/lista-items");
    }

    public static void eliminarItem(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        InventarioDao.eliminarItem(id);
        context.redirect("/lista-items");
    }
}