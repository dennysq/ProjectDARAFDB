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
public class Detalle 
{
    private Integer id;
    private Integer idFactura;    
    private String nombreProducto;

    public Integer getId() {
        return id;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    private Integer cantidad;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
