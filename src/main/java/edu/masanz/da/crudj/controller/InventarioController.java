package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dao.InventarioDaoDb;
import edu.masanz.da.crudj.dto.Item;
import io.javalin.http.Context;
import io.javalin.http.UploadedFile;

import java.io.IOException;
import java.util.*;

public class InventarioController {

    public static void listarItems(Context context) {
        Map<String, Object> model = new HashMap<>();

        List<Item> objetos = InventarioDaoDb.obtenerItems();

        if(objetos.size()>18){
            objetos = objetos.subList(0, 18);
        }

        model.put("itemsInventario", objetos);

        List<String> slotsVacios = new ArrayList<>();
        for (int i = 0; i < 18 - objetos.size(); i++) {
            slotsVacios.add("");
        }
        model.put("slotsVacios", slotsVacios);

        Map<String, String> pathParams = context.pathParamMap();
        if(pathParams.containsKey("id")){
            int id = Integer.parseInt(context.pathParam("id"));
            Item item = InventarioDaoDb.obtenerItem(id);
            model.put("selectedItem", item);
        }

        context.render("templates/inventario/inventario.ftl", model);
    }

    public static void servirItem(Context context) {
        Map<String, Object> model = new HashMap<>();

        Map<String, String> pathParams = context.pathParamMap();
        if(pathParams.containsKey("id")){
            int id = Integer.parseInt(context.pathParam("id"));
            Item item = InventarioDaoDb.obtenerItem(id);
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

        InventarioDaoDb.actualizarItem(new Item(id, nombre, cantidad));

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

        InventarioDaoDb.crearItem(nombreItem, cantidad, textoImagen);

        context.redirect("/lista-items");
    }

    public static void eliminarItem(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        InventarioDaoDb.eliminarItem(id);
        context.redirect("/lista-items");
    }
}