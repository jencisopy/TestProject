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
import org.javabeanstack.annotation.CheckMethod;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.error.ErrorReg;
import org.javabeanstack.error.IErrorReg;
import org.javabeanstack.services.DataService;
import org.javabeanstack.services.IDataServiceLocal;
import org.javabeanstack.services.IDataServiceRemote;
import net.makerapp.model.tables.AppUser;

/**
 *
 * @author Jorge Enciso
 */
@Stateless
@Remote(IDataServiceRemote.class)
@Local(IDataServiceLocal.class)
public class PaisSrv extends DataService{
    private static final Logger LOGGER = Logger.getLogger(PaisSrv.class);
    
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
