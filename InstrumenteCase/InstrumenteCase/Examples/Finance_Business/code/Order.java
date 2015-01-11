
/*
 * @(#)Order.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ro.ubbcluj.lci.codegen.framework.ocl.BasicConstraintChecker;
import ro.ubbcluj.lci.codegen.framework.ocl.CollectionUtilities;

/**
 *
 * @author unascribed
 */
public class Order {

	
	public boolean registerBuy() {

		return false;

	}
	
	public boolean registerSell() {

		return false;

	}
	
	public boolean putOnMarket() {

		return false;

	}
	
	public boolean matchOrder(float matchPrice) {

		return false;

	}
	
	public boolean cancelOrder() {

		return false;

	}
	
	public final Security getSecurity() {

		return security;
	}
	
	public final void setSecurity(Security arg) {

		if (security != arg) {
			Security temp = security;
			security = null;//to avoid infinite recursions
			if (temp != null) {
				temp.removeOrder(this);
			}
			if (arg != null) {
				security = arg;
				arg.addOrder(this);
			}
		}

	}
	
	public final Set getPortofolio() {

		if (portofolio == null) {
			return java.util.Collections.EMPTY_SET;
		}
		return java.util.Collections.unmodifiableSet(portofolio);
	}
	
	public final void addPortofolio(Portofolio arg) {

		if (arg != null) {
			if (portofolio == null) portofolio = new LinkedHashSet();
			if (portofolio.add(arg)) {
				arg.addOrders(this);
			}
		}

	}
	
	public final void removePortofolio(Portofolio arg) {

		if (portofolio != null && arg != null) {
			if (portofolio.remove(arg)) {
				arg.removeOrders(this);
			}
		}

	}
	
	public Order() {

	}
	
	public class ConstraintChecker extends BasicConstraintChecker {

		
		public void checkConstraints() {

			super.checkConstraints();
			check_Order_first();
			check_Order_second();
			check_Order_third();

		}
		
		public void check_Order_first() {

			Enum enumType = Order.this.type;
			boolean bEquals = enumType.equals(Enum.buy);
			float fMatchedPrice = Order.this.matchedPrice;
			float fLimit = Order.this.limit;
			boolean bLessOrEqual = fMatchedPrice <= fLimit;
			boolean bImplies = !bEquals || bLessOrEqual;
			if (!bImplies) {
				System.err.println("invariant 'first' failed for object "+Order.this);
			}

		}
		
		public void check_Order_second() {

			Enum enumType = Order.this.type;
			boolean bEquals = enumType.equals(Enum.sell);
			float fMatchedPrice = Order.this.matchedPrice;
			float fLimit = Order.this.limit;
			boolean bGreaterOrEqual = fMatchedPrice >= fLimit;
			boolean bImplies = !bEquals || bGreaterOrEqual;
			if (!bImplies) {
				System.err.println("invariant 'second' failed for object "+Order.this);
			}

		}
		
		public void check_Order_third() {

			Enum enumType = Order.this.type;
			boolean bEquals = enumType.equals(Enum.sell);
			Set setPortofolio = Order.this.getPortofolio();
			//evaluate 'collect(holdings)':
			List bagCollect = CollectionUtilities.newBag();
			final Iterator iter = setPortofolio.iterator();
			while (iter.hasNext()) {
				final Portofolio decl = (Portofolio)iter.next();
				Set setHoldings = decl.getHoldings();
				
				bagCollect.add(setHoldings);
			}
			bagCollect = CollectionUtilities.flatten(bagCollect);
			
			//evaluate 'exists(security.name=self.security.name)':
			boolean bExists = false;
			final Iterator iter0 = bagCollect.iterator();
			while (!bExists && iter0.hasNext()) {
				final Holding iter1 = (Holding)iter0.next();
				Security securitySecurity = iter1.getSecurity();
				String strName = securitySecurity.name;
				Security securitySecurity0 = Order.this.getSecurity();
				String strName0 = securitySecurity0.name;
				boolean bEquals0 = strName.equals(strName0);
				
				bExists = bEquals0;
			}
			boolean bImplies = !bEquals || bExists;
			if (!bImplies) {
				System.err.println("invariant 'third' failed for object "+Order.this);
			}

		}

	}
	
	public Enum type;
	
	public float matchedPrice;
	
	public Security security;
	
	public Set portofolio;
	
	private int number;
	
	private float limit;
	
	private Date validDate;
	
	private OrderStatusEnum state;

}
