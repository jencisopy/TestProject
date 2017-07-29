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
package py.com.digitalbox.model.tables;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.javabeanstack.data.DataRow;

@Entity
@Table(name = "bx_ubicacionbalda",uniqueConstraints=@UniqueConstraint(columnNames={"idbx_ubicacionestante","codigo"}))
public class BxUbicacionBalda extends DataRow {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_ubicacionbalda")
    private Long idbxUbicacionbalda;
    
    @JoinColumn(name = "idbx_ubicacionestante", referencedColumnName = "idbx_ubicacionestante")
    @ManyToOne(optional = false)
    private BxUbicacionEstante bxUbicacionEstante=new BxUbicacionEstante();
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    

    public BxUbicacionBalda() {
    }

    public Long getIdbxUbicacionbalda() {
        return idbxUbicacionbalda;
    }

    public void setIdbxUbicacionbalda(Long idbxUbicacionbalda) {
        this.idbxUbicacionbalda = idbxUbicacionbalda;
    }
    
     public BxUbicacionEstante getBxUbicacionEstante() {
        return bxUbicacionEstante;
    }

    public void setBxUbicacionEstante(BxUbicacionEstante bxUbicacionEstante) {
        this.bxUbicacionEstante = bxUbicacionEstante;
    }
    
    public Long getIdempresa(){
        if (getBxUbicacionEstante() == null){
            return null;
        }
        return getBxUbicacionEstante().getBxUbicacionModulo().getIdempresa();
    }    

    public String getCodigo() {
        if(codigo != null) {
            codigo = codigo.trim();
        }
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        if(nombre != null) {
            nombre = nombre.trim();
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }
        
    @PreUpdate
    @PrePersist    
    public void preUpdate() {
        fechamodificacion = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idbxUbicacionbalda);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (idbxUbicacionbalda == null || idbxUbicacionbalda == 0L){
            return equivalent(obj);
        }           
        final BxUbicacionBalda other = (BxUbicacionBalda) obj;
        return Objects.equals(this.idbxUbicacionbalda, other.idbxUbicacionbalda);
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxUbicacionBalda)) {
            return false;
        }
        final BxUbicacionBalda other = (BxUbicacionBalda) o;
        return (this.codigo.trim().equals(other.getCodigo().trim()) && 
                Objects.equals(this.getIdempresa(), other.getIdempresa()));
    }
    
    @Override
    public String toString() {
        return "UbicacionBalda{" + "idbxUbicacionbalda=" + idbxUbicacionbalda + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}
