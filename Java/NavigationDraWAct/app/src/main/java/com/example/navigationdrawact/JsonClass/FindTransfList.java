
package com.example.navigationdrawact.JsonClass;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindTransfList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Transferencia")
    @Expose
    private List<Transferencium> transferencia = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Transferencium> getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(List<Transferencium> transferencia) {
        this.transferencia = transferencia;
    }

}
