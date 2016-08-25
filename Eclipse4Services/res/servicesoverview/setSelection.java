// use field injection for the service
@Inject ESelectionService selectionService;

// viewer is a JFace Viewer
viewer.addSelectionChangedListener(new ISelectionChangedListener() {
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = viewer.getStructuredSelection();
		selectionService.setSelection(selection.getFirstElement());
	}
});