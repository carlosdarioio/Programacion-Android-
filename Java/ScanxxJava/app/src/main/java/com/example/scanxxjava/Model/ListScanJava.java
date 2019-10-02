package com.example.scanxxjava.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListScanJava implements Serializable {

    @SerializedName("xRootObject")
    @Expose
    private List<ScanJava> scanJava = null;

    public List<ScanJava> getScanJava() {
        return scanJava;
    }
    public void setScanJava(List<ScanJava> scanJava) {
        this.scanJava = scanJava;
    }
}
/*public class zScanJava {

    private String docnum;

     public String getUserName() {
        return docnum;
     }
    public void setdocnum(String docnum) {
        this.docnum = docnum;
    }
}
*/