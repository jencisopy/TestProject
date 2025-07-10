/*
* JavaBeanStack FrameWork
*
* Copyright (C) 2017 Jorge Enciso
* Email: jorge.enciso.r@gmail.com
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 3 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA 02110-1301  USA
 */
package org.javabeanstack.log;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.javabeanstack.model.IAppLogRecord;

/**
 * Su función es gestionar la escritura y lectura del log del sistema.
 *
 * @author Jorge Enciso
 */
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LogMngrData extends LogManager {
    /**
     * Escribe información de un evento en una tabla de la base de datos.
     *
     * @param <T>
     * @param logRecord registro del evento.
     * @param sessionId identificador de la sesión del usuario
     * @return verdadero si tuvo exito y falso si no.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public <T extends IAppLogRecord> boolean dbWrite(T logRecord, String sessionId) {
        logRecord.setCategory(IAppLogRecord.CATEGORY_DATA);
        return super.dbWrite(logRecord, sessionId);
    }

}
