/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.Cliente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;


/**
 *
 * @author ShipO
 */
public class ReadCliente 
{
    
    public void leer(List<Cliente> clientes) throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("Cliente.txt"));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    String everything = sb.toString();
} finally {
    br.close();
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
