/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.fileIO;

import com.daraf.projectdarafprotocol.model.Factura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author ShipO
 */
public class ReadFactura {

    public void leer(List<Factura> facturas) {
        try {
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("Factura.txt"));
            while ((cadena = bf.readLine()) != null) {
                System.out.println(cadena);
                datos = cadena.split("\t");
                System.out.println(cadena);
                facturas.add(new Factura(datos[0], datos[1], datos[2], datos[3]));
            }

            bf.close();
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
    }

    public boolean verificaExistenciaFactura(String id) {
        boolean respuesta = false;
        try {
            String datos[];
            String cadena;
            BufferedReader bf = new BufferedReader(new FileReader("factura.txt"));
            while ((cadena = bf.readLine()) != null) {
                datos = cadena.split("\t");
                if (datos[0].equals(id)) {
                    respuesta = true;
                    break;
                }

            }

            bf.close();
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return respuesta;
    }

    public void buscar(List<Factura> facturas, String id) {
        for (int i = 0; i < facturas.size(); i++) {
            if (!facturas.get(i).getId().equals(id)) {
                facturas.remove(i);
            }
        }
        for (int i = 0; i < facturas.size(); i++) {
            System.out.println(facturas.get(i).toString());
        }
    }
}
