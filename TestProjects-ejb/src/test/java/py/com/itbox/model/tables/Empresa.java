/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.util.Date;
import java.util.List;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import py.com.oym.frame.data.DataRow;
import py.com.oym.frame.model.IEmpresa;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "SEQUENCE", allocationSize = 1, sequenceName = "EMPRESA_SEQ")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdempresa", query = "SELECT e FROM Empresa e WHERE e.idempresa = :idempresa"),
    @NamedQuery(name = "Empresa.findByAppuser", query = "SELECT e FROM Empresa e WHERE e.appuser = :appuser")})
public class Empresa extends DataRow implements IEmpresa {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    @Column(name = "idempresamask")
    private Long idempresamask;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 50)
    @Column(name = "datos")
    private String datos;
    @Size(max = 50)
    @Column(name = "menu")
    private String menu;
    @Size(max = 50)
    @Column(name = "filesystem")
    private String filesystem;
    @Size(max = 100)
    @Column(name = "logo")
    private String logo;
    
    
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
    @Column(name = "firma")
    private String firma;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;

    @OneToMany(mappedBy = "idempresagrupo")
    private List<Empresa> empresaList;

    @JoinColumn(name = "idempresagrupo", referencedColumnName = "idempresa")
    @ManyToOne
    private Empresa idempresagrupo;

    public Empresa() {
    }

    public Empresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public Empresa(Long idempresa, String nombre) {
        this.idempresa = idempresa;
        this.nombre = nombre;
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
    public Long getIdempresamask() {
        return idempresamask;
    }

    @Override
    public void setIdempresamask(Long idempresamask) {
        this.idempresamask = idempresamask;
    }

    @Override
    public Long getIdperiodo() {
        return null;
    }

    @Override
    public void setIdperiodo(Long idperiodo) {
        //this.idperiodo = idperiodo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getRazonsocial() {
        return razonsocial;
    }

    @Override
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getRuc() {
        return ruc;
    }

    @Override
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String getDatos() {
        return datos;
    }

    @Override
    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String getFilesystem() {
        return filesystem;
    }

    @Override
    public void setFilesystem(String filesystem) {
        this.filesystem = filesystem;
    }

    @Override
    public String getLogo() {
        return logo;
    }

    @Override
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String getMotordatos() {
        return null;
    }

    @Override
    public void setMotordatos(String motordatos) {
        //this.motordatos = motordatos;
    }

    @Override
    public String getPais() {
        return null;
    }

    @Override
    public void setPais(String pais) {
        //this.pais = pais;
    }

    @Override
    public String getEmpresarubro() {
        return null;
    }

    @Override
    public void setEmpresarubro(String empresarubro) {
        //this.empresarubro = empresarubro;
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
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    @Override
    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
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
    public String getFirma() {
        return firma;
    }

    @Override
    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    @XmlTransient
    @Override
    public List<IEmpresa> getEmpresaList() {
        return (List<IEmpresa>)(List<?>)empresaList;
    }

    @Override
    public void setEmpresaList(List<IEmpresa> empresaList) {
        this.empresaList = (List<Empresa>)(List<?>)empresaList;
    }

    @Override
    public IEmpresa getIdempresagrupo() {
        return idempresagrupo;
    }

    @Override
    public void setIdempresagrupo(IEmpresa idempresagrupo) {
        this.idempresagrupo = (Empresa)idempresagrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        return equals(o);
    }
    
    @Override
    public String toString() {
        return "py.com.oym.model.Empresa[ idempresa=" + idempresa + " ]";
    }

    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
    }
    
}
