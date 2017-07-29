package py.com.oym.model.tables;

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
import org.javabeanstack.model.IUser;
import org.javabeanstack.model.IUserMember;

@Entity
@Table(name = "usuariomiembro")
public class UsuarioMiembro extends DataRow implements IUserMember {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariomiembro")
    private Long idusuariomiembro;
    
    @JoinColumn(name = "idmiembro", referencedColumnName = "idusuario",nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioMiembro;

    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario",nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioGrupo;
    
    public UsuarioMiembro() {
    }

    @Override
    public Long getIdusuariomiembro() {
        return idusuariomiembro;
    }

    @Override
    public void setIdusuariomiembro(Long idusuariomiembro) {
        this.idusuariomiembro = idusuariomiembro;
    }

    @Override
    public IUser getUsuarioMiembro() {
        return usuarioMiembro;
    }

    @Override
    public void setUsuarioMiembro(IUser usuarioMiembro) {
        this.usuarioMiembro = (Usuario)usuarioMiembro;
    }

    @Override
    public IUser getUsuarioGrupo() {
        return usuarioGrupo;
    }

    @Override
    public void setUsuarioGrupo(IUser usuarioGrupo) {
        this.usuarioGrupo = (Usuario)usuarioGrupo;
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
        final UsuarioMiembro other = (UsuarioMiembro) obj;
        return Objects.equals(this.idusuariomiembro, other.idusuariomiembro);
    }

    @Override
    public String toString() {
        return "UsuarioMiembro{" + "idusuariomiembro=" + idusuariomiembro + "}";
    }
}
