
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(getViewSite());
		// This is new code
		// First we create a menu Manager
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(viewer.getTable());
		// Set the MenuManager
		viewer.getTable().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);
		// make the selection available
		getSite().setSelectionProvider(viewer);
	}
