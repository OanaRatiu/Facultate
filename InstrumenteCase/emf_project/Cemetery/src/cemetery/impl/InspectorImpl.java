/**
 */
package cemetery.impl;

import cemetery.CemeteryPackage;
import cemetery.Decedat;
import cemetery.Detinator;
import cemetery.Inspector;
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
 * An implementation of the model object '<em><b>Inspector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cemetery.impl.InspectorImpl#getNume <em>Nume</em>}</li>
 *   <li>{@link cemetery.impl.InspectorImpl#getDecedati <em>Decedati</em>}</li>
 *   <li>{@link cemetery.impl.InspectorImpl#getDetinatori <em>Detinatori</em>}</li>
 *   <li>{@link cemetery.impl.InspectorImpl#getMorminte <em>Morminte</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InspectorImpl extends MinimalEObjectImpl.Container implements Inspector {
	/**
	 * The default value of the '{@link #getNume() <em>Nume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNume()
	 * @generated
	 * @ordered
	 */
	protected static final String NUME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNume() <em>Nume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNume()
	 * @generated
	 * @ordered
	 */
	protected String nume = NUME_EDEFAULT;

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
	 * The cached value of the '{@link #getDetinatori() <em>Detinatori</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetinatori()
	 * @generated
	 * @ordered
	 */
	protected EList<Detinator> detinatori;

	/**
	 * The cached value of the '{@link #getMorminte() <em>Morminte</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMorminte()
	 * @generated
	 * @ordered
	 */
	protected EList<Mormant> morminte;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InspectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CemeteryPackage.Literals.INSPECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNume() {
		return nume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNume(String newNume) {
		String oldNume = nume;
		nume = newNume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.INSPECTOR__NUME, oldNume, nume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Decedat> getDecedati() {
		if (decedati == null) {
			decedati = new EObjectResolvingEList<Decedat>(Decedat.class, this, CemeteryPackage.INSPECTOR__DECEDATI);
		}
		return decedati;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Detinator> getDetinatori() {
		if (detinatori == null) {
			detinatori = new EObjectResolvingEList<Detinator>(Detinator.class, this, CemeteryPackage.INSPECTOR__DETINATORI);
		}
		return detinatori;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mormant> getMorminte() {
		if (morminte == null) {
			morminte = new EObjectResolvingEList<Mormant>(Mormant.class, this, CemeteryPackage.INSPECTOR__MORMINTE);
		}
		return morminte;
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
	public void addDetinator(Detinator detinator) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addMormant(Mormant mormant) {
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
			case CemeteryPackage.INSPECTOR__NUME:
				return getNume();
			case CemeteryPackage.INSPECTOR__DECEDATI:
				return getDecedati();
			case CemeteryPackage.INSPECTOR__DETINATORI:
				return getDetinatori();
			case CemeteryPackage.INSPECTOR__MORMINTE:
				return getMorminte();
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
			case CemeteryPackage.INSPECTOR__NUME:
				setNume((String)newValue);
				return;
			case CemeteryPackage.INSPECTOR__DECEDATI:
				getDecedati().clear();
				getDecedati().addAll((Collection<? extends Decedat>)newValue);
				return;
			case CemeteryPackage.INSPECTOR__DETINATORI:
				getDetinatori().clear();
				getDetinatori().addAll((Collection<? extends Detinator>)newValue);
				return;
			case CemeteryPackage.INSPECTOR__MORMINTE:
				getMorminte().clear();
				getMorminte().addAll((Collection<? extends Mormant>)newValue);
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
			case CemeteryPackage.INSPECTOR__NUME:
				setNume(NUME_EDEFAULT);
				return;
			case CemeteryPackage.INSPECTOR__DECEDATI:
				getDecedati().clear();
				return;
			case CemeteryPackage.INSPECTOR__DETINATORI:
				getDetinatori().clear();
				return;
			case CemeteryPackage.INSPECTOR__MORMINTE:
				getMorminte().clear();
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
			case CemeteryPackage.INSPECTOR__NUME:
				return NUME_EDEFAULT == null ? nume != null : !NUME_EDEFAULT.equals(nume);
			case CemeteryPackage.INSPECTOR__DECEDATI:
				return decedati != null && !decedati.isEmpty();
			case CemeteryPackage.INSPECTOR__DETINATORI:
				return detinatori != null && !detinatori.isEmpty();
			case CemeteryPackage.INSPECTOR__MORMINTE:
				return morminte != null && !morminte.isEmpty();
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
			case CemeteryPackage.INSPECTOR___ADD_DECEDAT__DECEDAT:
				addDecedat((Decedat)arguments.get(0));
				return null;
			case CemeteryPackage.INSPECTOR___ADD_DETINATOR__DETINATOR:
				addDetinator((Detinator)arguments.get(0));
				return null;
			case CemeteryPackage.INSPECTOR___ADD_MORMANT__MORMANT:
				addMormant((Mormant)arguments.get(0));
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
		result.append(" (nume: ");
		result.append(nume);
		result.append(')');
		return result.toString();
	}

} //InspectorImpl
