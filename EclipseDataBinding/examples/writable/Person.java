import org.eclipse.core.databinding.observable.value.WritableValue;

public class Person {

	private WritableValue<String> firstName = new WritableValue<>();

	private WritableValue<String> lastName = new WritableValue<>();

	/**
	 * @return the person's first name
	 * @TrackedGetter
	 */
	public String getFirstName() {
		return firstName.getValue();
	}

	/**
	 * @param firstName
	 *            The summary to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}

	/**
	 * @return Returns the description.
	 * @TrackedGetter
	 */
	public String getLastName() {
		return lastName.getValue();
	}

	/**
	 * @param lastName
	 *            The last name to set.
	 */
	public void setLastName(String lastName) {
		this.lastName.setValue(lastName);
	}
}