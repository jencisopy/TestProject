/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.services;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import org.apache.log4j.Logger;
import py.com.oym.frame.annotation.CheckMethod;
import py.com.oym.frame.data.DBManager;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.services.DataService;
import py.com.oym.frame.error.ErrorReg;
import py.com.oym.frame.error.IErrorReg;
import py.com.oym.model.tables.Usuario;


/**
 *
 * @author jenci_000
 */
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class UsuarioSrv extends DataService implements IUsuarioSrv {
    private static final Logger LOGGER = Logger.getLogger(UsuarioSrv.class);
    
    @CheckMethod(fieldName = "codigo",
                operacion = {IDataRow.AGREGAR,
                             IDataRow.MODIFICAR,
                             IDataRow.BORRAR}) 
    @Override
    public IErrorReg checkCodigo(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg(); 
        LOGGER.info("IN validCodigo");
        return errorReg;
    }

    @CheckMethod(fieldName = "codigo",
                operacion = {IDataRow.BORRAR}) 
    @Override
    public IErrorReg checkCodigo2(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg(); 
        LOGGER.info("IN validCodigo2");
        return errorReg;
    }
    
    @CheckMethod(fieldName = "nombre")     
    @Override
    public IErrorReg checkNombre(Usuario row, String sessionId){
        IErrorReg errorReg = new ErrorReg();
        LOGGER.info("IN checkNombre");
        //errorReg.setMessage("prueba de error");
        return errorReg;
    }
    
    @Override
    protected String getPersistentUnit(String sessionId){
        return DBManager.CATALOGO;
    }
    
    public String hello(){
        return "UsuarioSrv";
    }

//    @PostConstruct
//    public void init() {
//        //System.out.println("Post construct");
//    }
//    
//    @PreDestroy
//    public void destroy() {
//        //System.out.println("destroy");
//    }
//    
//    @Remove
//    public void checkOut() {
//        //System.out.println("remove");
//    }
//    
//    @AfterBegin
//    private void afterBegin(){
//        System.out.println("A new transaction has started.");
//    }
//
//    @BeforeCompletion
//    private void beforeCompletion(){
//        System.out.println("A transaction is about to be committed.");
//    }
//    
//    @AfterCompletion
//    private void afterCompletion(boolean committed) {
//        System.out.println("a transaction commit protocol has completed, and tells the instance whether the transaction has been committed or rolled back , based on committed value : " + committed);
//    }
    
}
