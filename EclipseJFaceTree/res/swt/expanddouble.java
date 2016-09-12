
viewer.addDoubleClickListener(new IDoubleClickListener() {
	@Override
	public void doubleClick(DoubleClickEvent event) {
		TreeViewer viewer = (TreeViewer) event.getViewer();
		IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection(); 
		Object selectedNode = thisSelection.getFirstElement(); 
		viewer.setExpandedState(selectedNode,
				!viewer.getExpandedState(selectedNode));
	}
});