
/*
 * @(#)Customer.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ro.ubbcluj.lci.codegen.framework.dt.Real;
import ro.ubbcluj.lci.codegen.framework.ocl.CollectionUtilities;

/**
 *
 * @author unascribed
 */
public class Customer {

	
	public void register() {

	}
	
	public void printStatement() {

	}
	
	public boolean highRisk() {

		
		class ConstraintChecker {

			
			boolean result;
			
			public void checkPreconditions() {

			}
			
			public void checkPostconditions() {

				check_postcondition();
				check_firstScenario();
				check_secondScenario();
				check_thirdScenario();

			}
			
			public void check_postcondition() {

				boolean bIf;
				Set setPossession = Customer.this.getPossession();
				//evaluate 'collect(margin())':
				List bagCollect = CollectionUtilities.newBag();
				final Iterator iter = setPossession.iterator();
				while (iter.hasNext()) {
					final Portofolio decl = (Portofolio)iter.next();
					float fMargin = decl.margin();
					
					bagCollect.add(Real.toReal(fMargin));
				}
				bagCollect = CollectionUtilities.flatten(bagCollect);
				
				float fSum = CollectionUtilities.sum(bagCollect);
				Set setPossession0 = Customer.this.getPossession();
				//evaluate 'collect(loanValue())':
				List bagCollect0 = CollectionUtilities.newBag();
				final Iterator iter0 = setPossession0.iterator();
				while (iter0.hasNext()) {
					final Portofolio decl = (Portofolio)iter0.next();
					float fLoanValue = decl.loanValue();
					
					bagCollect0.add(Real.toReal(fLoanValue));
				}
				bagCollect0 = CollectionUtilities.flatten(bagCollect0);
				
				float fSum0 = CollectionUtilities.sum(bagCollect0);
				float fMultiply = 0.9f * fSum0;
				boolean bGreater = fSum > fMultiply;
				
				if (bGreater) {
					
					bIf = true;
				}
				else {
					
					bIf = false;
				}
				boolean bEquals = result == bIf;
				if (!bEquals) {
					System.err.println("postcondition 'postcondition' failed for object "+Customer.this);
				}

			}
			
			public void check_firstScenario() {

				boolean bIf;
				Set setPossession = Customer.this.getPossession();
				//evaluate 'collect(margin())':
				List bagCollect = CollectionUtilities.newBag();
				final Iterator iter = setPossession.iterator();
				while (iter.hasNext()) {
					final Portofolio decl = (Portofolio)iter.next();
					float fMargin = decl.margin();
					
					bagCollect.add(Real.toReal(fMargin));
				}
				bagCollect = CollectionUtilities.flatten(bagCollect);
				
				float fSum = CollectionUtilities.sum(bagCollect);
				Set setPossession0 = Customer.this.getPossession();
				//evaluate 'collect(p|p.loanValue())':
				List bagCollect0 = CollectionUtilities.newBag();
				final Iterator iter0 = setPossession0.iterator();
				while (iter0.hasNext()) {
					final Portofolio p = (Portofolio)iter0.next();
					float fLoanValue = p.loanValue();
					
					bagCollect0.add(Real.toReal(fLoanValue));
				}
				bagCollect0 = CollectionUtilities.flatten(bagCollect0);
				
				float fSum0 = CollectionUtilities.sum(bagCollect0);
				float fMultiply = 0.9f * fSum0;
				boolean bGreater = fSum > fMultiply;
				
				if (bGreater) {
					
					bIf = true;
				}
				else {
					
					bIf = false;
				}
				boolean bEquals = result == bIf;
				if (!bEquals) {
					System.err.println("postcondition 'firstScenario' failed for object "+Customer.this);
				}

			}
			
			public void check_secondScenario() {

				boolean bIf;
				Set setPossession = Customer.this.getPossession();
				//evaluate 'collect(margin())':
				List bagCollect = CollectionUtilities.newBag();
				final Iterator iter = setPossession.iterator();
				while (iter.hasNext()) {
					final Portofolio decl = (Portofolio)iter.next();
					float fMargin = decl.margin();
					
					bagCollect.add(Real.toReal(fMargin));
				}
				bagCollect = CollectionUtilities.flatten(bagCollect);
				
				float fSum = CollectionUtilities.sum(bagCollect);
				Set setPossession0 = Customer.this.getPossession();
				//evaluate 'collect(loanValue())':
				List bagCollect0 = CollectionUtilities.newBag();
				final Iterator iter0 = setPossession0.iterator();
				while (iter0.hasNext()) {
					final Portofolio iter1 = (Portofolio)iter0.next();
					float fLoanValue = iter1.loanValue();
					
					bagCollect0.add(Real.toReal(fLoanValue));
				}
				bagCollect0 = CollectionUtilities.flatten(bagCollect0);
				
				float fSum0 = CollectionUtilities.sum(bagCollect0);
				float fMultiply = 0.9f * fSum0;
				boolean bGreater = fSum > fMultiply;
				
				if (bGreater) {
					
					bIf = true;
				}
				else {
					
					bIf = false;
				}
				boolean bEquals = result == bIf;
				if (!bEquals) {
					System.err.println("postcondition 'secondScenario' failed for object "+Customer.this);
				}

			}
			
			public void check_thirdScenario() {

				boolean bIf;
				Set setPossession = Customer.this.getPossession();
				//evaluate 'collect(margin())':
				List bagCollect = CollectionUtilities.newBag();
				final Iterator iter = setPossession.iterator();
				while (iter.hasNext()) {
					final Portofolio decl = (Portofolio)iter.next();
					float fMargin = decl.margin();
					
					bagCollect.add(Real.toReal(fMargin));
				}
				bagCollect = CollectionUtilities.flatten(bagCollect);
				
				float fSum = CollectionUtilities.sum(bagCollect);
				Set setPossession0 = Customer.this.getPossession();
				//evaluate 'collect(loanValue())':
				List bagCollect0 = CollectionUtilities.newBag();
				final Iterator iter0 = setPossession0.iterator();
				while (iter0.hasNext()) {
					final Portofolio decl = (Portofolio)iter0.next();
					float fLoanValue = decl.loanValue();
					
					bagCollect0.add(Real.toReal(fLoanValue));
				}
				bagCollect0 = CollectionUtilities.flatten(bagCollect0);
				
				float fSum0 = CollectionUtilities.sum(bagCollect0);
				float fMultiply = 0.9f * fSum0;
				boolean bGreater = fSum > fMultiply;
				
				if (bGreater) {
					
					bIf = true;
				}
				else {
					
					bIf = false;
				}
				boolean bEquals = result == bIf;
				if (!bEquals) {
					System.err.println("postcondition 'thirdScenario' failed for object "+Customer.this);
				}

			}

		}
		ConstraintChecker checker = new ConstraintChecker();
		checker.checkPreconditions();
		checker.result = internal_highRisk();

		checker.checkPostconditions();
		return checker.result;

	}
	
	public final Set getPossession() {

		if (possession == null) {
			return java.util.Collections.EMPTY_SET;
		}
		return java.util.Collections.unmodifiableSet(possession);
	}
	
	public final void addPossession(Portofolio arg) {

		if (arg != null) {
			if (possession == null) {
				possession = new LinkedHashSet();
			}
			if (possession.add(arg)) {
				arg.setOwner(this);
			}
		}

	}
	
	public final void removePossession(Portofolio arg) {

		if (possession != null && arg != null) {
			if (possession.remove(arg)) {
				arg.setOwner(null);
			}
		}

	}
	
	private boolean internal_highRisk() {

		return false;

	}
	
	public Customer() {

	}
	
	public Set possession;
	
	private String name;
	
	private String address;
	
	private String phone;

}