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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import py.com.oym.frame.data.DataRow;
import py.com.oym.frame.model.IDicPermisoEmpresa;
import py.com.oym.frame.model.IUsuario;
import py.com.oym.frame.model.IUsuarioMiembro;
import py.com.oym.frame.util.Fn;

@Entity
@Table(name = "usuario")
public class Usuario extends DataRow implements IUsuario {

    private static final long serialVersionUID = 1L;
    static Logger logger = Logger.getLogger(Usuario.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Long idusuario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigo")
    private String codigo;

    @Basic(optional = false)
    @NotNull(message = "Debe ingresar el nombre de usuario")
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @Transient
    private String clave2;

    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "disable")
    private Boolean disable = false;

    @Column(name = "expira")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expira;

    @Size(max = 2)
    @Column(name = "rol")
    private String rol;

    @Size(max = 100)
    @Column(name = "approl")
    private String approl;

    @Column(name = "tipo")
    private Short tipo;

    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;

    @OneToMany(mappedBy = "usuarioMiembro")
    private List<UsuarioMiembro> listaUsuarioMiembro = new ArrayList<>();

    @Column(name = "idempresa")
    private Long idempresa;

    public Usuario() {
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
    public String getCodigo() {
        if (codigo != null) {
            codigo = codigo.trim();
        }
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNombre() {
        if (nombre != null) {
            nombre = nombre.trim();
        }
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getClave() {
        if (clave != null) {
            clave = clave.trim();
        }
        return clave;
    }

    @Override
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String getClave2() {
        if (clave2 != null) {
            clave2 = clave2.trim();
        }
        return clave2;
    }

    @Override
    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    @Override
    public String getDescripcion() {
        if (descripcion != null) {
            descripcion = descripcion.trim();
        }
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Boolean getDisable() {
        return disable;
    }

    @Override
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    @Override
    public Date getExpira() {
        return expira;
    }

    @Override
    public void setExpira(Date expira) {
        this.expira = expira;
    }

    @Override
    public String getRol() {
        if (rol != null) {
            rol = rol.trim();
        }
        return rol;
    }

    @Override
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String getAppRol() {
        if (approl == null) {
            return "";
        } else {
            return approl.trim();
        }
    }

    @Override
    public void setAppRol(String approl) {
        this.approl = approl;
    }

    @Override
    public Short getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(Short tipo) {
        this.tipo = tipo;
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
    public List<IUsuarioMiembro> getListaUsuarioMiembro() {
        return (List<IUsuarioMiembro>) (List<?>) listaUsuarioMiembro;
    }

    @Override
    public void setListaUsuarioMiembro(List<IUsuarioMiembro> listaUsuarioMiembro) {
        this.listaUsuarioMiembro = (List<UsuarioMiembro>) (List<?>) listaUsuarioMiembro;
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
    public List<IDicPermisoEmpresa> getDicPermisoEmpresaList() {
        return null;
    }

    @Override
    public void setDicPermisoEmpresaList(List<IDicPermisoEmpresa> dicPermisoEmpresaList) {
        //this.dicPermisoEmpresaList = (List<DicPermisoEmpresa>)(List<?>)dicPermisoEmpresaList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idusuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idusuario == null || idusuario == 0L) {
            return equivalent(obj);
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario obj = (Usuario) o;
        return (this.codigo.trim().equals(obj.getCodigo().trim()));
    }

    @Override
    public String toString() {
        return "idusuario=" + idusuario;
    }

    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
        if (expira == null) {
            expira = Fn.toDate("31/12/9999");
        }
    }

}
