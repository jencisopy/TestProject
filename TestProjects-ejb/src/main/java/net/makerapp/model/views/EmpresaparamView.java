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
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "empresaparam_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaparamView.findAll", query = "SELECT e FROM EmpresaparamView e")})
public class EmpresaparamView extends DataRow implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresa")
    private long idempresa;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperiodo")
    private long idperiodo;

    @Column(name = "idmonedalocal")
    private Long idmonedalocal;
    @Column(name = "idmonedacosto")
    private Long idmonedacosto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "costeo")
    private String costeo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ctrl_stk_out")
    private short ctrlStkOut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ctrl_stk_ped")
    private short ctrlStkPed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ctrl_lineacredito")
    private short ctrlLineacredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ctrl_caja_out")
    private short ctrlCajaOut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ctrl_banco_out")
    private short ctrlBancoOut;
    @Column(name = "ctrl_monedacotizacion_x_dia")
    private Boolean ctrlMonedacotizacionXDia;
    @Column(name = "ctrl_deposito_carga")
    private Short ctrlDepositoCarga;
    @Column(name = "ctrl_timbrado_vacio")
    private Boolean ctrlTimbradoVacio;
    @Column(name = "ctrl_centrocosto_vacio")
    private Boolean ctrlCentrocostoVacio;
    @Column(name = "ctrl_subrubro_vacio")
    private Boolean ctrlSubrubroVacio;
    @Column(name = "ctrl_preciovta_costo")
    private Boolean ctrlPreciovtaCosto;
    @Column(name = "ctrl_precio_orden_en_compra")
    private Boolean ctrlPrecioOrdenEnCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decimal_ml")
    private short decimalMl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decimal_me")
    private short decimalMe;
    @Column(name = "idmonedavta1")
    private Long idmonedavta1;
    @Column(name = "idmonedavta2")
    private Long idmonedavta2;
    @Column(name = "idmonedavta3")
    private Long idmonedavta3;
    @Column(name = "idmonedavta4")
    private Long idmonedavta4;
    @Column(name = "idmonedavta5")
    private Long idmonedavta5;
    @Column(name = "idmonedavta6")
    private Long idmonedavta6;
    @Column(name = "idmonedavta7")
    private Long idmonedavta7;
    @Column(name = "idmonedavta8")
    private Long idmonedavta8;
    @Column(name = "idmonedavta9")
    private Long idmonedavta9;
    @Column(name = "idmonedavta10")
    private Long idmonedavta10;
    @Column(name = "ventapreciodecimal")
    private Short ventapreciodecimal;
    @Column(name = "ventacantidaddecimal")
    private Short ventacantidaddecimal;
    @Column(name = "ventanegativa")
    private Boolean ventanegativa;
    @Size(max = 3)
    @Column(name = "ventadepositodefault")
    private String ventadepositodefault;
    @Size(max = 3)
    @Column(name = "ventamonedadefault")
    private String ventamonedadefault;
    @Size(max = 11)
    @Column(name = "ventavendedordefault")
    private String ventavendedordefault;
    @Size(max = 11)
    @Column(name = "ventaclientedefault")
    private String ventaclientedefault;
    @Size(max = 2)
    @Column(name = "ventalistapreciodefault")
    private String ventalistapreciodefault;
    @Size(max = 2)
    @Column(name = "ventaconceptodefault")
    private String ventaconceptodefault;
    @Size(max = 3)
    @Column(name = "ventarubrodefault")
    private String ventarubrodefault;
    @Size(max = 3)
    @Column(name = "ventasubrubrodefault")
    private String ventasubrubrodefault;
    @Size(max = 8)
    @Column(name = "ventacentrocostodefault")
    private String ventacentrocostodefault;
    @Column(name = "ventaconfirmadodefault")
    private Boolean ventaconfirmadodefault;
    @Column(name = "ventapreciodisable")
    private Boolean ventapreciodisable;
    @Column(name = "ventapreciotaxdisable")
    private Boolean ventapreciotaxdisable;
    @Column(name = "venta_ctrl_item_dup")
    private Boolean ventaCtrlItemDup;
    @Column(name = "venta_de_puntovta_default")
    private Boolean ventaDePuntovtaDefault;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "venta_porc_min_utilidad")
    private BigDecimal ventaPorcMinUtilidad;
    @Column(name = "venta_notificar_stockminimo")
    private Boolean ventaNotificarStockminimo;
    @Column(name = "venta_combo_nodetallar")
    private Boolean ventaComboNodetallar;
    @Column(name = "venta_redondeo_detalle_usd")
    private Boolean ventaRedondeoDetalleUsd;
    @Column(name = "venta_redondeo_detalle_usddec")
    private Short ventaRedondeoDetalleUsddec;
    @Column(name = "meta_x_marca")
    private Boolean metaXMarca;
    @Column(name = "meta_x_clase")
    private Boolean metaXClase;
    @Column(name = "meta_x_familia")
    private Boolean metaXFamilia;
    @Column(name = "meta_x_familiagrupo")
    private Boolean metaXFamiliagrupo;
    @Column(name = "meta_x_item")
    private Boolean metaXItem;
    @Column(name = "meta_x_ctactetipo")
    private Boolean metaXCtactetipo;
    @Column(name = "meta_x_ctacte")
    private Boolean metaXCtacte;
    @Column(name = "meta_x_zona")
    private Boolean metaXZona;
    @Column(name = "comprapreciodecimal")
    private Short comprapreciodecimal;
    @Column(name = "compracantidaddecimal")
    private Short compracantidaddecimal;
    @Size(max = 3)
    @Column(name = "compradepositodefault")
    private String compradepositodefault;
    @Size(max = 3)
    @Column(name = "compramonedadefault")
    private String compramonedadefault;
    @Size(max = 11)
    @Column(name = "compraproveedordefault")
    private String compraproveedordefault;
    @Size(max = 2)
    @Column(name = "compraconceptodefault")
    private String compraconceptodefault;
    @Size(max = 3)
    @Column(name = "comprarubrodefault")
    private String comprarubrodefault;
    @Size(max = 3)
    @Column(name = "comprasubrubrodefault")
    private String comprasubrubrodefault;
    @Column(name = "compraconfirmadodefault")
    private Boolean compraconfirmadodefault;
    @Column(name = "compravtaredondeototal")
    private Boolean compravtaredondeototal;
    @Column(name = "comprapreciodisable")
    private Boolean comprapreciodisable;
    @Column(name = "comprapreciotaxdisable")
    private Boolean comprapreciotaxdisable;
    @Column(name = "compra_porcvariacion_notificar")
    private BigDecimal compraPorcvariacionNotificar;
    @Column(name = "compra_afecta_costovisible")
    private Boolean compraAfectaCostovisible;
    @Column(name = "fondofijoenlacetesoreria")
    private Boolean fondofijoenlacetesoreria;
    @Column(name = "fondofijo_nro_x_ano")
    private Boolean fondofijoNroXAno;
    @Column(name = "cajacierreautorend")
    private Boolean cajacierreautorend;
    @Column(name = "cajacierregenegreso")
    private Boolean cajacierregenegreso;
    @Column(name = "cajacontrolaperturaper")
    private Boolean cajacontrolaperturaper;
    @Column(name = "cajaturnohs")
    private Short cajaturnohs;
    @Column(name = "cajalogallowupdate")
    private Boolean cajalogallowupdate;
    @Column(name = "cajainfversolocerrado")
    private Boolean cajainfversolocerrado;
    @Column(name = "cajaincluirremision")
    private Boolean cajaincluirremision;
    @Size(max = 3)
    @Column(name = "stockdepositodefault")
    private String stockdepositodefault;
    @Size(max = 2)
    @Column(name = "stockconceptodefault")
    private String stockconceptodefault;
    @Size(max = 3)
    @Column(name = "stockmonedadefault")
    private String stockmonedadefault;
    @Column(name = "stockpreciodecimal")
    private Short stockpreciodecimal;
    @Column(name = "stockcantidaddecimal")
    private Short stockcantidaddecimal;
    @Column(name = "stockreservatiempo")
    private Integer stockreservatiempo;
    @Column(name = "stock_costoprom_calctipo")
    private Short stockCostopromCalctipo;
    @Column(name = "clienteinteresgen")
    private Boolean clienteinteresgen;
    @Column(name = "idclienteiteminteres")
    private Long idclienteiteminteres;
    @Column(name = "idclienteitemmora")
    private Long idclienteitemmora;
    @Column(name = "clienteinteresmismorecibo")
    private Boolean clienteinteresmismorecibo;
    @Size(max = 2)
    @Column(name = "clienteinteresdebitotipo")
    private String clienteinteresdebitotipo;
    @Size(max = 2)
    @Column(name = "clienteanticipocreditotipo")
    private String clienteanticipocreditotipo;
    @Column(name = "clientecobro_mostrar_a_cobrar")
    private Long clientecobroMostrarACobrar;
    @Column(name = "clienteinteresdoc")
    private Short clienteinteresdoc;
    @Column(name = "clienteinteresgenmontomax")
    private Long clienteinteresgenmontomax;
    @Column(name = "clienteinactivonocobrar")
    private Boolean clienteinactivonocobrar;
    @Column(name = "clientecobro_masantiguo")
    private Boolean clientecobroMasantiguo;
    @Column(name = "idclienteitemanticipo")
    private Long idclienteitemanticipo;
    @Column(name = "idclientecobranzarecargo")
    private Long idclientecobranzarecargo;
    @Column(name = "idproveedoritemanticipo")
    private Long idproveedoritemanticipo;
    @Size(max = 2)
    @Column(name = "proveedoranticipocreditotipo")
    private String proveedoranticipocreditotipo;
    @Column(name = "iditeminteresdevengar")
    private Long iditeminteresdevengar;
    @Column(name = "segdefault")
    private Short segdefault;
    @Column(name = "ctactepuntoactivar")
    private Boolean ctactepuntoactivar;
    @Column(name = "ctactepuntofechaini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctactepuntofechaini;
    @Column(name = "ctactepuntodesc")
    private BigDecimal ctactepuntodesc;
    @Column(name = "ctactepuntodescporcliente")
    private Boolean ctactepuntodescporcliente;
    @Column(name = "ctactepunto_punto_monto")
    private Long ctactepuntoPuntoMonto;
    @Column(name = "idctactepuntoitemdesc")
    private Long idctactepuntoitemdesc;
    @Column(name = "idctactepuntoitemdesc2")
    private Long idctactepuntoitemdesc2;
    @Column(name = "edi_id")
    private Long ediId;
    @Size(max = 100)
    @Column(name = "edi_inbox")
    private String ediInbox;
    @Size(max = 100)
    @Column(name = "edi_outbox")
    private String ediOutbox;
    @Size(max = 100)
    @Column(name = "edi_processed")
    private String ediProcessed;
    @Size(max = 200)
    @Column(name = "documentlinkpath")
    private String documentlinkpath;
    @Column(name = "empresaunidad_activar")
    private Boolean empresaunidadActivar;
    @Column(name = "crm_proyecto_activar")
    private Boolean crmProyectoActivar;
    @Column(name = "produccion_cant_comp_decimal")
    private Short produccionCantCompDecimal;
    @Column(name = "produccion_cant_comp_redondeo")
    private Short produccionCantCompRedondeo;
    @Column(name = "gi_politicarec_mesesmora")
    private Integer giPoliticarecMesesmora;
    @Column(name = "gi_politicarec_ultpago")
    private Integer giPoliticarecUltpago;
    @Column(name = "gi_vtaenlazar")
    private Boolean giVtaenlazar;
    @Column(name = "gi_genvtacuotacobro")
    private Boolean giGenvtacuotacobro;
    @Size(max = 2)
    @Column(name = "gi_iddocumentotipo")
    private String giIddocumentotipo;
    @Size(max = 2)
    @Column(name = "gi_iddocumentotipocuota")
    private String giIddocumentotipocuota;
    @Column(name = "gi_tasamoratoria")
    private BigDecimal giTasamoratoria;
    @Column(name = "permisoporfraccion")
    private Short permisoporfraccion;
    @Column(name = "gc_politicarec_mesesmora")
    private Integer gcPoliticarecMesesmora;
    @Column(name = "gc_politicarec_ultpago")
    private Integer gcPoliticarecUltpago;
    @Column(name = "gc_vtaenlazar")
    private Boolean gcVtaenlazar;
    @Column(name = "gc_genvtacuotacobro")
    private Boolean gcGenvtacuotacobro;
    @Size(max = 2)
    @Column(name = "gc_iddocumentotipo")
    private String gcIddocumentotipo;
    @Size(max = 2)
    @Column(name = "gc_iddocumentotipocuota")
    private String gcIddocumentotipocuota;
    @Size(max = 2)
    @Column(name = "gc_iddocumentotipocuotaserv")
    private String gcIddocumentotipocuotaserv;
    @Column(name = "gc_tasamoratoria")
    private BigDecimal gcTasamoratoria;
    @Column(name = "permisoporcementerio")
    private Short permisoporcementerio;
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
    @Column(name = "gi_moratoleranciadias")
    private Short giMoratoleranciadias;
    @Column(name = "clientemoracambiar")
    private Boolean clientemoracambiar;
    @Column(name = "gi_contratoalfa")
    private Boolean giContratoalfa;
    @Size(max = 10)
    @Column(name = "gi_contratomask")
    private String giContratomask;
    @Column(name = "gc_contratoalfa")
    private Boolean gcContratoalfa;
    @Size(max = 10)
    @Column(name = "gc_contratomask")
    private String gcContratomask;
    @Column(name = "gi_lotealfa")
    private Boolean giLotealfa;
    @Column(name = "idgi_itemcomisionadm")
    private Long idgiItemcomisionadm;
    @Column(name = "idgi_itemcomisionvta")
    private Long idgiItemcomisionvta;
    @Column(name = "idgi_itemcomisioninteres")
    private Long idgiItemcomisioninteres;
    @Column(name = "venta_noctrl_secuencia")
    private Boolean ventaNoctrlSecuencia;
    @Column(name = "retenivaprovmontoimp_editar")
    private Boolean retenivaprovmontoimpEditar;
    @Column(name = "retenivacliemontoimp_editar")
    private Boolean retenivacliemontoimpEditar;
    @Column(name = "retenprov_allow_variasveces")
    private Boolean retenprovAllowVariasveces;
    @Column(name = "retenclie_allow_variasveces")
    private Boolean retenclieAllowVariasveces;
    @Column(name = "rs_platocompartidomonto")
    private BigDecimal rsPlatocompartidomonto;
    @Size(max = 100)
    @Column(name = "rs_cambioguarnicionprecios")
    private String rsCambioguarnicionprecios;
    @Column(name = "cierreitem_allow_movnoconfirm")
    private Boolean cierreitemAllowMovnoconfirm;
    @Column(name = "cierreitem_allow_stocknegativo")
    private Boolean cierreitemAllowStocknegativo;
    @Size(max = 2)
    @Column(name = "clientedescuentocreditotipo")
    private String clientedescuentocreditotipo;
    @Column(name = "ctrl_itemlistaprecio")
    private Short ctrlItemlistaprecio;
    @Column(name = "permisoporsucursal")
    private Short permisoporsucursal;
    @Column(name = "permisopordeposito")
    private Short permisopordeposito;
    @Column(name = "permisoporcaja")
    private Short permisoporcaja;
    @Column(name = "permisoporcrm_proyecto")
    private Short permisoporcrmProyecto;
    @Column(name = "permisoporcentrocosto")
    private Short permisoporcentrocosto;
    @Column(name = "permisoporlistaprecio")
    private Short permisoporlistaprecio;
    @Column(name = "permisoporempresaunidad")
    private Short permisoporempresaunidad;
    @Column(name = "ventadevolucionlimitedias")
    private Long ventadevolucionlimitedias;
    @Column(name = "ventadevolucion_confactura")
    private Boolean ventadevolucionConfactura;
    @Size(max = 3)
    @Column(name = "monedalocal")
    private String monedalocal;
    @Size(max = 3)
    @Column(name = "monedacosto")
    private String monedacosto;
    @Size(max = 3)
    @Column(name = "monedavta1")
    private String monedavta1;
    @Size(max = 3)
    @Column(name = "monedavta2")
    private String monedavta2;
    @Size(max = 3)
    @Column(name = "monedavta3")
    private String monedavta3;
    @Size(max = 3)
    @Column(name = "monedavta4")
    private String monedavta4;
    @Size(max = 3)
    @Column(name = "monedavta5")
    private String monedavta5;
    @Size(max = 3)
    @Column(name = "monedavta6")
    private String monedavta6;
    @Size(max = 3)
    @Column(name = "monedavta7")
    private String monedavta7;
    @Size(max = 3)
    @Column(name = "monedavta8")
    private String monedavta8;
    @Size(max = 3)
    @Column(name = "monedavta9")
    private String monedavta9;
    @Size(max = 3)
    @Column(name = "monedavta10")
    private String monedavta10;
    @Size(max = 16)
    @Column(name = "clienteiteminteres")
    private String clienteiteminteres;
    @Size(max = 50)
    @Column(name = "clienteiteminteresnombre")
    private String clienteiteminteresnombre;
    @Size(max = 16)
    @Column(name = "clienteitemmora")
    private String clienteitemmora;
    @Size(max = 50)
    @Column(name = "clienteitemmoranombre")
    private String clienteitemmoranombre;
    @Size(max = 16)
    @Column(name = "proveedoritemanticipo")
    private String proveedoritemanticipo;
    @Size(max = 50)
    @Column(name = "proveedoritemanticiponombre")
    private String proveedoritemanticiponombre;
    @Size(max = 16)
    @Column(name = "ctactepuntoitemdesc")
    private String ctactepuntoitemdesc;
    @Size(max = 50)
    @Column(name = "ctactepuntoitemdescnombre")
    private String ctactepuntoitemdescnombre;
    @Size(max = 16)
    @Column(name = "ctactepuntoitemdesc2")
    private String ctactepuntoitemdesc2;
    @Size(max = 50)
    @Column(name = "ctactepuntoitemdesc2nombre")
    private String ctactepuntoitemdesc2nombre;
    @Size(max = 16)
    @Column(name = "clienteitemanticipo")
    private String clienteitemanticipo;
    @Size(max = 50)
    @Column(name = "clienteitemanticiponombre")
    private String clienteitemanticiponombre;
    @Size(max = 16)
    @Column(name = "iteminteresdevengar")
    private String iteminteresdevengar;
    @Size(max = 50)
    @Column(name = "iteminteresdevengarnombre")
    private String iteminteresdevengarnombre;
    @Size(max = 16)
    @Column(name = "clientecobranzarecargo")
    private String clientecobranzarecargo;
    @Size(max = 50)
    @Column(name = "clientecobranzarecargonombre")
    private String clientecobranzarecargonombre;
    @Size(max = 16)
    @Column(name = "gi_itemcomisionadm")
    private String giItemcomisionadm;
    @Size(max = 50)
    @Column(name = "gi_itemcomisionadmnombre")
    private String giItemcomisionadmnombre;
    @Size(max = 16)
    @Column(name = "gi_itemcomisionvta")
    private String giItemcomisionvta;
    @Size(max = 50)
    @Column(name = "gi_itemcomisionvtanombre")
    private String giItemcomisionvtanombre;
    @Size(max = 16)
    @Column(name = "gi_itemcomisioninteres")
    private String giItemcomisioninteres;
    @Size(max = 50)
    @Column(name = "gi_itemcomisioninteresnombre")
    private String giItemcomisioninteresnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "itemelemento")
    private String itemelemento;

    public EmpresaparamView() {
    }

    
    public long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }

    public long getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(long idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Long getIdmonedalocal() {
        return idmonedalocal;
    }

    public void setIdmonedalocal(Long idmonedalocal) {
        this.idmonedalocal = idmonedalocal;
    }

    public Long getIdmonedacosto() {
        return idmonedacosto;
    }

    public void setIdmonedacosto(Long idmonedacosto) {
        this.idmonedacosto = idmonedacosto;
    }

    public String getCosteo() {
        return costeo;
    }

    public void setCosteo(String costeo) {
        this.costeo = costeo;
    }

    public short getCtrlStkOut() {
        return ctrlStkOut;
    }

    public void setCtrlStkOut(short ctrlStkOut) {
        this.ctrlStkOut = ctrlStkOut;
    }

    public short getCtrlStkPed() {
        return ctrlStkPed;
    }

    public void setCtrlStkPed(short ctrlStkPed) {
        this.ctrlStkPed = ctrlStkPed;
    }

    public short getCtrlLineacredito() {
        return ctrlLineacredito;
    }

    public void setCtrlLineacredito(short ctrlLineacredito) {
        this.ctrlLineacredito = ctrlLineacredito;
    }

    public short getCtrlCajaOut() {
        return ctrlCajaOut;
    }

    public void setCtrlCajaOut(short ctrlCajaOut) {
        this.ctrlCajaOut = ctrlCajaOut;
    }

    public short getCtrlBancoOut() {
        return ctrlBancoOut;
    }

    public void setCtrlBancoOut(short ctrlBancoOut) {
        this.ctrlBancoOut = ctrlBancoOut;
    }

    public Boolean getCtrlMonedacotizacionXDia() {
        return ctrlMonedacotizacionXDia;
    }

    public void setCtrlMonedacotizacionXDia(Boolean ctrlMonedacotizacionXDia) {
        this.ctrlMonedacotizacionXDia = ctrlMonedacotizacionXDia;
    }

    public Short getCtrlDepositoCarga() {
        return ctrlDepositoCarga;
    }

    public void setCtrlDepositoCarga(Short ctrlDepositoCarga) {
        this.ctrlDepositoCarga = ctrlDepositoCarga;
    }

    public Boolean getCtrlTimbradoVacio() {
        return ctrlTimbradoVacio;
    }

    public void setCtrlTimbradoVacio(Boolean ctrlTimbradoVacio) {
        this.ctrlTimbradoVacio = ctrlTimbradoVacio;
    }

    public Boolean getCtrlCentrocostoVacio() {
        return ctrlCentrocostoVacio;
    }

    public void setCtrlCentrocostoVacio(Boolean ctrlCentrocostoVacio) {
        this.ctrlCentrocostoVacio = ctrlCentrocostoVacio;
    }

    public Boolean getCtrlSubrubroVacio() {
        return ctrlSubrubroVacio;
    }

    public void setCtrlSubrubroVacio(Boolean ctrlSubrubroVacio) {
        this.ctrlSubrubroVacio = ctrlSubrubroVacio;
    }

    public Boolean getCtrlPreciovtaCosto() {
        return ctrlPreciovtaCosto;
    }

    public void setCtrlPreciovtaCosto(Boolean ctrlPreciovtaCosto) {
        this.ctrlPreciovtaCosto = ctrlPreciovtaCosto;
    }

    public Boolean getCtrlPrecioOrdenEnCompra() {
        return ctrlPrecioOrdenEnCompra;
    }

    public void setCtrlPrecioOrdenEnCompra(Boolean ctrlPrecioOrdenEnCompra) {
        this.ctrlPrecioOrdenEnCompra = ctrlPrecioOrdenEnCompra;
    }

    public short getDecimalMl() {
        return decimalMl;
    }

    public void setDecimalMl(short decimalMl) {
        this.decimalMl = decimalMl;
    }

    public short getDecimalMe() {
        return decimalMe;
    }

    public void setDecimalMe(short decimalMe) {
        this.decimalMe = decimalMe;
    }

    public Long getIdmonedavta1() {
        return idmonedavta1;
    }

    public void setIdmonedavta1(Long idmonedavta1) {
        this.idmonedavta1 = idmonedavta1;
    }

    public Long getIdmonedavta2() {
        return idmonedavta2;
    }

    public void setIdmonedavta2(Long idmonedavta2) {
        this.idmonedavta2 = idmonedavta2;
    }

    public Long getIdmonedavta3() {
        return idmonedavta3;
    }

    public void setIdmonedavta3(Long idmonedavta3) {
        this.idmonedavta3 = idmonedavta3;
    }

    public Long getIdmonedavta4() {
        return idmonedavta4;
    }

    public void setIdmonedavta4(Long idmonedavta4) {
        this.idmonedavta4 = idmonedavta4;
    }

    public Long getIdmonedavta5() {
        return idmonedavta5;
    }

    public void setIdmonedavta5(Long idmonedavta5) {
        this.idmonedavta5 = idmonedavta5;
    }

    public Long getIdmonedavta6() {
        return idmonedavta6;
    }

    public void setIdmonedavta6(Long idmonedavta6) {
        this.idmonedavta6 = idmonedavta6;
    }

    public Long getIdmonedavta7() {
        return idmonedavta7;
    }

    public void setIdmonedavta7(Long idmonedavta7) {
        this.idmonedavta7 = idmonedavta7;
    }

    public Long getIdmonedavta8() {
        return idmonedavta8;
    }

    public void setIdmonedavta8(Long idmonedavta8) {
        this.idmonedavta8 = idmonedavta8;
    }

    public Long getIdmonedavta9() {
        return idmonedavta9;
    }

    public void setIdmonedavta9(Long idmonedavta9) {
        this.idmonedavta9 = idmonedavta9;
    }

    public Long getIdmonedavta10() {
        return idmonedavta10;
    }

    public void setIdmonedavta10(Long idmonedavta10) {
        this.idmonedavta10 = idmonedavta10;
    }

    public Short getVentapreciodecimal() {
        return ventapreciodecimal;
    }

    public void setVentapreciodecimal(Short ventapreciodecimal) {
        this.ventapreciodecimal = ventapreciodecimal;
    }

    public Short getVentacantidaddecimal() {
        return ventacantidaddecimal;
    }

    public void setVentacantidaddecimal(Short ventacantidaddecimal) {
        this.ventacantidaddecimal = ventacantidaddecimal;
    }

    public Boolean getVentanegativa() {
        return ventanegativa;
    }

    public void setVentanegativa(Boolean ventanegativa) {
        this.ventanegativa = ventanegativa;
    }

    public String getVentadepositodefault() {
        return ventadepositodefault;
    }

    public void setVentadepositodefault(String ventadepositodefault) {
        this.ventadepositodefault = ventadepositodefault;
    }

    public String getVentamonedadefault() {
        return ventamonedadefault;
    }

    public void setVentamonedadefault(String ventamonedadefault) {
        this.ventamonedadefault = ventamonedadefault;
    }

    public String getVentavendedordefault() {
        return ventavendedordefault;
    }

    public void setVentavendedordefault(String ventavendedordefault) {
        this.ventavendedordefault = ventavendedordefault;
    }

    public String getVentaclientedefault() {
        return ventaclientedefault;
    }

    public void setVentaclientedefault(String ventaclientedefault) {
        this.ventaclientedefault = ventaclientedefault;
    }

    public String getVentalistapreciodefault() {
        return ventalistapreciodefault;
    }

    public void setVentalistapreciodefault(String ventalistapreciodefault) {
        this.ventalistapreciodefault = ventalistapreciodefault;
    }

    public String getVentaconceptodefault() {
        return ventaconceptodefault;
    }

    public void setVentaconceptodefault(String ventaconceptodefault) {
        this.ventaconceptodefault = ventaconceptodefault;
    }

    public String getVentarubrodefault() {
        return ventarubrodefault;
    }

    public void setVentarubrodefault(String ventarubrodefault) {
        this.ventarubrodefault = ventarubrodefault;
    }

    public String getVentasubrubrodefault() {
        return ventasubrubrodefault;
    }

    public void setVentasubrubrodefault(String ventasubrubrodefault) {
        this.ventasubrubrodefault = ventasubrubrodefault;
    }

    public String getVentacentrocostodefault() {
        return ventacentrocostodefault;
    }

    public void setVentacentrocostodefault(String ventacentrocostodefault) {
        this.ventacentrocostodefault = ventacentrocostodefault;
    }

    public Boolean getVentaconfirmadodefault() {
        return ventaconfirmadodefault;
    }

    public void setVentaconfirmadodefault(Boolean ventaconfirmadodefault) {
        this.ventaconfirmadodefault = ventaconfirmadodefault;
    }

    public Boolean getVentapreciodisable() {
        return ventapreciodisable;
    }

    public void setVentapreciodisable(Boolean ventapreciodisable) {
        this.ventapreciodisable = ventapreciodisable;
    }

    public Boolean getVentapreciotaxdisable() {
        return ventapreciotaxdisable;
    }

    public void setVentapreciotaxdisable(Boolean ventapreciotaxdisable) {
        this.ventapreciotaxdisable = ventapreciotaxdisable;
    }

    public Boolean getVentaCtrlItemDup() {
        return ventaCtrlItemDup;
    }

    public void setVentaCtrlItemDup(Boolean ventaCtrlItemDup) {
        this.ventaCtrlItemDup = ventaCtrlItemDup;
    }

    public Boolean getVentaDePuntovtaDefault() {
        return ventaDePuntovtaDefault;
    }

    public void setVentaDePuntovtaDefault(Boolean ventaDePuntovtaDefault) {
        this.ventaDePuntovtaDefault = ventaDePuntovtaDefault;
    }

    public BigDecimal getVentaPorcMinUtilidad() {
        return ventaPorcMinUtilidad;
    }

    public void setVentaPorcMinUtilidad(BigDecimal ventaPorcMinUtilidad) {
        this.ventaPorcMinUtilidad = ventaPorcMinUtilidad;
    }

    public Boolean getVentaNotificarStockminimo() {
        return ventaNotificarStockminimo;
    }

    public void setVentaNotificarStockminimo(Boolean ventaNotificarStockminimo) {
        this.ventaNotificarStockminimo = ventaNotificarStockminimo;
    }

    public Boolean getVentaComboNodetallar() {
        return ventaComboNodetallar;
    }

    public void setVentaComboNodetallar(Boolean ventaComboNodetallar) {
        this.ventaComboNodetallar = ventaComboNodetallar;
    }

    public Boolean getVentaRedondeoDetalleUsd() {
        return ventaRedondeoDetalleUsd;
    }

    public void setVentaRedondeoDetalleUsd(Boolean ventaRedondeoDetalleUsd) {
        this.ventaRedondeoDetalleUsd = ventaRedondeoDetalleUsd;
    }

    public Short getVentaRedondeoDetalleUsddec() {
        return ventaRedondeoDetalleUsddec;
    }

    public void setVentaRedondeoDetalleUsddec(Short ventaRedondeoDetalleUsddec) {
        this.ventaRedondeoDetalleUsddec = ventaRedondeoDetalleUsddec;
    }

    public Boolean getMetaXMarca() {
        return metaXMarca;
    }

    public void setMetaXMarca(Boolean metaXMarca) {
        this.metaXMarca = metaXMarca;
    }

    public Boolean getMetaXClase() {
        return metaXClase;
    }

    public void setMetaXClase(Boolean metaXClase) {
        this.metaXClase = metaXClase;
    }

    public Boolean getMetaXFamilia() {
        return metaXFamilia;
    }

    public void setMetaXFamilia(Boolean metaXFamilia) {
        this.metaXFamilia = metaXFamilia;
    }

    public Boolean getMetaXFamiliagrupo() {
        return metaXFamiliagrupo;
    }

    public void setMetaXFamiliagrupo(Boolean metaXFamiliagrupo) {
        this.metaXFamiliagrupo = metaXFamiliagrupo;
    }

    public Boolean getMetaXItem() {
        return metaXItem;
    }

    public void setMetaXItem(Boolean metaXItem) {
        this.metaXItem = metaXItem;
    }

    public Boolean getMetaXCtactetipo() {
        return metaXCtactetipo;
    }

    public void setMetaXCtactetipo(Boolean metaXCtactetipo) {
        this.metaXCtactetipo = metaXCtactetipo;
    }

    public Boolean getMetaXCtacte() {
        return metaXCtacte;
    }

    public void setMetaXCtacte(Boolean metaXCtacte) {
        this.metaXCtacte = metaXCtacte;
    }

    public Boolean getMetaXZona() {
        return metaXZona;
    }

    public void setMetaXZona(Boolean metaXZona) {
        this.metaXZona = metaXZona;
    }

    public Short getComprapreciodecimal() {
        return comprapreciodecimal;
    }

    public void setComprapreciodecimal(Short comprapreciodecimal) {
        this.comprapreciodecimal = comprapreciodecimal;
    }

    public Short getCompracantidaddecimal() {
        return compracantidaddecimal;
    }

    public void setCompracantidaddecimal(Short compracantidaddecimal) {
        this.compracantidaddecimal = compracantidaddecimal;
    }

    public String getCompradepositodefault() {
        return compradepositodefault;
    }

    public void setCompradepositodefault(String compradepositodefault) {
        this.compradepositodefault = compradepositodefault;
    }

    public String getCompramonedadefault() {
        return compramonedadefault;
    }

    public void setCompramonedadefault(String compramonedadefault) {
        this.compramonedadefault = compramonedadefault;
    }

    public String getCompraproveedordefault() {
        return compraproveedordefault;
    }

    public void setCompraproveedordefault(String compraproveedordefault) {
        this.compraproveedordefault = compraproveedordefault;
    }

    public String getCompraconceptodefault() {
        return compraconceptodefault;
    }

    public void setCompraconceptodefault(String compraconceptodefault) {
        this.compraconceptodefault = compraconceptodefault;
    }

    public String getComprarubrodefault() {
        return comprarubrodefault;
    }

    public void setComprarubrodefault(String comprarubrodefault) {
        this.comprarubrodefault = comprarubrodefault;
    }

    public String getComprasubrubrodefault() {
        return comprasubrubrodefault;
    }

    public void setComprasubrubrodefault(String comprasubrubrodefault) {
        this.comprasubrubrodefault = comprasubrubrodefault;
    }

    public Boolean getCompraconfirmadodefault() {
        return compraconfirmadodefault;
    }

    public void setCompraconfirmadodefault(Boolean compraconfirmadodefault) {
        this.compraconfirmadodefault = compraconfirmadodefault;
    }

    public Boolean getCompravtaredondeototal() {
        return compravtaredondeototal;
    }

    public void setCompravtaredondeototal(Boolean compravtaredondeototal) {
        this.compravtaredondeototal = compravtaredondeototal;
    }

    public Boolean getComprapreciodisable() {
        return comprapreciodisable;
    }

    public void setComprapreciodisable(Boolean comprapreciodisable) {
        this.comprapreciodisable = comprapreciodisable;
    }

    public Boolean getComprapreciotaxdisable() {
        return comprapreciotaxdisable;
    }

    public void setComprapreciotaxdisable(Boolean comprapreciotaxdisable) {
        this.comprapreciotaxdisable = comprapreciotaxdisable;
    }

    public BigDecimal getCompraPorcvariacionNotificar() {
        return compraPorcvariacionNotificar;
    }

    public void setCompraPorcvariacionNotificar(BigDecimal compraPorcvariacionNotificar) {
        this.compraPorcvariacionNotificar = compraPorcvariacionNotificar;
    }

    public Boolean getCompraAfectaCostovisible() {
        return compraAfectaCostovisible;
    }

    public void setCompraAfectaCostovisible(Boolean compraAfectaCostovisible) {
        this.compraAfectaCostovisible = compraAfectaCostovisible;
    }

    public Boolean getFondofijoenlacetesoreria() {
        return fondofijoenlacetesoreria;
    }

    public void setFondofijoenlacetesoreria(Boolean fondofijoenlacetesoreria) {
        this.fondofijoenlacetesoreria = fondofijoenlacetesoreria;
    }

    public Boolean getFondofijoNroXAno() {
        return fondofijoNroXAno;
    }

    public void setFondofijoNroXAno(Boolean fondofijoNroXAno) {
        this.fondofijoNroXAno = fondofijoNroXAno;
    }

    public Boolean getCajacierreautorend() {
        return cajacierreautorend;
    }

    public void setCajacierreautorend(Boolean cajacierreautorend) {
        this.cajacierreautorend = cajacierreautorend;
    }

    public Boolean getCajacierregenegreso() {
        return cajacierregenegreso;
    }

    public void setCajacierregenegreso(Boolean cajacierregenegreso) {
        this.cajacierregenegreso = cajacierregenegreso;
    }

    public Boolean getCajacontrolaperturaper() {
        return cajacontrolaperturaper;
    }

    public void setCajacontrolaperturaper(Boolean cajacontrolaperturaper) {
        this.cajacontrolaperturaper = cajacontrolaperturaper;
    }

    public Short getCajaturnohs() {
        return cajaturnohs;
    }

    public void setCajaturnohs(Short cajaturnohs) {
        this.cajaturnohs = cajaturnohs;
    }

    public Boolean getCajalogallowupdate() {
        return cajalogallowupdate;
    }

    public void setCajalogallowupdate(Boolean cajalogallowupdate) {
        this.cajalogallowupdate = cajalogallowupdate;
    }

    public Boolean getCajainfversolocerrado() {
        return cajainfversolocerrado;
    }

    public void setCajainfversolocerrado(Boolean cajainfversolocerrado) {
        this.cajainfversolocerrado = cajainfversolocerrado;
    }

    public Boolean getCajaincluirremision() {
        return cajaincluirremision;
    }

    public void setCajaincluirremision(Boolean cajaincluirremision) {
        this.cajaincluirremision = cajaincluirremision;
    }

    public String getStockdepositodefault() {
        return stockdepositodefault;
    }

    public void setStockdepositodefault(String stockdepositodefault) {
        this.stockdepositodefault = stockdepositodefault;
    }

    public String getStockconceptodefault() {
        return stockconceptodefault;
    }

    public void setStockconceptodefault(String stockconceptodefault) {
        this.stockconceptodefault = stockconceptodefault;
    }

    public String getStockmonedadefault() {
        return stockmonedadefault;
    }

    public void setStockmonedadefault(String stockmonedadefault) {
        this.stockmonedadefault = stockmonedadefault;
    }

    public Short getStockpreciodecimal() {
        return stockpreciodecimal;
    }

    public void setStockpreciodecimal(Short stockpreciodecimal) {
        this.stockpreciodecimal = stockpreciodecimal;
    }

    public Short getStockcantidaddecimal() {
        return stockcantidaddecimal;
    }

    public void setStockcantidaddecimal(Short stockcantidaddecimal) {
        this.stockcantidaddecimal = stockcantidaddecimal;
    }

    public Integer getStockreservatiempo() {
        return stockreservatiempo;
    }

    public void setStockreservatiempo(Integer stockreservatiempo) {
        this.stockreservatiempo = stockreservatiempo;
    }

    public Short getStockCostopromCalctipo() {
        return stockCostopromCalctipo;
    }

    public void setStockCostopromCalctipo(Short stockCostopromCalctipo) {
        this.stockCostopromCalctipo = stockCostopromCalctipo;
    }

    public Boolean getClienteinteresgen() {
        return clienteinteresgen;
    }

    public void setClienteinteresgen(Boolean clienteinteresgen) {
        this.clienteinteresgen = clienteinteresgen;
    }

    public Long getIdclienteiteminteres() {
        return idclienteiteminteres;
    }

    public void setIdclienteiteminteres(Long idclienteiteminteres) {
        this.idclienteiteminteres = idclienteiteminteres;
    }

    public Long getIdclienteitemmora() {
        return idclienteitemmora;
    }

    public void setIdclienteitemmora(Long idclienteitemmora) {
        this.idclienteitemmora = idclienteitemmora;
    }

    public Boolean getClienteinteresmismorecibo() {
        return clienteinteresmismorecibo;
    }

    public void setClienteinteresmismorecibo(Boolean clienteinteresmismorecibo) {
        this.clienteinteresmismorecibo = clienteinteresmismorecibo;
    }

    public String getClienteinteresdebitotipo() {
        return clienteinteresdebitotipo;
    }

    public void setClienteinteresdebitotipo(String clienteinteresdebitotipo) {
        this.clienteinteresdebitotipo = clienteinteresdebitotipo;
    }

    public String getClienteanticipocreditotipo() {
        return clienteanticipocreditotipo;
    }

    public void setClienteanticipocreditotipo(String clienteanticipocreditotipo) {
        this.clienteanticipocreditotipo = clienteanticipocreditotipo;
    }

    public Long getClientecobroMostrarACobrar() {
        return clientecobroMostrarACobrar;
    }

    public void setClientecobroMostrarACobrar(Long clientecobroMostrarACobrar) {
        this.clientecobroMostrarACobrar = clientecobroMostrarACobrar;
    }

    public Short getClienteinteresdoc() {
        return clienteinteresdoc;
    }

    public void setClienteinteresdoc(Short clienteinteresdoc) {
        this.clienteinteresdoc = clienteinteresdoc;
    }

    public Long getClienteinteresgenmontomax() {
        return clienteinteresgenmontomax;
    }

    public void setClienteinteresgenmontomax(Long clienteinteresgenmontomax) {
        this.clienteinteresgenmontomax = clienteinteresgenmontomax;
    }

    public Boolean getClienteinactivonocobrar() {
        return clienteinactivonocobrar;
    }

    public void setClienteinactivonocobrar(Boolean clienteinactivonocobrar) {
        this.clienteinactivonocobrar = clienteinactivonocobrar;
    }

    public Boolean getClientecobroMasantiguo() {
        return clientecobroMasantiguo;
    }

    public void setClientecobroMasantiguo(Boolean clientecobroMasantiguo) {
        this.clientecobroMasantiguo = clientecobroMasantiguo;
    }

    public Long getIdclienteitemanticipo() {
        return idclienteitemanticipo;
    }

    public void setIdclienteitemanticipo(Long idclienteitemanticipo) {
        this.idclienteitemanticipo = idclienteitemanticipo;
    }

    public Long getIdclientecobranzarecargo() {
        return idclientecobranzarecargo;
    }

    public void setIdclientecobranzarecargo(Long idclientecobranzarecargo) {
        this.idclientecobranzarecargo = idclientecobranzarecargo;
    }

    public Long getIdproveedoritemanticipo() {
        return idproveedoritemanticipo;
    }

    public void setIdproveedoritemanticipo(Long idproveedoritemanticipo) {
        this.idproveedoritemanticipo = idproveedoritemanticipo;
    }

    public String getProveedoranticipocreditotipo() {
        return proveedoranticipocreditotipo;
    }

    public void setProveedoranticipocreditotipo(String proveedoranticipocreditotipo) {
        this.proveedoranticipocreditotipo = proveedoranticipocreditotipo;
    }

    public Long getIditeminteresdevengar() {
        return iditeminteresdevengar;
    }

    public void setIditeminteresdevengar(Long iditeminteresdevengar) {
        this.iditeminteresdevengar = iditeminteresdevengar;
    }

    public Short getSegdefault() {
        return segdefault;
    }

    public void setSegdefault(Short segdefault) {
        this.segdefault = segdefault;
    }

    public Boolean getCtactepuntoactivar() {
        return ctactepuntoactivar;
    }

    public void setCtactepuntoactivar(Boolean ctactepuntoactivar) {
        this.ctactepuntoactivar = ctactepuntoactivar;
    }

    public Date getCtactepuntofechaini() {
        return ctactepuntofechaini;
    }

    public void setCtactepuntofechaini(Date ctactepuntofechaini) {
        this.ctactepuntofechaini = ctactepuntofechaini;
    }

    public BigDecimal getCtactepuntodesc() {
        return ctactepuntodesc;
    }

    public void setCtactepuntodesc(BigDecimal ctactepuntodesc) {
        this.ctactepuntodesc = ctactepuntodesc;
    }

    public Boolean getCtactepuntodescporcliente() {
        return ctactepuntodescporcliente;
    }

    public void setCtactepuntodescporcliente(Boolean ctactepuntodescporcliente) {
        this.ctactepuntodescporcliente = ctactepuntodescporcliente;
    }

    public Long getCtactepuntoPuntoMonto() {
        return ctactepuntoPuntoMonto;
    }

    public void setCtactepuntoPuntoMonto(Long ctactepuntoPuntoMonto) {
        this.ctactepuntoPuntoMonto = ctactepuntoPuntoMonto;
    }

    public Long getIdctactepuntoitemdesc() {
        return idctactepuntoitemdesc;
    }

    public void setIdctactepuntoitemdesc(Long idctactepuntoitemdesc) {
        this.idctactepuntoitemdesc = idctactepuntoitemdesc;
    }

    public Long getIdctactepuntoitemdesc2() {
        return idctactepuntoitemdesc2;
    }

    public void setIdctactepuntoitemdesc2(Long idctactepuntoitemdesc2) {
        this.idctactepuntoitemdesc2 = idctactepuntoitemdesc2;
    }

    public Long getEdiId() {
        return ediId;
    }

    public void setEdiId(Long ediId) {
        this.ediId = ediId;
    }

    public String getEdiInbox() {
        return ediInbox;
    }

    public void setEdiInbox(String ediInbox) {
        this.ediInbox = ediInbox;
    }

    public String getEdiOutbox() {
        return ediOutbox;
    }

    public void setEdiOutbox(String ediOutbox) {
        this.ediOutbox = ediOutbox;
    }

    public String getEdiProcessed() {
        return ediProcessed;
    }

    public void setEdiProcessed(String ediProcessed) {
        this.ediProcessed = ediProcessed;
    }

    public String getDocumentlinkpath() {
        return documentlinkpath;
    }

    public void setDocumentlinkpath(String documentlinkpath) {
        this.documentlinkpath = documentlinkpath;
    }

    public Boolean getEmpresaunidadActivar() {
        return empresaunidadActivar;
    }

    public void setEmpresaunidadActivar(Boolean empresaunidadActivar) {
        this.empresaunidadActivar = empresaunidadActivar;
    }

    public Boolean getCrmProyectoActivar() {
        return crmProyectoActivar;
    }

    public void setCrmProyectoActivar(Boolean crmProyectoActivar) {
        this.crmProyectoActivar = crmProyectoActivar;
    }

    public Short getProduccionCantCompDecimal() {
        return produccionCantCompDecimal;
    }

    public void setProduccionCantCompDecimal(Short produccionCantCompDecimal) {
        this.produccionCantCompDecimal = produccionCantCompDecimal;
    }

    public Short getProduccionCantCompRedondeo() {
        return produccionCantCompRedondeo;
    }

    public void setProduccionCantCompRedondeo(Short produccionCantCompRedondeo) {
        this.produccionCantCompRedondeo = produccionCantCompRedondeo;
    }

    public Integer getGiPoliticarecMesesmora() {
        return giPoliticarecMesesmora;
    }

    public void setGiPoliticarecMesesmora(Integer giPoliticarecMesesmora) {
        this.giPoliticarecMesesmora = giPoliticarecMesesmora;
    }

    public Integer getGiPoliticarecUltpago() {
        return giPoliticarecUltpago;
    }

    public void setGiPoliticarecUltpago(Integer giPoliticarecUltpago) {
        this.giPoliticarecUltpago = giPoliticarecUltpago;
    }

    public Boolean getGiVtaenlazar() {
        return giVtaenlazar;
    }

    public void setGiVtaenlazar(Boolean giVtaenlazar) {
        this.giVtaenlazar = giVtaenlazar;
    }

    public Boolean getGiGenvtacuotacobro() {
        return giGenvtacuotacobro;
    }

    public void setGiGenvtacuotacobro(Boolean giGenvtacuotacobro) {
        this.giGenvtacuotacobro = giGenvtacuotacobro;
    }

    public String getGiIddocumentotipo() {
        return giIddocumentotipo;
    }

    public void setGiIddocumentotipo(String giIddocumentotipo) {
        this.giIddocumentotipo = giIddocumentotipo;
    }

    public String getGiIddocumentotipocuota() {
        return giIddocumentotipocuota;
    }

    public void setGiIddocumentotipocuota(String giIddocumentotipocuota) {
        this.giIddocumentotipocuota = giIddocumentotipocuota;
    }

    public BigDecimal getGiTasamoratoria() {
        return giTasamoratoria;
    }

    public void setGiTasamoratoria(BigDecimal giTasamoratoria) {
        this.giTasamoratoria = giTasamoratoria;
    }

    public Short getPermisoporfraccion() {
        return permisoporfraccion;
    }

    public void setPermisoporfraccion(Short permisoporfraccion) {
        this.permisoporfraccion = permisoporfraccion;
    }

    public Integer getGcPoliticarecMesesmora() {
        return gcPoliticarecMesesmora;
    }

    public void setGcPoliticarecMesesmora(Integer gcPoliticarecMesesmora) {
        this.gcPoliticarecMesesmora = gcPoliticarecMesesmora;
    }

    public Integer getGcPoliticarecUltpago() {
        return gcPoliticarecUltpago;
    }

    public void setGcPoliticarecUltpago(Integer gcPoliticarecUltpago) {
        this.gcPoliticarecUltpago = gcPoliticarecUltpago;
    }

    public Boolean getGcVtaenlazar() {
        return gcVtaenlazar;
    }

    public void setGcVtaenlazar(Boolean gcVtaenlazar) {
        this.gcVtaenlazar = gcVtaenlazar;
    }

    public Boolean getGcGenvtacuotacobro() {
        return gcGenvtacuotacobro;
    }

    public void setGcGenvtacuotacobro(Boolean gcGenvtacuotacobro) {
        this.gcGenvtacuotacobro = gcGenvtacuotacobro;
    }

    public String getGcIddocumentotipo() {
        return gcIddocumentotipo;
    }

    public void setGcIddocumentotipo(String gcIddocumentotipo) {
        this.gcIddocumentotipo = gcIddocumentotipo;
    }

    public String getGcIddocumentotipocuota() {
        return gcIddocumentotipocuota;
    }

    public void setGcIddocumentotipocuota(String gcIddocumentotipocuota) {
        this.gcIddocumentotipocuota = gcIddocumentotipocuota;
    }

    public String getGcIddocumentotipocuotaserv() {
        return gcIddocumentotipocuotaserv;
    }

    public void setGcIddocumentotipocuotaserv(String gcIddocumentotipocuotaserv) {
        this.gcIddocumentotipocuotaserv = gcIddocumentotipocuotaserv;
    }

    public BigDecimal getGcTasamoratoria() {
        return gcTasamoratoria;
    }

    public void setGcTasamoratoria(BigDecimal gcTasamoratoria) {
        this.gcTasamoratoria = gcTasamoratoria;
    }

    public Short getPermisoporcementerio() {
        return permisoporcementerio;
    }

    public void setPermisoporcementerio(Short permisoporcementerio) {
        this.permisoporcementerio = permisoporcementerio;
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

    public Short getGiMoratoleranciadias() {
        return giMoratoleranciadias;
    }

    public void setGiMoratoleranciadias(Short giMoratoleranciadias) {
        this.giMoratoleranciadias = giMoratoleranciadias;
    }

    public Boolean getClientemoracambiar() {
        return clientemoracambiar;
    }

    public void setClientemoracambiar(Boolean clientemoracambiar) {
        this.clientemoracambiar = clientemoracambiar;
    }

    public Boolean getGiContratoalfa() {
        return giContratoalfa;
    }

    public void setGiContratoalfa(Boolean giContratoalfa) {
        this.giContratoalfa = giContratoalfa;
    }

    public String getGiContratomask() {
        return giContratomask;
    }

    public void setGiContratomask(String giContratomask) {
        this.giContratomask = giContratomask;
    }

    public Boolean getGcContratoalfa() {
        return gcContratoalfa;
    }

    public void setGcContratoalfa(Boolean gcContratoalfa) {
        this.gcContratoalfa = gcContratoalfa;
    }

    public String getGcContratomask() {
        return gcContratomask;
    }

    public void setGcContratomask(String gcContratomask) {
        this.gcContratomask = gcContratomask;
    }

    public Boolean getGiLotealfa() {
        return giLotealfa;
    }

    public void setGiLotealfa(Boolean giLotealfa) {
        this.giLotealfa = giLotealfa;
    }

    public Long getIdgiItemcomisionadm() {
        return idgiItemcomisionadm;
    }

    public void setIdgiItemcomisionadm(Long idgiItemcomisionadm) {
        this.idgiItemcomisionadm = idgiItemcomisionadm;
    }

    public Long getIdgiItemcomisionvta() {
        return idgiItemcomisionvta;
    }

    public void setIdgiItemcomisionvta(Long idgiItemcomisionvta) {
        this.idgiItemcomisionvta = idgiItemcomisionvta;
    }

    public Long getIdgiItemcomisioninteres() {
        return idgiItemcomisioninteres;
    }

    public void setIdgiItemcomisioninteres(Long idgiItemcomisioninteres) {
        this.idgiItemcomisioninteres = idgiItemcomisioninteres;
    }

    public Boolean getVentaNoctrlSecuencia() {
        return ventaNoctrlSecuencia;
    }

    public void setVentaNoctrlSecuencia(Boolean ventaNoctrlSecuencia) {
        this.ventaNoctrlSecuencia = ventaNoctrlSecuencia;
    }

    public Boolean getRetenivaprovmontoimpEditar() {
        return retenivaprovmontoimpEditar;
    }

    public void setRetenivaprovmontoimpEditar(Boolean retenivaprovmontoimpEditar) {
        this.retenivaprovmontoimpEditar = retenivaprovmontoimpEditar;
    }

    public Boolean getRetenivacliemontoimpEditar() {
        return retenivacliemontoimpEditar;
    }

    public void setRetenivacliemontoimpEditar(Boolean retenivacliemontoimpEditar) {
        this.retenivacliemontoimpEditar = retenivacliemontoimpEditar;
    }

    public Boolean getRetenprovAllowVariasveces() {
        return retenprovAllowVariasveces;
    }

    public void setRetenprovAllowVariasveces(Boolean retenprovAllowVariasveces) {
        this.retenprovAllowVariasveces = retenprovAllowVariasveces;
    }

    public Boolean getRetenclieAllowVariasveces() {
        return retenclieAllowVariasveces;
    }

    public void setRetenclieAllowVariasveces(Boolean retenclieAllowVariasveces) {
        this.retenclieAllowVariasveces = retenclieAllowVariasveces;
    }

    public BigDecimal getRsPlatocompartidomonto() {
        return rsPlatocompartidomonto;
    }

    public void setRsPlatocompartidomonto(BigDecimal rsPlatocompartidomonto) {
        this.rsPlatocompartidomonto = rsPlatocompartidomonto;
    }

    public String getRsCambioguarnicionprecios() {
        return rsCambioguarnicionprecios;
    }

    public void setRsCambioguarnicionprecios(String rsCambioguarnicionprecios) {
        this.rsCambioguarnicionprecios = rsCambioguarnicionprecios;
    }

    public Boolean getCierreitemAllowMovnoconfirm() {
        return cierreitemAllowMovnoconfirm;
    }

    public void setCierreitemAllowMovnoconfirm(Boolean cierreitemAllowMovnoconfirm) {
        this.cierreitemAllowMovnoconfirm = cierreitemAllowMovnoconfirm;
    }

    public Boolean getCierreitemAllowStocknegativo() {
        return cierreitemAllowStocknegativo;
    }

    public void setCierreitemAllowStocknegativo(Boolean cierreitemAllowStocknegativo) {
        this.cierreitemAllowStocknegativo = cierreitemAllowStocknegativo;
    }

    public String getClientedescuentocreditotipo() {
        return clientedescuentocreditotipo;
    }

    public void setClientedescuentocreditotipo(String clientedescuentocreditotipo) {
        this.clientedescuentocreditotipo = clientedescuentocreditotipo;
    }

    public Short getCtrlItemlistaprecio() {
        return ctrlItemlistaprecio;
    }

    public void setCtrlItemlistaprecio(Short ctrlItemlistaprecio) {
        this.ctrlItemlistaprecio = ctrlItemlistaprecio;
    }

    public Short getPermisoporsucursal() {
        return permisoporsucursal;
    }

    public void setPermisoporsucursal(Short permisoporsucursal) {
        this.permisoporsucursal = permisoporsucursal;
    }

    public Short getPermisopordeposito() {
        return permisopordeposito;
    }

    public void setPermisopordeposito(Short permisopordeposito) {
        this.permisopordeposito = permisopordeposito;
    }

    public Short getPermisoporcaja() {
        return permisoporcaja;
    }

    public void setPermisoporcaja(Short permisoporcaja) {
        this.permisoporcaja = permisoporcaja;
    }

    public Short getPermisoporcrmProyecto() {
        return permisoporcrmProyecto;
    }

    public void setPermisoporcrmProyecto(Short permisoporcrmProyecto) {
        this.permisoporcrmProyecto = permisoporcrmProyecto;
    }

    public Short getPermisoporcentrocosto() {
        return permisoporcentrocosto;
    }

    public void setPermisoporcentrocosto(Short permisoporcentrocosto) {
        this.permisoporcentrocosto = permisoporcentrocosto;
    }

    public Short getPermisoporlistaprecio() {
        return permisoporlistaprecio;
    }

    public void setPermisoporlistaprecio(Short permisoporlistaprecio) {
        this.permisoporlistaprecio = permisoporlistaprecio;
    }

    public Short getPermisoporempresaunidad() {
        return permisoporempresaunidad;
    }

    public void setPermisoporempresaunidad(Short permisoporempresaunidad) {
        this.permisoporempresaunidad = permisoporempresaunidad;
    }

    public Long getVentadevolucionlimitedias() {
        return ventadevolucionlimitedias;
    }

    public void setVentadevolucionlimitedias(Long ventadevolucionlimitedias) {
        this.ventadevolucionlimitedias = ventadevolucionlimitedias;
    }

    public Boolean getVentadevolucionConfactura() {
        return ventadevolucionConfactura;
    }

    public void setVentadevolucionConfactura(Boolean ventadevolucionConfactura) {
        this.ventadevolucionConfactura = ventadevolucionConfactura;
    }

    public String getMonedalocal() {
        return monedalocal;
    }

    public void setMonedalocal(String monedalocal) {
        this.monedalocal = monedalocal;
    }

    public String getMonedacosto() {
        return monedacosto;
    }

    public void setMonedacosto(String monedacosto) {
        this.monedacosto = monedacosto;
    }

    public String getMonedavta1() {
        return monedavta1;
    }

    public void setMonedavta1(String monedavta1) {
        this.monedavta1 = monedavta1;
    }

    public String getMonedavta2() {
        return monedavta2;
    }

    public void setMonedavta2(String monedavta2) {
        this.monedavta2 = monedavta2;
    }

    public String getMonedavta3() {
        return monedavta3;
    }

    public void setMonedavta3(String monedavta3) {
        this.monedavta3 = monedavta3;
    }

    public String getMonedavta4() {
        return monedavta4;
    }

    public void setMonedavta4(String monedavta4) {
        this.monedavta4 = monedavta4;
    }

    public String getMonedavta5() {
        return monedavta5;
    }

    public void setMonedavta5(String monedavta5) {
        this.monedavta5 = monedavta5;
    }

    public String getMonedavta6() {
        return monedavta6;
    }

    public void setMonedavta6(String monedavta6) {
        this.monedavta6 = monedavta6;
    }

    public String getMonedavta7() {
        return monedavta7;
    }

    public void setMonedavta7(String monedavta7) {
        this.monedavta7 = monedavta7;
    }

    public String getMonedavta8() {
        return monedavta8;
    }

    public void setMonedavta8(String monedavta8) {
        this.monedavta8 = monedavta8;
    }

    public String getMonedavta9() {
        return monedavta9;
    }

    public void setMonedavta9(String monedavta9) {
        this.monedavta9 = monedavta9;
    }

    public String getMonedavta10() {
        return monedavta10;
    }

    public void setMonedavta10(String monedavta10) {
        this.monedavta10 = monedavta10;
    }

    public String getClienteiteminteres() {
        return clienteiteminteres;
    }

    public void setClienteiteminteres(String clienteiteminteres) {
        this.clienteiteminteres = clienteiteminteres;
    }

    public String getClienteiteminteresnombre() {
        return clienteiteminteresnombre;
    }

    public void setClienteiteminteresnombre(String clienteiteminteresnombre) {
        this.clienteiteminteresnombre = clienteiteminteresnombre;
    }

    public String getClienteitemmora() {
        return clienteitemmora;
    }

    public void setClienteitemmora(String clienteitemmora) {
        this.clienteitemmora = clienteitemmora;
    }

    public String getClienteitemmoranombre() {
        return clienteitemmoranombre;
    }

    public void setClienteitemmoranombre(String clienteitemmoranombre) {
        this.clienteitemmoranombre = clienteitemmoranombre;
    }

    public String getProveedoritemanticipo() {
        return proveedoritemanticipo;
    }

    public void setProveedoritemanticipo(String proveedoritemanticipo) {
        this.proveedoritemanticipo = proveedoritemanticipo;
    }

    public String getProveedoritemanticiponombre() {
        return proveedoritemanticiponombre;
    }

    public void setProveedoritemanticiponombre(String proveedoritemanticiponombre) {
        this.proveedoritemanticiponombre = proveedoritemanticiponombre;
    }

    public String getCtactepuntoitemdesc() {
        return ctactepuntoitemdesc;
    }

    public void setCtactepuntoitemdesc(String ctactepuntoitemdesc) {
        this.ctactepuntoitemdesc = ctactepuntoitemdesc;
    }

    public String getCtactepuntoitemdescnombre() {
        return ctactepuntoitemdescnombre;
    }

    public void setCtactepuntoitemdescnombre(String ctactepuntoitemdescnombre) {
        this.ctactepuntoitemdescnombre = ctactepuntoitemdescnombre;
    }

    public String getCtactepuntoitemdesc2() {
        return ctactepuntoitemdesc2;
    }

    public void setCtactepuntoitemdesc2(String ctactepuntoitemdesc2) {
        this.ctactepuntoitemdesc2 = ctactepuntoitemdesc2;
    }

    public String getCtactepuntoitemdesc2nombre() {
        return ctactepuntoitemdesc2nombre;
    }

    public void setCtactepuntoitemdesc2nombre(String ctactepuntoitemdesc2nombre) {
        this.ctactepuntoitemdesc2nombre = ctactepuntoitemdesc2nombre;
    }

    public String getClienteitemanticipo() {
        return clienteitemanticipo;
    }

    public void setClienteitemanticipo(String clienteitemanticipo) {
        this.clienteitemanticipo = clienteitemanticipo;
    }

    public String getClienteitemanticiponombre() {
        return clienteitemanticiponombre;
    }

    public void setClienteitemanticiponombre(String clienteitemanticiponombre) {
        this.clienteitemanticiponombre = clienteitemanticiponombre;
    }

    public String getIteminteresdevengar() {
        return iteminteresdevengar;
    }

    public void setIteminteresdevengar(String iteminteresdevengar) {
        this.iteminteresdevengar = iteminteresdevengar;
    }

    public String getIteminteresdevengarnombre() {
        return iteminteresdevengarnombre;
    }

    public void setIteminteresdevengarnombre(String iteminteresdevengarnombre) {
        this.iteminteresdevengarnombre = iteminteresdevengarnombre;
    }

    public String getClientecobranzarecargo() {
        return clientecobranzarecargo;
    }

    public void setClientecobranzarecargo(String clientecobranzarecargo) {
        this.clientecobranzarecargo = clientecobranzarecargo;
    }

    public String getClientecobranzarecargonombre() {
        return clientecobranzarecargonombre;
    }

    public void setClientecobranzarecargonombre(String clientecobranzarecargonombre) {
        this.clientecobranzarecargonombre = clientecobranzarecargonombre;
    }

    public String getGiItemcomisionadm() {
        return giItemcomisionadm;
    }

    public void setGiItemcomisionadm(String giItemcomisionadm) {
        this.giItemcomisionadm = giItemcomisionadm;
    }

    public String getGiItemcomisionadmnombre() {
        return giItemcomisionadmnombre;
    }

    public void setGiItemcomisionadmnombre(String giItemcomisionadmnombre) {
        this.giItemcomisionadmnombre = giItemcomisionadmnombre;
    }

    public String getGiItemcomisionvta() {
        return giItemcomisionvta;
    }

    public void setGiItemcomisionvta(String giItemcomisionvta) {
        this.giItemcomisionvta = giItemcomisionvta;
    }

    public String getGiItemcomisionvtanombre() {
        return giItemcomisionvtanombre;
    }

    public void setGiItemcomisionvtanombre(String giItemcomisionvtanombre) {
        this.giItemcomisionvtanombre = giItemcomisionvtanombre;
    }

    public String getGiItemcomisioninteres() {
        return giItemcomisioninteres;
    }

    public void setGiItemcomisioninteres(String giItemcomisioninteres) {
        this.giItemcomisioninteres = giItemcomisioninteres;
    }

    public String getGiItemcomisioninteresnombre() {
        return giItemcomisioninteresnombre;
    }

    public void setGiItemcomisioninteresnombre(String giItemcomisioninteresnombre) {
        this.giItemcomisioninteresnombre = giItemcomisioninteresnombre;
    }

    public String getItemelemento() {
        return itemelemento;
    }

    public void setItemelemento(String itemelemento) {
        this.itemelemento = itemelemento;
    }
    
}
