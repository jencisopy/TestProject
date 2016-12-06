/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.services;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import py.com.oym.frame.annotation.CheckMethod;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.error.ErrorReg;
import py.com.oym.frame.error.IErrorReg;
import py.com.oym.frame.services.DataService;
import py.com.oym.frame.services.IDataServiceLocal;
import py.com.oym.frame.services.IDataServiceRemote;
import py.com.oym.model.tables.Usuario;

/**
 *
 * @author jenci_000
 */
@Stateless
@Remote(IDataServiceRemote.class)
@Local(IDataServiceLocal.class)
public class PaisSrv extends DataService{
    private static final Logger LOGGER = Logger.getLogger(PaisSrv.class);
    
    @CheckMethod(fieldName = "region",
                operacion = {IDataRow.AGREGAR,
                             IDataRow.MODIFICAR,
                             IDataRow.BORRAR}) 
    public IErrorReg checkRegion(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg(); 
        LOGGER.info("IN validCodigo");
        return errorReg;
    }
}
