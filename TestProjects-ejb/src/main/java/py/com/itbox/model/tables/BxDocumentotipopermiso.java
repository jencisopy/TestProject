/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.io.Serializable;
import java.util.Objects;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import py.com.oym.frame.data.DataRow;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "bx_documentotipopermiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxDocumentotipopermiso.findAll", query = "SELECT b FROM BxDocumentotipopermiso b")})
public class BxDocumentotipopermiso extends DataRow {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_documentotipopermiso")
    private Long idbxDocumentotipopermiso;
    
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "idbx_documentotipo")
//    private long idbxDocumentotipo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private long idusuario;

    @JoinColumn(name = "idbx_documentotipo", referencedColumnName = "idbx_documentotipo")
    @ManyToOne(optional = false)
    private BxDocumentotipo bxDocumentotipo; 
    
    public BxDocumentotipopermiso() {
    }



    public Long getIdbxDocumentotipopermiso() {
        return idbxDocumentotipopermiso;
    }

    public void setIdbxDocumentotipopermiso(Long idbxDocumentotipopermiso) {
        this.idbxDocumentotipopermiso = idbxDocumentotipopermiso;
    }

//    public long getIdbxDocumentotipo() {
//        return idbxDocumentotipo;
//    }
//
//    public void setIdbxDocumentotipo(long idbxDocumentotipo) {
//        this.idbxDocumentotipo = idbxDocumentotipo;
//    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public BxDocumentotipo getBxDocumentotipo() {
        return bxDocumentotipo;
    }

    public void setBxDocumentotipo(BxDocumentotipo bxDocumentotipo) {
        this.bxDocumentotipo = bxDocumentotipo;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxDocumentotipopermiso != null ? idbxDocumentotipopermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxDocumentotipopermiso)) {
            return false;
        }
        if (idbxDocumentotipopermiso == null || idbxDocumentotipopermiso == 0L){
            return equivalent(object);
        }
        BxDocumentotipopermiso other = (BxDocumentotipopermiso) object;
        if ((this.idbxDocumentotipopermiso == null && other.idbxDocumentotipopermiso != null) || (this.idbxDocumentotipopermiso != null && !this.idbxDocumentotipopermiso.equals(other.idbxDocumentotipopermiso))) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxDocumentotipopermiso)) {
            return false;
        }
        BxDocumentotipopermiso obj = (BxDocumentotipopermiso) o;
        return (this.idbxDocumentotipopermiso.equals(obj.getIdbxDocumentotipopermiso())) ;
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxDocumentotipopermiso[ idbxDocumentotipopermiso=" + idbxDocumentotipopermiso + " ]";
    }
    
}
