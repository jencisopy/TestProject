/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.services;

import org.javabeanstack.annotation.CheckMethod;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.error.IErrorReg;
import org.javabeanstack.services.IDataService;
import net.makerapp.model.tables.AppUser;

/**
 *
 * @author Jorge Enciso
 */
public interface IUsuarioSrv extends IDataService{

    @CheckMethod(fieldName = "codigo", action = {IDataRow.AGREGAR, IDataRow.MODIFICAR, IDataRow.BORRAR})
    IErrorReg checkCodigo(AppUser row, String sessionId);

    @CheckMethod(fieldName = "codigo", action = {IDataRow.BORRAR})
    IErrorReg checkCodigo2(AppUser row, String sessionId);

    @CheckMethod(fieldName = "nombre")
    IErrorReg checkNombre(AppUser row, String sessionId);
    
}
