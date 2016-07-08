public class TodoDetailsPart {

	private Text txtSummary;
	private Text txtDescription;
	private Button btnDone;
	private DateTime dateTime;

	private WritableValue<Todo> observableTodo = new WritableValue<>();

	@PostConstruct
	public void createControls(Composite parent) {

		// ... creation of the part's UI ...

		bindData();

		updateUserInterface(java.util.Optional.ofNullable(observableTodo.getValue()));
	}

	
	@SuppressWarnings("unchecked")
	private void bindData() {
		// check if the user interface is available
		// this assumes that a widget field is called "summary"
		if (txtSummary != null && !txtSummary.isDisposed()) {

			ISideEffectFactory sideEffectFactory = WidgetSideEffects.createFactory(txtSummary);

			IObservableValue<String> txtSummaryTarget = WidgetProperties.text(SWT.Modify).observe(txtSummary);
			IObservableValue<String> observeSummary = PojoProperties.value(Todo.FIELD_SUMMARY)
					.observeDetail(observableTodo);

			sideEffectFactory.create(observeSummary::getValue, txtSummaryTarget::setValue);
			sideEffectFactory.create(txtSummaryTarget::getValue, summary -> {
				observeSummary.setValue(summary);
			});

			IObservableValue<String> txtDescriptionTarget = WidgetProperties.text(SWT.Modify).observe(txtDescription);
			IObservableValue<String> observeDescription = PojoProperties.value(Todo.FIELD_DESCRIPTION)
					.observeDetail(observableTodo);
			sideEffectFactory.create(observeDescription::getValue, txtDescriptionTarget::setValue);
			sideEffectFactory.create(txtDescriptionTarget::getValue, description -> {
				observeDescription.setValue(description);
			});

			IObservableValue<Boolean> booleanTarget = WidgetProperties.selection().observe(btnDone);
			IObservableValue<Boolean> observeDone = PojoProperties.value(Todo.FIELD_DONE).observeDetail(observableTodo);
			sideEffectFactory.create(observeDone::getValue, booleanTarget::setValue);
			sideEffectFactory.create(booleanTarget::getValue, done -> {
				observeDone.setValue(done);
			});

			IObservableValue<Date> observeSelectionDateTimeObserveWidget = WidgetProperties.selection()
					.observe(dateTime);
			IObservableValue<Date> observeDueDate = PojoProperties.value(Todo.FIELD_DUEDATE)
					.observeDetail(observableTodo);
			sideEffectFactory.create(observeDueDate::getValue, date -> {
				if (date != null) {
					observeSelectionDateTimeObserveWidget.setValue(date);
				}
			});
			sideEffectFactory.create(observeSelectionDateTimeObserveWidget::getValue, dueDate -> {
				observeDueDate.setValue(dueDate);
			});
		}
	}

	private void updateUserInterface(java.util.Optional<Todo> todo) {

		// check if Todo is present
		if (todo.isPresent()) {
			enableUserInterface(true);
		} else {
			enableUserInterface(false);
			return;
		}

		// Check if the user interface is available
		// this assumes that a widget field is called "summary"
		if (txtSummary != null && !txtSummary.isDisposed()) {
			// update the master detail bindings
			this.observableTodo.setValue(todo.get());
		}
	}

	@Focus
	public void onFocus() {
		txtSummary.setFocus();
	}
}
