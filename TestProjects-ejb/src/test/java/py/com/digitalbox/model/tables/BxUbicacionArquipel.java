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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.javabeanstack.data.DataRow;

@Entity
@Table(name = "bx_ubicacionarquipel",uniqueConstraints=@UniqueConstraint(columnNames={"idbx_ubicacionbalda","codigo"}))
public class BxUbicacionArquipel extends DataRow {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_ubicacionarquipel")
    private Long idbxUbicacionarquipel;
    
    @JoinColumn(name = "idbx_ubicacionbalda", referencedColumnName = "idbx_ubicacionbalda")
    @ManyToOne(optional = false)
    private BxUbicacionBalda bxUbicacionBalda = new BxUbicacionBalda();
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
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
    
    public BxUbicacionArquipel() {
    }

    public Long getIdbxUbicacionarquipel() {
        return idbxUbicacionarquipel;
    }

    public void setIdbxUbicacionarquipel(Long idbxUbicacionarquipel) {
        this.idbxUbicacionarquipel = idbxUbicacionarquipel;
    }

    public Long getIdempresa(){
        if (getBxUbicacionBalda() == null){
            return null;
        }
        return getBxUbicacionBalda().getBxUbicacionEstante().
                getBxUbicacionModulo().getIdempresa();
    }    
    
    public BxUbicacionBalda getBxUbicacionBalda() {
        return bxUbicacionBalda;
    }

    public void setBxUbicacionBalda(BxUbicacionBalda bxUbicacionBalda) {
        this.bxUbicacionBalda = bxUbicacionBalda;
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
    

    @PrePersist    
    @PreUpdate
    public void preUpdate() {
        fechamodificacion = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idbxUbicacionarquipel);
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
        if (idbxUbicacionarquipel == null || idbxUbicacionarquipel == 0L){
            return equivalent(obj);
        }           
        final BxUbicacionArquipel other = (BxUbicacionArquipel) obj;
        return Objects.equals(this.idbxUbicacionarquipel, other.idbxUbicacionarquipel);
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxUbicacionArquipel)) {
            return false;
        }
        final BxUbicacionArquipel other = (BxUbicacionArquipel) o;
        return (this.codigo.trim().equals(other.getCodigo().trim()) && 
                Objects.equals(this.getIdempresa(), other.getIdempresa()));
    }
    
    @Override
    public String toString() {
        return "UbicacionArquipel{" + "idbxUbicacionarquipel=" + idbxUbicacionarquipel + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }

    @Override
    public Long getId() {
        return idbxUbicacionarquipel;
    }
}
