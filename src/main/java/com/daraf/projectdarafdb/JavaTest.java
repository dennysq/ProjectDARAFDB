/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb;


import com.daraf.projectdarafdb.facade.DBFacade;
import com.daraf.projectdarafprotocol.model.Factura;

/**
 *
 * @author Susana
 */
public class JavaTest 
{
    public static void main(String[] Args)
    {                
        DBFacade readf = new DBFacade ();
        Factura factura;
        factura = readf.buscarFactura("0000000005");
        System.out.println(factura.toString());
        System.out.println("factura detalles "+factura.getNumeroDetalles());
        
        
    }
}
