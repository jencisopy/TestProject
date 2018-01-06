/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.makerapp.model.views;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.javabeanstack.data.DataRow;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "RptWizardComp_view")

public class RptWizardCompView extends DataRow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idrptwizard")
    @Basic(optional = false)
    private Long idrptwizard;

    @Id
    @Column(name = "idrptwizardcomp")
    @Basic(optional = false)
    private Long idrptwizardcomp;

    @Id
    @Column(name = "idrptwizardtemplatedetail")
    @Basic(optional = false)
    private Long idrptwizardtemplatedetail;

    @Column(name = "idobjeto")
    private Long idobjeto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dic_objetocodigo")
    private String dicObjetocodigo;
    @Size(max = 50)
    @Column(name = "dic_objetonombre")
    private String dicObjetonombre;
    @Size(max = 15)
    @Column(name = "documento")
    private String documento;

    @Column(name = "documentotipo")
    private String documentoTipo;

    @Column(name = "idrptwizardtemplate")
    private Long idrptwizardtemplate;
    @Size(max = 10)
    @Column(name = "typecomponent")
    private String typecomponent;
    @Size(max = 50)
    @Column(name = "field")
    private String field;
    @Size(max = 50)
    @Column(name = "fieldlabel")
    private String fieldLabel;
    @Size(max = 30)
    @Column(name = "entityhelp")
    private String entityhelp;
    @Size(max = 20)
    @Column(name = "entityhelpfieldreturn")
    private String entityhelpfieldreturn;
    @Column(name = "leveldetail")
    private Integer leveldetail;
    @Size(max = 100)
    @Column(name = "orderfield")
    private String orderfield;
    @Size(max = 70)
    @Column(name = "reportname")
    private String reportname;
    @Size(max = 50)
    @Column(name = "TemplateName")
    private String templateName;
    @Size(max = 50)
    @Column(name = "Templatedesc")
    private String templatedesc;
    @Size(max = 50)
    @Column(name = "tmplfield")
    private String tmplfield;
    @Size(max = 50)
    @Column(name = "tmplfieldlabel")
    private String tmplfieldLabel;
    @Size(max = 30)
    @Column(name = "tmplentityhelp")
    private String tmplentityhelp;
    @Size(max = 20)
    @Column(name = "tmplentityhelpfieldreturn")
    private String tmplEntityHelpFieldReturn;
    @Column(name = "tmplleveldetail")
    private Integer tmplleveldetail;
    @Size(max = 100)
    @Column(name = "tmplorderfield")
    private String tmplorderfield;


    @Column(name = "rptcolumnpreviewgroup")
    private String rptcolumnpreviewgroup;

    @Column(name = "tmplrptcolumnpreviewgroup")
    private String tmplrptcolumnpreviewgroup;

    @Column(name = "rptcolumnpreviewsubgroup")
    private String rptcolumnpreviewsubgroup;
    
    @Column(name = "tmplrptcolumnpreviewsubgroup")
    private String tmplrptcolumnpreviewsubgroup;

    @Column(name = "rptcolumnquerygroup")
    private String rptcolumnquerygroup;

    @Column(name = "tmplrptcolumnquerygroup")
    private String tmplrptcolumnquerygroup;

    @Column(name = "rptcolumnquerysubgroup")
    private String rptcolumnquerysubgroup;
    
    @Column(name = "tmplrptcolumnquerysubgroup")
    private String tmplrptcolumnquerysubgroup;

    
    @Size(max = 70)
    @Column(name = "tmplreportname")
    private String tmplreportname;
    @Size(max = 100)
    @Column(name = "page1")
    private String page1;
    @Size(max = 100)
    @Column(name = "page2")
    private String page2;
    @Size(max = 100)
    @Column(name = "page3")
    private String page3;
    @Size(max = 100)
    @Column(name = "page4")
    private String page4;
    @Size(max = 50)
    @Column(name = "reportgroup")
    private String reportgroup;
    @Size(max = 50)
    @Column(name = "reporttype")
    private String reporttype;
    @Size(max = 200)
    @Column(name = "comentario")
    private String comentario;

    public RptWizardCompView() {
    }

    public long getIdrptwizard() {
        return idrptwizard;
    }

    public void setIdrptwizard(long idrptwizard) {
        this.idrptwizard = idrptwizard;
    }

    public Long getIdobjeto() {
        return idobjeto;
    }

    public void setIdobjeto(Long idobjeto) {
        this.idobjeto = idobjeto;
    }

    public String getDicObjetocodigo() {
        return dicObjetocodigo;
    }

    public void setDicObjetocodigo(String dicObjetocodigo) {
        this.dicObjetocodigo = dicObjetocodigo;
    }

    public String getDicObjetonombre() {
        return dicObjetonombre;
    }

    public void setDicObjetonombre(String dicObjetonombre) {
        this.dicObjetonombre = dicObjetonombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(String documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public Long getIdrptwizardtemplate() {
        return idrptwizardtemplate;
    }

    public void setIdrptwizardtemplate(Long idrptwizardtemplate) {
        this.idrptwizardtemplate = idrptwizardtemplate;
    }

    public String getTypecomponent() {
        return typecomponent;
    }

    public void setTypecomponent(String typecomponent) {
        this.typecomponent = typecomponent;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getEntityhelp() {
        return entityhelp;
    }

    public void setEntityhelp(String entityhelp) {
        this.entityhelp = entityhelp;
    }

    public Integer getLeveldetail() {
        if (leveldetail == null) {
            return 0;
        } else {
            return leveldetail;
        }
    }

    public void setLeveldetail(Integer leveldetail) {
        this.leveldetail = leveldetail;
    }

    public String getOrderfield() {
        return orderfield;
    }

    public void setOrderfield(String orderfield) {
        this.orderfield = orderfield;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTmplfield() {
        return tmplfield;
    }

    public void setTmplfield(String tmplfield) {
        this.tmplfield = tmplfield;
    }

    public String getTmplfieldLabel() {
        return tmplfieldLabel;
    }

    public void setTmplfieldLabel(String tmplfieldLabel) {
        this.tmplfieldLabel = tmplfieldLabel;
    }

    public String getTmplentityhelp() {
        return tmplentityhelp;
    }

    public void setTmplentityhelp(String tmplentityhelp) {
        this.tmplentityhelp = tmplentityhelp;
    }

    public Integer getTmplleveldetail() {
        if (tmplleveldetail == null) {
            return 0;
        } else {
            return tmplleveldetail;
        }
    }

    public void setTmplleveldetail(Integer tmplleveldetail) {
        this.tmplleveldetail = tmplleveldetail;
    }

    public String getTmplorderfield() {
        return tmplorderfield;
    }

    public void setTmplorderfield(String tmplorderfield) {
        this.tmplorderfield = tmplorderfield;
    }

    public void setIdrptwizard(Long idrptwizard) {
        this.idrptwizard = idrptwizard;
    }

    public Long getIdrptwizardcomp() {
        return idrptwizardcomp;
    }

    public void setIdrptwizardcomp(Long idrptwizardcomp) {
        this.idrptwizardcomp = idrptwizardcomp;
    }

    public Long getIdrptwizardtemplatedetail() {
        return idrptwizardtemplatedetail;
    }

    public void setIdrptwizardtemplatedetail(Long idrptwizardtemplatedetail) {
        this.idrptwizardtemplatedetail = idrptwizardtemplatedetail;
    }

    public String getTemplatedesc() {
        return templatedesc;
    }

    public void setTemplatedesc(String templatedesc) {
        this.templatedesc = templatedesc;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public String getTmplreportname() {
        return tmplreportname;
    }

    public void setTmplreportname(String tmplreportname) {
        this.tmplreportname = tmplreportname;
    }    

    public String getPage1() {
        return page1;
    }

    public void setPage1(String page1) {
        this.page1 = page1;
    }

    public String getPage2() {
        return page2;
    }

    public void setPage2(String page2) {
        this.page2 = page2;
    }

    public String getPage3() {
        return page3;
    }

    public void setPage3(String page3) {
        this.page3 = page3;
    }

    public String getPage4() {
        return page4;
    }

    public void setPage4(String page4) {
        this.page4 = page4;
    }

    public String getReportgroup() {
        return reportgroup;
    }

    public void setReportgroup(String reportgroup) {
        this.reportgroup = reportgroup;
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }

    public String getEntityhelpfieldreturn() {
        return entityhelpfieldreturn;
    }

    public void setEntityhelpfieldreturn(String entityhelpfieldreturn) {
        this.entityhelpfieldreturn = entityhelpfieldreturn;
    }

    public String getTmplEntityHelpFieldReturn() {
        return tmplEntityHelpFieldReturn;
    }

    public void setTmplEntityHelpFieldReturn(String tmplEntityHelpFieldReturn) {
        this.tmplEntityHelpFieldReturn = tmplEntityHelpFieldReturn;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

//    public String getColumnascorte() {
//        return columnascorte;
//    }
//
//    public void setColumnascorte(String columnascorte) {
//        this.columnascorte = columnascorte;
//    }
//
//    public String getCampocorte() {
//        return campocorte;
//    }
//
//    public void setCampocorte(String campocorte) {
//        this.campocorte = campocorte;
//    }
//
//    public String getTmplcolumnascorte() {
//        return tmplcolumnascorte;
//    }
//
//    public void setTmplcolumnascorte(String tmplcolumnascorte) {
//        this.tmplcolumnascorte = tmplcolumnascorte;
//    }
//
//    public String getTmplcampocorte() {
//        return tmplcampocorte;
//    }
//
//    public void setTmplcampocorte(String tmplcampocorte) {
//        this.tmplcampocorte = tmplcampocorte;
//    }

    public String getRptcolumnpreviewgroup() {
        return rptcolumnpreviewgroup;
    }

    public void setRptcolumnpreviewgroup(String rptcolumnpreviewgroup) {
        this.rptcolumnpreviewgroup = rptcolumnpreviewgroup;
    }

    public String getTmplrptcolumnpreviewgroup() {
        return tmplrptcolumnpreviewgroup;
    }

    public void setTmplrptcolumnpreviewgroup(String tmplrptcolumnpreviewgroup) {
        this.tmplrptcolumnpreviewgroup = tmplrptcolumnpreviewgroup;
    }

    public String getRptcolumnpreviewsubgroup() {
        return rptcolumnpreviewsubgroup;
    }

    public void setRptcolumnpreviewsubgroup(String rptcolumnpreviewsubgroup) {
        this.rptcolumnpreviewsubgroup = rptcolumnpreviewsubgroup;
    }

    public String getTmplrptcolumnpreviewsubgroup() {
        return tmplrptcolumnpreviewsubgroup;
    }

    public void setTmplrptcolumnpreviewsubgroup(String tmplrptcolumnpreviewsubgroup) {
        this.tmplrptcolumnpreviewsubgroup = tmplrptcolumnpreviewsubgroup;
    }

    public String getRptcolumnquerygroup() {
        return rptcolumnquerygroup;
    }

    public void setRptcolumnquerygroup(String rptcolumnquerygroup) {
        this.rptcolumnquerygroup = rptcolumnquerygroup;
    }

    public String getTmplrptcolumnquerygroup() {
        return tmplrptcolumnquerygroup;
    }

    public void setTmplrptcolumnquerygroup(String tmplrptcolumnquerygroup) {
        this.tmplrptcolumnquerygroup = tmplrptcolumnquerygroup;
    }

    public String getRptcolumnquerysubgroup() {
        return rptcolumnquerysubgroup;
    }

    public void setRptcolumnquerysubgroup(String rptcolumnquerysubgroup) {
        this.rptcolumnquerysubgroup = rptcolumnquerysubgroup;
    }

    public String getTmplrptcolumnquerysubgroup() {
        return tmplrptcolumnquerysubgroup;
    }

    public void setTmplrptcolumnquerysubgroup(String tmplrptcolumnquerysubgroup) {
        this.tmplrptcolumnquerysubgroup = tmplrptcolumnquerysubgroup;
    }
   
}
