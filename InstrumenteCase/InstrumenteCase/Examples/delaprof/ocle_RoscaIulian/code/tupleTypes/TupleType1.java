
/*
 * @(#)TupleType1.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
package tupleTypes;
import java.util.Set;

/**
 *
 * @author unascribed
 */
public class TupleType1 {

    
    public boolean equals(Object arg) {

        
        if (!(arg instanceof TupleType1)) {
            return false;
            
        }
        TupleType1 local = (TupleType1)arg;
        boolean result = true;
        result&= (id == local.id);
        result&= (name != null ? name.equals(local.name) : local.name == null);
        result&= (sales != null ? sales.equals(local.sales) : local.sales == null);
        result&= (valSize == local.valSize);
        return result;

    }
    
    public int id;
    
    public String name;
    
    public Set sales;
    
    public int valSize;

}
