/**
 */
package cemetery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mormant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cemetery.Mormant#getIdMormant <em>Id Mormant</em>}</li>
 *   <li>{@link cemetery.Mormant#getDecedati <em>Decedati</em>}</li>
 * </ul>
 * </p>
 *
 * @see cemetery.CemeteryPackage#getMormant()
 * @model
 * @generated
 */
public interface Mormant extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Mormant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Mormant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Mormant</em>' attribute.
	 * @see #setIdMormant(int)
	 * @see cemetery.CemeteryPackage#getMormant_IdMormant()
	 * @model id="true"
	 * @generated
	 */
	int getIdMormant();

	/**
	 * Sets the value of the '{@link cemetery.Mormant#getIdMormant <em>Id Mormant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Mormant</em>' attribute.
	 * @see #getIdMormant()
	 * @generated
	 */
	void setIdMormant(int value);

	/**
	 * Returns the value of the '<em><b>Decedati</b></em>' reference list.
	 * The list contents are of type {@link cemetery.Decedat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decedati</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decedati</em>' reference list.
	 * @see cemetery.CemeteryPackage#getMormant_Decedati()
	 * @model required="true"
	 * @generated
	 */
	EList<Decedat> getDecedati();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDecedat(Decedat decedat);

} // Mormant
