/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.data;

import org.apache.log4j.Logger;
import py.com.oym.frame.annotation.CheckMethod;
import py.com.oym.frame.data.DBManager;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.logic.DataService;
import py.com.oym.frame.error.ErrorReg;
import py.com.oym.frame.error.IErrorReg;
import py.com.oym.model.tables.Usuario;


/**
 *
 * @author jenci_000
 */
public class UsuarioSrv extends DataService {
    private static final Logger LOGGER = Logger.getLogger(UsuarioSrv.class);
    
    @CheckMethod(fieldName = "codigo",
                operacion = {IDataRow.AGREGAR,
                             IDataRow.MODIFICAR,
                             IDataRow.BORRAR}) 
    public IErrorReg validCodigo(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg(); 
        LOGGER.info("IN validCodigo");
        return errorReg;
    }

    @CheckMethod(fieldName = "codigo",
                operacion = {IDataRow.BORRAR}) 
    public IErrorReg validCodigo2(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg(); 
        LOGGER.info("IN validCodigo2");
        return errorReg;
    }
    
    @CheckMethod(fieldName = "nombre")     
    public IErrorReg checkNombre(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg();
        LOGGER.info("IN checkNombre");
        errorReg.setMessage("prueba de error");
        return errorReg;
    }
    
    @Override
    protected String getPersistentUnit(String sessionId){
        return DBManager.CATALOGO;
    }
    
    
}
