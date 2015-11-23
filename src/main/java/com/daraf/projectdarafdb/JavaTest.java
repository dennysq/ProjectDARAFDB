/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb;


import com.daraf.projectdarafdb.fileIO.ReadEmpresa;

/**
 *
 * @author Susana
 */
public class JavaTest 
{
    public static void main(String[] Args)
    {
//        List<Cliente> clientes = new ArrayList<>();
//        ReadCliente readc = new ReadCliente();     
//        WriteCliente writec = new WriteCliente();
//        readc.leer(clientes);
//        writec.escribir(new Cliente("5","Alejandra Ponce","0958315268","Sangolqui","2586952668"));
        ReadEmpresa reade = new ReadEmpresa();
        System.out.println(reade.buscar("1723520662001").toString());
        
    }
}
