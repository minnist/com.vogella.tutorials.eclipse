// assume we have Todo domain objects
// todos is a of type: List<Todo>
final ComboViewer viewer = new ComboViewer(parent, SWT.DROP_DOWN);
viewer.setContentProvider(ArrayContentProvider.getInstance());
viewer.setLabelProvider(new LabelProvider() {
	public String getText(Object element) {
		Todo todo = (Todo) element;
		return todo.getSummary();
	};
});
viewer.setInput(todos);

// create a Label to map to
Label label = new Label(parent, SWT.BORDER);
// parent has a GridLayout assigned
label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));


DataBindingContext dbc = new DataBindingContext();

// for binding to the label
IObservableValue target = WidgetProperties.text().observe(label);

// observe the selection
IViewerObservableValue selectedTodo = ViewerProperties
		.singleSelection().observe(viewer);
// observe the summary attribute of the selection
IObservableValue detailValue = 
	PojoProperties
		.value("summary", String.class)
		.observeDetail(selectedTodo)

dbc.bindValue(target, detailValue);