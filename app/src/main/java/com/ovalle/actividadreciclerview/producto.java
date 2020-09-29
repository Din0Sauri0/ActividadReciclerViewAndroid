package com.ovalle.actividadreciclerview;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class producto {

    String nombre;
    String descripcion;
    String cantidad;
    String marca;
    String valoracion;

    public producto(String nombre, String descripcion, String cantidad, String marca, String valoracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.marca = marca;
        this.valoracion = valoracion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
