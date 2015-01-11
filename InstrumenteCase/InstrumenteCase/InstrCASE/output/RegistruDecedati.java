
/*
 * @(#)RegistruDecedati.java
 *
 * Generated by <a href="http://lci.cs.ubbcluj.ro/ocle/>OCLE 2.0</a>
 * using <a href="http://jakarta.apache.org/velocity/">
 * Velocity Template Engine 1.3rc1</a>
 */

/**
 *
 * @author unascribed
 */
public class RegistruDecedati
{

    
    public void add(Decedat decedat, Detinator detinator, Mormant mromant)
    {

        
        class ConstraintChecker
        {

            
            public void checkPreconditions(Decedat decedat, Detinator detinator, Mormant mromant)
            {

                check_precondition(decedat, detinator, mromant);

            }
            
            public void checkPostconditions(Decedat decedat, Detinator detinator, Mormant mromant)
            {

            }
            
            public void check_precondition(Decedat d, Detinator dt, Mormant m)
            {

                int nIdMormant = m.idMormant;
                boolean bGreater = nIdMormant > 0;
                int nIdDecedat = d.idDecedat;
                boolean bGreater0 = nIdDecedat > 0;
                boolean bAnd0 = bGreater && bGreater0;
                int nIdDetinator = dt.idDetinator;
                boolean bGreater1 = nIdDetinator > 0;
                boolean bAnd = bAnd0 && bGreater1;
                if (!bAnd)
                {
                    System.err.println("precondition 'precondition' failed for object "+RegistruDecedati.this);
                }

            }

        }
        ConstraintChecker checker = new ConstraintChecker();
        checker.checkPreconditions(decedat, detinator, mromant);
        checker.result = internal_add(decedat, detinator, mromant);

        checker.checkPostconditions(decedat, detinator, mromant);
        return checker.result;

    }
    
    private void internal_add(Decedat decedat, Detinator detinator, Mormant mromant)
    {

    }
    
    public RegistruDecedati()
    {

    }

}
