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
public class Factura 
{
    private Integer id;
    private String fecha;
    private double total;
    private Integer idCliente;

    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
}
