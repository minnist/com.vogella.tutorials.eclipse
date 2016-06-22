
Button button = new Button(parent, SWT.PUSH);
button.setText("Open Wizard");
button.addSelectionListener(new SelectionAdapter() {
	@Override
	public void widgetSelected(SelectionEvent e) {
		WizardDialog wizardDialog = new WizardDialog(parent.getShell(),
			new MyWizard());
		if (wizardDialog.open() == Window.OK) {
			System.out.println("Ok pressed");
		} else {
			System.out.println("Cancel pressed");
		}
	}
});