import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import ro.ubbcluj.lci.codegen.framework.dt.Integer;
import ro.ubbcluj.lci.codegen.framework.ocl.BasicConstraintChecker;
import ro.ubbcluj.lci.codegen.framework.ocl.Ocl;

public class Sale {

	private int saleId;

	private String saleDate;

	private int saleAgentId;

	private Set<SaleItem> items;

	public Sale(int saleId, String saleDate, int saleAgentId,
			Set<SaleItem> items) {
		super();
		this.saleId = saleId;
		this.saleDate = saleDate;
		this.saleAgentId = saleAgentId;
		this.items = items;
	}

	public final Set<SaleItem> getItems() {

		if (items == null) {
			return Collections.emptySet();
		}
		return java.util.Collections.unmodifiableSet(items);
	}

	public final void addItems(SaleItem arg) {

		if (arg != null) {
			if (items == null) {
				items = new LinkedHashSet<SaleItem>();
			}
			items.add(arg);
		}

	}

	public final void removeItems(SaleItem arg) {

		if (items != null && arg != null) {
			items.remove(arg);
		}

	}

	public Sale(int saleId, String saleDate, int saleAgentId) {
		super();
		this.saleId = saleId;
		this.saleDate = saleDate;
		this.saleAgentId = saleAgentId;
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
				System.err
						.println("invariant 'sale_id_is_not_empty' failed for object "
								+ Sale.this);
			}

		}

		public void check_Sale_sale_date_is_defined() {

			String strSaleDate = Sale.this.saleDate;
			boolean bIsDefined = Ocl.isDefined(strSaleDate);
			boolean bNotEquals = !strSaleDate.equals("");
			boolean bAnd = bIsDefined && bNotEquals;
			if (!bAnd) {
				System.err
						.println("invariant 'sale_date_is_defined' failed for object "
								+ Sale.this);
			}

		}

		public void check_Sale_sale_agent_id_is_defined() {

			int nSaleAgentId = Sale.this.saleAgentId;
			boolean bIsDefined = Ocl.isDefined(Integer.toInteger(nSaleAgentId));
			int nSaleAgentId0 = Sale.this.saleAgentId;
			boolean bGreater = nSaleAgentId0 > 0;
			boolean bAnd = bIsDefined && bGreater;
			if (!bAnd) {
				System.err
						.println("invariant 'sale_agent_id_is_defined' failed for object "
								+ Sale.this);
			}

		}

	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public int getSaleAgentId() {
		return saleAgentId;
	}

	public void setSaleAgentId(int saleAgentId) {
		this.saleAgentId = saleAgentId;
	}

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", saleDate=" + saleDate
				+ ", saleAgentId=" + saleAgentId + ", items=" + items + "]";
	}

}
