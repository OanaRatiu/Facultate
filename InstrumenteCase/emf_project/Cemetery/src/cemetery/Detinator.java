/**
 */
package cemetery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detinator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cemetery.Detinator#getIdDetinator <em>Id Detinator</em>}</li>
 *   <li>{@link cemetery.Detinator#getNume <em>Nume</em>}</li>
 *   <li>{@link cemetery.Detinator#getChitanta <em>Chitanta</em>}</li>
 *   <li>{@link cemetery.Detinator#getMorminte <em>Morminte</em>}</li>
 * </ul>
 * </p>
 *
 * @see cemetery.CemeteryPackage#getDetinator()
 * @model
 * @generated
 */
public interface Detinator extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Detinator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Detinator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Detinator</em>' attribute.
	 * @see #setIdDetinator(int)
	 * @see cemetery.CemeteryPackage#getDetinator_IdDetinator()
	 * @model
	 * @generated
	 */
	int getIdDetinator();

	/**
	 * Sets the value of the '{@link cemetery.Detinator#getIdDetinator <em>Id Detinator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Detinator</em>' attribute.
	 * @see #getIdDetinator()
	 * @generated
	 */
	void setIdDetinator(int value);

	/**
	 * Returns the value of the '<em><b>Nume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nume</em>' attribute.
	 * @see #setNume(String)
	 * @see cemetery.CemeteryPackage#getDetinator_Nume()
	 * @model
	 * @generated
	 */
	String getNume();

	/**
	 * Sets the value of the '{@link cemetery.Detinator#getNume <em>Nume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nume</em>' attribute.
	 * @see #getNume()
	 * @generated
	 */
	void setNume(String value);

	/**
	 * Returns the value of the '<em><b>Chitanta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chitanta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chitanta</em>' attribute.
	 * @see #setChitanta(String)
	 * @see cemetery.CemeteryPackage#getDetinator_Chitanta()
	 * @model
	 * @generated
	 */
	String getChitanta();

	/**
	 * Sets the value of the '{@link cemetery.Detinator#getChitanta <em>Chitanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chitanta</em>' attribute.
	 * @see #getChitanta()
	 * @generated
	 */
	void setChitanta(String value);

	/**
	 * Returns the value of the '<em><b>Morminte</b></em>' reference list.
	 * The list contents are of type {@link cemetery.Mormant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Morminte</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Morminte</em>' reference list.
	 * @see cemetery.CemeteryPackage#getDetinator_Morminte()
	 * @model required="true"
	 * @generated
	 */
	EList<Mormant> getMorminte();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addMormant(Mormant mormant);

} // Detinator
