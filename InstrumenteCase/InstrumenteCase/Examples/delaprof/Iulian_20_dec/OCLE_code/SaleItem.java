
/*
 * @(#)SaleItem.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
import ro.ubbcluj.lci.codegen.framework.ocl.BasicConstraintChecker;

/**
 *
 * @author unascribed
 */
public class SaleItem {

    
    public final Product getProduct() {

        return product;
    }
    
    public final void setProduct(Product arg) {

        product = arg;
    }
    
    public SaleItem(int quantity, Product product) {

    }
    
    public class ConstraintChecker extends BasicConstraintChecker {

        
        public void checkConstraints() {

            super.checkConstraints();
            check_SaleItem_invariant();

        }
        
        public void check_SaleItem_invariant() {

            int nQuantitySold = SaleItem.this.quantitySold;
            boolean bGreater = nQuantitySold > 0;
            if (!bGreater) {
                System.err.println("invariant 'invariant' failed for object "+SaleItem.this);
            }

        }

    }
    
    private int quantitySold;
    
    private Product product;

}
