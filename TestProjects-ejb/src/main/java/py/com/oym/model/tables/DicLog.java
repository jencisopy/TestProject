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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import py.com.oym.frame.data.DataRow;
import py.com.oym.frame.model.ILogRecord;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "dic_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DicLog.findAll", query = "SELECT d FROM DicLog d")
    , @NamedQuery(name = "DicLog.findByIdlog", query = "SELECT d FROM DicLog d WHERE d.idlog = :idlog")
    , @NamedQuery(name = "DicLog.findBySesionid", query = "SELECT d FROM DicLog d WHERE d.sesionid = :sesionid")
    , @NamedQuery(name = "DicLog.findByMaquina", query = "SELECT d FROM DicLog d WHERE d.maquina = :maquina")
    , @NamedQuery(name = "DicLog.findByIdempresa", query = "SELECT d FROM DicLog d WHERE d.idempresa = :idempresa")
    , @NamedQuery(name = "DicLog.findByNroerror", query = "SELECT d FROM DicLog d WHERE d.nroerror = :nroerror")
    , @NamedQuery(name = "DicLog.findByNromensaje", query = "SELECT d FROM DicLog d WHERE d.nromensaje = :nromensaje")
    , @NamedQuery(name = "DicLog.findByClase", query = "SELECT d FROM DicLog d WHERE d.clase = :clase")
    , @NamedQuery(name = "DicLog.findByTipo", query = "SELECT d FROM DicLog d WHERE d.tipo = :tipo")})
public class DicLog extends DataRow implements ILogRecord {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    @Basic(optional = false)
    @Column(name = "idlog", nullable = false)
    private Long idlog;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sesionid", nullable = false, length = 30)
    private String sesionid;
    
    @Transient
    @Basic(optional = false)
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    
    @Column(name = "fechahoracliente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahoracliente;
    
    @Size(max = 50)
    @Column(name = "maquina", length = 50)
    private String maquina;

    @Column(name = "idusuario")
    private Long idusuario;
    
    @Column(name = "idempresa")
    private Long idempresa;
    
    @Column(name = "nroerror")
    private Integer nroerror;
    
    @Column(name = "nromensaje")
    private Integer nromensaje;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "mensaje", nullable = false, length = 2147483647)
    private String mensaje;
    
    @Column(name = "eleccion")
    private Integer eleccion;
    
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otros", length = 2147483647)
    private String otros;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "clase", nullable = false)
    @Size(max = 1)    
    private String clase;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo", nullable = false)
    @Size(max = 1)    
    private String tipo;
    
    @Size(max = 100)
    @Column(name = "objeto", length = 100)
    private String objeto;
    
    @Size(max = 100)
    @Column(name = "objetoelemento", length = 100)
    private String objetoelemento;
    
    @Column(name = "nrolinea")
    private Integer nrolinea;
    
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
    
    @Size(max = 32)
    @Column(name = "firma", length = 32)
    private String firma;

    public DicLog() {
    }

    public DicLog(Long idlog) {
        this.idlog = idlog;
    }

    public DicLog(Long idlog, String sesionid, Date fechahora, String mensaje, String clase, String tipo) {
        this.idlog = idlog;
        this.sesionid = sesionid;
        this.fechahora = fechahora;
        this.mensaje = mensaje;
        this.clase = clase;
        this.tipo = tipo;
    }

    @Override
    public Long getIdlog() {
        return idlog;
    }

    @Override
    public void setIdlog(Long idlog) {
        this.idlog = idlog;
    }

    @Override
    public String getSessionId() {
        return sesionid;
    }

    @Override
    public void setSessionId(String sessionId) {
        this.sesionid = sessionId;
    }

    @Override
    public Date getLogTime() {
        return fechahora;
    }

    @Override
    public void setLogTime(Date dateTime) {
        this.fechahora = dateTime;
    }

    @Override
    public Date getLogTimeOrigin() {
        return fechahoracliente;
    }

    @Override
    public void setLogTimeOrigin(Date dateTime) {
        this.fechahoracliente = dateTime;
    }

    @Override
    public String getOrigin() {
        return maquina;
    }

    @Override
    public void setOrigin(String origin) {
        this.maquina = origin;
    }

    @Override
    public Long getIdempresa() {
        return idempresa;
    }

    @Override
    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    @Override    
    public Long getIdusuario() {
        return idusuario;
    }

    @Override    
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    
    @Override
    public Integer getErrorNumber() {
        return nroerror;
    }

    @Override
    public void setErrorNumber(Integer errorNumber) {
        this.nroerror = errorNumber;
    }

    @Override
    public Integer getMessageNumber() {
        return nromensaje;
    }

    @Override
    public void setMessageNumber(Integer messageNumber) {
        this.nromensaje = messageNumber;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

    @Override
    public void setMessage(String message) {
        this.mensaje = message;
    }

    @Override
    public Integer getChoose() {
        return eleccion;
    }

    @Override
    public void setChoose(Integer choose) {
        this.eleccion = choose;
    }

    @Override
    public String getMessageInfo() {
        return otros;
    }

    @Override
    public void setMessageInfo(String messageInfo) {
        this.otros = messageInfo;
    }

    @Override
    public String getCategory() {
        return clase;
    }

    @Override
    public void setCategory(String category) {
        this.clase = category;
    }

    @Override
    public String getLevel() {
        return tipo;
    }

    @Override
    public void setLevel(String level) {
        this.tipo = level;
    }

    @Override
    public String getObject() {
        return objeto;
    }

    @Override
    public void setObject(String object) {
        this.objeto = object;
    }

    @Override
    public String getObjectElement() {
        return objetoelemento;
    }

    @Override
    public void setObjectElement(String objectElement) {
        this.objetoelemento = objectElement;
    }

    @Override
    public Integer getLineNumber() {
        return nrolinea;
    }

    @Override
    public void setLineNumber(Integer lineNumber) {
        this.nrolinea = lineNumber;
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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlog != null ? idlog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DicLog)) {
            return false;
        }
        DicLog other = (DicLog) object;
        if ((this.idlog == null && other.idlog != null) || (this.idlog != null && !this.idlog.equals(other.idlog))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof DicMensaje)) {
            return false;
        }
        return equals(o); 
    }
    
    @Override
    public String toString() {
        return "py.com.oym.model.tables.DicLog[ idlog=" + idlog + " ]";
    }
}
