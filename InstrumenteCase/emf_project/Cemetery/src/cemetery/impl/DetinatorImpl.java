/**
 */
package cemetery.impl;

import cemetery.CemeteryPackage;
import cemetery.Detinator;
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
 * An implementation of the model object '<em><b>Detinator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cemetery.impl.DetinatorImpl#getIdDetinator <em>Id Detinator</em>}</li>
 *   <li>{@link cemetery.impl.DetinatorImpl#getNume <em>Nume</em>}</li>
 *   <li>{@link cemetery.impl.DetinatorImpl#getChitanta <em>Chitanta</em>}</li>
 *   <li>{@link cemetery.impl.DetinatorImpl#getMorminte <em>Morminte</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DetinatorImpl extends MinimalEObjectImpl.Container implements Detinator {
	/**
	 * The default value of the '{@link #getIdDetinator() <em>Id Detinator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdDetinator()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_DETINATOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdDetinator() <em>Id Detinator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdDetinator()
	 * @generated
	 * @ordered
	 */
	protected int idDetinator = ID_DETINATOR_EDEFAULT;

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
	 * The default value of the '{@link #getChitanta() <em>Chitanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChitanta()
	 * @generated
	 * @ordered
	 */
	protected static final String CHITANTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChitanta() <em>Chitanta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChitanta()
	 * @generated
	 * @ordered
	 */
	protected String chitanta = CHITANTA_EDEFAULT;

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
	protected DetinatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CemeteryPackage.Literals.DETINATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdDetinator() {
		return idDetinator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdDetinator(int newIdDetinator) {
		int oldIdDetinator = idDetinator;
		idDetinator = newIdDetinator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.DETINATOR__ID_DETINATOR, oldIdDetinator, idDetinator));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.DETINATOR__NUME, oldNume, nume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChitanta() {
		return chitanta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChitanta(String newChitanta) {
		String oldChitanta = chitanta;
		chitanta = newChitanta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.DETINATOR__CHITANTA, oldChitanta, chitanta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mormant> getMorminte() {
		if (morminte == null) {
			morminte = new EObjectResolvingEList<Mormant>(Mormant.class, this, CemeteryPackage.DETINATOR__MORMINTE);
		}
		return morminte;
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
			case CemeteryPackage.DETINATOR__ID_DETINATOR:
				return getIdDetinator();
			case CemeteryPackage.DETINATOR__NUME:
				return getNume();
			case CemeteryPackage.DETINATOR__CHITANTA:
				return getChitanta();
			case CemeteryPackage.DETINATOR__MORMINTE:
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
			case CemeteryPackage.DETINATOR__ID_DETINATOR:
				setIdDetinator((Integer)newValue);
				return;
			case CemeteryPackage.DETINATOR__NUME:
				setNume((String)newValue);
				return;
			case CemeteryPackage.DETINATOR__CHITANTA:
				setChitanta((String)newValue);
				return;
			case CemeteryPackage.DETINATOR__MORMINTE:
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
			case CemeteryPackage.DETINATOR__ID_DETINATOR:
				setIdDetinator(ID_DETINATOR_EDEFAULT);
				return;
			case CemeteryPackage.DETINATOR__NUME:
				setNume(NUME_EDEFAULT);
				return;
			case CemeteryPackage.DETINATOR__CHITANTA:
				setChitanta(CHITANTA_EDEFAULT);
				return;
			case CemeteryPackage.DETINATOR__MORMINTE:
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
			case CemeteryPackage.DETINATOR__ID_DETINATOR:
				return idDetinator != ID_DETINATOR_EDEFAULT;
			case CemeteryPackage.DETINATOR__NUME:
				return NUME_EDEFAULT == null ? nume != null : !NUME_EDEFAULT.equals(nume);
			case CemeteryPackage.DETINATOR__CHITANTA:
				return CHITANTA_EDEFAULT == null ? chitanta != null : !CHITANTA_EDEFAULT.equals(chitanta);
			case CemeteryPackage.DETINATOR__MORMINTE:
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CemeteryPackage.DETINATOR___ADD_MORMANT__MORMANT:
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
		result.append(" (idDetinator: ");
		result.append(idDetinator);
		result.append(", nume: ");
		result.append(nume);
		result.append(", chitanta: ");
		result.append(chitanta);
		result.append(')');
		return result.toString();
	}

} //DetinatorImpl
