
package com.example.navigationdrawact.JsonClass;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarcajeBuscarCodigoClase1 implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("Marcajes")
    @Expose
    private List<Marcaje> marcajes = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Marcaje> getMarcajes() {
        return marcajes;
    }

    public void setMarcajes(List<Marcaje> marcajes) {
        this.marcajes = marcajes;
    }

}
