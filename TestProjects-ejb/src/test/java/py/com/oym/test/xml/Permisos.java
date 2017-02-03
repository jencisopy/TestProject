/*
* Copyright (c) 2015-2017 OyM System Group S.A.
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

package py.com.oym.test.xml;

import py.com.oym.test.xml.XmlJDom;


/**
 *
 * @author jenciso
 */
public final class Permisos {
    public String usuario = "";
    public String objeto  = "";
    public int objetotipo = 0;
    public String permisosxml= "";
    public XmlJDom permisos   = null;

    public boolean checkPermiso(String usuario,String objeto, short objetotipo,String accion){
        return true;
    }

    public boolean checkPermisoFld(String usuario,String objeto, short objetotipo, String campo, String accion){
        return true;
    }

    private String getPermiso(String grupoLista){
        return "";
    }
}
