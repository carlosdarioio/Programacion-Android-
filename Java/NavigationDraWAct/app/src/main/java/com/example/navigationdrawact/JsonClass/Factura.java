
package com.example.navigationdrawact.JsonClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Factura {

    @SerializedName("Tipo")
    @Expose
    private String tipo;
    @SerializedName("Guia")
    @Expose
    private String guia;
    @SerializedName("Cliente")
    @Expose
    private String cliente;
    @SerializedName("FACTURA")
    @Expose
    private String fACTURA;
    @SerializedName("ZONA")
    @Expose
    private String zONA;
    @SerializedName("Fecha")
    @Expose
    private String fecha;
    @SerializedName("EstadoFactura2")
    @Expose
    private String estadoFactura2;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFACTURA() {
        return fACTURA;
    }

    public void setFACTURA(String fACTURA) {
        this.fACTURA = fACTURA;
    }

    public String getZONA() {
        return zONA;
    }

    public void setZONA(String zONA) {
        this.zONA = zONA;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoFactura2() {
        return estadoFactura2;
    }

    public void setEstadoFactura2(String estadoFactura2) {
        this.estadoFactura2 = estadoFactura2;
    }

}
