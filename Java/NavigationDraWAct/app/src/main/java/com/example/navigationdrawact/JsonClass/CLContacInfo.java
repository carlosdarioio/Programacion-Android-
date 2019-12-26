
package com.example.navigationdrawact.JsonClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CLContacInfo implements Serializable {

    @SerializedName("Codigo")
    @Expose
    private String codigo;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Phone1")
    @Expose
    private String phone1;
    @SerializedName("Phone2")
    @Expose
    private String phone2;
    @SerializedName("celular")
    @Expose
    private String celular;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
