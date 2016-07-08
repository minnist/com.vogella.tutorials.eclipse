@Inject
@Optional
public void trackUserSettings(
	@Preference(value = "user") String user) {
	System.out.println("New user: " + user);
}
