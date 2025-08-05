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
package net.makerapp.model.views;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "ctbparametro_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtbparametroView.findAll", query = "SELECT c FROM CtbparametroView c")})
public class CtbparametroView extends DataRow implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    
    @Column(name = "ctbcuentaseparador")
    private Character ctbcuentaseparador;
    @Column(name = "nivel1")
    private Short nivel1;
    @Column(name = "nivel2")
    private Short nivel2;
    @Column(name = "nivel3")
    private Short nivel3;
    @Column(name = "nivel4")
    private Short nivel4;
    @Column(name = "nivel5")
    private Short nivel5;
    @Column(name = "nivel6")
    private Short nivel6;
    @Column(name = "nivel7")
    private Short nivel7;
    @Column(name = "idctbproveedor")
    private Long idctbproveedor;
    @Column(name = "idctbcliente")
    private Long idctbcliente;
    @Column(name = "idctbimportacion")
    private Long idctbimportacion;
    @Column(name = "idctbresultadoejerc")
    private Long idctbresultadoejerc;
    @Column(name = "idctbresultadoacum")
    private Long idctbresultadoacum;
    @Column(name = "idctbcapsuscripto")
    private Long idctbcapsuscripto;
    @Column(name = "idctbcapintegrar")
    private Long idctbcapintegrar;
    @Column(name = "idctbcapintegrado")
    private Long idctbcapintegrado;
    @Column(name = "idctbreservalegal")
    private Long idctbreservalegal;
    @Column(name = "idctbreservafac")
    private Long idctbreservafac;
    @Column(name = "idctbreservarevaluo")
    private Long idctbreservarevaluo;
    @Column(name = "idctbivacred5")
    private Long idctbivacred5;
    @Column(name = "idctbivacred10")
    private Long idctbivacred10;
    @Column(name = "idctbivadeb5")
    private Long idctbivadeb5;
    @Column(name = "idctbivadeb10")
    private Long idctbivadeb10;
    @Column(name = "idctbfondofijo")
    private Long idctbfondofijo;
    @Column(name = "idctbproveedorretiva")
    private Long idctbproveedorretiva;
    @Column(name = "idctbclienteretiva")
    private Long idctbclienteretiva;
    @Column(name = "idctbretencionrenta")
    private Long idctbretencionrenta;
    @Column(name = "idctbdifcambioing")
    private Long idctbdifcambioing;
    @Column(name = "idctbdifcambioegr")
    private Long idctbdifcambioegr;
    @Column(name = "lastnroctrl")
    private Long lastnroctrl;
    @Column(name = "asientodecimal")
    private Short asientodecimal;
    @Column(name = "ivadecimal")
    private Short ivadecimal;
    @Column(name = "depreciarmodo")
    private Short depreciarmodo;
    @Column(name = "bancogenvtocheque")
    private Boolean bancogenvtocheque;
    @Column(name = "bancogenemisioncheque")
    private Boolean bancogenemisioncheque;
    @Column(name = "compraplnagrupar")
    private Boolean compraplnagrupar;
    @Column(name = "compraasientoagrupar")
    private Short compraasientoagrupar;
    @Column(name = "ventaplnagrupar")
    private Boolean ventaplnagrupar;
    @Column(name = "ventaasientoagrupar")
    private Short ventaasientoagrupar;
    @Column(name = "redondeargenasiento")
    private Boolean redondeargenasiento;
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
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;
    @Size(max = 32)
    @Column(name = "appuser")
    private String appuser;
    @Column(name = "ctbtipocambiocriterio")
    private Short ctbtipocambiocriterio;
    @Column(name = "idctbipsgasto")
    private Long idctbipsgasto;
    @Column(name = "idctbipspagar")
    private Long idctbipspagar;
    @Column(name = "idctbipsgastoobr")
    private Long idctbipsgastoobr;
    @Column(name = "permit_asi_sucursal_desbalance")
    private Boolean permitAsiSucursalDesbalance;
    @Size(max = 15)
    @Column(name = "ctbproveedor")
    private String ctbproveedor;
    @Size(max = 50)
    @Column(name = "ctbproveedornombre")
    private String ctbproveedornombre;
    @Size(max = 15)
    @Column(name = "ctbcliente")
    private String ctbcliente;
    @Size(max = 50)
    @Column(name = "ctbclientenombre")
    private String ctbclientenombre;
    @Size(max = 15)
    @Column(name = "ctbimportacion")
    private String ctbimportacion;
    @Size(max = 50)
    @Column(name = "ctbimportacionnombre")
    private String ctbimportacionnombre;
    @Size(max = 15)
    @Column(name = "ctbresultadoejerc")
    private String ctbresultadoejerc;
    @Size(max = 50)
    @Column(name = "ctbresultadoejercnombre")
    private String ctbresultadoejercnombre;
    @Size(max = 15)
    @Column(name = "ctbresultadoacum")
    private String ctbresultadoacum;
    @Size(max = 50)
    @Column(name = "ctbresultadoacumnombre")
    private String ctbresultadoacumnombre;
    @Size(max = 15)
    @Column(name = "ctbcapsuscripto")
    private String ctbcapsuscripto;
    @Size(max = 50)
    @Column(name = "ctbcapsuscriptonombre")
    private String ctbcapsuscriptonombre;
    @Size(max = 15)
    @Column(name = "ctbcapintegrar")
    private String ctbcapintegrar;
    @Size(max = 50)
    @Column(name = "ctbcapintegrarnombre")
    private String ctbcapintegrarnombre;
    @Size(max = 15)
    @Column(name = "ctbcapintegrado")
    private String ctbcapintegrado;
    @Size(max = 50)
    @Column(name = "ctbcapintegradonombre")
    private String ctbcapintegradonombre;
    @Size(max = 15)
    @Column(name = "ctbreservalegal")
    private String ctbreservalegal;
    @Size(max = 50)
    @Column(name = "ctbreservalegalnombre")
    private String ctbreservalegalnombre;
    @Size(max = 15)
    @Column(name = "ctbreservafac")
    private String ctbreservafac;
    @Size(max = 50)
    @Column(name = "ctbreservafacnombre")
    private String ctbreservafacnombre;
    @Size(max = 15)
    @Column(name = "ctbreservarevaluo")
    private String ctbreservarevaluo;
    @Size(max = 50)
    @Column(name = "ctbreservarevaluonombre")
    private String ctbreservarevaluonombre;
    @Size(max = 15)
    @Column(name = "ctbivacred5")
    private String ctbivacred5;
    @Size(max = 50)
    @Column(name = "ctbivacred5nombre")
    private String ctbivacred5nombre;
    @Size(max = 15)
    @Column(name = "ctbivacred10")
    private String ctbivacred10;
    @Size(max = 50)
    @Column(name = "ctbivacred10nombre")
    private String ctbivacred10nombre;
    @Size(max = 15)
    @Column(name = "ctbivadeb5")
    private String ctbivadeb5;
    @Size(max = 50)
    @Column(name = "ctbivadeb5nombre")
    private String ctbivadeb5nombre;
    @Size(max = 15)
    @Column(name = "ctbivadeb10")
    private String ctbivadeb10;
    @Size(max = 50)
    @Column(name = "ctbivadeb10nombre")
    private String ctbivadeb10nombre;
    @Size(max = 15)
    @Column(name = "ctbfondofijo")
    private String ctbfondofijo;
    @Size(max = 50)
    @Column(name = "ctbfondofijonombre")
    private String ctbfondofijonombre;
    @Size(max = 15)
    @Column(name = "ctbproveedorretiva")
    private String ctbproveedorretiva;
    @Size(max = 50)
    @Column(name = "ctbproveedorretivanombre")
    private String ctbproveedorretivanombre;
    @Size(max = 15)
    @Column(name = "ctbclienteretiva")
    private String ctbclienteretiva;
    @Size(max = 50)
    @Column(name = "ctbclienteretivanombre")
    private String ctbclienteretivanombre;
    @Size(max = 15)
    @Column(name = "ctbretencionrenta")
    private String ctbretencionrenta;
    @Size(max = 50)
    @Column(name = "ctbretencionrentanombre")
    private String ctbretencionrentanombre;
    @Size(max = 15)
    @Column(name = "ctbdifcambioing")
    private String ctbdifcambioing;
    @Size(max = 50)
    @Column(name = "ctbdifcambioingnombre")
    private String ctbdifcambioingnombre;
    @Size(max = 15)
    @Column(name = "ctbdifcambioegr")
    private String ctbdifcambioegr;
    @Size(max = 50)
    @Column(name = "ctbdifcambioegrnombre")
    private String ctbdifcambioegrnombre;
    @Size(max = 15)
    @Column(name = "ctbipsgasto")
    private String ctbipsgasto;
    @Size(max = 50)
    @Column(name = "ctbipsgastonombre")
    private String ctbipsgastonombre;
    @Size(max = 15)
    @Column(name = "ctbipspagar")
    private String ctbipspagar;
    @Size(max = 50)
    @Column(name = "ctbipspagarnombre")
    private String ctbipspagarnombre;
    @Size(max = 15)
    @Column(name = "ctbipsgastoobr")
    private String ctbipsgastoobr;
    @Size(max = 50)
    @Column(name = "ctbipsgastoobrnombre")
    private String ctbipsgastoobrnombre;

    public CtbparametroView() {
    }

    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public Character getCtbcuentaseparador() {
        return ctbcuentaseparador;
    }

    public void setCtbcuentaseparador(Character ctbcuentaseparador) {
        this.ctbcuentaseparador = ctbcuentaseparador;
    }

    public Short getNivel1() {
        return nivel1;
    }

    public void setNivel1(Short nivel1) {
        this.nivel1 = nivel1;
    }

    public Short getNivel2() {
        return nivel2;
    }

    public void setNivel2(Short nivel2) {
        this.nivel2 = nivel2;
    }

    public Short getNivel3() {
        return nivel3;
    }

    public void setNivel3(Short nivel3) {
        this.nivel3 = nivel3;
    }

    public Short getNivel4() {
        return nivel4;
    }

    public void setNivel4(Short nivel4) {
        this.nivel4 = nivel4;
    }

    public Short getNivel5() {
        return nivel5;
    }

    public void setNivel5(Short nivel5) {
        this.nivel5 = nivel5;
    }

    public Short getNivel6() {
        return nivel6;
    }

    public void setNivel6(Short nivel6) {
        this.nivel6 = nivel6;
    }

    public Short getNivel7() {
        return nivel7;
    }

    public void setNivel7(Short nivel7) {
        this.nivel7 = nivel7;
    }

    public Long getIdctbproveedor() {
        return idctbproveedor;
    }

    public void setIdctbproveedor(Long idctbproveedor) {
        this.idctbproveedor = idctbproveedor;
    }

    public Long getIdctbcliente() {
        return idctbcliente;
    }

    public void setIdctbcliente(Long idctbcliente) {
        this.idctbcliente = idctbcliente;
    }

    public Long getIdctbimportacion() {
        return idctbimportacion;
    }

    public void setIdctbimportacion(Long idctbimportacion) {
        this.idctbimportacion = idctbimportacion;
    }

    public Long getIdctbresultadoejerc() {
        return idctbresultadoejerc;
    }

    public void setIdctbresultadoejerc(Long idctbresultadoejerc) {
        this.idctbresultadoejerc = idctbresultadoejerc;
    }

    public Long getIdctbresultadoacum() {
        return idctbresultadoacum;
    }

    public void setIdctbresultadoacum(Long idctbresultadoacum) {
        this.idctbresultadoacum = idctbresultadoacum;
    }

    public Long getIdctbcapsuscripto() {
        return idctbcapsuscripto;
    }

    public void setIdctbcapsuscripto(Long idctbcapsuscripto) {
        this.idctbcapsuscripto = idctbcapsuscripto;
    }

    public Long getIdctbcapintegrar() {
        return idctbcapintegrar;
    }

    public void setIdctbcapintegrar(Long idctbcapintegrar) {
        this.idctbcapintegrar = idctbcapintegrar;
    }

    public Long getIdctbcapintegrado() {
        return idctbcapintegrado;
    }

    public void setIdctbcapintegrado(Long idctbcapintegrado) {
        this.idctbcapintegrado = idctbcapintegrado;
    }

    public Long getIdctbreservalegal() {
        return idctbreservalegal;
    }

    public void setIdctbreservalegal(Long idctbreservalegal) {
        this.idctbreservalegal = idctbreservalegal;
    }

    public Long getIdctbreservafac() {
        return idctbreservafac;
    }

    public void setIdctbreservafac(Long idctbreservafac) {
        this.idctbreservafac = idctbreservafac;
    }

    public Long getIdctbreservarevaluo() {
        return idctbreservarevaluo;
    }

    public void setIdctbreservarevaluo(Long idctbreservarevaluo) {
        this.idctbreservarevaluo = idctbreservarevaluo;
    }

    public Long getIdctbivacred5() {
        return idctbivacred5;
    }

    public void setIdctbivacred5(Long idctbivacred5) {
        this.idctbivacred5 = idctbivacred5;
    }

    public Long getIdctbivacred10() {
        return idctbivacred10;
    }

    public void setIdctbivacred10(Long idctbivacred10) {
        this.idctbivacred10 = idctbivacred10;
    }

    public Long getIdctbivadeb5() {
        return idctbivadeb5;
    }

    public void setIdctbivadeb5(Long idctbivadeb5) {
        this.idctbivadeb5 = idctbivadeb5;
    }

    public Long getIdctbivadeb10() {
        return idctbivadeb10;
    }

    public void setIdctbivadeb10(Long idctbivadeb10) {
        this.idctbivadeb10 = idctbivadeb10;
    }

    public Long getIdctbfondofijo() {
        return idctbfondofijo;
    }

    public void setIdctbfondofijo(Long idctbfondofijo) {
        this.idctbfondofijo = idctbfondofijo;
    }

    public Long getIdctbproveedorretiva() {
        return idctbproveedorretiva;
    }

    public void setIdctbproveedorretiva(Long idctbproveedorretiva) {
        this.idctbproveedorretiva = idctbproveedorretiva;
    }

    public Long getIdctbclienteretiva() {
        return idctbclienteretiva;
    }

    public void setIdctbclienteretiva(Long idctbclienteretiva) {
        this.idctbclienteretiva = idctbclienteretiva;
    }

    public Long getIdctbretencionrenta() {
        return idctbretencionrenta;
    }

    public void setIdctbretencionrenta(Long idctbretencionrenta) {
        this.idctbretencionrenta = idctbretencionrenta;
    }

    public Long getIdctbdifcambioing() {
        return idctbdifcambioing;
    }

    public void setIdctbdifcambioing(Long idctbdifcambioing) {
        this.idctbdifcambioing = idctbdifcambioing;
    }

    public Long getIdctbdifcambioegr() {
        return idctbdifcambioegr;
    }

    public void setIdctbdifcambioegr(Long idctbdifcambioegr) {
        this.idctbdifcambioegr = idctbdifcambioegr;
    }

    public Long getLastnroctrl() {
        return lastnroctrl;
    }

    public void setLastnroctrl(Long lastnroctrl) {
        this.lastnroctrl = lastnroctrl;
    }

    public Short getAsientodecimal() {
        return asientodecimal;
    }

    public void setAsientodecimal(Short asientodecimal) {
        this.asientodecimal = asientodecimal;
    }

    public Short getIvadecimal() {
        return ivadecimal;
    }

    public void setIvadecimal(Short ivadecimal) {
        this.ivadecimal = ivadecimal;
    }

    public Short getDepreciarmodo() {
        return depreciarmodo;
    }

    public void setDepreciarmodo(Short depreciarmodo) {
        this.depreciarmodo = depreciarmodo;
    }

    public Boolean getBancogenvtocheque() {
        return bancogenvtocheque;
    }

    public void setBancogenvtocheque(Boolean bancogenvtocheque) {
        this.bancogenvtocheque = bancogenvtocheque;
    }

    public Boolean getBancogenemisioncheque() {
        return bancogenemisioncheque;
    }

    public void setBancogenemisioncheque(Boolean bancogenemisioncheque) {
        this.bancogenemisioncheque = bancogenemisioncheque;
    }

    public Boolean getCompraplnagrupar() {
        return compraplnagrupar;
    }

    public void setCompraplnagrupar(Boolean compraplnagrupar) {
        this.compraplnagrupar = compraplnagrupar;
    }

    public Short getCompraasientoagrupar() {
        return compraasientoagrupar;
    }

    public void setCompraasientoagrupar(Short compraasientoagrupar) {
        this.compraasientoagrupar = compraasientoagrupar;
    }

    public Boolean getVentaplnagrupar() {
        return ventaplnagrupar;
    }

    public void setVentaplnagrupar(Boolean ventaplnagrupar) {
        this.ventaplnagrupar = ventaplnagrupar;
    }

    public Short getVentaasientoagrupar() {
        return ventaasientoagrupar;
    }

    public void setVentaasientoagrupar(Short ventaasientoagrupar) {
        this.ventaasientoagrupar = ventaasientoagrupar;
    }

    public Boolean getRedondeargenasiento() {
        return redondeargenasiento;
    }

    public void setRedondeargenasiento(Boolean redondeargenasiento) {
        this.redondeargenasiento = redondeargenasiento;
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

    public Short getCtbtipocambiocriterio() {
        return ctbtipocambiocriterio;
    }

    public void setCtbtipocambiocriterio(Short ctbtipocambiocriterio) {
        this.ctbtipocambiocriterio = ctbtipocambiocriterio;
    }

    public Long getIdctbipsgasto() {
        return idctbipsgasto;
    }

    public void setIdctbipsgasto(Long idctbipsgasto) {
        this.idctbipsgasto = idctbipsgasto;
    }

    public Long getIdctbipspagar() {
        return idctbipspagar;
    }

    public void setIdctbipspagar(Long idctbipspagar) {
        this.idctbipspagar = idctbipspagar;
    }

    public Long getIdctbipsgastoobr() {
        return idctbipsgastoobr;
    }

    public void setIdctbipsgastoobr(Long idctbipsgastoobr) {
        this.idctbipsgastoobr = idctbipsgastoobr;
    }

    public Boolean getPermitAsiSucursalDesbalance() {
        return permitAsiSucursalDesbalance;
    }

    public void setPermitAsiSucursalDesbalance(Boolean permitAsiSucursalDesbalance) {
        this.permitAsiSucursalDesbalance = permitAsiSucursalDesbalance;
    }

    public String getCtbproveedor() {
        return ctbproveedor;
    }

    public void setCtbproveedor(String ctbproveedor) {
        this.ctbproveedor = ctbproveedor;
    }

    public String getCtbproveedornombre() {
        return ctbproveedornombre;
    }

    public void setCtbproveedornombre(String ctbproveedornombre) {
        this.ctbproveedornombre = ctbproveedornombre;
    }

    public String getCtbcliente() {
        return ctbcliente;
    }

    public void setCtbcliente(String ctbcliente) {
        this.ctbcliente = ctbcliente;
    }

    public String getCtbclientenombre() {
        return ctbclientenombre;
    }

    public void setCtbclientenombre(String ctbclientenombre) {
        this.ctbclientenombre = ctbclientenombre;
    }

    public String getCtbimportacion() {
        return ctbimportacion;
    }

    public void setCtbimportacion(String ctbimportacion) {
        this.ctbimportacion = ctbimportacion;
    }

    public String getCtbimportacionnombre() {
        return ctbimportacionnombre;
    }

    public void setCtbimportacionnombre(String ctbimportacionnombre) {
        this.ctbimportacionnombre = ctbimportacionnombre;
    }

    public String getCtbresultadoejerc() {
        return ctbresultadoejerc;
    }

    public void setCtbresultadoejerc(String ctbresultadoejerc) {
        this.ctbresultadoejerc = ctbresultadoejerc;
    }

    public String getCtbresultadoejercnombre() {
        return ctbresultadoejercnombre;
    }

    public void setCtbresultadoejercnombre(String ctbresultadoejercnombre) {
        this.ctbresultadoejercnombre = ctbresultadoejercnombre;
    }

    public String getCtbresultadoacum() {
        return ctbresultadoacum;
    }

    public void setCtbresultadoacum(String ctbresultadoacum) {
        this.ctbresultadoacum = ctbresultadoacum;
    }

    public String getCtbresultadoacumnombre() {
        return ctbresultadoacumnombre;
    }

    public void setCtbresultadoacumnombre(String ctbresultadoacumnombre) {
        this.ctbresultadoacumnombre = ctbresultadoacumnombre;
    }

    public String getCtbcapsuscripto() {
        return ctbcapsuscripto;
    }

    public void setCtbcapsuscripto(String ctbcapsuscripto) {
        this.ctbcapsuscripto = ctbcapsuscripto;
    }

    public String getCtbcapsuscriptonombre() {
        return ctbcapsuscriptonombre;
    }

    public void setCtbcapsuscriptonombre(String ctbcapsuscriptonombre) {
        this.ctbcapsuscriptonombre = ctbcapsuscriptonombre;
    }

    public String getCtbcapintegrar() {
        return ctbcapintegrar;
    }

    public void setCtbcapintegrar(String ctbcapintegrar) {
        this.ctbcapintegrar = ctbcapintegrar;
    }

    public String getCtbcapintegrarnombre() {
        return ctbcapintegrarnombre;
    }

    public void setCtbcapintegrarnombre(String ctbcapintegrarnombre) {
        this.ctbcapintegrarnombre = ctbcapintegrarnombre;
    }

    public String getCtbcapintegrado() {
        return ctbcapintegrado;
    }

    public void setCtbcapintegrado(String ctbcapintegrado) {
        this.ctbcapintegrado = ctbcapintegrado;
    }

    public String getCtbcapintegradonombre() {
        return ctbcapintegradonombre;
    }

    public void setCtbcapintegradonombre(String ctbcapintegradonombre) {
        this.ctbcapintegradonombre = ctbcapintegradonombre;
    }

    public String getCtbreservalegal() {
        return ctbreservalegal;
    }

    public void setCtbreservalegal(String ctbreservalegal) {
        this.ctbreservalegal = ctbreservalegal;
    }

    public String getCtbreservalegalnombre() {
        return ctbreservalegalnombre;
    }

    public void setCtbreservalegalnombre(String ctbreservalegalnombre) {
        this.ctbreservalegalnombre = ctbreservalegalnombre;
    }

    public String getCtbreservafac() {
        return ctbreservafac;
    }

    public void setCtbreservafac(String ctbreservafac) {
        this.ctbreservafac = ctbreservafac;
    }

    public String getCtbreservafacnombre() {
        return ctbreservafacnombre;
    }

    public void setCtbreservafacnombre(String ctbreservafacnombre) {
        this.ctbreservafacnombre = ctbreservafacnombre;
    }

    public String getCtbreservarevaluo() {
        return ctbreservarevaluo;
    }

    public void setCtbreservarevaluo(String ctbreservarevaluo) {
        this.ctbreservarevaluo = ctbreservarevaluo;
    }

    public String getCtbreservarevaluonombre() {
        return ctbreservarevaluonombre;
    }

    public void setCtbreservarevaluonombre(String ctbreservarevaluonombre) {
        this.ctbreservarevaluonombre = ctbreservarevaluonombre;
    }

    public String getCtbivacred5() {
        return ctbivacred5;
    }

    public void setCtbivacred5(String ctbivacred5) {
        this.ctbivacred5 = ctbivacred5;
    }

    public String getCtbivacred5nombre() {
        return ctbivacred5nombre;
    }

    public void setCtbivacred5nombre(String ctbivacred5nombre) {
        this.ctbivacred5nombre = ctbivacred5nombre;
    }

    public String getCtbivacred10() {
        return ctbivacred10;
    }

    public void setCtbivacred10(String ctbivacred10) {
        this.ctbivacred10 = ctbivacred10;
    }

    public String getCtbivacred10nombre() {
        return ctbivacred10nombre;
    }

    public void setCtbivacred10nombre(String ctbivacred10nombre) {
        this.ctbivacred10nombre = ctbivacred10nombre;
    }

    public String getCtbivadeb5() {
        return ctbivadeb5;
    }

    public void setCtbivadeb5(String ctbivadeb5) {
        this.ctbivadeb5 = ctbivadeb5;
    }

    public String getCtbivadeb5nombre() {
        return ctbivadeb5nombre;
    }

    public void setCtbivadeb5nombre(String ctbivadeb5nombre) {
        this.ctbivadeb5nombre = ctbivadeb5nombre;
    }

    public String getCtbivadeb10() {
        return ctbivadeb10;
    }

    public void setCtbivadeb10(String ctbivadeb10) {
        this.ctbivadeb10 = ctbivadeb10;
    }

    public String getCtbivadeb10nombre() {
        return ctbivadeb10nombre;
    }

    public void setCtbivadeb10nombre(String ctbivadeb10nombre) {
        this.ctbivadeb10nombre = ctbivadeb10nombre;
    }

    public String getCtbfondofijo() {
        return ctbfondofijo;
    }

    public void setCtbfondofijo(String ctbfondofijo) {
        this.ctbfondofijo = ctbfondofijo;
    }

    public String getCtbfondofijonombre() {
        return ctbfondofijonombre;
    }

    public void setCtbfondofijonombre(String ctbfondofijonombre) {
        this.ctbfondofijonombre = ctbfondofijonombre;
    }

    public String getCtbproveedorretiva() {
        return ctbproveedorretiva;
    }

    public void setCtbproveedorretiva(String ctbproveedorretiva) {
        this.ctbproveedorretiva = ctbproveedorretiva;
    }

    public String getCtbproveedorretivanombre() {
        return ctbproveedorretivanombre;
    }

    public void setCtbproveedorretivanombre(String ctbproveedorretivanombre) {
        this.ctbproveedorretivanombre = ctbproveedorretivanombre;
    }

    public String getCtbclienteretiva() {
        return ctbclienteretiva;
    }

    public void setCtbclienteretiva(String ctbclienteretiva) {
        this.ctbclienteretiva = ctbclienteretiva;
    }

    public String getCtbclienteretivanombre() {
        return ctbclienteretivanombre;
    }

    public void setCtbclienteretivanombre(String ctbclienteretivanombre) {
        this.ctbclienteretivanombre = ctbclienteretivanombre;
    }

    public String getCtbretencionrenta() {
        return ctbretencionrenta;
    }

    public void setCtbretencionrenta(String ctbretencionrenta) {
        this.ctbretencionrenta = ctbretencionrenta;
    }

    public String getCtbretencionrentanombre() {
        return ctbretencionrentanombre;
    }

    public void setCtbretencionrentanombre(String ctbretencionrentanombre) {
        this.ctbretencionrentanombre = ctbretencionrentanombre;
    }

    public String getCtbdifcambioing() {
        return ctbdifcambioing;
    }

    public void setCtbdifcambioing(String ctbdifcambioing) {
        this.ctbdifcambioing = ctbdifcambioing;
    }

    public String getCtbdifcambioingnombre() {
        return ctbdifcambioingnombre;
    }

    public void setCtbdifcambioingnombre(String ctbdifcambioingnombre) {
        this.ctbdifcambioingnombre = ctbdifcambioingnombre;
    }

    public String getCtbdifcambioegr() {
        return ctbdifcambioegr;
    }

    public void setCtbdifcambioegr(String ctbdifcambioegr) {
        this.ctbdifcambioegr = ctbdifcambioegr;
    }

    public String getCtbdifcambioegrnombre() {
        return ctbdifcambioegrnombre;
    }

    public void setCtbdifcambioegrnombre(String ctbdifcambioegrnombre) {
        this.ctbdifcambioegrnombre = ctbdifcambioegrnombre;
    }

    public String getCtbipsgasto() {
        return ctbipsgasto;
    }

    public void setCtbipsgasto(String ctbipsgasto) {
        this.ctbipsgasto = ctbipsgasto;
    }

    public String getCtbipsgastonombre() {
        return ctbipsgastonombre;
    }

    public void setCtbipsgastonombre(String ctbipsgastonombre) {
        this.ctbipsgastonombre = ctbipsgastonombre;
    }

    public String getCtbipspagar() {
        return ctbipspagar;
    }

    public void setCtbipspagar(String ctbipspagar) {
        this.ctbipspagar = ctbipspagar;
    }

    public String getCtbipspagarnombre() {
        return ctbipspagarnombre;
    }

    public void setCtbipspagarnombre(String ctbipspagarnombre) {
        this.ctbipspagarnombre = ctbipspagarnombre;
    }

    public String getCtbipsgastoobr() {
        return ctbipsgastoobr;
    }

    public void setCtbipsgastoobr(String ctbipsgastoobr) {
        this.ctbipsgastoobr = ctbipsgastoobr;
    }

    public String getCtbipsgastoobrnombre() {
        return ctbipsgastoobrnombre;
    }

    public void setCtbipsgastoobrnombre(String ctbipsgastoobrnombre) {
        this.ctbipsgastoobrnombre = ctbipsgastoobrnombre;
    }
    
}
