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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@EntityListeners(BxCampoListener.class)
@Table(name = "bx_campo",uniqueConstraints=@UniqueConstraint(columnNames={"idempresa","codigo"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxCampo.findAll", query = "SELECT b FROM BxCampo b")})
public class BxCampo extends DataRow{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_campo")
    private Long idbxCampo;
    
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
    @Size(min = 1, max = 1)    
    @Column(name = "tipo")
    private String tipo;

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
    

    public BxCampo() {
    }


    public BxCampo(Long idbxCampo, Long idempresa, String codigo, String nombre, String tipo) {
        this.idbxCampo = idbxCampo;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getIdbxCampo() {
        return idbxCampo;
    }

    public void setIdbxCampo(Long idbxCampo) {
        this.idbxCampo = idbxCampo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idbxCampo != null ? idbxCampo.hashCode() : 0);
        return hash;
    }

    
    
//    @PostLoad
//    public void postLoad(){
//        System.out.println(idbxCampo);
//    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxCampo)) {
            return false;
        }
        if (getId() == null || (Long)getId() == 0L){
            return equivalent(object);
        }
        BxCampo other = (BxCampo) object;
        if ((this.idbxCampo == null && other.idbxCampo != null) || (this.idbxCampo != null && !this.idbxCampo.equals(other.idbxCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxCampo)) {
            return false;
        }
        BxCampo obj = (BxCampo) o;
        return (this.codigo.trim().equals(obj.getCodigo().trim()) && 
                Objects.equals(this.idempresa, obj.getIdempresa()));
    }

    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxCampo[ idbxCampo=" + idbxCampo + " ]";
    }
}
