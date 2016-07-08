@Override
public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {

	// do launch and anything else...

	// ... and add a certain IDebugTarget in case the debug mode is used
	if (ILaunchManager.DEBUG_MODE.equals(mode)) {
		IDebugTarget target = // instanciate custom IDebugTarget
		launch.addDebugTarget(target);
	}
}