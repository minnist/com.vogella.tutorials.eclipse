// listBox is an SWT widget

// GridDataFactory version
GridDataFactory.fillDefaults().grab(true, true).hint(150, 150).applyTo(listBox);
 
// Equivalent SWT version
GridData listBoxData = new GridData(GridData.FILL_BOTH);
listBoxData.widthHint = 150;
listBoxData.heightHint = 150;
listBoxData.minimumWidth = 1;
listBoxData.minimumHeight = 1;
listBox.setLayoutData(listBoxData);