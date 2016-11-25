public class ShowPreferenceValues {

	@Execute
	public Object execute(Shell shell) {
		String myPrefString = Activator.getDefault().getPreferenceStore()
				.getString("MySTRING1");
		MessageDialog.openInformation(shell, "Info", myPrefString);
		Boolean myPrefBoolean = Activator.getDefault().getPreferenceStore()
				.getBoolean("BOOLEAN_VALUE");
		// RadioGroupFieldEditor can get access
		String choice = Activator.getDefault().getPreferenceStore().getString("CHOICE");
		System.out.println(choice);
		MessageDialog.openInformation(shell, "Info", myPrefBoolean.toString());
		// I assume you get the rest by yourself
	}

}
