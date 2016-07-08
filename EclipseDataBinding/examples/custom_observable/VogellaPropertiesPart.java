public class VogellaPropertiesPart {

	@PostConstruct
	public void createPartControl(Composite parent) {
		CustomWidget customWidget = new CustomWidget(parent);
		
		// Observable for the CustomWidget by using the delegate
		IObservableValue customWidgetObservable = VogellaProperties.vogellaProperty().observe(customWidget);
		
		DateTime dateTime = new DateTime(parent, SWT.DROP_DOWN);
		// Observable for the DateTime by using the delegate
		IObservableValue dateTimeJava8Observable = VogellaProperties.vogellaProperty().observe(dateTime);
		
		// ### Real common properties for different kinds of objects ###
		
		Button button = new Button(parent, SWT.CHECK);
		CCombo combo = new CCombo(parent, SWT.READ_ONLY);
		
		// see WidgetSelectionProperty for more details
		ISWTObservableValue oldDateTimeObservable = WidgetProperties.selection().observe(dateTime);
		ISWTObservableValue buttonSelectionObservable = WidgetProperties.selection().observe(button);
		ISWTObservableValue comboSelectionObservable = WidgetProperties.selection().observe(combo);
		
		// and much more
	}
}
