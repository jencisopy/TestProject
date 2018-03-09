package net.makerapp.model.tables;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppCompanyAllowed;

@Entity
@Table(name = "dic_permisoempresa")
public class AppCompanyAllowed extends DataRow implements IAppCompanyAllowed {
    private static final long serialVersionUID = 1L;
    

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private Long idusuario;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "permitir")
    private boolean permitir;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "negar")
    private boolean negar;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    

    public AppCompanyAllowed() {
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
    public Long getIdcompany() {
        return idempresa;
    }

    @Override
    public void setIdcompany(Long idempresa) {
        this.idempresa = idempresa;
    }


    @Override
    public boolean getAllow() {
        return permitir;
    }

    @Override
    public void setAllow(boolean permitir) {
        this.permitir = permitir;
    }

    @Override
    public boolean getDeny() {
        return negar;
    }

    @Override
    public void setDeny(boolean negar) {
        this.negar = negar;
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

    @Override
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }
}
