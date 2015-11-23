/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.Empresa;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author ShipO
 */
public class ReadEmpresa 
{
    public Empresa buscar(String usuario, String pass)
    {
         try
        {   
            Empresa empresa = null;
            String[] datos;
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Empresa.txt"));         
            while ((cadena = bf.readLine())!=null) 
            {
                datos = cadena.split("\t");
                if(datos[4].equals(usuario) && datos[5].equals(pass))
                {
                    empresa = new Empresa(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]);
                }
            }
            
            bf.close();
            return empresa;
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());
            return null;
        }
    }
    
}
