/**
 */
package cemetery.impl;

import cemetery.CemeteryFactory;
import cemetery.CemeteryPackage;
import cemetery.Decedat;
import cemetery.Detinator;
import cemetery.Inspector;
import cemetery.Mormant;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CemeteryPackageImpl extends EPackageImpl implements CemeteryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decedatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mormantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detinatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inspectorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see cemetery.CemeteryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CemeteryPackageImpl() {
		super(eNS_URI, CemeteryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CemeteryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CemeteryPackage init() {
		if (isInited) return (CemeteryPackage)EPackage.Registry.INSTANCE.getEPackage(CemeteryPackage.eNS_URI);

		// Obtain or create and register package
		CemeteryPackageImpl theCemeteryPackage = (CemeteryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CemeteryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CemeteryPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCemeteryPackage.createPackageContents();

		// Initialize created meta-data
		theCemeteryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCemeteryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CemeteryPackage.eNS_URI, theCemeteryPackage);
		return theCemeteryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecedat() {
		return decedatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecedat_IdDecedat() {
		return (EAttribute)decedatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecedat_Nume() {
		return (EAttribute)decedatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecedat_Prenume() {
		return (EAttribute)decedatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMormant() {
		return mormantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMormant_IdMormant() {
		return (EAttribute)mormantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMormant_Decedati() {
		return (EReference)mormantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMormant__AddDecedat__Decedat() {
		return mormantEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDetinator() {
		return detinatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetinator_IdDetinator() {
		return (EAttribute)detinatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetinator_Nume() {
		return (EAttribute)detinatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetinator_Chitanta() {
		return (EAttribute)detinatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDetinator_Morminte() {
		return (EReference)detinatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDetinator__AddMormant__Mormant() {
		return detinatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInspector() {
		return inspectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInspector_Nume() {
		return (EAttribute)inspectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspector_Decedati() {
		return (EReference)inspectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspector_Detinatori() {
		return (EReference)inspectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspector_Morminte() {
		return (EReference)inspectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInspector__AddDecedat__Decedat() {
		return inspectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInspector__AddDetinator__Detinator() {
		return inspectorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInspector__AddMormant__Mormant() {
		return inspectorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CemeteryFactory getCemeteryFactory() {
		return (CemeteryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		decedatEClass = createEClass(DECEDAT);
		createEAttribute(decedatEClass, DECEDAT__ID_DECEDAT);
		createEAttribute(decedatEClass, DECEDAT__NUME);
		createEAttribute(decedatEClass, DECEDAT__PRENUME);

		mormantEClass = createEClass(MORMANT);
		createEAttribute(mormantEClass, MORMANT__ID_MORMANT);
		createEReference(mormantEClass, MORMANT__DECEDATI);
		createEOperation(mormantEClass, MORMANT___ADD_DECEDAT__DECEDAT);

		detinatorEClass = createEClass(DETINATOR);
		createEAttribute(detinatorEClass, DETINATOR__ID_DETINATOR);
		createEAttribute(detinatorEClass, DETINATOR__NUME);
		createEAttribute(detinatorEClass, DETINATOR__CHITANTA);
		createEReference(detinatorEClass, DETINATOR__MORMINTE);
		createEOperation(detinatorEClass, DETINATOR___ADD_MORMANT__MORMANT);

		inspectorEClass = createEClass(INSPECTOR);
		createEAttribute(inspectorEClass, INSPECTOR__NUME);
		createEReference(inspectorEClass, INSPECTOR__DECEDATI);
		createEReference(inspectorEClass, INSPECTOR__DETINATORI);
		createEReference(inspectorEClass, INSPECTOR__MORMINTE);
		createEOperation(inspectorEClass, INSPECTOR___ADD_DECEDAT__DECEDAT);
		createEOperation(inspectorEClass, INSPECTOR___ADD_DETINATOR__DETINATOR);
		createEOperation(inspectorEClass, INSPECTOR___ADD_MORMANT__MORMANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(decedatEClass, Decedat.class, "Decedat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecedat_IdDecedat(), ecorePackage.getEInt(), "idDecedat", null, 0, 1, Decedat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDecedat_Nume(), ecorePackage.getEString(), "nume", null, 0, 1, Decedat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDecedat_Prenume(), ecorePackage.getEString(), "prenume", null, 0, 1, Decedat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mormantEClass, Mormant.class, "Mormant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMormant_IdMormant(), ecorePackage.getEInt(), "idMormant", null, 0, 1, Mormant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMormant_Decedati(), this.getDecedat(), null, "decedati", null, 1, -1, Mormant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getMormant__AddDecedat__Decedat(), null, "addDecedat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDecedat(), "decedat", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(detinatorEClass, Detinator.class, "Detinator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDetinator_IdDetinator(), ecorePackage.getEInt(), "idDetinator", null, 0, 1, Detinator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetinator_Nume(), ecorePackage.getEString(), "nume", null, 0, 1, Detinator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetinator_Chitanta(), ecorePackage.getEString(), "chitanta", null, 0, 1, Detinator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDetinator_Morminte(), this.getMormant(), null, "morminte", null, 1, -1, Detinator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDetinator__AddMormant__Mormant(), null, "addMormant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMormant(), "mormant", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inspectorEClass, Inspector.class, "Inspector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInspector_Nume(), ecorePackage.getEString(), "nume", null, 0, 1, Inspector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspector_Decedati(), this.getDecedat(), null, "decedati", null, 1, -1, Inspector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspector_Detinatori(), this.getDetinator(), null, "detinatori", null, 1, -1, Inspector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspector_Morminte(), this.getMormant(), null, "morminte", null, 1, -1, Inspector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getInspector__AddDecedat__Decedat(), null, "addDecedat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDecedat(), "decedat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getInspector__AddDetinator__Detinator(), null, "addDetinator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDetinator(), "detinator", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getInspector__AddMormant__Mormant(), null, "addMormant", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMormant(), "mormant", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (decedatEClass, 
		   source, 
		   new String[] {
		   });
	}

} //CemeteryPackageImpl
