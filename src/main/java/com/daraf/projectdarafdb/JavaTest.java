/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb;

import FileIO.ReadCliente;
import FileIO.WriteCliente;
import com.daraf.projectdarafdb.Entidades.Cliente;
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
        List<Cliente> clientes = new ArrayList<Cliente>();
        ReadCliente readc = new ReadCliente();
        WriteCliente writec = new WriteCliente();
        readc.leer(clientes);
        //readc.buscar(clientes, "1723520662");
        for (int i = 0; i < clientes.size(); i++) 
        {
            System.out.println (clientes.get(i).toString());
        }
        clientes.add(new Cliente ("3","Alejandra Ponce","0983106601","Sangolqui","0503637909"));
        //writec.escribir(clientes);
        
    }
}
