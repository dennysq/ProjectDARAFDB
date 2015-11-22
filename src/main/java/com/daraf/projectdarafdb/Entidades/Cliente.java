/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.Entidades;

/**
 *
 * @author ShipO
 */
public class Cliente 
{
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String identificacion;
    
    public Cliente(String a, String b, String c, String d, String e)
    {                 
            id= Integer.parseInt(a);
            nombre = b;
            telefono = c;
            direccion = d;
            identificacion = e;                
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return id.toString() + "\t" + nombre + "\t" + telefono + "\t" + direccion + "\t" + identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
}
