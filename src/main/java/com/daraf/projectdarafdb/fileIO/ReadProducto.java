/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;


import com.daraf.projectdarafprotocol.model.Producto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author ShipO
 */
public class ReadProducto 
{
    public void leer(List<Producto> productos) 
    {
        try
        {      
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Producto.txt"));         
            while ((cadena = bf.readLine())!=null) 
            {
                System.out.println(cadena);
                datos = cadena.split("\t");
                System.out.println(cadena);
                productos.add(new Producto(datos[0],datos[1],datos[2],datos[3]));
            }
            
            bf.close();
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
    }
    
    public void buscar(List<Producto> productos, String nombre)
    {
        for (int i = 0; i < productos.size(); i++) 
        {
                if(!productos.get(i).getNombre().equals(nombre))
                {
                    productos.remove(i);
                }
        }
        for (int i = 0; i < productos.size(); i++) 
        {
            System.out.println (productos.get(i).toString());
        }
    }
    
}
