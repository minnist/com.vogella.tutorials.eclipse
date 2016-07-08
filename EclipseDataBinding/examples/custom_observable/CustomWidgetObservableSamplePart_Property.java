@PostConstruct
public void createComposite(Composite parent) {
	parent.setLayout(new GridLayout(1, false));

	DataBindingContext dbc = new DataBindingContext();
	
	CustomWidget widget = new CustomWidget(parent);
	
	// Create the property and then observe the widget afterwards
	CustomWidgetProperty customWidgetProperty = new CustomWidgetProperty();
	ISWTObservableValue customWidgetObservableValue = customWidgetProperty.observe(widget);
	
	Todo todo = //...
	IObservableValue todoSummaryObservable = PojoProperties.value("summary").observe(todo);
	
	dbc.bindValue(customWidgetObservableValue, todoSummaryObservable);
}