/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdempresa", query = "SELECT e FROM Empresa e WHERE e.idempresa = :idempresa"),
    @NamedQuery(name = "Empresa.findByIdempresamask", query = "SELECT e FROM Empresa e WHERE e.idempresamask = :idempresamask"),
    @NamedQuery(name = "Empresa.findByIdperiodo", query = "SELECT e FROM Empresa e WHERE e.idperiodo = :idperiodo"),
    @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empresa.findByRazonsocial", query = "SELECT e FROM Empresa e WHERE e.razonsocial = :razonsocial"),
    @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresa.findByTelefono", query = "SELECT e FROM Empresa e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empresa.findByRuc", query = "SELECT e FROM Empresa e WHERE e.ruc = :ruc"),
    @NamedQuery(name = "Empresa.findByDatos", query = "SELECT e FROM Empresa e WHERE e.datos = :datos"),
    @NamedQuery(name = "Empresa.findByMenu", query = "SELECT e FROM Empresa e WHERE e.menu = :menu"),
    @NamedQuery(name = "Empresa.findByFilesystem", query = "SELECT e FROM Empresa e WHERE e.filesystem = :filesystem"),
    @NamedQuery(name = "Empresa.findByLogo", query = "SELECT e FROM Empresa e WHERE e.logo = :logo"),
    @NamedQuery(name = "Empresa.findByMotordatos", query = "SELECT e FROM Empresa e WHERE e.motordatos = :motordatos"),
    @NamedQuery(name = "Empresa.findByPais", query = "SELECT e FROM Empresa e WHERE e.pais = :pais"),
    @NamedQuery(name = "Empresa.findByEmpresarubro", query = "SELECT e FROM Empresa e WHERE e.empresarubro = :empresarubro"),
    @NamedQuery(name = "Empresa.findByFechacreacion", query = "SELECT e FROM Empresa e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Empresa.findByFechamodificacion", query = "SELECT e FROM Empresa e WHERE e.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "Empresa.findByFechareplicacion", query = "SELECT e FROM Empresa e WHERE e.fechareplicacion = :fechareplicacion"),
    @NamedQuery(name = "Empresa.findByFirma", query = "SELECT e FROM Empresa e WHERE e.firma = :firma"),
    @NamedQuery(name = "Empresa.findByAppuser", query = "SELECT e FROM Empresa e WHERE e.appuser = :appuser")})
public class Empresa extends DataRow implements IEmpresa {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    @Column(name = "idempresamask")
    private Long idempresamask;
    @Column(name = "idperiodo")
    private Long idperiodo;
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
    @Size(max = 50)
    @Column(name = "motordatos")
    private String motordatos;
    @Size(max = 4)
    @Column(name = "pais")
    private String pais;
    @Size(max = 10)
    @Column(name = "empresarubro")
    private String empresarubro;
    
    
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


    @Column(name = "idempresagrupo")
    private Long idempresagrupo;

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
        return idperiodo;
    }

    @Override
    public void setIdperiodo(Long idperiodo) {
        this.idperiodo = idperiodo;
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
        return motordatos;
    }

    @Override
    public void setMotordatos(String motordatos) {
        this.motordatos = motordatos;
    }

    @Override
    public String getPais() {
        return pais;
    }

    @Override
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String getEmpresarubro() {
        return empresarubro;
    }

    @Override
    public void setEmpresarubro(String empresarubro) {
        this.empresarubro = empresarubro;
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
    public Long getIdempresagrupo() {
        return idempresagrupo;
    }

    @Override
    public void setIdempresagrupo(Long idempresagrupo) {
        this.idempresagrupo = idempresagrupo;
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
    public String toString() {
        return "py.com.oym.model.Empresa[ idempresa=" + idempresa + " ]";
    }
}
