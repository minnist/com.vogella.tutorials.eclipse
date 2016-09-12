@PostConstruct
public void createComposite(Composite parent) {
	parent.setLayout(new GridLayout(1, false));

	DataBindingContext dbc = new DataBindingContext();

	DateTime dateTime = new DateTime(parent, SWT.DROP_DOWN);

	// use the previously created DateTimeSelectionProperty to be able to
	// create a binding with a Java 8 TemporalAccessor
	DateTimeSelectionProperty dateTimeSelectionProperty = new DateTimeSelectionProperty();
	dateTimeObservableValue = dateTimeSelectionProperty.observe(dateTime);

	// create and initialize a placeholder observable, which can be changed
	// later on
	writableDateTimeModel = new WritableValue();
	writableDateTimeModel.setValue(LocalDate.now());

	// bind DateTime widget to a Java 8 TemporalAccessor observable
	dbc.bindValue(dateTimeObservableValue, writableDateTimeModel);

	Label label = new Label(parent, SWT.BORDER);
	GridDataFactory.fillDefaults().grab(true, false).applyTo(label);

	ISWTObservableValue dateTimeLabelObservable = WidgetProperties.text().observe(label);

	// bind a Label to the DateTime Widget, in order to see the changes,
	// which are made in the DateTime widget
	dbc.bindValue(dateTimeLabelObservable, dateTimeObservableValue);

	tableViewer = new TableViewer(parent);
	tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

	tableViewer.add("27.04.1986 00:30:20");
	tableViewer.add("23.06.1976 03:15:30");
	tableViewer.add("27.06.1980 12:05:40");
	tableViewer.add("26.03.2015 22:25:50");
	tableViewer.add("06.12.2015 20:00:10");

	final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

	// databinding could be used here similar to the following code:
	// dbc.bindValue(ViewerProperties.singleSelection().
	// observe(tableViewer), 
	// writableDateTimeModel, 
	// stringToLocalDateTimeUpdateStrategy, 
	// LocalDateTimeToStringUpdateStrategy)
	
	// the following used an ISelectionChangedListener instead of databinding as this 
	// results in shorter code
	tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				String string = (String) ((IStructuredSelection) selection).getFirstElement();

				// parse string from table with the DateTimeFormatter from above
				LocalDateTime localDateTime = LocalDateTime.parse(string, dateTimeFormatter);
				// set the selected localDateTime to the WritableValue,
				// which is bound to the DateTime widget
				writableDateTimeModel.setValue(localDateTime);
			}
		}
	});
}
