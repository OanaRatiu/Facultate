/**
 */
package cemetery.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>cemetery</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class CemeteryTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new CemeteryTests("cemetery Tests");
		suite.addTestSuite(MormantTest.class);
		suite.addTestSuite(DetinatorTest.class);
		suite.addTestSuite(InspectorTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CemeteryTests(String name) {
		super(name);
	}

} //CemeteryTests
