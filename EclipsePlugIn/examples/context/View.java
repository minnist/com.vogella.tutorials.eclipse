// get the context of a part
IEclipseContext partContext = 
	(IEclipseContext) getViewSite().getService(IEclipseContext.class);

// or access directly a value in the context based on its key
EModelService service = 
	(EModelService) getViewSite().getService(EModelService.class);