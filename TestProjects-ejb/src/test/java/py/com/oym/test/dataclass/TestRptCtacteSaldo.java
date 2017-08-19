/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.dataclass;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.javabeanstack.util.Dates;
import org.javabeanstack.util.Strings;
import static org.javabeanstack.util.Strings.isNullorEmpty;
import org.junit.Test;

import static org.javabeanstack.util.Strings.textMerge;

/**
 *
 * @author Jorge Enciso
 */
public class TestRptCtacteSaldo {
    private String sqlSentenceSaldo;
    private String debito="1";
    private String credito="2";
    
    @Test
    public void test() {
        CtacteSaldo_de_Fecha(null);
        System.out.println(sqlSentenceSaldo);
    }
    
    public void CtacteSaldo_de_Fecha(Date fecha){
        String sentence;
        boolean incluirCheques = true;
        
        Map<String, String> paramMerge = new HashMap();
        paramMerge.put("debito", debito);
        paramMerge.put("credito", credito);
        
        String columns = 
                Strings.textMerge("CASE when b.monto is NOT null then x.codigo else a.itemmovcondicion end  as itemmovcondicion,\n"
                + "CASE when a.ctacteafecta IN ({debito})  and b.monto is null then \n"
                + "        a.totalmonto \n"
                + "     when  a.ctacteafecta IN({debito})  then\n"
                + "        b.monto \n"
                + "     else 00000000000.000 \n"
                + "END  as debito,\n"
                + "CASE when a.ctacteafecta IN ({credito}) and b.monto is null then \n"
                + "          a.totalmonto \n"
                + "     when  a.ctacteafecta IN({credito}) then \n"
                + "          b.monto \n"
                + "     else 00000000000.000 \n"
                + "END  as credito\n",paramMerge);
        
        String filter = "";
        if (!isNullorEmpty(filter)){
            filter = " and "+ filter;
        }
        String orderBy="";
        
        sentence = Strings.textMerge(
                "SELECT idctacte, ctacte, ctactenombre, moneda, \n"
                + "   MAX(fecha) as fecha, ruc, telefono, \n"
                + "   SUM(debito) as debito,\n"
                + "   SUM(credito) as credito\n"
                + "FROM (\n"
                + "      SELECT a.idctacte, a.ctacte, a.ctactenombre, a.moneda,\n"
                + "        a.fecha, a.ruc, ctacte.telefonoctacte as telefono,\n"
                + "        a.rubro, a.rubronombre,a.subrubro,a.subrubronombre,\n"
                + "        a.iddocumento, a.iddocumentotipo,\n"
                + "        a.confirmado, a.idempresa, a.anulado,\n"
                +          columns
                + "      FROM {schema}.ctactemovimiento_view a \n"
                + "	 INNER JOIN {schema}.ctacte on a.idctacte = ctacte.idctacte\n"
                + "      LEFT OUTER JOIN {schema}.ctactemovimientodetalle      b  on a.idctactemovimiento = b.idctactemovimiento\n"
                + "      LEFT OUTER JOIN {schema}.ctactependientedetalle       p  on b.idctactependientedetalle = p.idctactependientedetalle\n"
                + "      LEFT OUTER JOIN {schema}.ctactependiente              o  on p.idctactependiente = o.idctactependiente\n"
                + "      LEFT OUTER JOIN {schema}.ctactemovimiento             q  on o.idctactemovimiento = q.idctactemovimiento\n"
                + "      LEFT OUTER JOIN {schema}.itemmovcondicion             x  on q.iditemmovcondicion = x.iditemmovcondicion\n"
                + "      WHERE a.fecha <= :fecha\n"
                + "	 and a.ctacteafecta in ({debito},{credito})\n"
                + "      and a.idperiodo = :idperiodo\n"                                        
                +        filter +") x\n"
                + "GROUP BY idctacte, ctacte, ctactenombre, moneda,ruc, telefono\n"
                  ,paramMerge);

        if (incluirCheques){
            sentence += Strings.textMerge(
                    " UNION ALL\n"
                    + "SELECT idctacte,ctacte, ctactenombre, moneda, MAX(fecha) as fecha, ruc, telefono,\n"
                    + "	  SUM(monto) as debito,SUM(0) as credito\n"
                    + "FROM (\n"
                    + "      SELECT a.idempresa,a.idctacte,a.ctacte, a.ctactenombre,\n"
                    + "         a.idctactesub, a.ctactesub, a.ctactesubnombre, moneda, fechaemision as fecha,\n"
                    + "         a.ruc, ctacte.telefonoctacte as telefono,\n"
                    + "		:true as confirmado, :false as anulado,\n"
                    + "		monto,\n"
                    + "		CAST('' as char(3)) as iddocumento,\n"
                    + "		CAST('' as char(2)) as iddocumentotipo,\n"
                    + "		CAST('' as char(3)) as rubro,CAST('' as char(30)) as rubronombre,\n"
                    + "		CAST('' as char(3)) as subrubro,CAST('' as char(30)) as subrubronombre,\n"
                    + "		CAST('' as char(2)) as itemmovcondicion,CAST('' as char(30)) as itemmovcondicionnombre\n"
                    + "		FROM {schema}.ctactecheque_view a \n"
                    + "		INNER JOIN {schema}.ctacte on a.idctacte = ctacte.idctacte\n"
                    + "		where cobrado = :false\n"
                    + "		and   estado   <> 'A'\n"
                    + "         ) a \n"
                    + "where "+filter+"\n"
                    + "and fecha <= :fecha\n"
                    + "GROUP BY idctacte, ctacte, ctactenombre, moneda,ruc,telefono",                    
                       paramMerge);
                    
        }
        sentence += "\n "+orderBy;
        sqlSentenceSaldo = sentence;
    }    
}
