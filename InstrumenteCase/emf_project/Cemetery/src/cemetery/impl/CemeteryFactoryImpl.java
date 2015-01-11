/**
 */
package cemetery.impl;

import cemetery.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CemeteryFactoryImpl extends EFactoryImpl implements CemeteryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CemeteryFactory init() {
		try {
			CemeteryFactory theCemeteryFactory = (CemeteryFactory)EPackage.Registry.INSTANCE.getEFactory(CemeteryPackage.eNS_URI);
			if (theCemeteryFactory != null) {
				return theCemeteryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CemeteryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CemeteryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CemeteryPackage.DECEDAT: return createDecedat();
			case CemeteryPackage.MORMANT: return createMormant();
			case CemeteryPackage.DETINATOR: return createDetinator();
			case CemeteryPackage.INSPECTOR: return createInspector();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decedat createDecedat() {
		DecedatImpl decedat = new DecedatImpl();
		return decedat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mormant createMormant() {
		MormantImpl mormant = new MormantImpl();
		return mormant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Detinator createDetinator() {
		DetinatorImpl detinator = new DetinatorImpl();
		return detinator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inspector createInspector() {
		InspectorImpl inspector = new InspectorImpl();
		return inspector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CemeteryPackage getCemeteryPackage() {
		return (CemeteryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CemeteryPackage getPackage() {
		return CemeteryPackage.eINSTANCE;
	}

} //CemeteryFactoryImpl
