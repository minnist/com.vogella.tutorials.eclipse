
public void createPartControl(Composite parent) {
	//.... existing coding
	// make selection available via the SelectionProvider
	getSite().setSelectionProvider(viewer);
}

//Used to update the viewer from outsite
public void refresh() {
	viewer.refresh();
}
