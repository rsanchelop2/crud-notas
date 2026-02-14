package edu.masanz.da.crudj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.masanz.da.crudj.database.ConnectionManager;
import edu.masanz.da.crudj.dto.Item;

public class InventarioDaoDb {

    public static Item obtenerItem(int idItem) {
        String sql = "SELECT id, nombre, cantidad, imagen " +
                "FROM inventario WHERE id = ? ORDER BY id DESC LIMIT 1";
        Object[] params = {idItem};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length == 1) {
            Item item = new Item();

            item.setId((Integer) resultado[0][0]);
            item.setNombre((String) resultado[0][1]);
            item.setCantidad((Integer) resultado[0][2]);
            item.setImagen((String) resultado[0][3]);

            return item;
        }
        return null;
    }

    public static void actualizarItem(Item item) {
        String sql = "UPDATE inventario SET nombre = ?, cantidad = ?, imagen = ? WHERE id = ?";
        Object[] params = {item.getNombre(), item.getCantidad(), item.getImagen(), item.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
    }

    public static void eliminarItem(Item deleteItem) {
        String sql = "DELETE FROM inventario WHERE id = ?";
        Object[] params = {deleteItem.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
    }

    public static void eliminarItem(int id) {
        String sql = "DELETE FROM inventario WHERE id = ?";
        Object[] params = {id};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
    }

    public static void inicializarInventario() {
        ConnectionManager.conectar("crud_db", "proy", "password");
    }

    public static List<Item> obtenerItems() {
        List<Item> items = new ArrayList<>();

        String sql = "SELECT id, nombre, cantidad, imagen " +
                "FROM inventario ORDER BY id DESC";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length>0) {
            for(int i = 0; i < resultado.length; i++) {
                Item item = new Item();
                item.setId((Integer) resultado[i][0]);
                item.setNombre((String) resultado[i][1]);
                item.setCantidad((Integer) resultado[i][2]);
                item.setImagen((String) resultado[i][3]);
                items.add(item);
            }
        }
        return items;
    }

    public static void crearItem(String nombreItem, int cantidad, String textoImagen) {
        String sql = "INSERT INTO inventario (nombre, cantidad, imagen) VALUES (?, ?, ?)";
        Object[] params = {nombreItem, cantidad, textoImagen};
        long id = ConnectionManager.ejecutarInsertSQL(sql, params);
        if (id > 0){
            System.out.println("item insertado correctamente");
        } else {
            System.out.println("algo ha ido mal en el insert: ["+sql+"] con estos paramentros: ["+params[0]+", "+params[1]+", "+params[2]+"]");
        }
    }

}