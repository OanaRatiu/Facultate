/**
 */
package cemetery.impl;

import cemetery.CemeteryPackage;
import cemetery.Decedat;
import cemetery.Mormant;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mormant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cemetery.impl.MormantImpl#getIdMormant <em>Id Mormant</em>}</li>
 *   <li>{@link cemetery.impl.MormantImpl#getDecedati <em>Decedati</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MormantImpl extends MinimalEObjectImpl.Container implements Mormant {
	/**
	 * The default value of the '{@link #getIdMormant() <em>Id Mormant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdMormant()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_MORMANT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdMormant() <em>Id Mormant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdMormant()
	 * @generated
	 * @ordered
	 */
	protected int idMormant = ID_MORMANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDecedati() <em>Decedati</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecedati()
	 * @generated
	 * @ordered
	 */
	protected EList<Decedat> decedati;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MormantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CemeteryPackage.Literals.MORMANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdMormant() {
		return idMormant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdMormant(int newIdMormant) {
		int oldIdMormant = idMormant;
		idMormant = newIdMormant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.MORMANT__ID_MORMANT, oldIdMormant, idMormant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Decedat> getDecedati() {
		if (decedati == null) {
			decedati = new EObjectResolvingEList<Decedat>(Decedat.class, this, CemeteryPackage.MORMANT__DECEDATI);
		}
		return decedati;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addDecedat(Decedat decedat) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CemeteryPackage.MORMANT__ID_MORMANT:
				return getIdMormant();
			case CemeteryPackage.MORMANT__DECEDATI:
				return getDecedati();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CemeteryPackage.MORMANT__ID_MORMANT:
				setIdMormant((Integer)newValue);
				return;
			case CemeteryPackage.MORMANT__DECEDATI:
				getDecedati().clear();
				getDecedati().addAll((Collection<? extends Decedat>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CemeteryPackage.MORMANT__ID_MORMANT:
				setIdMormant(ID_MORMANT_EDEFAULT);
				return;
			case CemeteryPackage.MORMANT__DECEDATI:
				getDecedati().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CemeteryPackage.MORMANT__ID_MORMANT:
				return idMormant != ID_MORMANT_EDEFAULT;
			case CemeteryPackage.MORMANT__DECEDATI:
				return decedati != null && !decedati.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CemeteryPackage.MORMANT___ADD_DECEDAT__DECEDAT:
				addDecedat((Decedat)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (idMormant: ");
		result.append(idMormant);
		result.append(')');
		return result.toString();
	}

} //MormantImpl
