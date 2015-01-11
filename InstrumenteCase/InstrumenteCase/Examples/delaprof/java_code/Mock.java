

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ro.ubbcluj.lci.codegen.framework.dt.OrderedSet;


public class Mock {

	public static void main(String[] args) {
		Product p1 = new Product("1", "Lapte", 5);
		Product p2 = new Product("2", "Paine", 4);
		Product p3 = new Product("3", "Bere", 8.5f);
		Product p4 = new Product("4", "Ciocolata", 6);


		OrderedSet products = new OrderedSet();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);

		Stock stock = new Stock(products);
		Set<Sale> log = new HashSet<>();

		SaleSystem saleSystem = new SaleSystem(log, stock);

		String adminName = "Iulian Rosca";

		Administrator admin = new Administrator(adminName, saleSystem);
		saleSystem.setAdministrator(admin);

		SaleAgent saleAgent1 = new SaleAgent(new OrderedSet(), 1, "Agent1",
				saleSystem);

		SaleAgent saleAgent2 = new SaleAgent(new OrderedSet(), 2, "Agent2",
				saleSystem);

		SaleItem si1 = new SaleItem(2, p1);
		SaleItem si2 = new SaleItem(3, p2);
		SaleItem si3 = new SaleItem(3, p2);

		Set<SaleItem> saleitems1 = new HashSet<>();
		Collections.addAll(saleitems1, si1, si2, si3);

		Sale s1 = new Sale(1, "15/11/2013", saleAgent1.getId(), saleitems1);
		saleAgent1.makeSale(s1);

		SaleItem si4 = new SaleItem(2, p3);
		SaleItem si5 = new SaleItem(5, p1);
		SaleItem si6 = new SaleItem(7, p4);

		Set<SaleItem> saleitems2 = new HashSet<>();
		Collections.addAll(saleitems2, si4, si5, si6);

		Sale s2 = new Sale(1, "31/12/2013", saleAgent1.getId(), saleitems2);
		saleAgent1.makeSale(s2);

		for (Sale s : saleSystem.getLog()) {
			System.out.println(s);
		}
		
		
		/// INVARIANTS  ------- OBSERVERS 
		
		Product p5 = new Product("4", "Ciocolata", -5);
		Product p6 = new Product("4", "", 5);
		Product p7 = new Product("", "Ciocolata", 5);
		try {
			p5.validate();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}

		try {
			p6.validate();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}

		try {
			p7.validate();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}
		
		Set<Product> selectedProds = stock.selectProds(p2);
		
		for (Product product : selectedProds) {
			System.out.println(product);
		}
		
		stock.deleteProduct("2");
		
		saleSystem.addSaleAgents(saleAgent1);
		saleSystem.addSaleAgents(saleAgent2);
		
		System.out.println(saleSystem.mostSalesAgent());
		
		admin.createNewProduct("12", "", 2.3f);
		admin.createNewProduct("", "Ceai", 2.3f);
		admin.createNewProduct("12", "Ceai", -2.3f);

	}
}
