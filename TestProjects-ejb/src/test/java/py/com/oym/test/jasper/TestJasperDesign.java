/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.jasper;

import java.awt.Color;
import java.io.File;
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JRReportTemplate;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignFrame;
import net.sf.jasperreports.engine.design.JRDesignGroup;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.CalculationEnum;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.type.PositionTypeEnum;
import net.sf.jasperreports.engine.type.ResetTypeEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge Enciso
 */
public class TestJasperDesign {
    public TestJasperDesign() {
    }

    @Test
    public void test1() throws Exception {
        Long start = System.currentTimeMillis();
        JasperDesign jasperDesign = getJasperDesign();
        JasperCompileManager.compileReportToFile(jasperDesign, "../NoXmlDesignReport.jasper");
        System.err.println("Compile time : " + (System.currentTimeMillis() - start));        
        JasperCompileManager.writeReportToXmlFile(jasperDesign,"../NoXmlDesignReport.jrxml");
        assertNotNull(jasperDesign);
        
    }
    
    public JasperDesign getJasperDesign() throws JRException{
        //JasperTemplate
        File file = new File("/proyectos/java/oym/TestProjects/template.jrxml");
        //JRTemplate template = JRXmlTemplateLoader.load(file);
        JRReportTemplate template = JRXmlLoader.load(file).getTemplates()[0];        

        //JasperDesign
        JasperDesign jasperDesign = new JasperDesign();
        
        jasperDesign.setName("NoXmlDesignReport");
        jasperDesign.setPageWidth(595);
        jasperDesign.setPageHeight(842);
        jasperDesign.setColumnWidth(515);
        jasperDesign.setColumnSpacing(0);
        jasperDesign.setLeftMargin(40);
        jasperDesign.setRightMargin(40);
        jasperDesign.setTopMargin(50);
        jasperDesign.setBottomMargin(50);
        jasperDesign.addTemplate(template);
        
        //Fonts
        JRDesignStyle normalStyle = new JRDesignStyle();
        normalStyle.setName("Times_Normal");
        normalStyle.setDefault(true);
        normalStyle.setFontName("Times New Roman");
        normalStyle.setFontSize(12F);
        jasperDesign.addStyle(normalStyle);

        JRDesignStyle boldStyle = new JRDesignStyle();
        boldStyle.setName("Times_Bold");
        boldStyle.setFontName("Times New Roman");
        boldStyle.setFontSize(12F);
        boldStyle.setBold(true);
        jasperDesign.addStyle(boldStyle);

        JRDesignStyle italicStyle = new JRDesignStyle();
        italicStyle.setName("Times_Italic");
        italicStyle.setFontName("Times New Roman");
        italicStyle.setFontSize(12F);
        italicStyle.setItalic(true);
        jasperDesign.addStyle(italicStyle);

        //Parameters
        JRDesignParameter parameter = new JRDesignParameter();
        parameter.setName("ReportTitle");
        parameter.setValueClass(java.lang.String.class);
        jasperDesign.addParameter(parameter);

        parameter = new JRDesignParameter();
        parameter.setName("OrderByClause");
        parameter.setValueClass(java.lang.String.class);
        jasperDesign.addParameter(parameter);

        //Query
        JRDesignQuery query = new JRDesignQuery();
        query.setText("SELECT * FROM Address $P!{OrderByClause}");
        jasperDesign.setQuery(query);

        //Fields
        JRDesignField field = new JRDesignField();
        field.setName("Id");
        field.setValueClass(java.lang.Integer.class);
        jasperDesign.addField(field);

        field = new JRDesignField();
        field.setName("FirstName");
        field.setValueClass(java.lang.String.class);
        jasperDesign.addField(field);

        field = new JRDesignField();
        field.setName("LastName");
        field.setValueClass(java.lang.String.class);
        jasperDesign.addField(field);

        field = new JRDesignField();
        field.setName("Street");
        field.setValueClass(java.lang.String.class);
        jasperDesign.addField(field);

        field = new JRDesignField();
        field.setName("City");
        field.setValueClass(java.lang.String.class);
        jasperDesign.addField(field);

        //Group
        JRDesignGroup group = new JRDesignGroup();
        group.setName("CityGroup");

        //Variables
        JRDesignVariable variable = new JRDesignVariable();
        variable.setName("CityNumber");
        variable.setValueClass(java.lang.Integer.class);
        variable.setResetType(ResetTypeEnum.GROUP);
        variable.setResetGroup(group);
        variable.setCalculation(CalculationEnum.SYSTEM);
        JRDesignExpression expression = new JRDesignExpression();
        expression.setValueClass(java.lang.Integer.class);
        expression.setText("($V{CityNumber} != null)?(new Integer($V{CityNumber}.intValue() + 1)):(new Integer(1))");
        variable.setInitialValueExpression(expression);
        jasperDesign.addVariable(variable);

        variable = new JRDesignVariable();
        variable.setName("AllCities");
        variable.setValueClass(java.lang.String.class);
        variable.setResetType(ResetTypeEnum.REPORT);
        variable.setCalculation(CalculationEnum.SYSTEM);
        jasperDesign.addVariable(variable);

        //Groups
        group.setMinHeightToStartNewPage(60);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.String.class);
        expression.setText("$F{City}");
        group.setExpression(expression);

        JRDesignBand band = new JRDesignBand();
        band.setHeight(20);
        JRDesignTextField textField = new JRDesignTextField();
        textField.setX(0);
        textField.setY(4);
        textField.setWidth(515);
        textField.setHeight(15);
        textField.setBackcolor(new Color(0xC0, 0xC0, 0xC0));
        textField.setMode(ModeEnum.OPAQUE);
        textField.setHorizontalTextAlign(HorizontalTextAlignEnum.LEFT);
        textField.setStyleNameReference("detail_number");
        //textField.setStyle(boldStyle);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.String.class);
        expression.setText("\"  \" + String.valueOf($V{CityNumber}) + \". \" + String.valueOf($F{City})");
        textField.setExpression(expression);
        band.addElement(textField);
        JRDesignLine line = new JRDesignLine();
        line.setX(0);
        line.setY(19);
        line.setWidth(515);
        line.setHeight(0);
        band.addElement(line);
        ((JRDesignSection) group.getGroupHeaderSection()).addBand(band);

        band = new JRDesignBand();
        band.setHeight(20);
        line = new JRDesignLine();
        line.setX(0);
        line.setY(-1);
        line.setWidth(515);
        line.setHeight(0);
        band.addElement(line);
        JRDesignStaticText staticText = new JRDesignStaticText();
        staticText.setX(400);
        staticText.setY(0);
        staticText.setWidth(60);
        staticText.setHeight(15);
        textField.setHorizontalTextAlign(HorizontalTextAlignEnum.RIGHT);        
        staticText.setStyle(boldStyle);
        staticText.setText("Count : ");
        band.addElement(staticText);
        textField = new JRDesignTextField();
        textField.setX(460);
        textField.setY(0);
        textField.setWidth(30);
        textField.setHeight(15);
        textField.setHorizontalTextAlign(HorizontalTextAlignEnum.RIGHT);                
        textField.setStyle(boldStyle);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.Integer.class);
        expression.setText("$V{CityGroup_COUNT}");
        textField.setExpression(expression);
        band.addElement(textField);
        ((JRDesignSection) group.getGroupFooterSection()).addBand(band);

        jasperDesign.addGroup(group);

        //Title
        band = new JRDesignBand();
        band.setHeight(50);
        line = new JRDesignLine();
        line.setX(0);
        line.setY(0);
        line.setWidth(515);
        line.setHeight(0);
        band.addElement(line);
        textField = new JRDesignTextField();
        textField.setBlankWhenNull(true);
        textField.setX(0);
        textField.setY(10);
        textField.setWidth(515);
        textField.setHeight(30);
        textField.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);                
        textField.setStyle(normalStyle);
        textField.setFontSize(22F);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.String.class);
        expression.setText("$P{ReportTitle}");
        textField.setExpression(expression);
        band.addElement(textField);
        jasperDesign.setTitle(band);

        //Page header
        band = new JRDesignBand();
        band.setHeight(20);
        JRDesignFrame frame = new JRDesignFrame();
        frame.setX(0);
        frame.setY(5);
        frame.setWidth(515);
        frame.setHeight(15);
        frame.setForecolor(new Color(0x33, 0x33, 0x33));
        frame.setBackcolor(new Color(0x33, 0x33, 0x33));
        frame.setMode(ModeEnum.OPAQUE);
        band.addElement(frame);
        staticText = new JRDesignStaticText();
        staticText.setX(0);
        staticText.setY(0);
        staticText.setWidth(55); 
        staticText.setHeight(15);
        staticText.setForecolor(Color.white);
        staticText.setBackcolor(new Color(0x33, 0x33, 0x33));
        staticText.setMode(ModeEnum.OPAQUE);
        textField.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);                
        staticText.setStyle(boldStyle);
        staticText.setText("ID");
        frame.addElement(staticText);
        staticText = new JRDesignStaticText();
        staticText.setX(55);
        staticText.setY(0);
        staticText.setWidth(205);
        staticText.setHeight(15);
        staticText.setForecolor(Color.white);
        staticText.setBackcolor(new Color(0x33, 0x33, 0x33));
        staticText.setMode(ModeEnum.OPAQUE);
        staticText.setStyle(boldStyle);
        staticText.setText("Name");
        frame.addElement(staticText);
        staticText = new JRDesignStaticText();
        staticText.setX(260);
        staticText.setY(0);
        staticText.setWidth(255);
        staticText.setHeight(15);
        staticText.setForecolor(Color.white);
        staticText.setBackcolor(new Color(0x33, 0x33, 0x33));
        staticText.setMode(ModeEnum.OPAQUE);
        staticText.setStyle(boldStyle);
        staticText.setText("Street");
        frame.addElement(staticText);
        jasperDesign.setPageHeader(band);

        //Column header
        band = new JRDesignBand();
        jasperDesign.setColumnHeader(band);

        //Detail
        band = new JRDesignBand();
        band.setHeight(20);
        textField = new JRDesignTextField();
        textField.setX(0);
        textField.setY(4);
        textField.setWidth(50);
        textField.setHeight(15);
        textField.setHorizontalTextAlign(HorizontalTextAlignEnum.RIGHT);                
        textField.setStyle(normalStyle);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.Integer.class);
        expression.setText("$F{Id}");
        textField.setExpression(expression);
        band.addElement(textField);
        textField = new JRDesignTextField();
        textField.setStretchWithOverflow(true);
        textField.setX(55);
        textField.setY(4);
        textField.setWidth(200);
        textField.setHeight(15);
        textField.setPositionType(PositionTypeEnum.FLOAT);
        textField.setStyle(normalStyle);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.String.class);
        expression.setText("$F{FirstName} + \" \" + $F{LastName}");
        textField.setExpression(expression);
        band.addElement(textField);
        textField = new JRDesignTextField();
        textField.setStretchWithOverflow(true);
        textField.setX(260);
        textField.setY(4);
        textField.setWidth(255);
        textField.setHeight(15);
        textField.setPositionType(PositionTypeEnum.FLOAT);
        textField.setStyle(normalStyle);
        expression = new JRDesignExpression();
        expression.setValueClass(java.lang.String.class);
        expression.setText("$F{Street}");
        textField.setExpression(expression);
        band.addElement(textField);
        line = new JRDesignLine();
        line.setX(0);
        line.setY(19);
        line.setWidth(515);
        line.setHeight(0);
        line.setForecolor(new Color(0x80, 0x80, 0x80));
        line.setPositionType(PositionTypeEnum.FLOAT);
        band.addElement(line);
        ((JRDesignSection) jasperDesign.getDetailSection()).addBand(band);

        //Column footer
        band = new JRDesignBand();
        jasperDesign.setColumnFooter(band);

        //Page footer
        band = new JRDesignBand();
        jasperDesign.setPageFooter(band);

        //Summary
        band = new JRDesignBand();
        jasperDesign.setSummary(band);
        
        return jasperDesign;
    }
}
