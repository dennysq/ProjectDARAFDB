/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.facade;

import com.daraf.projectdarafdb.fileIO.ReadEmpresa;
import com.daraf.projectdarafdb.fileIO.WriteCliente;
import com.daraf.projectdarafdb.fileIO.WriteDetalle;
import com.daraf.projectdarafdb.fileIO.WriteFactura;
import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafprotocol.model.Detalle;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafprotocol.model.Factura;
import com.daraf.projectdarafprotocol.model.Producto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

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

    public static boolean insertarcliente(String id, String nombre, String direccion, String telefono) {
        if (id != null && nombre != null && direccion != null && telefono != null) {
            WriteCliente writer = new WriteCliente();
            Cliente cli = new Cliente(id, nombre, telefono, direccion, direccion);
            writer.escribir(cli);
            return true;

        } else {
            return false;
        }
    }

    public static Producto buscarProducto(String idProducto) {
        Producto producto = null;
        try {
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Producto.txt"));
            while ((cadena = bf.readLine()) != null) {
                datos = cadena.split("\t");
                if (datos[0].equals(idProducto)) {
                    producto = new Producto(datos[0], datos[1], datos[2], datos[3]);
                }
            }

            bf.close();
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return producto;
    }

    //voy a  insertae unanueva factura creando los objetos

    public static boolean insertarFactura(String id, String identificacionCliente, String fecha, String total, List<Detalle> detalles) {

//        private String id;//Longitud fija: 10               Ejemplo: 0000000025  *Se completa con ceros a la ixquierda
//    private String identificacionCliente;//Longitud fija: 20        Ejemplo: 0000000114  *Se completa con ceros a la ixquierda
//    private String fecha;//Longitud fija:8              Ejemplo: ddMMyyyy 11092013
//    private String total;//Longitud fija:10             Ejemplo: 1256.30 *Siempre debe tener 2 decimales
        if (id != null && identificacionCliente != null && fecha != null && total != null) {
            WriteFactura writer = new WriteFactura();
            Factura f = new Factura(id, identificacionCliente, fecha, total);

            writer.escribir(f);
            WriteDetalle wd = new WriteDetalle();
            for (Detalle d : detalles) {
                wd.escribir(d);
            }
            return true;

        } else {
            return false;
        }
    }
}
