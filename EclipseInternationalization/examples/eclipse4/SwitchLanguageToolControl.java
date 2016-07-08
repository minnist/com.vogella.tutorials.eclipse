public class SwitchLanguageToolControl.java {

	Button button;
	
	@Inject
	ILocaleChangeService lcs;
	
	@PostConstruct
	public createPartControls(Composite parent) {
		
		final Text input = new Text(parent, SWT.BORDER);
		
		
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.CR
						|| event.keyCode == SWT.KEYPAD_CR) {
					lcs.changeApplicationLocale(input.getText());
				}
			}
		});
	
		button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lcs.changeApplicationLocale(input.getText());
			};
		});
	}

	@Inject
	public void translate(@Translation Messages messages) {
		// button localization via Eclipse Translation Pattern
		button.setText(messages.button_change_locale);
	}
}