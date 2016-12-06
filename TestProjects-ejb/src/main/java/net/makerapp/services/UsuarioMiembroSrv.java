/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.services;

import py.com.oym.frame.data.DBManager;
import py.com.oym.frame.services.DataService;

/**
 *
 * @author jenci_000
 */
public class UsuarioMiembroSrv extends DataService{
    @Override
    protected String getPersistentUnit(String sessionId){
        return DBManager.CATALOGO;
    }    
}
