package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dao.InventarioDAO;
import edu.masanz.da.crudj.dto.Item;
import edu.masanz.da.crudj.dto.Nota;
import edu.masanz.da.crudj.service.NotaService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventarioController {

    public static void listarItems(Context context) {
        Map<String, Object> model = new HashMap<>();
        List<Item> items = InventarioDAO.obtenerItems();
        model.put("items", items);

        context.render("templates/inventario/lista-items.ftl");
    }
}