@PostConstruct
public void createComposite(Composite parent) {
	parent.setLayout(new GridLayout(1, false));

	DataBindingContext dbc = new DataBindingContext();
	
	CustomWidget widget = new CustomWidget(parent);
	CustomWidgetObservableValue customWidgetObservableValue = new CustomWidgetObservableValue(widget);
	
	Todo todo = //...
	IObservableValue todoSummaryObservable = PojoProperties.value("summary").observe(todo);
	
	dbc.bindValue(customWidgetObservableValue, todoSummaryObservable);
}