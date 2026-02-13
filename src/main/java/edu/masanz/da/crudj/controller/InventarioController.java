package edu.masanz.da.crudj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.masanz.da.crudj.dao.InventarioDAO;
import edu.masanz.da.crudj.dto.Item;
import io.javalin.http.Context;
import io.javalin.http.UploadedFile;

public class InventarioController {

    public static void listarItems(Context context) {
        Map<String, Object> model = new HashMap<>();

        List<Item> objetos = InventarioDAO.obtenerItems();
        model.put("items", objetos);

        // AQUI FALTA CODIGO PARA DEVOLVER ITEMS VACIONS PARA PINTAR EL INVENTARIO
        List<String> slotsVacios = new ArrayList<>();

        if(objetos.size() > 18){
            slotsVacios.add("");
        }

        model.put("itemsInventario", objetos);
    }

    public static void servirItem(Context context) {
        Map<String, Object> model = new HashMap<>();

        Map<String, String> pathParams = context.pathParamMap();
        if(pathParams.containsKey("id")){
            int id = Integer.parseInt(context.pathParam("id"));
            Item item = InventarioDAO.obtenerItem(id);
            model.put("item", item);
        }

        context.render("templates/new-index.ftl", model);
    }

    public static void editarItem(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        String nombre = context.formParam("nombre");
        int cantidad = Integer.parseInt(context.formParam("cantidad"));

        UploadedFile imagen = context.uploadedFile("imagen");
        System.out.println(imagen.toString());

        InventarioDAO.actualizarItem(new Item(id, nombre, cantidad));

        context.redirect("/inventario");
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

        InventarioDAO.crearItem(nombreItem, cantidad, textoImagen);

        context.redirect("/lista-items");
    }

    public static void eliminarItem(Context context) {
        int id = Integer.parseInt(context.pathParam("id"));
        InventarioDAO.eliminarItem(id);
        context.redirect("/lista-items");
    }
}