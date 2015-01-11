/**
 */
package cemetery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decedat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cemetery.Decedat#getIdDecedat <em>Id Decedat</em>}</li>
 *   <li>{@link cemetery.Decedat#getNume <em>Nume</em>}</li>
 *   <li>{@link cemetery.Decedat#getPrenume <em>Prenume</em>}</li>
 * </ul>
 * </p>
 *
 * @see cemetery.CemeteryPackage#getDecedat()
 * @model
 * @generated
 */
public interface Decedat extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Decedat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Decedat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Decedat</em>' attribute.
	 * @see #setIdDecedat(int)
	 * @see cemetery.CemeteryPackage#getDecedat_IdDecedat()
	 * @model id="true"
	 * @generated
	 */
	int getIdDecedat();

	/**
	 * Sets the value of the '{@link cemetery.Decedat#getIdDecedat <em>Id Decedat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Decedat</em>' attribute.
	 * @see #getIdDecedat()
	 * @generated
	 */
	void setIdDecedat(int value);

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
	 * @see cemetery.CemeteryPackage#getDecedat_Nume()
	 * @model unique="false"
	 * @generated
	 */
	String getNume();

	/**
	 * Sets the value of the '{@link cemetery.Decedat#getNume <em>Nume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nume</em>' attribute.
	 * @see #getNume()
	 * @generated
	 */
	void setNume(String value);

	/**
	 * Returns the value of the '<em><b>Prenume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prenume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prenume</em>' attribute.
	 * @see #setPrenume(String)
	 * @see cemetery.CemeteryPackage#getDecedat_Prenume()
	 * @model
	 * @generated
	 */
	String getPrenume();

	/**
	 * Sets the value of the '{@link cemetery.Decedat#getPrenume <em>Prenume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prenume</em>' attribute.
	 * @see #getPrenume()
	 * @generated
	 */
	void setPrenume(String value);

} // Decedat
