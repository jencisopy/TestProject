/*
* Copyright (c) 2015-2018 OyM System Group S.A.
* Capitan Cristaldo 464, Asunción, Paraguay
* All rights reserved. 
*
* NOTICE:  All information contained herein is, and remains
* the property of OyM System Group S.A. and its suppliers,
* if any.  The intellectual and technical concepts contained
* herein are proprietary to OyM System Group S.A.
* and its suppliers and protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material
* is strictly forbidden unless prior written permission is obtained
* from OyM System Group S.A.
 */
package py.com.oym.frame.security;

import java.util.Map;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.log4j.Logger;
import org.javabeanstack.data.DataNativeQuery;
import org.javabeanstack.data.IDataNativeQuery;
import org.javabeanstack.data.IDataQueryModel;
import org.javabeanstack.data.IDataResult;
import org.javabeanstack.data.services.DataService;
import org.javabeanstack.error.ErrorManager;
import org.javabeanstack.model.IAppObjectAuth;
import org.javabeanstack.model.IAppUser;
import org.javabeanstack.security.IAppObjectAuthSrv;
import org.javabeanstack.xml.DomW3cParser;
import org.w3c.dom.Document;
import static org.javabeanstack.model.IAppObjectAuth.*;

/**
 *
 * @author Jorge Enciso
 *
 *
 */

@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AppObjectAuthSrv extends DataService implements IAppObjectAuthSrv {
    private static final Logger LOGGER = Logger.getLogger(AppObjectAuthSrv.class);


    private final String XMLDEF = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

    /**
     * Determina si un usuario tiene o no permitido una acción, sin considerar
     * el grupo a que pertenece, sobre un objeto determinado.
     *
     * @param sessionId identificador de la sessión.
     * @param idAppObject identificador del objeto.
     * @param user usuario
     * @param action acción
     * @param authDenyDefault si no se especifica permisos, entonces por defecto
     * se niega o no el permiso dependiendo de las politicas de seguridad
     * definida en el sistema.
     * @return si un usuario puede o no realizar una acción. No se incluye
     * permisos heredados de los grupos a que pertenece.
     */
    @Override
    public Integer checkAuthUserOnly(String sessionId, Long idAppObject, IAppUser user, String action, Integer authDenyDefault) {
        return ALLOWED;
    }

    /**
     * Determina si un usuario tiene o no permitido una acción, (se hereda los
     * permisos del grupo a que pertenece) sobre un objeto determinado.
     *
     * @param sessionId identificador de la sessión.
     * @param idAppObject identificador del objeto.
     * @param user usuario
     * @param action acción
     * @param checkResult
     * @param authDenyDefault si no se especifica permisos, entonces por defecto
     * se niega o no el permiso dependiendo de las politicas de seguridad
     * definida en el sistema.
     * @return si un usuario puede o no realizar una acción. Se incluye permisos
     * heredados de los grupos a que pertenece.
     */
    @Override
    public Integer checkAuth(String sessionId, Long idAppObject, IAppUser user, String action, Map<String, String> checkResult, Integer authDenyDefault) {
        return ALLOWED;
    }

    /**
     * Determina si un usuario tiene o no permitido una acción, (se hereda los
     * permisos del grupo a que pertenece) sobre un objeto determinado.
     *
     * @param sessionId identificador de la sessión.
     * @param idAppObject identificador del objeto.
     * @param iduser id del usuario.
     * @param action acción
     * @param checkResult
     * @param authDenyDefault si no se especifica permisos, entonces por defecto
     * se niega o no el permiso dependiendo de las politicas de seguridad
     * definida en el sistema.
     * @return si un usuario puede o no realizar una acción. Se incluye permisos
     * heredados de los grupos a que pertenece.
     */
    @Override
    public Integer checkAuth(String sessionId, Long idAppObject, Long iduser, String action, Map<String, String> checkResult, Integer authDenyDefault) {
        return ALLOWED;
    }
    /**
     * Determina si un usuario tiene o no permitido una acción sobre un campo
     * del objeto, (se hereda los permisos del grupo a que pertenece).
     *
     * @param sessionId identificador de la sessión.
     * @param idAppObject identificador del objeto.
     * @param iduser id del usuario.
     * @param field campo.
     * @param action acción
     * @return si un usuario puede o no realizar una acción sobre el campo de un
     * objeto. Se incluye permisos heredados de los grupos a que pertenece.
     */
    @Override
    public Integer checkAuthField(String sessionId, Long idAppObject, Long iduser, String field, String action) {
        return ALLOWED;
    }

    /**
     * Determina si un usuario tiene o no permitido una acción sobre un campo
     * del objeto, (se hereda los permisos del grupo a que pertenece).
     *
     * @param sessionId identificador de la sessión.
     * @param idAppObject identificador del objeto.
     * @param user usuario
     * @param field campo.
     * @param action acción
     * @return si un usuario puede o no realizar una acción sobre el campo de un
     * objeto. Se incluye permisos heredados de los grupos a que pertenece.
     */
    @Override
    public Integer checkAuthField(String sessionId, Long idAppObject, IAppUser user, String field, String action) {
            return ALLOWED;
    }


    /**
     * Devuelve el campo authdef de AppObject en formato XmlDom
     *
     * @param idAppObject identificador del objeto dentro de AppObject.
     * @return el campo authdef de AppObject en formato XmlDom
     */
    @Override
    public Document getAuthXmlDom(Long idAppObject) {
        try {
            IDataNativeQuery query = DataNativeQuery.create(dao, null);
            IDataQueryModel data
                    = query.select("authdef")
                            .from("AppObject")
                            .where("idappobject = " + idAppObject)
                            .execQuerySingle();
            if (data != null) {
                String xml;
                if (data.getColumn("authdef") != null) {
                    xml = XMLDEF + data.getColumnStr("authdef");
                } else {
                    xml = XMLDEF + "<AUTHORIZATIONS execute=\"\"/>";
                }
                return DomW3cParser.loadXml(xml);
            }
        } catch (Exception e) {
            ErrorManager.showError(e, LOGGER);
        }
        return null;
    }

    @Override
    public Document getAuthXmlDom(Long idAppObject, Long iduser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IAppObjectAuth getAppObjectAuth(Long idAppObject, Long iduser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IDataResult saveAppObjectAuth(String sessionId, IAppObjectAuth ejb) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
