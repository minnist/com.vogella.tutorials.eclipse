public class SampleLaunchConfiguration extends LaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		String attribute = configuration.getAttribute(VogellaLaunchConfigurationAttributes.CONSOLE_TEXT, "Simon says \"RUN!\"");
		System.out.println(attribute);
	}

}
