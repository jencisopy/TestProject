package org.hibernate.dialect;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

/**
 *
 * @author jenciso
 */
public class MkSqlServer implements FunctionContributor {
    @Override
    public void contributeFunctions(FunctionContributions functionContributions) {
        // Registramos la función.
        // El primer parámetro es el nombre que usarás en HQL ("fn_getitemmovstatus").
        // El segundo es la definición de la función, que incluye el nombre real
        // en la base de datos ("datos.fn_getitemmovstatus") y su tipo de retorno.
        functionContributions.getFunctionRegistry()
            .register(
                "fn_getitemmovstatus", 
                new StandardSQLFunction("datos.fn_getitemmovstatus", StandardBasicTypes.INTEGER)
                    
            );
    }
}
