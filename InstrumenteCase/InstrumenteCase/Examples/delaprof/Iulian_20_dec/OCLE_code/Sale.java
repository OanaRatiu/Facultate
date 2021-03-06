
/*
 * @(#)Sale.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
import java.util.LinkedHashSet;
import java.util.Set;
import ro.ubbcluj.lci.codegen.framework.dt.Integer;
import ro.ubbcluj.lci.codegen.framework.ocl.BasicConstraintChecker;
import ro.ubbcluj.lci.codegen.framework.ocl.Ocl;

/**
 *
 * @author unascribed
 */
public class Sale {

    
    public final Set getItems() {

        if (items == null) {
            return java.util.Collections.EMPTY_SET;
        }
        return java.util.Collections.unmodifiableSet(items);
    }
    
    public final void addItems(SaleItem arg) {

        if (arg != null) {
            if (items == null) {
                items = new LinkedHashSet();
            }
            items.add(arg);
        }

    }
    
    public final void removeItems(SaleItem arg) {

        if (items != null && arg != null) {
            items.remove(arg);
        }

    }
    
    public Sale() {

    }
    
    public class ConstraintChecker extends BasicConstraintChecker {

        
        public void checkConstraints() {

            super.checkConstraints();
            check_Sale_sale_id_is_not_empty();
            check_Sale_sale_date_is_defined();
            check_Sale_sale_agent_id_is_defined();

        }
        
        public void check_Sale_sale_id_is_not_empty() {

            int nSaleId = Sale.this.saleId;
            boolean bIsDefined = Ocl.isDefined(Integer.toInteger(nSaleId));
            int nSaleId0 = Sale.this.saleId;
            boolean bGreater = nSaleId0 > 0;
            boolean bAnd = bIsDefined && bGreater;
            if (!bAnd) {
                System.err.println("invariant 'sale_id_is_not_empty' failed for object "+Sale.this);
            }

        }
        
        public void check_Sale_sale_date_is_defined() {

            String strSaleDate = Sale.this.saleDate;
            boolean bIsDefined = Ocl.isDefined(strSaleDate);
            String strSaleDate0 = Sale.this.saleDate;
            boolean bNotEquals = true;
            boolean bAnd = bIsDefined && bNotEquals;
            if (!bAnd) {
                System.err.println("invariant 'sale_date_is_defined' failed for object "+Sale.this);
            }

        }
        
        public void check_Sale_sale_agent_id_is_defined() {

            int nSaleAgentId = Sale.this.saleAgentId;
            boolean bIsDefined = Ocl.isDefined(Integer.toInteger(nSaleAgentId));
            int nSaleAgentId0 = Sale.this.saleAgentId;
            boolean bGreater = nSaleAgentId0 > 0;
            boolean bAnd = bIsDefined && bGreater;
            if (!bAnd) {
                System.err.println("invariant 'sale_agent_id_is_defined' failed for object "+Sale.this);
            }

        }

    }
    
    private int saleId;
    
    private String saleDate;
    
    private int saleAgentId;
    
    private Set items;

}
