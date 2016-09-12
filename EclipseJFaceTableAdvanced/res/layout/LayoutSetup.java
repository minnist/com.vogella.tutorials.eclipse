Composite tableComposite = new Composite(parent, SWT.NONE);
TableColumnLayout tableColumnLayout = new TableColumnLayout();
tableComposite.setLayout(tableColumnLayout);
TableViewer viewer = 
	new TableViewer(tableComposite, 
			SWT.MULTI | 
			SWT.H_SCROLL | 
			SWT.V_SCROLL | 
			SWT.FULL_SELECTION | 
			SWT.BORDER);
