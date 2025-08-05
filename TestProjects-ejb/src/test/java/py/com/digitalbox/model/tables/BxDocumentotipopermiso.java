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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "bx_documentotipopermiso",uniqueConstraints=@UniqueConstraint(columnNames={"idbx_documentotipo","idusuario"}))
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
