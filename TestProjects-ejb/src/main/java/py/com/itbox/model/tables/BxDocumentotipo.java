/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import py.com.oym.frame.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_documentotipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxDocumentotipo.findAll", query = "SELECT b FROM BxDocumentotipo b"),
    @NamedQuery(name = "BxDocumentotipo.findAllWs", query = "SELECT idbxDocumentotipo,idempresa,codigo,nombre,folder FROM BxDocumentotipo b")
})
public class BxDocumentotipo extends DataRow {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_documentotipo")
    private Long idbxDocumentotipo;
    
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

    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "folder")
    private String folder;
    
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
    
    @JoinColumn(name = "idbx_repositorio", referencedColumnName = "idbx_repositorio",nullable = false)
    @ManyToOne(optional = false)
    private BxRepositorio bxRepositorio;

    @JoinColumn(name = "idbx_plantilla", referencedColumnName = "idbx_plantilla", nullable = false)
    @ManyToOne(optional = false)
    private BxPlantilla bxPlantilla;

    @OneToMany(mappedBy = "bxDocumentotipo")
    private List<BxDocumentotipopermiso> listaUsuarioPermiso = new ArrayList<>();
    
    public BxDocumentotipo() {
    }

    public BxDocumentotipo(Long idbxDocumentotipo) {
        this.idbxDocumentotipo = idbxDocumentotipo;
    }

    public BxDocumentotipo(Long idbxDocumentotipo, Long idempresa, String codigo, String nombre) {
        this.idbxDocumentotipo = idbxDocumentotipo;
        this.idempresa = idempresa;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdbxDocumentotipo() {
        return idbxDocumentotipo;
    }

    public void setIdbxDocumentotipo(Long idbxDocumentotipo) {
        this.idbxDocumentotipo = idbxDocumentotipo;
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


    public BxRepositorio getBxRepositorio() {
        return bxRepositorio;
    }

    public void setBxRepositorio(BxRepositorio idbxRepositorio) {
        this.bxRepositorio = idbxRepositorio;
    }

    public BxPlantilla getBxPlantilla() {
        return bxPlantilla;
    }

    public void setBxPlantilla(BxPlantilla idbxPlantilla) {
        this.bxPlantilla = idbxPlantilla;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @XmlTransient
    public List<BxDocumentotipopermiso> getListaUsuarioPermiso() {
        return listaUsuarioPermiso;
    }

    public void setListaUsuarioPermiso(List<BxDocumentotipopermiso> listaUsuarioPermiso) {
        this.listaUsuarioPermiso = listaUsuarioPermiso;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxDocumentotipo != null ? idbxDocumentotipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxDocumentotipo)) {
            return false;
        }
        if (idbxDocumentotipo == null || idbxDocumentotipo == 0L){
            return equivalent(object);
        }
        BxDocumentotipo other = (BxDocumentotipo) object;
        if ((this.idbxDocumentotipo == null && other.idbxDocumentotipo != null) || (this.idbxDocumentotipo != null && !this.idbxDocumentotipo.equals(other.idbxDocumentotipo))) {
            return false;
        }
        return true;
    }

    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxDocumentotipo)) {
            return false;
        }
        BxDocumentotipo obj = (BxDocumentotipo) o;
        return (this.codigo.trim().equals(obj.getCodigo().trim()) && 
                Objects.equals(this.idempresa, obj.getIdempresa()));
    }
    
    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxDocumentotipo[ idbxDocumentotipo=" + idbxDocumentotipo + " ]";
    }
    
}
