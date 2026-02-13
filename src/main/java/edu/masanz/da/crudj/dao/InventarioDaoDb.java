package edu.masanz.da.crudj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.masanz.da.crudj.database.ConnectionManager;
import edu.masanz.da.crudj.dto.Item;

public class InventarioDaoDb{

    public InventarioDaoDb() {
        ConnectionManager.conectar("crud_db", "proy", "password");
    }

    public int obtenerNumeroItems() {
        String sql = "SELECT COUNT(*) FROM notas";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length == 1) {
            int numeroItems = Integer.parseInt(resultado[0][0].toString());
            return numeroItems;
        }
        return 0;
    }


    public static List<Item> obtenerItems(int pagina, int ItemsPorPagina) {
        String sql = "SELECT id, nombre, cantidad, imagen" +
                     "FROM items ORDER BY id DESC LIMIT ? OFFSET ?";
        Long limite = (long) ItemsPorPagina;
        Long offset = (long) ((pagina-1)*ItemsPorPagina);
        Object[] params = {limite, offset};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Item> items = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Item item = new Item();

                item.setId((Long) fila[0]);
                item.setNombre((String) fila[1]);
                item.setCantidad((int) fila[2]);
                item.setCantidad((int) fila[3]);

                items.add(item);
            }
        }
        return items;
    }


    public Item obtenerItem(int idItem){
        String sql = "SELECT id, nombre, cantidad, imagen" +
                "FROM items WHERE id = ? ORDER BY id DESC LIMIT 1";
        Object[] params = {idItem};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length > 0) {
            for (int i = 0; i < resultado.length; i++) {
                Item item = new Item();

                item.setId((Integer) resultado[0][0]);
                item.setNombre((String) resultado[0][1]);
                item.setCantidad((Integer) resultado[0][2]);
                item.setImagen((String) resultado[0][3]);
                // aqui falta codigo
                return item;
            }
        
            
        }
        return null;


    }

    public boolean actualizarItem(Item item) {
        String sql = "UPDATE notas SET nombre = ?, cantidad = ?, imagen = ? WHERE id = ?";
        Object[] params = {item.getNombre(), item.getCantidad(), item.getImagen(), item.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }


    public Item guardarItem(Item item) {
        String sql = "INSERT INTO notas (titulo, cantidad, imagen) VALUES (?, ?, ?)";
        Object[] params = {item.getNombre(), item.getCantidad(), item.getImagen()};
        int id = (int) ConnectionManager.ejecutarInsertSQL(sql, params);
        if (id > 0){
            item.setId(id);
        }
        return item;
    }

    

    public boolean eliminarItem(Item item) {
        String sql = "DELETE FROM notas WHERE id = ?";
        Object[] params = {item.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

}
