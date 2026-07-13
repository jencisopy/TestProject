package net.makerapp.hibernate;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

/**
 * Registra las funciones SQL propias en Hibernate. Se descubre por
 * ServiceLoader (META-INF/services/org.hibernate.boot.model.FunctionContributor)
 * y aplica a todas las unidades de persistencia, sin importar el motor de base
 * de datos; por eso las PU usan los dialectos estándar de Hibernate.
 * Antes esta clase se llamaba MkSqlServer y vivía en org.hibernate.dialect.
 *
 * @author jenciso
 */
public class MakerFunctionContributor implements FunctionContributor {
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
