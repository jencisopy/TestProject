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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_plantilladetalle",uniqueConstraints=@UniqueConstraint(columnNames={"idbx_plantilla","idbx_campo"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxPlantilladetalle.findAll", query = "SELECT b FROM BxPlantilladetalle b")})
public class BxPlantilladetalle extends DataRow {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_plantilladetalle")
    private Long idbxPlantilladetalle;

    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;

    @Size(max = 100)
    @Column(name = "valor_defecto")
    private String valorDefecto;
    
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

    @JoinColumn(name = "idbx_plantilla", referencedColumnName = "idbx_plantilla",nullable = false)
    @ManyToOne(optional = true)
    private BxPlantilla bxPlantilla;
    
    @JoinColumn(name = "idbx_campo", referencedColumnName = "idbx_campo",nullable = false)
    @ManyToOne(optional = false)
    private BxCampo bxCampo;

    public BxPlantilladetalle() {
    }

    public BxPlantilladetalle(Long idbxPlantilladetalle) {
        this.idbxPlantilladetalle = idbxPlantilladetalle;
    }

    public BxPlantilladetalle(Long idbxPlantilladetalle, int orden) {
        this.idbxPlantilladetalle = idbxPlantilladetalle;
        this.orden = orden;
    }

    public Long getIdbxPlantilladetalle() {
        return idbxPlantilladetalle;
    }

    public void setIdbxPlantilladetalle(Long idbxPlantilladetalle) {
        this.idbxPlantilladetalle = idbxPlantilladetalle;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(String valorDefecto) {
        this.valorDefecto = valorDefecto;
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

    public BxPlantilla getBxPlantilla() {
        return bxPlantilla;
    }

    public void setBxPlantilla(BxPlantilla bxPlantilla) {
        this.bxPlantilla = bxPlantilla;
    }

    public BxCampo getBxCampo() {
        return bxCampo;
    }

    public void setBxCampo(BxCampo bxCampo) {
        this.bxCampo = bxCampo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxPlantilladetalle != null ? idbxPlantilladetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxPlantilladetalle)) {
            return false;
        }
        if (idbxPlantilladetalle == null || idbxPlantilladetalle == 0L){
            return equivalent(object);
        }
        BxPlantilladetalle other = (BxPlantilladetalle) object;
        if ((this.idbxPlantilladetalle == null && other.idbxPlantilladetalle != null) || (this.idbxPlantilladetalle != null && !this.idbxPlantilladetalle.equals(other.idbxPlantilladetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxPlantilladetalle)) {
            return false;
        }
        BxPlantilladetalle other = (BxPlantilladetalle) o;        
        return (getBxPlantilla().equals(other.getBxPlantilla()) && 
                getBxCampo().equals(other.getBxCampo()));
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxPlantilladetalle[ idbxPlantilladetalle=" + idbxPlantilladetalle + " ]";
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
