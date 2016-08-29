

// From a view you get the site which allow to get the service
IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
try {
	handlerService.executeCommand("add.command", null);
	} catch (Exception ex) {
		throw new RuntimeException("add.command not found");
		// Give message
		}
}
