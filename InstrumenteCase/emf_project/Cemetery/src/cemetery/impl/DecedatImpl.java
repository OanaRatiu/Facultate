/**
 */
package cemetery.impl;

import cemetery.CemeteryPackage;

import cemetery.Decedat;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decedat</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cemetery.impl.DecedatImpl#getIdDecedat <em>Id Decedat</em>}</li>
 *   <li>{@link cemetery.impl.DecedatImpl#getNume <em>Nume</em>}</li>
 *   <li>{@link cemetery.impl.DecedatImpl#getPrenume <em>Prenume</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DecedatImpl extends MinimalEObjectImpl.Container implements Decedat {
	/**
	 * The default value of the '{@link #getIdDecedat() <em>Id Decedat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdDecedat()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_DECEDAT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdDecedat() <em>Id Decedat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdDecedat()
	 * @generated
	 * @ordered
	 */
	protected int idDecedat = ID_DECEDAT_EDEFAULT;

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
	 * The default value of the '{@link #getPrenume() <em>Prenume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrenume()
	 * @generated
	 * @ordered
	 */
	protected static final String PRENUME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrenume() <em>Prenume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrenume()
	 * @generated
	 * @ordered
	 */
	protected String prenume = PRENUME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecedatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CemeteryPackage.Literals.DECEDAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIdDecedat() {
		return idDecedat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdDecedat(int newIdDecedat) {
		int oldIdDecedat = idDecedat;
		idDecedat = newIdDecedat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.DECEDAT__ID_DECEDAT, oldIdDecedat, idDecedat));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.DECEDAT__NUME, oldNume, nume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrenume() {
		return prenume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrenume(String newPrenume) {
		String oldPrenume = prenume;
		prenume = newPrenume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CemeteryPackage.DECEDAT__PRENUME, oldPrenume, prenume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CemeteryPackage.DECEDAT__ID_DECEDAT:
				return getIdDecedat();
			case CemeteryPackage.DECEDAT__NUME:
				return getNume();
			case CemeteryPackage.DECEDAT__PRENUME:
				return getPrenume();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CemeteryPackage.DECEDAT__ID_DECEDAT:
				setIdDecedat((Integer)newValue);
				return;
			case CemeteryPackage.DECEDAT__NUME:
				setNume((String)newValue);
				return;
			case CemeteryPackage.DECEDAT__PRENUME:
				setPrenume((String)newValue);
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
			case CemeteryPackage.DECEDAT__ID_DECEDAT:
				setIdDecedat(ID_DECEDAT_EDEFAULT);
				return;
			case CemeteryPackage.DECEDAT__NUME:
				setNume(NUME_EDEFAULT);
				return;
			case CemeteryPackage.DECEDAT__PRENUME:
				setPrenume(PRENUME_EDEFAULT);
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
			case CemeteryPackage.DECEDAT__ID_DECEDAT:
				return idDecedat != ID_DECEDAT_EDEFAULT;
			case CemeteryPackage.DECEDAT__NUME:
				return NUME_EDEFAULT == null ? nume != null : !NUME_EDEFAULT.equals(nume);
			case CemeteryPackage.DECEDAT__PRENUME:
				return PRENUME_EDEFAULT == null ? prenume != null : !PRENUME_EDEFAULT.equals(prenume);
		}
		return super.eIsSet(featureID);
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
		result.append(" (idDecedat: ");
		result.append(idDecedat);
		result.append(", nume: ");
		result.append(nume);
		result.append(", prenume: ");
		result.append(prenume);
		result.append(')');
		return result.toString();
	}

} //DecedatImpl
