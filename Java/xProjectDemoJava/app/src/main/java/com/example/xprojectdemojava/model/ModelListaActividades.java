package com.example.xprojectdemojava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelListaActividades implements Serializable {

    @SerializedName("Codigo")
    @Expose
private String Codigo;

    public String getCodigo() { return Codigo;    }

    public void setCodigo(String Codigo) {  this.Codigo = Codigo;    }
}
