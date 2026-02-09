package edu.masanz.da.crudj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.masanz.da.crudj.controller.InventarioController;
import edu.masanz.da.crudj.controller.NotaController;
import edu.masanz.da.crudj.dao.InventarioDAO;
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

        InventarioDAO.inicializarInventario();

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
        app.get("/lista-items", InventarioController::listarItems);
        app.get("/edita-item/{id}", InventarioController::servirItem);
        app.post("/edita-item/{id}", InventarioController::editarItem);
        app.get("/crea-item", InventarioController::servirItem);
        app.post("/crea-item", InventarioController::crearItem);
        app.get("/elimina-item/{id}", InventarioController::eliminarItem);

    }

}