
@PostConstruct
public void createControls(Composite parent, ITodoService todoService) {
	// as before

    // at the end of the method but before updateUserInterface
	Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		button.setText("Save");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ParameterizedCommand command = commandService.createCommand("org.eclipse.ui.file.saveAll", null);
				handlerService.executeHandler(command);
			}
		});
		
		updateUserInterface(todo);
		
}