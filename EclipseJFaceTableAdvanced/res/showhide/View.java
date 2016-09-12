
// define the menu and assign to the table
contextMenu = new Menu(viewer.getTable());
viewer.getTable().setMenu(contextMenu);

// create your columns as usual...

// afterwards add a MenuItem for each column to the table menu
for (TableColumn tableColumn : viewer.getTable().getColumns() ){
	createMenuItem(contextMenu, tableColumn);
}

// the createMenuItem() method adds a MenuItem
// per column to the menu

private void createMenuItem(Menu parent, final TableColumn column) {
	final MenuItem itemName = new MenuItem(parent, SWT.CHECK);
	itemName.setText(column.getText());
	itemName.setSelection(column.getResizable());
	itemName.addSelectionListener(new SelectionAdapter() {
		  @Override
		  public void widgetSelected(SelectionEvent e) {
			if (itemName.getSelection()) {
				column.setWidth(150);
				column.setResizable(true);
			} else {
				column.setWidth(0);
				column.setResizable(false);
			}
		}
	});
}


