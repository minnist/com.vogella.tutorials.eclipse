// define your change listener
// dirty holds the state for the changed status of the editor
IChangeListener listener = new IChangeListener() {
	@Override
	public void handleChange(ChangeEvent event) {
		// Ensure dirty is not null
		if (dirty!=null){
			dirty.setDirty(true);
		}
};


private void updateUserInterface(Todo todo) {
	
	// check that the user interface is available
	if (txtSummary != null && !txtSummary.isDisposed()) {
	
		
		// Deregister change listener to the old binding
		IObservableList providers = ctx.getValidationStatusProviders();
		for (Object o : providers) {
			Binding b = (Binding) o;
			b.getTarget().removeChangeListener(listener);
		}
	
		// dispose the binding
		ctx.dispose();
	
		// NOTE
		// HERE WOULD BE THE DATABINDING CODE
		// INTENTIALLY LEFT OUT FOR BREVITY
	
	
		
		// get the validation status provides
		IObservableList bindings = 
			ctx.getValidationStatusProviders();

		// mot all validation status providers 
		// are bindings, e.g. MultiValidator
		// otherwise you could use
		// context.getBindings()

		// register the listener to all bindings
		for (Object o : bindings) {
			Binding b = (Binding) o;
			b.getTarget().addChangeListener(listener);
		}
	}
}