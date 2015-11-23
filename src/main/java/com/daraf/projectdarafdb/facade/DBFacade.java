/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafdb.facade;

import com.daraf.projectdarafdb.fileIO.ReadEmpresa;
import com.daraf.projectdarafprotocol.model.Empresa;

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
}
