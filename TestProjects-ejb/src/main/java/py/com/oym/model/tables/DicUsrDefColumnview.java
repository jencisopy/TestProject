/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import py.com.oym.frame.data.DataRow;
import py.com.oym.frame.data.IDataRow;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "dic_usrdef_columnview")
public class DicUsrDefColumnview extends DataRow implements Serializable, IDataRow {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 30)
    @Column(name = "xhtml")
    private String xhtml;
    @Column(name = "columna")
    private String columna;
    @Column(name = "header")
    private String header;
    @Size(max = 30)
    @Column(name = "idcolumn")
    private String idcolumn;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "indice")
    private Long indice;
    @Column(name = "iduser")
    private Long iduser;

    public DicUsrDefColumnview() {
    }

    public DicUsrDefColumnview(Long id) {
        this.id = id;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXhtml() {
        return xhtml;
    }

    public void setXhtml(String xhtml) {
        this.xhtml = xhtml;
    }

    public String getIdcolumn() {
        return idcolumn;
    }

    public void setIdcolumn(String idcolumn) {
        this.idcolumn = idcolumn;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Long getIndice() {
        return indice;
    }

    public void setIndice(Long indice) {
        this.indice = indice;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DicUsrDefColumnview)) {
            return false;
        }
        DicUsrDefColumnview other = (DicUsrDefColumnview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.UsrDefColumnview[ id=" + id + " ]";
    }
    
}
