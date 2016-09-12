// Track the validation status from all binding in the DataBindingContext
AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(dbc.getBindings(),
		AggregateValidationStatus.MAX_SEVERITY);

// Create a boolean observable, which depends on the ok status
IObservableValue<Boolean> isValidationOk = ComputedValue
		.create(() -> aggregateValidationStatus.getValue().isOK());

ISWTObservableValue buttonEnabledObservable = WidgetProperties.enabled().observe(finishButton);

// bind the enablement of the finish button to the validation
dbc.bindValue(buttonEnabledObservable, isValidationOk);