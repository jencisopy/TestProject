/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Jorge Enciso
 */
public class BxCampoListener {
    @PreUpdate
    @PrePersist
    public void setLastUpdate(BxCampo o) {
        o.setFechamodificacion(new Date());
    }    
}
