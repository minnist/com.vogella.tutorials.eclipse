public class TranslationExamplePart {
	private Label myLabel;
	
	@PostConstruct
	public void postConstruct(Composite parent, @Translation Messages messages) {
		// create the UI
		myLabel = new Label(parent, SWT.NONE);
		// as @PostConstruct is executed after field injection, we need to
		// call translate here manually to fill the UI initially
		translate(messages);
	}

	// the method that will perform the dynamic locale changes
	@Inject
	public void translate(@Translation Messages messages) {
		if (myLabel != null && !myLabel.isDisposed())
			myLabel.setText(messages.labelSummary);
	}
}