/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.facade;

import com.daraf.projectdarafdb.fileIO.ReadCliente;
import com.daraf.projectdarafdb.fileIO.ReadEmpresa;
import com.daraf.projectdarafdb.fileIO.WriteCliente;
import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafprotocol.model.Empresa;
import java.util.ArrayList;
import java.util.List;
import com.daraf.projectdarafprotocol.model.Producto;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Dennys
 */
public class DBFacade {

    public static Empresa selectCompany(String identi) {

        if (!identi.isEmpty()) {

            ReadEmpresa reader = new ReadEmpresa();
            return reader.buscar(identi);

        }
        return null;
    }
    public static boolean insertarcliente(String id, String nombre, String telefono,String direccion){
        if(id!=null && nombre!=null && direccion!=null && telefono!=null){
            WriteCliente writer=new WriteCliente();
            Cliente cli=new Cliente(id, nombre, telefono, direccion);
            writer.escribir(cli);
            return true;
            
        }
        else{
            return false;
        }
    }
     public static Cliente selectCliente(String identi) {

        if (!identi.isEmpty()) {
            List<Cliente> cliente;
            ReadCliente reader = new ReadCliente();
            cliente=new ArrayList<>();
            reader.leer(cliente);
            return reader.buscar(cliente, identi);
        }
        return null;
     }
    public static Producto buscarProducto(String idProducto)
    {
        Producto producto = null;
        try
        {      
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Producto.txt"));         
            while ((cadena = bf.readLine())!=null) 
            {
                datos = cadena.split("\t");
                if(datos[0].equals(idProducto))
                {
                    producto = new Producto(datos[0],datos[1],datos[2],datos[3]);
                }                                
            }
            
            bf.close();
        }
        catch (Exception e)
        {
            System.err.println("Ocurrio un error: " + e.getMessage());            
        }
        return producto;
    }
}
