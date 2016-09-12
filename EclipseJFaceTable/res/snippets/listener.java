viewer.addSelectionChangedListener(new ISelectionChangedListener() {
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = viewer.getStructuredSelection();
		Object firstElement = selection.getFirstElement();
		// do something with it
	}
});