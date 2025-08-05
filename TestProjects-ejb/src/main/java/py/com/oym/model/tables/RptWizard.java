/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.model.tables;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.javabeanstack.data.DataRow;

/**
 *
 * @author mtrinidad
 */
@Entity
@Table(name = "RptWizard")
public class RptWizard extends DataRow implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 50)
    @Column(name = "reportname")
    private String reportname;
    @Size(max = 10)
    @Column(name = "typecomponent")
    private String typecomponent;
    @Size(max = 30)
    @Column(name = "field")
    private String field;
    @Size(max = 30)
    @Column(name = "label")
    private String label;
    @Size(max = 20)
    @Column(name = "bean")
    private String bean;
    @Column(name = "leveldetail")
    private Integer leveldetail;
    @Size(max = 20)
    @Column(name = "orderfield")
    private String orderfield;

    public RptWizard() {
    }

    public RptWizard(Integer id) {
        this.id = id;
    }
   
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public Integer getLeveldetail() {
        return leveldetail;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RptWizard)) {
            return false;
        }
        RptWizard other = (RptWizard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.oym.model.RptWizard[ id=" + id + " ]";
    }
    
}
