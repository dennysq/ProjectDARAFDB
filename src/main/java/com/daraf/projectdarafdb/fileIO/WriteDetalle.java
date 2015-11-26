/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.Detalle;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ShipO
 */
public class WriteDetalle 
{
    public void escribir(Detalle detalles)
    {
        File f;
        f = new File("Cliente.txt");
        //Escritura
        try
        {
            FileWriter w = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);          
            wr.println(detalles.AsTexto()); //concatenamos en el archivo sin borrar lo existente                
            wr.close();
            bw.close();

        }
        catch(IOException e){};

    }
}
