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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "bx_repositorio",uniqueConstraints=@UniqueConstraint(columnNames={"idempresa","codigo"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxRepositorio.findAll", query = "SELECT b FROM BxRepositorio b")})
public class BxRepositorio extends DataRow {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_repositorio")
    private Long idbxRepositorio;
    
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
    @Size(min = 1, max = 255)
    @Column(name = "path1")
    private String path1;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "path2")
    private String path2;
    
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
    

    public BxRepositorio() {
    }

    public BxRepositorio(Long idbxRepositorio) {
        this.idbxRepositorio = idbxRepositorio;
    }

    public BxRepositorio(Long idbxRepositorio, Long idempresa, String codigo, String nombre, String path1, String path2) {
        this.idbxRepositorio = idbxRepositorio;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.path1 = path1;
        this.path2 = path2;
    }

    public Long getIdbxRepositorio() {
        return idbxRepositorio;
    }

    public void setIdbxRepositorio(Long idbxRepositorio) {
        this.idbxRepositorio = idbxRepositorio;
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

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path1) {
        this.path1 = path1;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxRepositorio != null ? idbxRepositorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxRepositorio)) {
            return false;
        }
        if (idbxRepositorio == null || idbxRepositorio == 0L){
            return equivalent(object);
        }
        BxRepositorio other = (BxRepositorio) object;
        if ((this.idbxRepositorio == null && other.idbxRepositorio != null) || (this.idbxRepositorio != null && !this.idbxRepositorio.equals(other.idbxRepositorio))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxRepositorio)) {
            return false;
        }
        BxRepositorio other = (BxRepositorio) o;
        return (this.codigo.trim().equals(other.getCodigo().trim()) && 
                Objects.equals(this.idempresa, other.getIdempresa()));
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxRepositorio[ idbxRepositorio=" + idbxRepositorio + " ]";
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
