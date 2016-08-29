
// Method belongs to class ApplicationActionBarAdvisor
	@Override
	protected void makeActions(IWorkbenchWindow window)
	{
		IWorkbenchAction quickStartAction = ActionFactory.INTRO.create(window);
		register(quickStartAction);
		IWorkbenchAction resetView = ActionFactory.RESET_PERSPECTIVE
				.create(window);
		register(resetView);
	}