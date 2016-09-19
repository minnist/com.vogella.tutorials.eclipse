
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		// provide the input to the ContentProvider
		viewer.setInput(new String[] { "One", "Two", "Three" });
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(viewer.getControl(), "message");
	}