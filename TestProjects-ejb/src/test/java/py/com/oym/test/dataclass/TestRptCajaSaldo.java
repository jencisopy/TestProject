/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.dataclass;

import java.util.Date;
import org.junit.Test;
import py.com.oym.frame.util.Fn;
import static py.com.oym.frame.util.Strings.textMerge;

/**
 *
 * @author jenci_000
 */
public class TestRptCajaSaldo {
    private String sqlSentenceSaldo;
    
    @Test
    public void test() {
        CajaSaldo_de_Fecha(null);
        
        System.out.println(sqlSentenceSaldo);
    }
    
    public void CajaSaldo_de_Fecha(Date fecha) {
        /*
        * Operacion
	*  1 Suma
	* -1 Resta
	*  2 Tranferencia
        */
        if (fecha == null){
            fecha = Fn.today();
        }
        
        String columns = 
                  "sum(CASE when operacion =   1     then monto   else 00000000000.000  END)  as debito,\n"
                + "sum(CASE when operacion IN (-1,2) then monto   else 00000000000.000  END)  as credito\n";
        
        String filter = "a.idempresa = 1\n";

	// Sumar ingresos y egresos
        // TODO falta filtro periodo.
	String sqlSentence1 = 
                "select idcaja, caja, cajanombre, moneda, MAX(fecha) as fecha,\n"
                + columns 
		+ "from {schema}.cajamovimiento_view a \n"
                + "where "+filter
		+ "and a.fecha < :fecha \n"
		+ "group by idcaja, caja, cajanombre, moneda\n";

        columns = 
		 "sum(CASE when operacion IN (1,2)  then monto   else 00000000000.000  END)  as debito,\n"
		+"sum(CASE when operacion = -1      then monto   else 00000000000.000  END)  as credito\n";
        
        filter = filter.replaceAll("caja", "cajadest");
        filter = filter.replaceAll("cajanombre", "cajadestnombre");

	// Sumar Tranferencias        
	String sqlSentence2 = 
                "select idcajadest as idcaja, cajadest as caja, cajadestnombre as cajanombre, moneda, MAX(fecha) as fecha,\n"
                + columns 
		+ "from {schema}.cajamovimiento_view a \n"
                + "where "+filter
		+ "and a.idcajadest is not null \n"                
		+ "and a.fecha < :fecha \n"
                + "and a.operacion = 2\n"
                + "group by idcajadest, cajadest, cajadestnombre, moneda\n";
        
        
        // Juntar
        sqlSentenceSaldo = ""
                + "select idcaja, caja, cajanombre, moneda, fecha,\n"
                + "  sum(debito)  as debito,\n"
                + "  sum(credito) as credito,\n"
                + "  sum(debito-credito) as saldo\n"
                + "from (\n"
                + "    ("+sqlSentence1+") \n"
                + "      UNION ALL \n"
                + "    ("+sqlSentence2+") \n"
                + "   ) x1 \n"
                + " group by idcaja, caja, cajanombre, moneda, fecha";
        
        sqlSentenceSaldo = textMerge(sqlSentenceSaldo);
    }
    
}
