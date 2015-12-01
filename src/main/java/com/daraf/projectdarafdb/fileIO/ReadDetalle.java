/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.DetalleFacturaAppRQ;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Susana
 */
public class ReadDetalle 
{    
    public List<DetalleFacturaAppRQ> leer(String idFactura)            
    {
        List<DetalleFacturaAppRQ> detalles = new ArrayList<>();                
        try
        {      
            String datos[];
            String cadena;
            detalles= new ArrayList<>();
            BufferedReader bf = new BufferedReader(new FileReader("Detalle.txt"));         
            while ((cadena = bf.readLine())!=null) 
            {                
                datos = cadena.split("\t");
                if(idFactura.equals(datos[0]))
                {
                    detalles.add(new DetalleFacturaAppRQ(datos[1],datos[3]));
                    //System.err.println(""+detalles.toString());
                }
                
            }
            
            bf.close();
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return detalles;
    }
}
