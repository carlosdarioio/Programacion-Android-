
package com.example.navigationdrawact.JsonClass;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindClList implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("CLContacInfo")
    @Expose
    private List<CLContacInfo> cLContacInfo = null;

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

    public List<CLContacInfo> getCLContacInfo() {
        return cLContacInfo;
    }

    public void setCLContacInfo(List<CLContacInfo> cLContacInfo) {
        this.cLContacInfo = cLContacInfo;
    }

}
