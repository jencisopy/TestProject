/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import py.com.oym.frame.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_plantilladetalle")
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

    @Basic(optional = false)
    @Column(name = "obligatorio")
    private boolean obligatorio=false;  
    
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

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
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
