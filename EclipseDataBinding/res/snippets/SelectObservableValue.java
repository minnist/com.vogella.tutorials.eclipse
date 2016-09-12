Group group = new Group(shell, SWT.NONE);
group.setText("Radio Group with Names");
GridLayoutFactory.fillDefaults().applyTo(group);
GridDataFactory.fillDefaults().grab(true, true).applyTo(group);

// Options for the radio buttons
String[] names = new String[] { "Matthew Hall", "Dirk Fauth", "Lars Vogel",
		"Simon Scholz" };

SelectObservableValue selectedRadioButtonObservable = new SelectObservableValue();
for (String name : names) {
	Button button = new Button(group, SWT.RADIO);
	button.setText(name);
	// Add name as option value in case the appropriate button is selected
	selectedRadioButtonObservable.addOption("Selected: " + name, WidgetProperties.selection().observe(button));
}

Label label = new Label(shell, SWT.NONE);
GridDataFactory.fillDefaults().applyTo(label);
ISWTObservableValue labelTextObservable = WidgetProperties.text().observe(label);

DataBindingContext dbc = new DataBindingContext();
// bind label text to currently selected option
dbc.bindValue(selectedRadioButtonObservable, labelTextObservable);