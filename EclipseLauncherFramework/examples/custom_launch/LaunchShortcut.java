public class LaunchShortcut implements ILaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		System.out.println("Selection: " + mode);
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		System.out.println("Editor: " + mode);
	}

}