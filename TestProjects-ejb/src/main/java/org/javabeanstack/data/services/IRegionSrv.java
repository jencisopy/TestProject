package org.javabeanstack.data.services;

import org.javabeanstack.data.services.IDataService;
import org.javabeanstack.annotation.CheckMethod;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.error.IErrorInfo;
import org.javabeanstack.model.tables.Region;

/**
 *
 * @author Jorge Enciso
 */
public interface IRegionSrv extends IDataService{

    @CheckMethod(fieldName = "codigo", action = {IDataRow.AGREGAR, IDataRow.MODIFICAR, IDataRow.BORRAR})
    IErrorInfo checkCodigo(String sessionId, Region row);

    @CheckMethod(fieldName = "codigo", action = {IDataRow.BORRAR})
    IErrorInfo checkCodigo2(String sessionId, Region row);

    @CheckMethod(fieldName = "nombre", action = {IDataRow.AGREGAR, IDataRow.MODIFICAR})
    IErrorInfo checkNombre(String sessionId, Region row);
    
}
