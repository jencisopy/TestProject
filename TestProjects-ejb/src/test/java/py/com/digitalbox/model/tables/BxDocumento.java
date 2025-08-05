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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "bx_documento",uniqueConstraints=@UniqueConstraint(columnNames={"idempresa","idbx_documentotipo","anho","nrodoc"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BxDocumento.findAll", query = "SELECT b FROM BxDocumento b")})
public class BxDocumento extends DataRow {
    public static final short NOPROCESADO  = 0;
    public static final short PROCESANDO   = 1;
    public static final short ERRORPROCESO = 2;    
    public static final short PROCESADO    = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbx_documento")
    private Long idbxDocumento;
    
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
    @Column(name = "nroexpediente")
    private String nroexpediente;
    
    @Basic(optional = false)
    @Column(name = "ubicacionfisica")
    private String ubicacionfisica;

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

    @Column(columnDefinition = "text", name="contenido")
    private String contenido;

    @JoinColumn(name = "idbx_repositorio", referencedColumnName = "idbx_repositorio", nullable = false)
    @ManyToOne(optional = false)
    private BxRepositorio bxRepositorio;
    
    @JoinColumn(name = "idbx_documentotipo", referencedColumnName = "idbx_documentotipo",nullable=false)
    @ManyToOne(optional = false)
    private BxDocumentotipo bxDocumentotipo;
    
    @OneToMany(mappedBy = "bxDocumento")
    @OrderBy("idbx_documentodetalle ASC")
    private List<BxDocumentodetalle> bxDocumentodetalle= new ArrayList();
    
    @JoinColumn(name = "idbx_ubicacionarquipel", referencedColumnName = "idbx_ubicacionarquipel")
    @ManyToOne()
    private BxUbicacionArquipel bxUbicacionArquipel;
    
    
    public BxDocumento() {
    }

    public BxDocumento(Long idempresa, String fileorigen, String fileresultTiff, String fileresultPdf) {
        this.idempresa = idempresa;
        this.fileorigen = fileorigen;
        this.fileresulttiff = fileresultTiff;
        this.fileresultpdf = fileresultPdf;
    }

    public Long getIdbxDocumento() {
        return idbxDocumento;
    }

    public void setIdbxDocumento(Long idbxDocumento) {
        this.idbxDocumento = idbxDocumento;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public BxUbicacionArquipel getBxUbicacionArquipel() {
        return bxUbicacionArquipel;
    }

    public void setBxUbicacionArquipel(BxUbicacionArquipel bxUbicacionArquipel) {
        this.bxUbicacionArquipel = bxUbicacionArquipel;
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
        if (null != indexStatus) {
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
    public List<BxDocumentodetalle> getBxDocumentodetalle() {
        return bxDocumentodetalle;
    }

    public void setBxDocumentodetalle(List<BxDocumentodetalle> bxDocumentodetalle) {
        this.bxDocumentodetalle = bxDocumentodetalle;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNroexpediente() {
        return nroexpediente;
    }

    public void setNroexpediente(String nroexpediente) {
        this.nroexpediente = nroexpediente;
    }

    public String getUbicacionfisica() {
        return ubicacionfisica;
    }

    public void setUbicacionfisica(String ubicacionfisica) {
        this.ubicacionfisica = ubicacionfisica;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbxDocumento != null ? idbxDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BxDocumento)) {
            return false;
        }
        if (idbxDocumento == null || idbxDocumento == 0L){
            return equivalent(object);
        }
        BxDocumento other = (BxDocumento) object;
        if ((this.idbxDocumento == null && other.idbxDocumento != null) || (this.idbxDocumento != null && !this.idbxDocumento.equals(other.idbxDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.itbox.model.tables.BxDocumento[ idbxDocumento=" + idbxDocumento + " ]";
    }
    
    @Override
    public boolean equivalent(Object o) {
        if (!(o instanceof BxDocumento)) {
            return false;
        }
        BxDocumento other = (BxDocumento) o;
        return (Objects.equals(anho, other.getAnho())
                && Objects.equals(getBxDocumentotipo(), other.getBxDocumentotipo())
                && Objects.equals(getNrodoc(), other.getNrodoc())
                && Objects.equals(this.idempresa, other.getIdempresa()));
    }
    
    @PreUpdate
    @PrePersist
    public void preUpdate() {
        fechamodificacion = new Date();
        if (anho == null || anho.toString().isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String cFecha = formatter.format(fechadoc);
            anho = Long.parseLong(cFecha.substring(6, 10));
        }
    }
}
