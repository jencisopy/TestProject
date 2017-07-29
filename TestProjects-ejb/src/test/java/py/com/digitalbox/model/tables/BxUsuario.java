/*
* Copyright (c) 2015-2017 OyM System Group S.A.
* Capitan Cristaldo 464, Asunción, Paraguay
* All rights reserved. 
*
* NOTICE:  All information contained herein is, and remains
* the property of OyM System Group S.A. and its suppliers,
* if any.  The intellectual and technical concepts contained
* herein are proprietary to OyM System Group S.A.
* and its suppliers and protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material
* is strictly forbidden unless prior written permission is obtained
* from OyM System Group S.A.
*/
package py.com.digitalbox.model.tables;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IDicPermisoEmpresa;
import org.javabeanstack.util.Dates;

@Entity
@Table(name = "bx_usuario_view")
public class BxUsuario extends DataRow  {
    private static final long serialVersionUID = 1L;
    static Logger logger = Logger.getLogger(BxUsuario.class);
    
    @Id
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
    
    @Column(name = "tipo")
    private Short tipo;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    @Column(name = "approl")
    private String approl;

//    @OneToMany(mappedBy = "usuarioMiembro")
//    private List<UsuarioMiembro> listaUsuarioMiembro = new ArrayList<>();

    @Column(name = "idempresa")
    private Long idempresa;
    
    public BxUsuario() {
    }


    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getCodigo() {
        if(codigo != null) {
            codigo = codigo.trim();
        }
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        if(nombre != null) {
            nombre = nombre.trim();
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        if(clave != null) {
            clave = clave.trim();
        }
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave2() {
        if(clave2 != null) {
            clave2 = clave2.trim();
        }
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getDescripcion() {
        if(descripcion != null) {
            descripcion = descripcion.trim();
        }
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Date getExpira() {
        return expira;
    }

    public void setExpira(Date expira) {
        this.expira = expira;
    }

    public String getRol() {
        if(rol != null) {
            rol = rol.trim();
        }
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }
    
//    @Override
//    public List<IUsuarioMiembro> getListaUsuarioMiembro() {
//        return (List<IUsuarioMiembro>) (List<?>)listaUsuarioMiembro;
//    }
//
//    @Override
//    public void setListaUsuarioMiembro(List<IUsuarioMiembro> listaUsuarioMiembro) {
//        this.listaUsuarioMiembro = (List<UsuarioMiembro>) (List<?>)listaUsuarioMiembro;
//    }

    public Long getIdempresa() {
        return idempresa;
    }
    
    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public List<IDicPermisoEmpresa> getDicPermisoEmpresaList() {
        return null;
    }

    public void setDicPermisoEmpresaList(List<IDicPermisoEmpresa> dicPermisoEmpresaList) {
        //this.dicPermisoEmpresaList = (List<DicPermisoEmpresa>)(List<?>)dicPermisoEmpresaList;
    }

    public String getApprol() {
        return approl;
    }

    public void setApprol(String approl) {
        this.approl = approl;
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
        if (idusuario == null || idusuario == 0L){
            return equivalent(obj);
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BxUsuario other = (BxUsuario) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxUsuario)) {
            return false;
        }
        BxUsuario obj = (BxUsuario) o;
        return (this.codigo.trim().equals(obj.getCodigo().trim()));
    }
    

    @Override
    public String toString() {
        return "idusuario=" + idusuario ;
    }

    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
        if (expira == null){
            expira = Dates.toDate("31/12/9999");
        }
    }
}
