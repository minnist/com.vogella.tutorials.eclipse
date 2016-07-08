public class SampleTab extends AbstractLaunchConfigurationTab {

	private Text text;

	@Override
	public void createControl(Composite parent) {
		
		Composite comp = new Group(parent, SWT.BORDER);
		setControl(comp);
		
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(comp);

		Label label = new Label(comp, SWT.NONE);
		label.setText("Console Text:");
		GridDataFactory.swtDefaults().applyTo(label);

		text = new Text(comp, SWT.BORDER);
		text.setMessage("Console Text");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			String consoleText = configuration.getAttribute(VogellaLaunchConfigurationAttributes.CONSOLE_TEXT,
					"Simon says \"RUN!\"");
			text.setText(consoleText);
		} catch (CoreException e) {
			// ignore here
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// set the text value for the CONSOLE_TEXT key
		configuration.setAttribute(VogellaLaunchConfigurationAttributes.CONSOLE_TEXT, text.getText());
	}

	@Override
	public String getName() {
		return "Vogella sample launch tab";
	}

}
