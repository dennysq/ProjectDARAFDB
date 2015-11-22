/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.List;


/**
 *
 * @author ShipO
 */
public class ReadCliente 
{
    
    public void leer(List<Cliente> clientes) 
    {
        try
        {          
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Cliente.txt"));         
            while ((cadena = bf.readLine())!=null) 
            {
                System.out.println(cadena);
            }
            
            bf.close();
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
    }
    
    public void buscar(List<Cliente> clientes, String documento)
    {
        for (int i = 0; i < clientes.size(); i++) 
        {
                if(!clientes.get(i).getIdentificacion().equals(documento))
                {
                    clientes.remove(i);
                }
        }
        for (int i = 0; i < clientes.size(); i++) 
        {
            System.out.println (clientes.get(i).toString());
        }
    }
}
