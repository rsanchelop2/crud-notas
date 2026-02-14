package edu.masanz.da.crudj.dao;


import edu.masanz.da.crudj.dto.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventarioDao {

    public static final String[] NOMBRE_ITEMS = {"Pocion", "Flecha", "Pan", "Bomba", "Cuchillo"};

    public static Map<Integer, Item> inventario;
    public static int contador;

    public static Item obtenerItem(int id) {
        return inventario.get(id);
    }

    public static void actualizarItem(Item item) {
        if(inventario.containsKey(item.getId())){
            inventario.put(item.getId(), item);
        }
    }

    public static void eliminarItem(Item deleteItem) {
        // TODO: Eliminar del hashmap del inventario la cantidad del item facilitado - DONE
        Item itemInventario = inventario.get(deleteItem.getId());
        if(itemInventario != null){
            int nuevaCantidad = itemInventario.getCantidad() - deleteItem.getCantidad();
            itemInventario.setCantidad(nuevaCantidad);
            if(nuevaCantidad <= 0){
                inventario.remove(deleteItem.getId());
            }
        }
    }

    public static void eliminarItem(int id) {
        inventario.remove(id);
    }

    public static void inicializarInventario() {
        // TODO: Debera crear el hashmap del inventario
        inventario = new HashMap<>();
        contador = 1;

        for (int i = 1; i < 4; i++) {
            String nombre = NOMBRE_ITEMS[(int)(Math.random()* NOMBRE_ITEMS.length)];
            int cantidad = (int)(Math.random() * 5) + 1;
            inventario.put(contador, new Item(contador, nombre, cantidad));
            contador++;
        }
    }

    public static List<Item> obtenerItems() {
        // TODO: Devolver todos los items del hashmap del inventario
        // OPCION A
        List<Item> items = new ArrayList<>(inventario.values());
        // OPCION B
        /*
        List<Item> items = new ArrayList<>();
        Iterator<Item> iterador = inventario.values().iterator();
        while(iterador.hasNext()){
            items.add(iterador.next());
        }
        */
        return items;
    }

    public static void crearItem(String nombreItem, int cantidad, String textoImagen) {
        Item item = new Item(contador, nombreItem, cantidad);
        item.setImagen(textoImagen);
        inventario.put(contador, item);
        contador++;
    }
}