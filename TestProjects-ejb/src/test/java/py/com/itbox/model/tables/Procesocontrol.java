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
import py.com.oym.frame.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "procesocontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesocontrol.findAll", query = "SELECT p FROM Procesocontrol p")})
public class Procesocontrol extends DataRow {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprocesocontrol")
    private Long idprocesocontrol;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    
    @Column(name = "fechafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinal;
    
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    
    @Transient
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    
    @Size(max = 50)
    @Column(name = "maquina")
    private String maquina;

    @Column(name = "appuser")
    private String appuser;
    
    @Column(name = "ultimaactividad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaactividad;
    
    @Size(max = 200)
    @Column(name = "logfile")
    private String logfile;

    public Procesocontrol() {
    }

    public Procesocontrol(Long idprocesocontrol) {
        this.idprocesocontrol = idprocesocontrol;
    }

    public Procesocontrol(Long idprocesocontrol, Long idempresa, String nombre, Date fechainicio, Date fechacreacion, Date fechamodificacion) {
        this.idprocesocontrol = idprocesocontrol;
        this.idempresa = idempresa;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
    }

    public Long getIdprocesocontrol() {
        return idprocesocontrol;
    }

    public void setIdprocesocontrol(Long idprocesocontrol) {
        this.idprocesocontrol = idprocesocontrol;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Date getUltimaactividad() {
        return ultimaactividad;
    }

    public void setUltimaactividad(Date ultimaactividad) {
        this.ultimaactividad = ultimaactividad;
    }

    public String getLogfile() {
        return logfile;
    }

    public void setLogfile(String logfile) {
        this.logfile = logfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocesocontrol != null ? idprocesocontrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesocontrol)) {
            return false;
        }
        Procesocontrol other = (Procesocontrol) object;
        if ((this.idprocesocontrol == null && other.idprocesocontrol != null) || (this.idprocesocontrol != null && !this.idprocesocontrol.equals(other.idprocesocontrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.itbox.model.tables.Procesocontrol[ idprocesocontrol=" + idprocesocontrol + " ]";
    }

    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
