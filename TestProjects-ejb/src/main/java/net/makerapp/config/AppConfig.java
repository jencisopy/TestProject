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
package net.makerapp.config;

import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.javabeanstack.config.AppGenericConfig;
import org.javabeanstack.error.ErrorManager;
import org.javabeanstack.io.IOUtil;
import org.javabeanstack.xml.DomW3cParser;
import static org.javabeanstack.util.Strings.decode64;

/**
 *
 * @author Jorge Enciso
 */
//@Singleton
@Startup
@Lock(LockType.READ)
public class AppConfig extends AppGenericConfig{
    @PostConstruct
    public void init() {
        InputStream xml = null;
        //Buscar en resource/config archivos de configuración.
        try {
            //System        
            xml = IOUtil.getResourceAsStream(getClass(), "/config/system.xml");
            Document dom = DomW3cParser.loadXml(xml);
            config.put("SYSTEM", dom);
            String edicion = DomW3cParser.getPropertyValue(dom, "edicion", "/Configuration/Sistema");
            edicion = decode64(edicion);
            //Ediciones
            xml = IOUtil.getResourceAsStream(getClass(), "/config/ediciones.xml");
            //Solo el nodo correspondiente a la edición.        
            dom = DomW3cParser.newDocument();
            Element root = (Element)DomW3cParser.
                    selectSingleNode(DomW3cParser.loadXml(xml), edicion);
            dom.appendChild(dom.adoptNode(root.cloneNode(true)));
            config.put("EDICIONES", dom);
        } catch (Exception ex) {
            ErrorManager.showError(ex, LOGGER);
        } finally {
            IOUtils.closeQuietly(xml);
        }
    }
}


