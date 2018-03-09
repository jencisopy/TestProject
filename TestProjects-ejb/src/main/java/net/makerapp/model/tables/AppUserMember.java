package net.makerapp.model.tables;

import java.util.Objects; 
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppUser;
import org.javabeanstack.model.IAppUserMember;

@Entity
@Table(name = "usuariomiembro")
public class AppUserMember extends DataRow implements IAppUserMember {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariomiembro")
    private Long idusuariomiembro;
    
    @JoinColumn(name = "idmiembro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private AppUser usuarioMiembro;

    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private AppUser usuarioGrupo;
    
    public AppUserMember() {
    }

    @Override
    public Long getIdusermember() {
        return idusuariomiembro;
    }

    @Override
    public void setIdusermember(Long idusuariomiembro) {
        this.idusuariomiembro = idusuariomiembro;
    }

    @Override
    public IAppUser getUserMember() {
        return usuarioMiembro;
    }

    @Override
    public void setUserMember(IAppUser usuarioMiembro) {
        this.usuarioMiembro = (AppUser)usuarioMiembro;
    }

    @Override
    public IAppUser getUserGroup() {
        return usuarioGrupo;
    }

    @Override
    public void setUserGroup(IAppUser usuarioGrupo) {
        this.usuarioGrupo = (AppUser)usuarioGrupo;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idusuariomiembro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUserMember other = (AppUserMember) obj;
        return Objects.equals(this.idusuariomiembro, other.idusuariomiembro);
    }

    @Override
    public String toString() {
        return "UsuarioMiembro{" + "idusuariomiembro=" + idusuariomiembro + "}";
    }

    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof AppUserMember)) {
            return false;
        }
        AppUserMember obj = (AppUserMember) o;
        return (this.idusuariomiembro.equals(obj.getIdusermember())); 
    }
    
}
