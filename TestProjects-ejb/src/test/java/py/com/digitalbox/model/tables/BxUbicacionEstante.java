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
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.javabeanstack.data.DataRow;

@Entity
@Table(name = "bx_ubicacionestante",uniqueConstraints=@UniqueConstraint(columnNames={"idbx_ubicacionmodulo","codigo"}))
public class BxUbicacionEstante extends DataRow{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_ubicacionestante")
    private Long idbxUbicacionestante;
    
    @JoinColumn(name = "idbx_ubicacionmodulo", referencedColumnName = "idbx_ubicacionmodulo")
    @ManyToOne(optional = false)
    private BxUbicacionModulo bxUbicacionModulo=new BxUbicacionModulo();
    
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
    
    public BxUbicacionEstante() {
    }

    public Long getIdbxUbicacionestante() {
        return idbxUbicacionestante;
    }

    public void setIdbxUbicacionestante(Long idbxUbicacionestante) {
        this.idbxUbicacionestante = idbxUbicacionestante;
    }

    public BxUbicacionModulo getBxUbicacionModulo() {
        return bxUbicacionModulo;
    }

    public void setBxUbicacionModulo(BxUbicacionModulo bxUbicacionModulo) {
        this.bxUbicacionModulo = bxUbicacionModulo;
    }

    public Long getIdempresa(){
        if (getBxUbicacionModulo() == null){
            return null;
        }
        return getBxUbicacionModulo().getIdempresa();
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

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
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
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idbxUbicacionestante);
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
        if (idbxUbicacionestante == null || idbxUbicacionestante == 0L){
            return equivalent(obj);
        }          
        final BxUbicacionEstante other = (BxUbicacionEstante) obj;
        return (!Objects.equals(this.idbxUbicacionestante, other.idbxUbicacionestante));
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxUbicacionEstante)) {
            return false;
        }
        final BxUbicacionEstante other = (BxUbicacionEstante) o;
        return (this.codigo.trim().equals(other.getCodigo().trim()) && 
                Objects.equals(this.getIdempresa(), other.getIdempresa()));
    }

    @Override
    public String toString() {
        return "UbicacionEstante{" + "idbxUbicacionestante=" + idbxUbicacionestante + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}
