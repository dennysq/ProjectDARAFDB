/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.facade;

import com.daraf.projectdarafdb.fileIO.ReadCliente;
import com.daraf.projectdarafdb.fileIO.ReadDetalle;
import com.daraf.projectdarafdb.fileIO.ReadEmpresa;
import com.daraf.projectdarafdb.fileIO.ReadFactura;
import com.daraf.projectdarafdb.fileIO.WriteCliente;
import com.daraf.projectdarafdb.fileIO.WriteDetalle;
import com.daraf.projectdarafdb.fileIO.WriteFactura;
import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafprotocol.model.Detalle;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafprotocol.model.Factura;
import java.util.ArrayList;
import java.util.List;
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

    public static boolean insertarcliente(String id, String nombre, String telefono, String direccion) {
        
        ReadCliente rc = new ReadCliente();
        if (id != null && nombre != null && direccion != null && telefono != null) {
            WriteCliente writer = new WriteCliente();
            Cliente cli = new Cliente(id, nombre, telefono, direccion);
            writer.escribir(cli);
            return true;

        } else {
            return false;
        }
    }

    public static Cliente selectCliente(String identificacion) {
        Cliente cliente = null;
        try {
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Cliente.txt"));
            while ((cadena = bf.readLine()) != null) {
                datos = cadena.split("\t");
                if (datos[0].equals(identificacion)) {
                    System.err.println("" + datos[0]);
                    cliente = new Cliente(datos[0], datos[1], datos[2], datos[3]);
                }
            }
            bf.close();
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return cliente;
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

    public static String insertarFactura(String id, String identificacionCliente, String fecha, String total, String numeroDetalles, List<Detalle> detalles) {

        /*
         public static void main(String[] args) {
         String identificacion = "0503337909";
         String nombre = "Ana Lucia";
         String telefono = "0993188521";
         String direccion = "Quito";
         >>>>>>> origin/master

         */
        if (id != null && identificacionCliente != null && fecha != null && total != null) {
            ReadFactura rf = new ReadFactura();
            if (rf.verificaExistenciaFactura(id)) {
                return "3";
            } else {
                WriteFactura writer = new WriteFactura();
                Factura f = new Factura(id, identificacionCliente, fecha, total, numeroDetalles);
                writer.escribir(f);
                WriteDetalle wd = new WriteDetalle();
                for (Detalle d : detalles) {
                    wd.escribir(d);
                }
                return "1";
            }
        } else {
            return "4";//error en os campos enviados
        }
    }

//         if (insertarcliente(identificacion, nombre, telefono, direccion))
//         System.err.println("si");
//                
//         }
    //Shipo
    public Factura buscarFactura(String idFactura) {
        Factura factura = new Factura();
        ReadDetalle detalles = new ReadDetalle();
        try {
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Factura.txt"));
            while ((cadena = bf.readLine()) != null) {
                datos = cadena.split("a");
                if (datos[0].equals(idFactura)) {                    
                    factura.setId(datos[0]);
                    factura.setFecha(datos[1]);
                    factura.setTotal(datos[2]);
                    factura.setIdentificacionCliente(datos[3]);
                    factura.setNumeroDetalles(datos[4]);
                }
            }

            bf.close();
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());

        }
        factura.setDetalles(detalles.leer(factura.getId()));
        return factura;
    }
    
    public static void main(String[] args) {
//        String buscar="0000000005";
//        Factura factura = new Factura();
//
//        factura = buscarFactura(buscar);
//        
//        if(factura !=null)
//               System.out.print(factura.toString()+"\n"); 
//        else
//            System.err.println("No encontrado factura");
    }
    
}
