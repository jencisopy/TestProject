/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import py.com.oym.frame.data.DataRow;
import py.com.oym.frame.model.IDicMensaje;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "dic_mensaje", uniqueConstraints = {
                                @UniqueConstraint(columnNames = {"nro"})})
@XmlRootElement
public class DicMensaje extends DataRow implements IDicMensaje {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmensaje", nullable = false)
    private Long idmensaje;
    
    @Column(name = "nro")
    private Long nro;
    
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "explicacion", length = 2147483647)
    private String explicacion;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;

    @Transient
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    
    @Size(max = 32)
    @Column(name = "appuser", length = 32)
    private String appuser;

    public DicMensaje() {
    }

    public DicMensaje(Long idmensaje) {
        this.idmensaje = idmensaje;
    }

    @Override
    public Long getIdmensaje() {
        return idmensaje;
    }

    @Override
    public void setIdmensaje(Long idmensaje) {
        this.idmensaje = idmensaje;
    }

    @Override
    public Long getNro() {
        return nro;
    }

    @Override
    public void setNro(Long nro) {
        this.nro = nro;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getExplicacion() {
        return explicacion;
    }

    @Override
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    @Override
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    @Override
    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Override
    public Date getFechacreacion() {
        return fechacreacion;
    }

    @Override
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public Date getFechareplicacion() {
        return fechareplicacion;
    }

    @Override
    public void setFechareplicacion(Date fechareplicacion) {
        this.fechareplicacion = fechareplicacion;
    }

    @Override
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensaje != null ? idmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DicMensaje)) {
            return false;
        }
        if (idmensaje == null || idmensaje == 0L){
            return equivalent(object);
        }
        DicMensaje other = (DicMensaje) object;
        return this.idmensaje.equals(other.idmensaje);
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof DicMensaje)) {
            return false;
        }
        DicMensaje other = (DicMensaje) o;
        return (this.nro.equals(other.getNro())); 
    }

    @Override
    public String toString() {
        return "py.com.oym.model.tables.DicMensaje[ idmensaje=" + idmensaje + " ]";
    }
    
}
