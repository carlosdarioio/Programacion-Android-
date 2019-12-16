
package com.example.navigationdrawact.JsonClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Articulo implements Serializable {

    @SerializedName("Articulo")
    @Expose
    private String articulo;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Cantidad")
    @Expose
    private String cantidad;
    @SerializedName("Venta")
    @Expose
    private String venta;
    @SerializedName("Almacen")
    @Expose
    private String almacen;

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

}
