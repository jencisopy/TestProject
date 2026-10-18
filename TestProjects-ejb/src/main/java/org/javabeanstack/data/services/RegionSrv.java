package org.javabeanstack.data.services;

import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import org.javabeanstack.annotation.CheckMethod;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.error.ErrorInfo;
import org.javabeanstack.error.IErrorInfo;
import org.javabeanstack.model.tables.Region;
import org.javabeanstack.util.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author Jorge Enciso
 */
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class RegionSrv extends DataService implements IRegionSrv {
    private static final Logger LOGGER = LogManager.getLogger(RegionSrv.class);
    
    @CheckMethod(fieldName = "codigo",
                 action   = {IDataRow.AGREGAR,
                             IDataRow.MODIFICAR,
                             IDataRow.BORRAR}) 
    @Override
    public IErrorInfo checkCodigo(String sessionId, Region row){
        IErrorInfo errorInfo = new ErrorInfo(); 
        LOGGER.info("IN validCodigo");
        if (Strings.isNullorEmpty(row.getCodigo())){
            LOGGER.info("validCodigo error");
            errorInfo.setMessage("No deje en blanco el campo código");
        }
        return errorInfo;
    }

    @CheckMethod(fieldName = "codigo", action = {IDataRow.BORRAR}) 
    @Override
    public IErrorInfo checkCodigo2(String sessionId, Region row){
        IErrorInfo errorInfo = new ErrorInfo(); 
        LOGGER.info("IN validCodigo2");
        return errorInfo;
    }
    
    @CheckMethod(fieldName = "nombre", action = {IDataRow.AGREGAR, IDataRow.MODIFICAR})
    @Override
    public IErrorInfo checkNombre(String sessionId, Region row){
        IErrorInfo errorInfo = new ErrorInfo();
        LOGGER.info("IN checkNombre");
        if (Strings.isNullorEmpty(row.getNombre())){
            errorInfo.setMessage("No deje en blanco el campo nombre");
        }
        return errorInfo;
    }
    
    public String hello(){
        return "RegionSrv";
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
