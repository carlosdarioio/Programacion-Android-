package com.example.myapplicationbottomnav;

public class ClientModel {

    private String Cliente, nombre,vendedor,almacen,rtn,termino,entrega;
    private String id;

    public String getid(){
        return id;
    }

    public void setid(String id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    //
    public String getvendedor() {
        return vendedor;
    }

    public void setvendedor(String estado) {
        this.vendedor = vendedor;
    }

    //
    public String getalmacen() {
        return almacen;
    }

    public void setalmacen(String almacen) {
        this.almacen = almacen;
    }
    //
    public String getrtn() {
        return rtn;
    }

    public void setrtn(String rtn) {
        this.rtn = rtn;
    }
    //
    public String gettermino() {
        return termino;
    }

    public void settermino(String termino) {
        this.termino = termino;
    }
    //
    public String getentrega() {
        return entrega;
    }

    public void setentrega(String entrega) {
        this.entrega = entrega;
    }
}
