/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.services;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import org.javabeanstack.annotation.CheckMethod;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.error.ErrorReg;
import org.javabeanstack.error.IErrorReg;
import org.javabeanstack.data.services.DataService;
import org.javabeanstack.data.services.IDataServiceLocal;
import org.javabeanstack.data.services.IDataServiceRemote;
import org.javabeanstack.model.appcatalog.AppUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author Jorge Enciso
 */
//@Stateless
//@Remote(IDataServiceRemote.class)
//@Local(IDataServiceLocal.class)
public class PaisSrv extends DataService{
    private static final Logger LOGGER = LogManager.getLogger(PaisSrv.class);
    
    @CheckMethod(fieldName = "region",
                 action    = {IDataRow.AGREGAR,
                              IDataRow.MODIFICAR,
                              IDataRow.BORRAR}) 
    public IErrorReg checkRegion(AppUser row, String sessionId){
        IErrorReg errorReg = new ErrorReg(); 
        LOGGER.info("IN validCodigo");
        return errorReg;
    }
}
