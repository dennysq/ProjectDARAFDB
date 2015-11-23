/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.server;


import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dennys
 */
public class DBServerInstance {
    public static void main(String[] args) {
        System.out.println("Servidor de Base de datos arriba");
        try{
            ServerSocket server = new ServerSocket(5002);
            while(true){
                Socket client = server.accept();
                new DBSocketSession(client).start();
                System.out.println("El servidor de Base de datos ha recibido una conexion");
                
            }    
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
