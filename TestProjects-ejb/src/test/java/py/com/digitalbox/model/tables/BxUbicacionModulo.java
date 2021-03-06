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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.javabeanstack.data.DataRow;

@Entity
@Table(name = "bx_ubicacionmodulo",uniqueConstraints=@UniqueConstraint(columnNames={"idempresa","codigo"}))
public class BxUbicacionModulo extends DataRow {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_ubicacionmodulo")
    private Long idbxUbicacionmodulo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;

    
    @Basic(optional = false)
    @NotNull(message = "Código no válido")
    @Size(min = 1, max = 5, message = "El Código debe tener entre {min} y {max} caracteres")
    @Column(name = "codigo")
    private String codigo;
    
    @NotNull(message = "Descripción no válida")
    @Size(min=1, max = 50, message = "El Nombre debe tener entre {min} y {max} caracteres")
    @Column(name = "nombre")
    private String nombre;
    
    @Transient
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    
    
    public BxUbicacionModulo() {
    }

    public Long getIdbxUbicacionmodulo() {
        return idbxUbicacionmodulo;
    }

    public void setIdbxUbicacionmodulo(Long idbxUbicacionmodulo) {
        this.idbxUbicacionmodulo = idbxUbicacionmodulo;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
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

    public Date getFechacreacion() {
        return fechacreacion;
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
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idbxUbicacionmodulo);
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
        if (idbxUbicacionmodulo == null || idbxUbicacionmodulo == 0L){
            return equivalent(obj);
        }        
        final BxUbicacionModulo other = (BxUbicacionModulo) obj;
        return Objects.equals(this.idbxUbicacionmodulo, other.idbxUbicacionmodulo);
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxUbicacionModulo)) {
            return false;
        }
        final BxUbicacionModulo other = (BxUbicacionModulo) o;
        return (this.codigo.trim().equals(other.getCodigo().trim()) && 
                Objects.equals(this.idempresa, other.getIdempresa()));
    }
        
    @Override
    public String toString() {
        return "UbicacionModulo{" + "idbxUbicacionmodulo=" + idbxUbicacionmodulo + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}
