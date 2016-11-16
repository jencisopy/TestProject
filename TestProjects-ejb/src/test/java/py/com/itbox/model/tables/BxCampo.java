/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/**
 *
 * @author Jorge Enciso
 */
@Entity
@EntityListeners(BxCampoListener.class)
@Table(name = "bx_campo")
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
