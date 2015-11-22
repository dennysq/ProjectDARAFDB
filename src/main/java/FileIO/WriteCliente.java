/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;


import com.daraf.projectdarafprotocol.model.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author ShipO
 */
public class WriteCliente 
{
    public void escribir(List<Cliente> clientes)
    {
        try
        {
            String tabla="";
            File archivo = new File("Cliente.txt");
            BufferedWriter bw;            
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < clientes.size(); i++) 
            {
                tabla += (clientes.get(i).toString()+"\n");
            }
            bw.write(tabla);
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
