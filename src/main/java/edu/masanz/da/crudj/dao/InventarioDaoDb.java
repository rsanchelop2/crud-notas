package edu.masanz.da.crudj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.masanz.da.crudj.database.ConnectionManager;
import edu.masanz.da.crudj.dto.Item;
import edu.masanz.da.crudj.dto.Nota;

public class InventarioDaoDb{

    public InventarioDaoDb() {
        ConnectionManager.conectar("crud_db", "proy", "password");
    }

    public int obtenerNumeroNotas() {
        String sql = "SELECT COUNT(*) FROM notas";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length == 1) {
            int numeroNotas = Integer.parseInt(resultado[0][0].toString());
            return numeroNotas;
        }
        return 0;
    }


    public List<Nota> obtenerNotas(int pagina, int notasPorPagina) {
        String sql = "SELECT id, titulo, contenido, creado, modificado " +
                     "FROM notas ORDER BY id DESC LIMIT ? OFFSET ?";
        Long limite = (long) notasPorPagina;
        Long offset = (long) ((pagina-1)*notasPorPagina);
        Object[] params = {limite, offset};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Nota> notas = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Nota nota = new Nota();

                nota.setId((Long) fila[0]);
                nota.setTitulo((String) fila[1]);
                nota.setContenido((String) fila[2]);
                nota.setCreado((String) fila[3]);
                nota.setModificado((String) fila[4]);

                notas.add(nota);
            }
        }
        return notas;
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
            }
            
            

            return item;
        }
        return null;


    }

    public boolean actualizarItem(Item item) {
        String sql = "UPDATE notas SET nombre = ?, cantidad = ?, imagen = ? WHERE id = ?";
        Object[] params = {item.getNombre(), item.getCantidad(), item.getImagen(), item.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }





    


    public Nota guardarNota(Nota nota) {
        String sql = "INSERT INTO notas (titulo, contenido, creado, modificado) VALUES (?, ?, ?, ?)";
        Object[] params = {nota.getTitulo(), nota.getContenido(), nota.getCreado(), nota.getModificado()};
        long id = ConnectionManager.ejecutarInsertSQL(sql, params);
        if (id > 0){
            nota.setId(id);
        }
        return nota;
    }

    

    public boolean eliminarItem(Item item) {
        String sql = "DELETE FROM notas WHERE id = ?";
        Object[] params = {item.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

}
