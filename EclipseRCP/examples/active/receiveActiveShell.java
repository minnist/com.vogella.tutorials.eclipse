// tracks the active shell
@Inject
@Optional
public void receiveActiveShell(
	@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
	if (shell != null) {
		System.out.println("Active shell (Window) changed");
	}
}