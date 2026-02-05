package edu.masanz.da.crudj.dao;



import edu.masanz.da.crudj.dto.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventarioDAO {

    private static HashMap<String, Item> inventario;

    public static void agregarItem(Item addItem) {
        // TODO: Agregar al hashmap el item facilitado (check)
        Item itemInventario = inventario.get(addItem.getNombre());
        if (itemInventario == null){
            inventario.put(addItem.getNombre(), addItem);
        } else {
            itemInventario.setCantidad(itemInventario.getCantidad() + addItem.getCantidad());
        }
    }

    public static void perderItems(Item deleteItem) {
        // TODO: Eliminar del hashmap del item facilitado
        Item itemInventario = inventario.get(deleteItem.getNombre());
        if (itemInventario != null){
            int nuevaCantidad = itemInventario.getCantidad() - deleteItem.getCantidad();
            if (nuevaCantidad <= 0){
                itemInventario.setCantidad(nuevaCantidad);
            }
        }
    }

    public static void inicializarInventario() {
        // TODO: Crear el hashMap del inventario (check)
        inventario = new HashMap<>();
    }


    public static List<Item> obtenerItems() {
        // TODO Devolver todos los items del hashMap del inventario
        List<Item> items = new ArrayList<>(inventario.values());
        return items;
    }
}
