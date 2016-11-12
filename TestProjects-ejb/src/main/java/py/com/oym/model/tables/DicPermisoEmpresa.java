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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import py.com.oym.frame.data.DataRow;
import py.com.oym.frame.data.IDataRow;
import py.com.oym.frame.model.IDicPermisoEmpresa;

@Entity
@Table(name = "dic_permisoempresa")
public class DicPermisoEmpresa extends DataRow implements IDicPermisoEmpresa {
    
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
    

    public DicPermisoEmpresa() {
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
    public Long getIdempresa() {
        return idempresa;
    }

    @Override
    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }


    @Override
    public boolean getPermitir() {
        return permitir;
    }

    @Override
    public void setPermitir(boolean permitir) {
        this.permitir = permitir;
    }

    @Override
    public boolean getNegar() {
        return negar;
    }

    @Override
    public void setNegar(boolean negar) {
        this.negar = negar;
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
    public String getAppuser() {
        return appuser;
    }

    @Override
    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

/*
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dicPermisoEmpresaPK != null ? dicPermisoEmpresaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DicPermisoEmpresa)) {
            return false;
        }
        DicPermisoEmpresa other = (DicPermisoEmpresa) object;
        return (this.dicPermisoEmpresaPK != null || other.dicPermisoEmpresaPK == null) && (this.dicPermisoEmpresaPK == null || this.dicPermisoEmpresaPK.equals(other.dicPermisoEmpresaPK));
    }

    @Override
    public String toString() {
        return "DicPermisoempresa{" + "dicPermisoempresaPK=" + dicPermisoEmpresaPK + ", permitir=" + permitir + ", negar=" + negar + ", fechacreacion=" + fechacreacion + ", fechamodificacion=" + fechamodificacion + ", appuser=" + appuser + '}';
    }
*/
}
