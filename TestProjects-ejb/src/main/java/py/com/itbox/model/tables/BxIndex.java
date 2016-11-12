/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.itbox.model.tables;

import java.text.SimpleDateFormat;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import py.com.oym.frame.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_index")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxIndex.findAll", query = "SELECT b FROM BxIndex b")})
public class BxIndex extends DataRow {
    public static final short NOPROCESADO  = 0;
    public static final short PROCESANDO   = 1;
    public static final short ERRORPROCESO = 2;    
    public static final short PROCESADO    = 3;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_index")
    private Long idbxIndex;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private Long idempresa;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fileorigen")
    private String fileorigen="";
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fileresult_tiff")
    private String fileresulttiff="";
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fileresult_pdf")
    private String fileresultpdf="";

    @Basic(optional = false)
    @NotNull
    @Column(name = "nrodoc")
    private Long nrodoc;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadoc;

    @Basic(optional = false)
    @NotNull
    @Column(name = "anho")
    private Long anho;

    @Column(name = "nrolote")
    private Long nrolote;
    
    @Column(name = "nrotrabajo")
    private Long nrotrabajo;

    @Column(name = "observacion")
    private String observacion;
    
    @Transient
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion = new Date();
    
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    
    @Column(name = "appuser")
    private String appuser;

    @Column(name = "nroproceso")
    private Long nroproceso;

    @Column(name = "paginas")
    private Long paginas;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "indexstatus")
    private Short indexStatus=0;
    
    @Column(name = "indexresult")
    private String indexResult;

    
    @JoinColumn(name = "idbx_repositorio", referencedColumnName = "idbx_repositorio",nullable=false)
    @ManyToOne(optional = false)
    private BxRepositorio bxRepositorio;
    
    @JoinColumn(name = "idbx_documentotipo", referencedColumnName = "idbx_documentotipo",nullable=false)
    @ManyToOne(optional = false)
    private BxDocumentotipo bxDocumentotipo;
    
    @OneToMany(mappedBy = "bxIndex")
    @OrderBy("idbx_indexdetalle ASC")
    private List<BxIndexdetalle> bxIndexdetalle= new ArrayList();
    
    public BxIndex() {
    }

    public BxIndex(Long idbxIndex) {
        this.idbxIndex = idbxIndex;
    }

    public BxIndex(Long idbxIndex, Long idempresa, String fileorigen, String fileresultTiff, String fileresultPdf) {
        this.idbxIndex = idbxIndex;
        this.idempresa = idempresa;
        this.fileorigen = fileorigen;
        this.fileresulttiff = fileresultTiff;
        this.fileresultpdf = fileresultPdf;
    }

    public Long getIdbxIndex() {
        return idbxIndex;
    }

    public void setIdbxIndex(Long idbxIndex) {
        this.idbxIndex = idbxIndex;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getFileorigen() {
        return fileorigen;
    }

    public void setFileorigen(String fileorigen) {
        this.fileorigen = fileorigen;
    }

    public String getFileresulttiff() {
        return fileresulttiff;
    }

    public void setFileresulttiff(String fileresultTiff) {
        this.fileresulttiff = fileresultTiff;
    }

    public String getFileresultpdf() {
        return fileresultpdf;
    }

    public void setFileresultpdf(String fileresultPdf) {
        this.fileresultpdf = fileresultPdf;
    }

    public Long getNrolote() {
        return nrolote;
    }

    public void setNrolote(Long nrolote) {
        this.nrolote = nrolote;
    }

    public Long getNrotrabajo() {
        return nrotrabajo;
    }

    public void setNrotrabajo(Long nrotrabajo) {
        this.nrotrabajo = nrotrabajo;
    }

    public Long getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(Long nrodoc) {
        this.nrodoc = nrodoc;
    }

    public Date getFechadoc() {
        return fechadoc;
    }

    public void setFechadoc(Date fechadoc) {
        this.fechadoc = fechadoc;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Short getIndexStatus() {
        return indexStatus;
    }

    public String getIndexStatusMsg(){
        String msg = "";
        if (null != indexStatus)
            switch (indexStatus) {
            case 0:
                msg = "No procesado";
                break;
            case 1:
                msg = "En proceso";
                break;
            case 2:
                msg = "Error";
                break;
            case 3:
                msg = "Procesado";
                break;
            default:
                break;
        }
        return msg;
    }
    
    public void setIndexStatus(Short processtatus) {
        this.indexStatus = processtatus;
    }

    public String getIndexResult() {
        return indexResult;
    }

    public void setIndexResult(String indexresult) {
        this.indexResult = indexresult;
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

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    @XmlTransient
    public BxRepositorio getBxRepositorio() {
        return bxRepositorio;
    }

    public void setBxRepositorio(BxRepositorio bxRepositorio) {
        this.bxRepositorio = bxRepositorio;
    }

    public BxDocumentotipo getBxDocumentotipo() {
        return bxDocumentotipo;
    }

    public void setBxDocumentotipo(BxDocumentotipo bxDocumentotipo) {
        this.bxDocumentotipo = bxDocumentotipo;
    }

    @XmlTransient
    public List<BxIndexdetalle> getBxIndexdetalle() {
        return bxIndexdetalle;
    }

    public void setBxIndexdetalle(List<BxIndexdetalle> bxIndexdetalle) {
        this.bxIndexdetalle = bxIndexdetalle;
    }

    public Long getNroproceso() {
        return nroproceso;
    }

    public void setNroproceso(Long nroproceso) {
        this.nroproceso = nroproceso;
    }

    public Long getPaginas() {
        return paginas;
    }

    public void setPaginas(Long paginas) {
        this.paginas = paginas;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getAnho() {
        return anho;
    }

    public void setAnho(Long anho) {
        this.anho = anho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxIndex != null ? idbxIndex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxIndex)) {
            return false;
        }
        if (idbxIndex == null || idbxIndex == 0L){
            return equivalent(object);
        }
        BxIndex other = (BxIndex) object;
        if ((this.idbxIndex == null && other.idbxIndex != null) || (this.idbxIndex != null && !this.idbxIndex.equals(other.idbxIndex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxIndex[ idbxIndex=" + idbxIndex + " ]";
    }
    
    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxIndex)) {
            return false;
        }
        BxIndex other = (BxIndex) o;
        return (Objects.equals(anho, other.getAnho())
                && Objects.equals(getBxDocumentotipo(), other.getBxDocumentotipo())
                && Objects.equals(getNrodoc(), other.getNrodoc())
                && Objects.equals(this.idempresa, other.getIdempresa()));
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
        if (anho.toString().isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String cFecha = formatter.format(fechadoc);
            anho = Long.parseLong(cFecha.substring(6, 10));
        }
    }
}
