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

//import py.com.oym.test.xml.XmlDocument;

/**
 *
 * @author jenciso
 */
public final class Licencia {
    private String idmaquina;
    private String getIdMaquina(){
        return "";
    }
    private String computerName(){
        return "";
    }
    public boolean demo(){
        return true;
    }

    public Integer timesToExpire(){
        return 0;
    }

    public Integer daysToExpire(){
        return 0;
    }

    public void setDaysToExpire(){

    }

    public void setTimesToExpire(){

    }
    public String setKeyAct(String licencia,String nroSerie,String clave){
        return "";
    }

    public String numeroSerie(){
        return "";
    }
    public String macAdress(){
        return "";
    }

    private String generarLicClient(XmlDocument data, String claveActr, String idmaquina){
        return "";
    }

    private String generarLicSrv(XmlDocument data,String claveActivacion){
        return "";
    }

    private boolean checkLicencia(String sistema){
        return true;
    }
    private boolean checkClave(){
        return true;
    }
    
}
