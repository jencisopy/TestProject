/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.services;

import py.com.oym.frame.annotation.CheckMethod;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.error.IErrorReg;
import py.com.oym.frame.services.IDataService;
import py.com.oym.model.tables.Usuario;

/**
 *
 * @author jenci_000
 */
public interface IUsuarioSrv extends IDataService{

    @CheckMethod(fieldName = "codigo", operacion = {IDataRow.AGREGAR, IDataRow.MODIFICAR, IDataRow.BORRAR})
    IErrorReg checkCodigo(Usuario row, String sessionId);

    @CheckMethod(fieldName = "codigo", operacion = {IDataRow.BORRAR})
    IErrorReg checkCodigo2(Usuario row, String sessionId);

    @CheckMethod(fieldName = "nombre")
    IErrorReg checkNombre(Usuario row, String sessionId);
    
}
