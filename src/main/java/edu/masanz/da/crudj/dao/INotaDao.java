package edu.masanz.da.crudj.dao;

import java.util.List;

import edu.masanz.da.crudj.dto.Nota;

public interface INotaDao {

    int obtenerNumeroNotas();

    List<Nota> obtenerNotas(int pagina, int notasPorPagina);

    Nota obtenerNota(long idNota);

    Nota guardarNota(Nota nota);

    boolean actualizarNota(Nota nota);

    boolean eliminarNota(long idNota);

}
