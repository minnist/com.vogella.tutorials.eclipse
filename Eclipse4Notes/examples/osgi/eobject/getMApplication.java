// Using EMF to access the parent of a toolbar
@Override
protected MApplication getApplication() {
	return (MApplication) (((EObject) toolbar).eContainer()).eContainer().eContainer();
}

//Using EMF to access the parent of a menu
@Override
protected MApplication getApplication() {
	return (MApplication) (((EObject) menu).eContainer()).eContainer();
}