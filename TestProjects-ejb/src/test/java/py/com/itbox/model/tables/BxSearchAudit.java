/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import py.com.oym.frame.data.DataRow;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "bx_search_audit")
@NamedQueries({
    @NamedQuery(name = "BxSearchAudit.findAll", query = "SELECT b FROM BxSearchAudit b")})
public class BxSearchAudit extends DataRow {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbx_index")
    private BigInteger idbxIndex;
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_search_audit")
    private BigDecimal idbxSearchAudit;

    public BxSearchAudit() {
    }

    public BxSearchAudit(BigDecimal idbxSearchAudit) {
        this.idbxSearchAudit = idbxSearchAudit;
    }

    public BxSearchAudit(BigDecimal idbxSearchAudit, BigInteger idbxIndex) {
        this.idbxSearchAudit = idbxSearchAudit;
        this.idbxIndex = idbxIndex;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BigInteger getIdbxIndex() {
        return idbxIndex;
    }

    public void setIdbxIndex(BigInteger idbxIndex) {
        this.idbxIndex = idbxIndex;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public BigDecimal getIdbxSearchAudit() {
        return idbxSearchAudit;
    }

    public void setIdbxSearchAudit(BigDecimal idbxSearchAudit) {
        this.idbxSearchAudit = idbxSearchAudit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxSearchAudit != null ? idbxSearchAudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BxSearchAudit)) {
            return false;
        }
        BxSearchAudit other = (BxSearchAudit) object;
        if ((this.idbxSearchAudit == null && other.idbxSearchAudit != null) || (this.idbxSearchAudit != null && !this.idbxSearchAudit.equals(other.idbxSearchAudit))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        return equals(o);
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxSearchAudit[ idbxSearchAudit=" + idbxSearchAudit + " ]";
    }
    
}
