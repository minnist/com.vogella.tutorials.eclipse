IObservableValue<String> lastName = // ...
IObservableValue<String> firstName = // ...

IObservableValue<String> formattedName = ComputedValue.create(() -> {
	// since lastName and firstName are tracked getter (see JavaDoc of
	// getValue() mehtod) the value of this ComputedValue gets recomputed once
	// lastName or firstName are changed
	String lastNameValue = lastName.getValue();
	String firstNameValue = firstName.getValue();
	lastNameValue = (lastNameValue != null && lastNameValue.isEmpty()) ? "[Last Name]" : lastNameValue;
	firstNameValue = (firstNameValue != null && firstNameValue.isEmpty()) ? "[First Name]" : firstNameValue;

	return lastNameValue + "," + firstNameValue;
});