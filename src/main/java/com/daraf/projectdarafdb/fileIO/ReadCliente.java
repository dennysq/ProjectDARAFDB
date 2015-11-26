/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafprotocol.model.Producto;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.List;


/**
 *
 * @author ShipO
 */
public class ReadCliente 
{
    public boolean verificaExistenciaCliente(String identificacion)
    {
        boolean respuesta = false;
        try
        {              
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Cliente.txt"));                     
            while ((cadena = bf.readLine())!=null) 
            {
                datos = cadena.split("\t");
                if(datos[4].equals(identificacion))
                    respuesta = true;
            }
            
            bf.close();
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return respuesta;
    }
    public void leer(List<Cliente> clientes) 
    {
        try
        {      
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Cliente.txt"));         
            while ((cadena = bf.readLine())!=null) 
            {
                System.out.println(cadena);
                datos = cadena.split("\t");
                System.out.println(cadena);
                clientes.add(new Cliente(datos[0],datos[1],datos[2],datos[3]));
            }
            
            bf.close();
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
    }
    
    public void buscar(List<Cliente> clientes, String identifiacion)
    {
        for (int i = 0; i < clientes.size(); i++) 
        {
                if(!clientes.get(i).getIdentificacion().equals(identifiacion))
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
