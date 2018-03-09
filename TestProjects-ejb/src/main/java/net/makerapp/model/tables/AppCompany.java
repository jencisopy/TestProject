package net.makerapp.model.tables;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppCompany;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
public class AppCompany extends DataRow implements IAppCompany {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)    
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

    @Column(name = "logo2")
    private byte[] logo2;
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
    private List<AppCompany> empresaList;

    @Column(name = "idempresagrupo")
    private Long idempresagrupo;

    public AppCompany() {
    }

    public AppCompany(Long idempresa) {
        this.idempresa = idempresa;
    }

    public AppCompany(Long idempresa, String nombre) {
        this.idempresa = idempresa;
        this.nombre = nombre;
    }

    @Override
    public Long getIdcompany() {
        return idempresa;
    }

    @Override
    public void setIdcompany(Long idempresa) {
        this.idempresa = idempresa;
    }

    @Override
    public Long getIdcompanymask() {
        return idempresamask;
    }

    @Override
    public void setIdcompanymask(Long idempresamask) {
        this.idempresamask = idempresamask;
    }

    @Override
    public Long getIdperiod() {
        return idperiodo;
    }

    @Override
    public void setIdperiod(Long idperiodo) {
        this.idperiodo = idperiodo;
    }

    @Override
    public String getName() {
        return nombre;
    }

    @Override
    public void setName(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getSocialName() {
        return razonsocial;
    }

    @Override
    public void setSocialName(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    @Override
    public String getAddress() {
        return direccion;
    }

    @Override
    public void setAddress(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelephoneNumber() {
        return telefono;
    }

    @Override
    public void setTelephoneNumber(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getTaxId() {
        return ruc;
    }

    @Override
    public void setTaxId(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String getPersistentUnit() {
        return datos;
    }

    @Override
    public void setPersistentUnit(String datos) {
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
    public String getDbengine() {
        return motordatos;
    }

    @Override
    public void setDbengine(String motordatos) {
        this.motordatos = motordatos;
    }

    @Override
    public String getCountry() {
        return pais;
    }

    @Override
    public void setCountry(String pais) {
        this.pais = pais;
    }

    @Override
    public String getCompanyActivity() {
        return empresarubro;
    }

    @Override
    public void setCompanyActivity(String empresarubro) {
        this.empresarubro = empresarubro;
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
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    
    @Override
    public byte[] getLogo() {
        return logo2;
    }

    @Override
    public void setLogo(byte[] logo) {
        this.logo2 = logo;
    }
    
    @XmlTransient
    @Override
    public List<IAppCompany> getCompanyList() {
        return (List<IAppCompany>) (List<?>) empresaList;
    }

    @Override
    public void setCompanyList(List<IAppCompany> empresaList) {
        this.empresaList = (List<AppCompany>) (List<?>) empresaList;
    }

    @Override
    public Long getIdcompanygroup() {
        return idempresagrupo;
    }

    @Override
    public void setIdcompanygroup(Long idempresagrupo) {
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
        if (!(object instanceof AppCompany)) {
            return false;
        }
        AppCompany other = (AppCompany) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.Empresa[ idempresa=" + idempresa + " ]";
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppCompany)) {
            return false;
        }
        AppCompany obj = (AppCompany) o;
        return (this.idempresa.equals(obj.getIdcompany()));
    }

}
