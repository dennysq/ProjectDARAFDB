/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb;


import com.daraf.projectdarafdb.fileIO.ReadCliente;
import com.daraf.projectdarafdb.fileIO.WriteCliente;
import com.daraf.projectdarafprotocol.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Susana
 */
public class JavaTest 
{
    public static void main(String[] Args)
    {
        List<Cliente> clientes = new ArrayList<>();
        ReadCliente readc = new ReadCliente();     
        WriteCliente writec = new WriteCliente();
        readc.leer(clientes);
        writec.escribir(new Cliente("5","Alejandra Ponce","0958315268","Sangolqui","2586952668"));
        
    }
}
