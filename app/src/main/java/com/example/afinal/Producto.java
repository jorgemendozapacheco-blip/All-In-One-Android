package com.example.afinal;

public class Producto {
    private String nombre;
    private int cantidad;
    private int cantidadTotal;

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

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
// Constructor, getters y setters

    public Producto() {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.cantidadTotal = cantidadTotal;
    }
}
