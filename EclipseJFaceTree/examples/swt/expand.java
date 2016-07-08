// the viewer field is an already configured TreeViewer
Tree tree = (Tree) viewer.getControl();
tree.addSelectionListener(new SelectionAdapter() {
  @Override
  public void widgetSelected(SelectionEvent e) {
	  TreeItem item = (TreeItem) e.item;
	  	if (item.getItemCount() > 0) {
	  		item.setExpanded(!item.getExpanded());
	  		// update the viewer
	  		viewer.refresh();
	  	}
  	}
});