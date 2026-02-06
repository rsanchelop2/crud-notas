package edu.masanz.da.crudj.dto;

public class Item {

    private int id;
    private String nombre;
    private int cantidad;

    public Item() {

    }

    public Item(int id, String nombre, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
