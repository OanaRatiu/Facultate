import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ro.ubbcluj.lci.codegen.framework.dt.OrderedSet;

public class Main {

	public static void main(String[] args) {
		/*
		 * In codul ce urmeaza este demonstrata validarea invariantilor si
		 * observatorilor generati de OCLE
		 */
		OrderedSet products = new OrderedSet();
		Stock stock = new Stock(products);
		Set<Sale> log = new HashSet<>();

		SaleSystem saleSystem = new SaleSystem(log, stock);

		/* Check generated invariants */

		checkAdministratorInvariants(saleSystem);

		checkSaleAgentInvariants(saleSystem);

		checkSaleItemInvariants(saleSystem);
		
		checkSaleInvariants(saleSystem);

		/*
		 * As prefera ca in codul generat, ConstraintChecker in loc sa afiseze o
		 * erroare - sa arunce o exceptie, astfel permitand programatorului sa
		 * propage exceptia la nivelele mai de sus. Am facut ceva modificari ca
		 * exemplu cum as vedea eu validarea invariantului in clasa Product,
		 * unde am comentat metoda checkConstraints() deoarece signatura
		 * acesteia nu permite aruncarea unei exceptii si am scris alta metoda
		 * checkConstraintsThrowingException() care arunca o exceptie "custom"
		 * (InvariantException).
		 */
		checkProductInvariants(saleSystem);

		/* Check method invariants for class Administrator */

		/*
		 * Remarca pentru ConstraintChecker : La metodele la care nu sunt valide
		 * preconditiile, in loc sa se continue executarea (internal_..) ar
		 * trebui sa se arunce o erroare si intreruperea metodei. Doar daca
		 * preconditiile sunt respectate se ruleaza metoda
		 */

		// Exemplu :
		// (unde result = false daca nu sunt valide preconditiile)
		// if (checker.result == true) {
		// internal_createNewProduct(bCode, name, price);
		// checker.checkPostconditions(bCode, name, price);
		// }

		checkAdministratorMethodInvariants(saleSystem);

		/* ------ OBSERVERS ------ */
		checkMostSalesAgent(saleSystem);

		checkTotalSalesForAgent(saleSystem);

		checkSelectProducts(saleSystem);
	}

	private static void checkSaleInvariants(SaleSystem saleSystem) {
		System.err
		.println("----------------Sale Invariants----------------");
		Sale s1 = new Sale(1,"20/02/2012",-3);
		Sale.ConstraintChecker cc = s1.new ConstraintChecker();
		cc.checkConstraints();
		
		s1.setSaleAgentId(2);
		s1.setSaleDate("");
		cc.checkConstraints();
		
		
	}

	private static void checkSelectProducts(SaleSystem saleSystem) {
		System.out
				.println("----------------Select Products with price greater than p.price----------------");
		Product p = new Product("23", "Sare iodata", 3);
		Stock stock = saleSystem.getStock();
		Set<Product> selectedProds = stock.selectProds(p);

		for (Product product : selectedProds) {
			System.out.println(product);
		}

	}

	private static void checkTotalSalesForAgent(SaleSystem saleSystem) {
		System.out
				.println("----------------Total Sales Observer----------------");
		Set<SaleAgent> agents = saleSystem.getSaleAgents();
		for (SaleAgent saleAgent : agents) {
			System.out.println("Sales for agent " + saleAgent.getName());
			for (Sale s : saleAgent.totalSales()) {
				System.out.println(s);
			}
		}
		System.out.println();
		System.out.println();

	}

	private static void checkMostSalesAgent(SaleSystem saleSystem) {
		System.out
				.println("----------------Most Sales Observer----------------");
		SaleAgent saleAgent1 = new SaleAgent(new OrderedSet(), 1, "Agent1",
				saleSystem);

		SaleAgent saleAgent2 = new SaleAgent(new OrderedSet(), 2, "Agent2",
				saleSystem);

		saleSystem.addSaleAgents(saleAgent1);
		saleSystem.addSaleAgents(saleAgent2);

		Product p1 = new Product("1", "Lapte", 5);
		Product p2 = new Product("2", "Paine", 4);
		Product p3 = new Product("3", "Bere", 8.5f);
		Product p4 = new Product("4", "Ciocolata", 6);

		Stock stock = saleSystem.getStock();
		stock.addProduct(p1);
		stock.addProduct(p2);
		stock.addProduct(p3);
		stock.addProduct(p4);

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
		System.out.println("Most sales are made by : "
				+ saleSystem.mostSalesAgentRefactored());

		System.out.println();
		System.out.println();

	}

	private static void checkAdministratorMethodInvariants(SaleSystem saleSystem) {
		System.err
				.println("----------------Administrator methods Invariants----------------");
		Administrator admin = saleSystem.getAdministrator();

		/*
		 * createNewProduct(bCode:String, name:String, price:Real) pre:bCode <>
		 * '' and name <> '' and price > 0
		 */

		admin.createNewProduct("", "paine", 2);

		/*
		 * deleteProduct(bCode:String) pre: bCode <> ''
		 */

		admin.deleteProduct("");

		/*
		 * updateProduct(bCode:String, name:String, price:Real) pre: bCode <> ''
		 * and name <> '' and price > 0
		 */

		admin.updateProduct("2", "23", -5);
	}

	private static void checkProductInvariants(SaleSystem saleSystem) {
		System.err
				.println("----------------Product Invariants----------------");
		Product p = new Product();
		Product.ConstraintChecker cc = p.new ConstraintChecker();

		// inv : self.barCode <> ''
		try {
			String invalidBarCode = "";
			p.setBarCode(invalidBarCode);
			cc.check_Product_invariant_barCode();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}
		// inv : self.name <> ''
		try {
			String invalidName = "";
			p.setName(invalidName);
			cc.check_Product_invariant_name();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}
		// inv : self.price > 0
		try {
			float invalidPrice = -20;
			p.setPrice(invalidPrice);
			cc.check_Product_invariant_price();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}

		// all invariants are respected
		p.setBarCode("232");
		p.setName("Lapte");
		p.setPrice(5);
		try {
			cc.checkConstraintsThrowingException();
		} catch (InvariantException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void checkSaleItemInvariants(SaleSystem saleSystem) {
		System.err
				.println("----------------Sale Item Invariants----------------");
		Product p1 = new Product("1", "Lapte", 5);

		// inv : self.quantitySold > 0
		int invalidQuantity = -3;
		SaleItem si1 = new SaleItem(invalidQuantity, p1);
		SaleItem.ConstraintChecker cc = si1.new ConstraintChecker();
		cc.check_SaleItem_invariant();

		// invariant is respected
		int validQuantity = 3;
		si1.setQuantitySold(validQuantity);
		cc.check_SaleItem_invariant();

	}

	private synchronized static void checkSaleAgentInvariants(
			SaleSystem saleSystem) {
		System.err
				.println("----------------Sale Agent Invariants----------------");
		// inv : id.isDefined() and id > 0
		int invalidId = -1;

		// invariant is not respected, name is equal to ""
		SaleAgent sa = new SaleAgent(new OrderedSet(), invalidId,
				"Ion Popescu", saleSystem);
		SaleAgent.ConstraintChecker cc = sa.new ConstraintChecker();
		cc.check_SaleAgent_Id_invariant();

		// valid id, variant is respected
		sa.setId(1);
		cc.check_SaleAgent_Id_invariant();

		// inv : self.name <> ''
		String invalidName = "";
		sa.setName(invalidName);
		cc.check_SaleAgent_Name_invariant();

		// valid name, variant is respected
		sa.setName("Ion Popescu");
		cc.check_SaleAgent_Name_invariant();

		saleSystem.addSaleAgents(sa);
	}

	private static void checkAdministratorInvariants(SaleSystem saleSystem) {
		System.err
				.println("----------------Administrator Invariants----------------");
		// inv : self.name<> ''

		// invariant is not respected, name is equal to ""
		String invalidAdminName = "";
		Administrator admin = new Administrator(invalidAdminName, saleSystem);
		Administrator.ConstraintChecker cc = admin.new ConstraintChecker();
		cc.checkConstraints();

		// invariant is respected, name is valid
		String validName = "Iulian Rosca";
		admin.setName(validName);
		cc.checkConstraints();

		saleSystem.setAdministrator(admin);
	}
}
