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
@Table(name = "bx_indexdetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxIndexdetalle.findAll", query = "SELECT b FROM BxIndexdetalle b")})
public class BxIndexdetalle extends DataRow {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_indexdetalle")
    private Long idbxIndexdetalle;
    
    @Size(max = 200)
    @Column(name = "bx_campovalor")
    private String bxCampovalor;
    
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

    @JoinColumn(name = "idbx_index", referencedColumnName = "idbx_index", nullable = false)
    @ManyToOne(optional = false)
    private BxIndex bxIndex;

    @JoinColumn(name = "idbx_campo", referencedColumnName = "idbx_campo", nullable = false)
    @ManyToOne(optional = false)
    private BxCampo bxCampo;

    public BxIndexdetalle() {
    }

    public BxIndexdetalle(Long idbxIndexdetalle) {
        this.idbxIndexdetalle = idbxIndexdetalle;
    }


    public Long getIdbxIndexdetalle() {
        return idbxIndexdetalle;
    }

    public void setIdbxIndexdetalle(Long idbxIndexdetalle) {
        this.idbxIndexdetalle = idbxIndexdetalle;
    }

    public String getBxCampovalor() {
        return bxCampovalor;
    }

    public void setBxCampovalor(String bxCampovalor) {
        this.bxCampovalor = bxCampovalor;
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
    public BxIndex getBxIndex() {
        return bxIndex;
    }

    public void setBxIndex(BxIndex bxIndex) {
        this.bxIndex = bxIndex;
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
        hash += (idbxIndexdetalle != null ? idbxIndexdetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxIndexdetalle)) {
            return false;
        }
        if (idbxIndexdetalle == null || idbxIndexdetalle == 0L){
            return equivalent(object);
        }
        BxIndexdetalle other = (BxIndexdetalle) object;
        if ((this.idbxIndexdetalle == null && other.idbxIndexdetalle != null) || (this.idbxIndexdetalle != null && !this.idbxIndexdetalle.equals(other.idbxIndexdetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxIndexdetalle)) {
            return false;
        }
        BxIndexdetalle other = (BxIndexdetalle) o;        
        return (getBxIndex().equals(other.getBxIndex()) && 
                getBxCampo().equals(other.getBxCampo()));
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxIndexdetalle[ idbxIndexdetalle=" + idbxIndexdetalle + " ]";
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
