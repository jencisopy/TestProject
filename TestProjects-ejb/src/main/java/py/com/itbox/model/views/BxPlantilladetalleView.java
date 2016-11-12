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
@Table(name = "bx_plantilladetalle_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxPlantilladetalleView.findAll", query = "SELECT b FROM BxPlantilladetalleView b"),
    @NamedQuery(name = "BxPlantilladetalleView.findByIdbxPlantilla", query = "SELECT b FROM BxPlantilladetalleView b WHERE b.idbxPlantilla = :idbxPlantilla"),
    @NamedQuery(name = "BxPlantilladetalleView.findByPlantillacodigo", query = "SELECT b FROM BxPlantilladetalleView b WHERE b.plantillacodigo = :plantillacodigo"),
    @NamedQuery(name = "BxPlantilladetalleView.findByPlantillanombre", query = "SELECT b FROM BxPlantilladetalleView b WHERE b.plantillanombre = :plantillanombre"),
    @NamedQuery(name = "BxPlantilladetalleView.findByCampocodigo", query = "SELECT b FROM BxPlantilladetalleView b WHERE b.campocodigo = :campocodigo"),
    @NamedQuery(name = "BxPlantilladetalleView.findByCamponombre", query = "SELECT b FROM BxPlantilladetalleView b WHERE b.camponombre = :camponombre"),
    @NamedQuery(name = "BxPlantilladetalleView.findByCampotipo", query = "SELECT b FROM BxPlantilladetalleView b WHERE b.campotipo = :campotipo")})
public class BxPlantilladetalleView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "idbx_plantilladetalle")
    @Id
    private long idbxPlantilladetalle;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbx_plantilla")
    private long idbxPlantilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "plantillacodigo")
    private String plantillacodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "plantillanombre")
    private String plantillanombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "campocodigo")
    private String campocodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "camponombre")
    private String camponombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "campotipo")
    private Character campotipo;

    public BxPlantilladetalleView() {
    }

    public long getIdbxPlantilla() {
        return idbxPlantilla;
    }

    public void setIdbxPlantilla(long idbxPlantilla) {
        this.idbxPlantilla = idbxPlantilla;
    }

    public String getPlantillacodigo() {
        return plantillacodigo;
    }

    public void setPlantillacodigo(String plantillacodigo) {
        this.plantillacodigo = plantillacodigo;
    }

    public String getPlantillanombre() {
        return plantillanombre;
    }

    public void setPlantillanombre(String plantillanombre) {
        this.plantillanombre = plantillanombre;
    }

    public String getCampocodigo() {
        return campocodigo;
    }

    public void setCampocodigo(String campocodigo) {
        this.campocodigo = campocodigo;
    }

    public String getCamponombre() {
        return camponombre;
    }

    public void setCamponombre(String camponombre) {
        this.camponombre = camponombre;
    }

    public Character getCampotipo() {
        return campotipo;
    }

    public void setCampotipo(Character campotipo) {
        this.campotipo = campotipo;
    }

    public long getIdbxPlantilladetalle() {
        return idbxPlantilladetalle;
    }

    public void setIdbxPlantilladetalle(long idbxPlantilladetalle) {
        this.idbxPlantilladetalle = idbxPlantilladetalle;
    }
    
}
