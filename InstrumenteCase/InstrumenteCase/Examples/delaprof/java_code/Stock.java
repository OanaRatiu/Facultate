

/*
 * @(#)Stock.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import ro.ubbcluj.lci.codegen.framework.ocl.CollectionUtilities;

public class Stock {

	private Set<Product> products;

	public Stock() {

	}

	public Stock(Set<Product> products) {
		super();
		this.products = products;
	}

	public void addProduct(Product p) {

		class ConstraintChecker {

			public void check_postcondition(Product p) {

				Set<Product> setProducts = Stock.this.getProducts();
				boolean bIncludes = CollectionUtilities
						.includes(setProducts, p);
				if (!bIncludes) {
					System.err
							.println("postcondition 'postcondition' failed for object "
									+ Stock.this);
				}

			}

			public void checkPostconditions(Product p) {

				check_postcondition(p);

			}

			public void checkPreconditions(Product p) {

			}

		}
		ConstraintChecker checker = new ConstraintChecker();
		checker.checkPreconditions(p);
		internal_addProduct(p);

		checker.checkPostconditions(p);
	}

	public final void addProducts(Product arg) {

		if (arg != null) {
			if (products == null) {
				products = new LinkedHashSet<Product>();
			}
			products.add(arg);
		}

	}

	public void deleteProduct(String barcode) {

		class ConstraintChecker {

			public void check_postcondition(Product p) {

				Set<Product> setProducts = Stock.this.getProducts();
				boolean bIncludes = CollectionUtilities
						.includes(setProducts, p);
				boolean bNot = !bIncludes;
				if (!bNot) {
					System.err
							.println("postcondition 'postcondition' failed for object "
									+ Stock.this);
				}

			}

			public void checkPostconditions(Product p) {

				check_postcondition(p);

			}

			public void checkPreconditions(Product p) {

			}

		}
		ConstraintChecker checker = new ConstraintChecker();
		Product p = getProductByBarcode(barcode);
		checker.checkPreconditions(p);
		internal_deleteProduct(p);

		checker.checkPostconditions(p);

	}

	private Product getProductByBarcode(String barcode) {
		Product pr = null;
		for (Product p : getProducts()) {
			if (p.getBarCode().equals(barcode)) {
				pr = p;
			}
		}
		return pr;
	}

	public final Set<Product> getProducts() {

		if (products == null) {
			return Collections.emptySet();
		}
		return java.util.Collections.unmodifiableSet(products);
	}

	private void internal_addProduct(Product p) {
		products.add(p);

	}

	private void internal_deleteProduct(Product p) {
		
	}

	public final void removeProducts(Product arg) {

		if (products != null && arg != null) {
			products.remove(arg);
		}

	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void updateProduct(String barCode, Product p) {
		deleteProduct(barCode);
		addProduct(p);
	}
	
    public Set<Product> selectProds(Product prep) {

        Set<Product> setProducts = Stock.this.getProducts();
        //evaluate 'select(p|p.price>prep.price)':
        Set<Product> setSelect = CollectionUtilities.newSet();
        final Iterator<Product> iter = setProducts.iterator();
        while (iter.hasNext()) {
            final Product p = (Product)iter.next();
            float fPrice = p.getPrice();
            float fPrice0 = prep.getPrice();
            boolean bGreater = fPrice > fPrice0;
            
            if (bGreater) CollectionUtilities.add(setSelect, p);
        }
        return setSelect;

    }

}
