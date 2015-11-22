/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;
import com.daraf.projectdarafdb.Entidades.Cliente;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
/**
 *
 * @author ShipO
 */
public class ReadCliente 
{
    private static int verificador=0;
    public void leer(List<Cliente> clientes)
    {
        try
        {
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream("Cliente.txt");
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String[] datos;
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   
            {                
                // Imprimimos la línea por pantalla
                //System.out.println (strLinea);
                datos = strLinea.split("\t");                                
                clientes.add(new Cliente(datos[0],datos[1],datos[2],datos[3], datos[4]));                                
            }
            // Cerramos el archivo
            entrada.close();
            
            
        }
        catch (Exception e)
        { //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
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
