/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.views;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "bx_documentotipo_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxDocumentotipoView.findAll", query = "SELECT b FROM BxDocumentotipoView b"),
    @NamedQuery(name = "BxDocumentotipoView.findByIdbxDocumentotipo", query = "SELECT b FROM BxDocumentotipoView b WHERE b.idbxDocumentotipo = :idbxDocumentotipo"),
    @NamedQuery(name = "BxDocumentotipoView.findByIdbxPlantilla", query = "SELECT b FROM BxDocumentotipoView b WHERE b.idbxPlantilla = :idbxPlantilla"),
    @NamedQuery(name = "BxDocumentotipoView.findByIdbxRepositorio", query = "SELECT b FROM BxDocumentotipoView b WHERE b.idbxRepositorio = :idbxRepositorio"),
    @NamedQuery(name = "BxDocumentotipoView.findByIdempresa", query = "SELECT b FROM BxDocumentotipoView b WHERE b.idempresa = :idempresa"),
    @NamedQuery(name = "BxDocumentotipoView.findByCodigo", query = "SELECT b FROM BxDocumentotipoView b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "BxDocumentotipoView.findByNombre", query = "SELECT b FROM BxDocumentotipoView b WHERE b.nombre = :nombre")})
public class BxDocumentotipoView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbx_documentotipo")
    @Id
    private long idbxDocumentotipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbx_plantilla")
    private long idbxPlantilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbx_repositorio")
    private long idbxRepositorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "folder")
    private String folder;
  
    public BxDocumentotipoView() {
    }

    public long getIdbxDocumentotipo() {
        return idbxDocumentotipo;
    }

    public void setIdbxDocumentotipo(long idbxDocumentotipo) {
        this.idbxDocumentotipo = idbxDocumentotipo;
    }

    public long getIdbxPlantilla() {
        return idbxPlantilla;
    }

    public void setIdbxPlantilla(long idbxPlantilla) {
        this.idbxPlantilla = idbxPlantilla;
    }

    public long getIdbxRepositorio() {
        return idbxRepositorio;
    }

    public void setIdbxRepositorio(long idbxRepositorio) {
        this.idbxRepositorio = idbxRepositorio;
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }    
}
