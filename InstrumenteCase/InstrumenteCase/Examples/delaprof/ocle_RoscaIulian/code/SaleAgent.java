
/*
 * @(#)SaleAgent.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ro.ubbcluj.lci.codegen.framework.dt.Integer;
import ro.ubbcluj.lci.codegen.framework.ocl.BasicConstraintChecker;
import ro.ubbcluj.lci.codegen.framework.ocl.CollectionUtilities;
import ro.ubbcluj.lci.codegen.framework.ocl.Ocl;
import ro.ubbcluj.lci.codegen.framework.ocl.OclType;

/**
 *
 * @author unascribed
 */
public class SaleAgent {

    
    public void makeSale(Sale sale) {

    }
    
    public final SaleSystem getJob() {

        return job;
    }
    
    public final void setJob(SaleSystem arg) {

        if (job != arg) {
            SaleSystem temp = job;
            job = null;//to avoid infinite recursions
            if (temp != null) {
                temp.removeSaleAgents(this);
            }
            if (arg != null) {
                job = arg;
                arg.addSaleAgents(this);
            }
        }

    }
    
    public final Set getSales() {

        if (sales == null) {
            return java.util.Collections.EMPTY_SET;
        }
        return java.util.Collections.unmodifiableSet(sales);
    }
    
    public final void addSales(Sale arg) {

        if (arg != null) {
            if (sales == null) {
                sales = new LinkedHashSet();
            }
            if (sales.add(arg)) {
                arg.setSaleAgent(this);
            }
        }

    }
    
    public final void removeSales(Sale arg) {

        if (sales != null && arg != null) {
            if (sales.remove(arg)) {
                arg.setSaleAgent(null);
            }
        }

    }
    
    public int size() {

        Set setSales = SaleAgent.this.getSales();
        int nSize = CollectionUtilities.size(setSales);
        return nSize;

    }
    
    public List lastSale() {

        Set setSales = SaleAgent.this.getSales();
    //evaluate 'collectNested(s|Sequence{s,s.getSaleDate,s.getItems})':
        List bagCollectNested = CollectionUtilities.newBag();
        final Iterator iter = setSales.iterator();
        while (iter.hasNext()) {
            final Sale s = (Sale)iter.next();
            List seq = CollectionUtilities.newSequence();
            CollectionUtilities.add(seq, s);
            DateTime dateTimegetSaleDate = s.getSaleDate();
            CollectionUtilities.add(seq, dateTimegetSaleDate);
            Set setgetItems = s.getItems();
            CollectionUtilities.add(seq, setgetItems);
            
            bagCollectNested.add(seq);
        }
        List seqAsSequence = CollectionUtilities.asSequence(bagCollectNested);
        List seqLast = (List)CollectionUtilities.last(seqAsSequence);
        return seqLast;

    }
    
    public int getId() {

        int nId = SaleAgent.this.id;
        return nId;

    }
    
    public String getName() {

        String strName = SaleAgent.this.name;
        return strName;

    }
    
    public Set getSales() {

        Set setSales = SaleAgent.this.getSales();
        return setSales;

    }
    
    public SaleAgent() {

    }
    
    public class ConstraintChecker extends BasicConstraintChecker {

        
        public void checkConstraints() {

            super.checkConstraints();
            check_SaleAgent_invariant();
            check_SaleAgent_invariant0();
            check_SaleAgent_invariant1();

        }
        
        public void check_SaleAgent_invariant() {

            int nId = SaleAgent.this.id;
            boolean bIsDefined = Ocl.isDefined(Integer.toInteger(nId));
            int nId0 = SaleAgent.this.id;
            boolean bGreater = nId0 > 0;
            boolean bAnd = bIsDefined && bGreater;
            if (!bAnd) {
                System.err.println("invariant 'invariant' failed for object "+SaleAgent.this);
            }

        }
        
        public void check_SaleAgent_invariant0() {

            String strName = SaleAgent.this.name;
            boolean bNotEquals = !strName.equals("");
            if (!bNotEquals) {
                System.err.println("invariant 'invariant0' failed for object "+SaleAgent.this);
            }

        }
        
        public void check_SaleAgent_invariant1() {

        Set setAllInstances = Ocl.getType(new Class[]{SaleAgent.class}).allInstances();
            //evaluate 'collect(id)':
            List bagCollect = CollectionUtilities.newBag();
            final Iterator iter = setAllInstances.iterator();
            while (iter.hasNext()) {
                final SaleAgent decl = (SaleAgent)iter.next();
                int nId = decl.id;
                
                bagCollect.add(Integer.toInteger(nId));
            }
            bagCollect = CollectionUtilities.flatten(bagCollect);
            
            //evaluate 'isUnique(n|n)':
            Set uniquenessValidator = CollectionUtilities.newSet();
            boolean bIsUnique = true;
            final Iterator iter0 = bagCollect.iterator();
            while (bIsUnique && iter0.hasNext()) {
                final int n = ((Integer)iter0.next()).asInteger();
                
                bIsUnique = uniquenessValidator.add(Integer.toInteger(n));
            }
            if (!bIsUnique) {
                System.err.println("invariant 'invariant1' failed for object "+SaleAgent.this);
            }

        }

    }
    
    private int id;
    
    private String name;
    
    private SaleSystem job;
    
    private Set sales;
    {

        OclType.registerInstance(this, SaleAgent.class);

    }

}