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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_documentodetalle",uniqueConstraints=@UniqueConstraint(columnNames={"idbx_documento","idbx_campo"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxDocumentodetalle.findAll", query = "SELECT b FROM BxDocumentodetalle b")})
public class BxDocumentodetalle extends DataRow {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_documentodetalle")
    private Long idbxDocumentodetalle;
    
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

    @JoinColumn(name = "idbx_documento", referencedColumnName = "idbx_documento", nullable = false)
    @ManyToOne(optional = false)
    private BxDocumento bxDocumento;

    @JoinColumn(name = "idbx_campo", referencedColumnName = "idbx_campo", nullable = false)
    @ManyToOne(optional = false)
    private BxCampo bxCampo;

    public BxDocumentodetalle() {
    }


    public Long getIdbxDocumentodetalle() {
        return idbxDocumentodetalle;
    }

    public void setIdbxDocumentodetalle(Long idbxDocumentodetalle) {
        this.idbxDocumentodetalle = idbxDocumentodetalle;
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

    public BxDocumento getBxDocumento() {
        return bxDocumento;
    }

    public void setBxDocumento(BxDocumento bxDocumento) {
        this.bxDocumento = bxDocumento;
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
        hash += (idbxDocumentodetalle != null ? idbxDocumentodetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxDocumentodetalle)) {
            return false;
        }
        if (idbxDocumentodetalle == null || idbxDocumentodetalle == 0L){
            return equivalent(object);
        }
        BxDocumentodetalle other = (BxDocumentodetalle) object;
        if ((this.idbxDocumentodetalle == null && other.idbxDocumentodetalle != null) || (this.idbxDocumentodetalle != null && !this.idbxDocumentodetalle.equals(other.idbxDocumentodetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxDocumentodetalle)) {
            return false;
        }
        BxDocumentodetalle other = (BxDocumentodetalle) o;        
        return (getBxDocumento().equals(other.getBxDocumento()) && 
                getBxCampo().equals(other.getBxCampo()));
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxDocumentodetalle[ idbxDocumentodetalle=" + idbxDocumentodetalle + " ]";
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
