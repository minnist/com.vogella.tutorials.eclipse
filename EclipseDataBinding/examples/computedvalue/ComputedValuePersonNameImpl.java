public class FormattedName extends ComputedValue {
	private IObservableValue<String> firstName;

	private IObservableValue<String> lastName;

	FormattedName(IObservableValue<String> firstName, IObservableValue<String> lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	protected Object calculate() {
		// since lastName and firstName are tracked getter (see JavaDoc of
		// getValue() mehtod) the value of this ComputedValue gets recomputed once
		// lastName or firstName are changed
		String lastName = this.lastName.getValue();
		String firstName = this.firstName.getValue();
		lastName = (lastName != null && lastName.isEmpty()) ? "[Last Name]" : lastName;
		firstName = (firstName != null && firstName.isEmpty()) ? "[First Name]" : firstName;

		return lastName + "," + firstName;
	}
}