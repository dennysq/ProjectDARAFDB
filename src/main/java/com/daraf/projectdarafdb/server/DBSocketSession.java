/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.server;

/**
 *
 * @author RAUL
 */
import com.daraf.projectdarafdb.facade.DBFacade;
import com.daraf.projectdarafprotocol.Mensaje;
import com.daraf.projectdarafprotocol.appdb.seguridades.AutenticacionEmpresaRQ;
import com.daraf.projectdarafprotocol.appdb.MensajeRQ;
import com.daraf.projectdarafprotocol.appdb.MensajeRS;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaClienteRQ;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaClienteRS;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaFacturaRQ;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaFacturaRS;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaProductoRQ;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaProductoRS;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoClienteRQ;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoClienteRS;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoFacturaRQ;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoFacturaRS;
import com.daraf.projectdarafprotocol.appdb.seguridades.AutenticacionEmpresaRS;
import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafprotocol.model.Factura;
import com.daraf.projectdarafprotocol.model.Producto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DBSocketSession extends Thread {

    private static Integer global = 0;
    private PrintWriter output;
    private BufferedReader input;
    private Socket socket;

    private Integer id;

    public DBSocketSession(Socket socket) throws IOException {

        this.id = DBSocketSession.global++;
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {

            String userInput;

            while ((userInput = input.readLine()) != null) {
                if ("FIN".equalsIgnoreCase(userInput)) {
                    break;
                }
                System.out.println("Hilo: " + this.id + " Mensaje recibido: " + userInput);
                MensajeRQ msj = new MensajeRQ();
                if (msj.build(userInput)) {
                    if (msj.getCabecera().getIdMensaje().equals(Mensaje.ID_MENSAJE_AUTENTICACIONCLIENTE)) {

                        // metodo de autenticacion
                        AutenticacionEmpresaRQ aut = (AutenticacionEmpresaRQ) msj.getCuerpo();
                        Empresa empresaDB = DBFacade.selectCompany(aut.getIdentificacion().trim());//uso el trim para obviar los espacios en blanco en caso de que hubiere
                        MensajeRS mensajeRS = new MensajeRS("dbserver", Mensaje.ID_MENSAJE_AUTENTICACIONCLIENTE);
                        AutenticacionEmpresaRS autRS = new AutenticacionEmpresaRS();
                        if (empresaDB != null) {

                            autRS.setResultado("1");
                            autRS.setEmpresa(empresaDB);
                            mensajeRS.setCuerpo(autRS);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();

                        } else {
                            autRS.setResultado("2");
                            mensajeRS.setCuerpo(autRS);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        }
                    }
                    if (msj.getCabecera().getIdMensaje().equals(Mensaje.ID_MENSAJE_CONSULTACLIENTE)) {

                        // metodo de autenticacion
                        ConsultaClienteRQ cli = (ConsultaClienteRQ) msj.getCuerpo();
                        Cliente clienteDB = DBFacade.selectCliente(cli.getIdentificacion().trim());//uso el trim para obviar los espacios en blanco en caso de que hubiere
                        MensajeRS mensajeRS = new MensajeRS("dbserver", Mensaje.ID_MENSAJE_CONSULTACLIENTE);
                        ConsultaClienteRS cliRS = new ConsultaClienteRS();
                        if (clienteDB != null) {
                            cliRS.setResultado("1");
                            cliRS.setCliente(clienteDB);
                            mensajeRS.setCuerpo(cliRS);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        } else {
                            cliRS.setResultado("2");
                            mensajeRS.setCuerpo(cliRS);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        }
                    }
                    if (msj.getCabecera().getIdMensaje().equals(Mensaje.ID_MENSAJE_INGRESOCLIENTE)) {
                        IngresoClienteRQ ing = (IngresoClienteRQ) msj.getCuerpo();
                        Boolean ingresocorrecto = DBFacade.insertarcliente(ing.getCliente().getIdentificacion(), ing.getCliente().getNombre(), ing.getCliente().getTelefono(), ing.getCliente().getDireccion());
                        MensajeRS mensajeRS = new MensajeRS("dbserver", Mensaje.ID_MENSAJE_INGRESOCLIENTE);
                        IngresoClienteRS ingrs = new IngresoClienteRS();
                        if (ingresocorrecto) {
                            ingrs.setResultado("1");
                            mensajeRS.setCuerpo(ingrs);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        } else {
                            ingrs.setResultado("2");
                            mensajeRS.setCuerpo(ingrs);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        }
                    }
                    if (msj.getCabecera().getIdMensaje().equals(Mensaje.ID_MENSAJE_CONSULTAPRODUCTO)) {

                        ConsultaProductoRQ cprq = (ConsultaProductoRQ) msj.getCuerpo();
                        Producto productoDB = DBFacade.buscarProducto(cprq.getIdProducto().trim());
                        MensajeRS mensajeRS = new MensajeRS("dbserver", Mensaje.ID_MENSAJE_CONSULTAPRODUCTO);

                        ConsultaProductoRS cprs = new ConsultaProductoRS();
                        if (productoDB != null) {

                            cprs.setResultado("1");
                            cprs.setProducto(productoDB);
                            mensajeRS.setCuerpo(cprs);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();

                        } else {
                            cprs.setResultado("2");
                            mensajeRS.setCuerpo(cprs);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        }
                    }

                } else {
                    output.write(Mensaje.ID_MENSAJE_FALLOBUILD + "\n");
                    output.flush();
                }
                if (msj.getCabecera().getIdMensaje().equals(Mensaje.ID_MENSAJE_INGRESOFACTURA)) {
                    IngresoFacturaRQ ing = (IngresoFacturaRQ) msj.getCuerpo();

                    String response = DBFacade.insertarFactura(ing.getIdFactura(), ing.getIdentificacionCliente(), ing.getFecha(), ing.getTotal(), ing.getNumeroDetalles(), ing.getDetalles());
                    MensajeRS mensajeRS = new MensajeRS("dbserver", Mensaje.ID_MENSAJE_INGRESOFACTURA);
                    IngresoFacturaRS ingrs = new IngresoFacturaRS();

                    ingrs.setResultado(response);

                    mensajeRS.setCuerpo(ingrs);
                    output.write(mensajeRS.asTexto() + "\n");
                    output.flush();
                }
                
                if (msj.getCabecera().getIdMensaje().equals(Mensaje.ID_MENSAJE_CONSULTAFACTURA)) {

                        ConsultaFacturaRQ cfrq = (ConsultaFacturaRQ) msj.getCuerpo();
                        Factura facturaDB = DBFacade.buscarFactura(cfrq.getIdFactura().trim());
                        MensajeRS mensajeRS = new MensajeRS("dbserver", Mensaje.ID_MENSAJE_CONSULTAFACTURA);

                        ConsultaFacturaRS cfrs = new ConsultaFacturaRS();
                        if (facturaDB != null) {

                            cfrs.setResultado("1");
                            cfrs.setFactura(facturaDB);
                            mensajeRS.setCuerpo(cfrs);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();

                        } else {
                            cfrs.setResultado("2");
                            mensajeRS.setCuerpo(cfrs);
                            output.write(mensajeRS.asTexto() + "\n");
                            output.flush();
                        }
                    }
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Error:  " + e.getMessage());
        }
    }
}
