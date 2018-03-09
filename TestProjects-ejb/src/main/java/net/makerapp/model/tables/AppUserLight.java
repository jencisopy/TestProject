package net.makerapp.model.tables;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppCompanyAllowed;
import org.javabeanstack.model.IAppUser;
import org.javabeanstack.model.IAppUserMember;

@Entity
@Table(name = "usuario")
public class AppUserLight extends DataRow implements IAppUser {

    private static final long serialVersionUID = 1L;

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

    @Size(max = 100)
    @Column(name = "email1")
    private String email1;

    @Size(max = 100)
    @Column(name = "email2")
    private String email2;
    
    @Size(max = 50)
    @Column(name = "telefono1")
    private String telefono1;

    @Size(max = 50)
    @Column(name = "celular1")
    private String celular1;

    @Size(max = 50)
    @Column(name = "celular2")
    private String celular2;
    
    @Column(name = "disable")
    private Boolean disable = false;

    @Column(name = "expira")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expira;

    @Size(max = 2)
    @Column(name = "rol")
    private String rol;

    @Column(name = "tipo")
    private Short tipo;

    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;

    @OneToMany(mappedBy = "usuarioMiembro")
    private List<AppUserMember> listaUsuarioMiembro = new ArrayList<>();

    @Column(name = "idempresa")
    private Long idempresa;

    public AppUserLight() {
    }

    @Override
    public Long getIduser() {
        return idusuario;
    }

    @Override
    public void setIduser(Long idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String getLogin() {
        if (codigo != null) {
            codigo = codigo.trim();
        }
        return codigo;
    }

    @Override
    public void setLogin(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getCode() {
        if (codigo != null) {
            codigo = codigo.trim();
        }
        return codigo;
    }

    @Override
    public void setCode(String code) {
        this.codigo = code;
    }

    @Override
    public String getFullName() {
        if (nombre != null) {
            nombre = nombre.trim();
        }
        return nombre;
    }

    @Override
    public void setFullName(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getPass() {
        if (clave != null) {
            clave = clave.trim();
        }
        return clave;
    }

    @Override
    public void setPass(String clave) {
        this.clave = clave;
    }

    @Override
    public String getPassConfirm() {
        if (clave2 != null) {
            clave2 = clave2.trim();
        }
        return clave2;
    }

    @Override
    public void setPassConfirm(String clave2) {
        this.clave2 = clave2;
    }

    @Override
    public String getDescription() {
        if (descripcion != null) {
            descripcion = descripcion.trim();
        }
        return descripcion;
    }

    @Override
    public void setDescription(String descripcion) {
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
    public Date getExpiredDate() {
        return expira;
    }

    @Override
    public void setExpiredDate(Date expira) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAppRol(String appRol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Short getType() {
        return tipo;
    }

    @Override
    public void setType(Short tipo) {
        this.tipo = tipo;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Override
    public List<IAppUserMember> getUserMemberList() {
        return (List<IAppUserMember>) (List<?>) listaUsuarioMiembro;
    }

    @Override
    public void setUserMemberList(List<IAppUserMember> listaUsuarioMiembro) {
        this.listaUsuarioMiembro = (List<AppUserMember>) (List<?>) listaUsuarioMiembro;
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
    public List<IAppCompanyAllowed> getAppCompanyAllowedList() {
        return null;
    }

    @Override
    public void setAppCompanyAllowedList(List<IAppCompanyAllowed> dicPermisoEmpresaList) {
        //this.dicPermisoEmpresaList = (List<DicPermisoEmpresa>)(List<?>)dicPermisoEmpresaList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUserLight other = (AppUserLight) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppUserLight)) {
            return false;
        }
        AppUserLight obj = (AppUserLight) o;
        return (this.codigo.trim().equals(obj.getLogin().trim()));
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", codigo=" + codigo + ", nombre=" + nombre + ", clave=" + clave + ", clave2=" + clave2 + ", descripcion=" + descripcion + ", disable=" + disable + ", expira=" + expira + ", rol=" + rol + ", tipo=" + tipo + '}';
    }

    @Override
    public byte[] getAvatar() {
        return null;
    }

    @Override
    public void setAvatar(byte[] avatar) {
    }


    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }
    
}
