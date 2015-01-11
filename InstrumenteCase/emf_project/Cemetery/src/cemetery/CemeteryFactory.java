/**
 */
package cemetery;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cemetery.CemeteryPackage
 * @generated
 */
public interface CemeteryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CemeteryFactory eINSTANCE = cemetery.impl.CemeteryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Decedat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decedat</em>'.
	 * @generated
	 */
	Decedat createDecedat();

	/**
	 * Returns a new object of class '<em>Mormant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mormant</em>'.
	 * @generated
	 */
	Mormant createMormant();

	/**
	 * Returns a new object of class '<em>Detinator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detinator</em>'.
	 * @generated
	 */
	Detinator createDetinator();

	/**
	 * Returns a new object of class '<em>Inspector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inspector</em>'.
	 * @generated
	 */
	Inspector createInspector();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CemeteryPackage getCemeteryPackage();

} //CemeteryFactory
