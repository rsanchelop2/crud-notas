package edu.masanz.da.crudj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.masanz.da.crudj.controller.InventarioController;
import edu.masanz.da.crudj.controller.ItemsController;
import edu.masanz.da.crudj.controller.NotaController;
import edu.masanz.da.crudj.dao.InventarioDaoDb;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(8080);

        InventarioDaoDb.inicializarInventario();

        // PRINCIPAL
        app.get("/", NotaController::servirIndice);
        // NOTAS
        app.get("/lista-notas", NotaController::servirLista);
        app.get("/nota/{id}", NotaController::servirNota);
        app.get("/crea-nota", NotaController::servirCrearNota);
        app.post("/crea-nota", NotaController::crearNota);
        app.get("/edita-nota/{id}", NotaController::servirEditarNota);
        app.post("/edita-nota/{id}", NotaController::editarNota);
        app.get("/elimina-nota/{id}", NotaController::servirEliminarNota);
        app.post("/elimina-nota/{id}", NotaController::eliminarNota);
        app.get("/error", NotaController::servirError);
        // ITEMS
        app.get("/lista-items", ItemsController::listarItems);
        app.get("/edita-item/{id}", ItemsController::servirItem);
        app.post("/edita-item/{id}", ItemsController::editarItem);
        app.get("/crea-item", ItemsController::servirItem);
        app.post("/crea-item", ItemsController::crearItem);
        app.get("/elimina-item/{id}", ItemsController::eliminarItem);
        // INVENTARIO NUEVO
        app.get("/inventario", InventarioController::listarItems);
        app.get("/inventario/{id}", InventarioController::listarItems);
    }

}