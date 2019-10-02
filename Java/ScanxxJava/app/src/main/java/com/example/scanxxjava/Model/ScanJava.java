package com.example.scanxxjava.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ScanJava implements Serializable{//implements Serializable
/*private String docnum;

    public String getdocnum() { return docnum;    }

    public void setdocnum(String xdocnum) {  docnum = xdocnum;    }*/

    @SerializedName("Codigo")
    @Expose
    private String docnum;

    public String getdocnum() {
        return docnum;
    }
    public void setdocnum(String docnum) {
        this.docnum = docnum;
    }

}
