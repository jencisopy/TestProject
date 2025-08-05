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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_plantilla",uniqueConstraints=@UniqueConstraint(columnNames={"idempresa","codigo"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxPlantilla.findAll", query = "SELECT b FROM BxPlantilla b")})
public class BxPlantilla extends DataRow {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_plantilla")
    private Long idbxPlantilla;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "inactivo")
    private boolean inactivo=false;
    
    @Transient
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion = new Date();
    
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;

    @Column(name = "appuser")
    private String appuser;

    @OneToMany(mappedBy = "bxPlantilla")
    @OrderBy("orden ASC")
    private List<BxPlantilladetalle> bxPlantilladetalle=new ArrayList(); 
    

    public BxPlantilla() {
    }

    public BxPlantilla(Long idbxPlantilla) {
        this.idbxPlantilla = idbxPlantilla;
    }

    public BxPlantilla(Long idbxPlantilla, Long idempresa, String codigo, String nombre) {
        this.idbxPlantilla = idbxPlantilla;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdbxPlantilla() {
        return idbxPlantilla;
    }

    public void setIdbxPlantilla(Long idbxPlantilla) {
        this.idbxPlantilla = idbxPlantilla;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
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

    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    @XmlTransient
    public List<BxPlantilladetalle> getBxPlantilladetalle() {
        return bxPlantilladetalle;
    }

    public void setBxPlantilladetalle(List<BxPlantilladetalle> bxPlantilladetalleList) {
        this.bxPlantilladetalle = bxPlantilladetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxPlantilla != null ? idbxPlantilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxPlantilla)) {
            return false;
        }
        if (idbxPlantilla == null || idbxPlantilla == 0L){
            return equivalent(object);
        }
        BxPlantilla other = (BxPlantilla) object;
        if ((this.idbxPlantilla == null && other.idbxPlantilla != null) || (this.idbxPlantilla != null && !this.idbxPlantilla.equals(other.idbxPlantilla))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxPlantilla)) {
            return false;
        }
        BxPlantilla other = (BxPlantilla) o;
        return (this.codigo.trim().equals(other.getCodigo().trim()) && 
                Objects.equals(this.idempresa, other.getIdempresa()));
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxPlantilla[ idbxPlantilla=" + idbxPlantilla + " ]";
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
