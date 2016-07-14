public class MyOwnClass {
	@Inject
	void setChildValue(
			@Optional @Named("key_of_child_value") @Active String value) {
		this.childValue = value;
	}
}