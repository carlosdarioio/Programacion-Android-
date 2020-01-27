
package com.example.navigationdrawact.JsonClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Marcaje implements Serializable {

    @SerializedName("TRACVE")
    @Expose
    private String tRACVE;
    @SerializedName("CONSEC")
    @Expose
    private String cONSEC;
    @SerializedName("FECHA")
    @Expose
    private String fECHA;
    @SerializedName("HORAMA")
    @Expose
    private String hORAMA;
    @SerializedName("LOCAL")
    @Expose
    private String lOCAL;

    public String getTRACVE() {
        return tRACVE;
    }

    public void setTRACVE(String tRACVE) {
        this.tRACVE = tRACVE;
    }

    public String getCONSEC() {
        return cONSEC;
    }

    public void setCONSEC(String cONSEC) {
        this.cONSEC = cONSEC;
    }

    public String getFECHA() {
        return fECHA;
    }

    public void setFECHA(String fECHA) {
        this.fECHA = fECHA;
    }

    public String getHORAMA() {
        return hORAMA;
    }

    public void setHORAMA(String hORAMA) {
        this.hORAMA = hORAMA;
    }

    public String getLOCAL() {
        return lOCAL;
    }

    public void setLOCAL(String lOCAL) {
        this.lOCAL = lOCAL;
    }

}
