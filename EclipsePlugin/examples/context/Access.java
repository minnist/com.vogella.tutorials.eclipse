// the following example assumes you are in a handler

// get context from active window
IEclipseContext windowCtx = 
	(IEclipseContext) 
		HandlerUtil.getActiveWorkbenchWindow(event).
			getService(IEclipseContext.class);

// get context from active part
IEclipseContext ctx = 
	(IEclipseContext) HandlerUtil.getActivePart(event).
		getSite().getService(IEclipseContext.class);