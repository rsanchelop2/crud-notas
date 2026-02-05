package edu.masanz.da.crudj.dto;

import java.util.Arrays;

public class Item {
    private String nombre;
    private int cantidad;

    String[] items = {
            "Espada de Hierro",
            "Poción de Vida",
            "Escudo de Madera",
            "Amuleto de Maná",
            "Daga de Cobre"
    };

    public Item(String nombre, int cantidad) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
    public Item() {
        nombre = asignarNombre();
        cantidad = cantidadAleatoria();
    }

    private int cantidadAleatoria() {
        int n = (int) (Math.random() * 64) + 1;
        return n;
    }

    private String asignarNombre() {
        int n = (int) (Math.random() * items.length);
        String objetoAleatorio = items[n];
        return objetoAleatorio;
    }

    // region Getter y Setters
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    // endregion


    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
