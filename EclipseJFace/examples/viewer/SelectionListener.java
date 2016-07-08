// react to the selection change of the viewer
// note that the viewer returns the actual object 

viewer.addSelectionChangedListener(new ISelectionChangedListener() {
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event
			.getSelection();
		if (selection.size() > 0){
			System.out.println(((Person) selection.getFirstElement())
					.getLastName());
		}
	}
});

