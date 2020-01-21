
package com.example.navigationdrawact.JsonClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Transferencium implements Serializable {

    @SerializedName("DocNum")
    @Expose
    private String docNum;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("de")
    @Expose
    private String de;
    @SerializedName("a")
    @Expose
    private String a;

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

}
