// after the viewer is instantiated
viewer.addSelectionChangedListener(new ISelectionChangedListener() {
@Override
public void selectionChanged(SelectionChangedEvent event) {
	IStructuredSelection selection =  viewer.getStructuredSelection();
		// selection.getFirstElement() returns a Todo object 
		service.setSelection(selection.getFirstElement());
	}
});