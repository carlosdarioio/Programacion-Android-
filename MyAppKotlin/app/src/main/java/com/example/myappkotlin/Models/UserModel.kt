package com.example.myappkotlin.Models

class UserModel {
    private var nombre: String? = null
    private var estado:String? = null
    private var id: String? = null

    fun getid(): String? {
        return id
    }

    fun setid(id: String) {
        this.id = id
    }

    fun getNombre(): String? {
        return nombre
    }

    fun setnombre(nombre: String) {
        this.nombre = nombre
    }

    fun getestado(): String? {
        return estado
    }

    fun setestado(estado: String) {
        this.estado = estado
    }
}