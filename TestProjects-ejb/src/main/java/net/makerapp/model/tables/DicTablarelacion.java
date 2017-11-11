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
package net.makerapp.model.tables;

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
import org.javabeanstack.data.DataRow;
import org.javabeanstack.model.IAppTablesRelation;

/**
 *
 * @author Jorge Enciso
 */
@Entity
@Table(name = "dic_tablarelacion")
@NamedQueries({
    @NamedQuery(name = "AppTablesRelation.findAll", query = "SELECT d FROM DicTablarelacion d"),
    @NamedQuery(name = "AppTablesRelation.findByEntity", query = 
            "SELECT d FROM DicTablarelacion d "
                    + "where principal = :entityPK "
                    + "and externa = :entityFK "
                    + "and incluir = true")
                })
public class DicTablarelacion extends DataRow implements IAppTablesRelation {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "externa")
    private String externa;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "principal")
    private String principal;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "expresion_externa")
    private String expresionExterna;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "expresion_principal")
    private String expresionPrincipal;

    @Column(name = "incluir")
    private Boolean incluir;
    @Column(name = "marcado")
    private Boolean marcado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiporelacion")
    private short tiporelacion;

    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechareplicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareplicacion;

    public DicTablarelacion() {
    }

    @Override
    public String getEntityPK() {
        return principal;
    }

    @Override
    public String getFieldsPK() {
        return this.expresionPrincipal;
    }

    @Override
    public String getEntityFK() {
        return externa;
    }

    @Override
    public String getFieldsFK() {
        return expresionExterna;
    }

    @Override
    public void setEntityPK(String entity) {
        this.principal = entity;
    }

    @Override
    public void setFieldsPK(String fields) {
        this.expresionPrincipal = fields;
    }

    @Override
    public void setEntityFK(String entity) {
        this.externa = entity;
    }

    @Override
    public void setFieldsFK(String fields) {
        this.expresionExterna = fields;
    }
    
    @Override
    public boolean isIncluded() {
        return incluir;
    }

    @Override
    public void setIncluded(boolean incluir) {
        this.incluir = incluir;
    }

    @Override
    public short getRelationType() {
        return tiporelacion;
    }

    @Override
    public void setRelationType(short tiporelacion) {
        this.tiporelacion = tiporelacion;
    }

    public Boolean getMarcado() {
        return marcado;
    }

    public void setMarcado(Boolean marcado) {
        this.marcado = marcado;
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


    @Override
    public String toString() {
        return "net.makerapp.model.tables.DicTablarelacion[ dicTablarelacionPK= ]";
    }
}
