
ServiceReference<?> serviceReference = context.
	getServiceReference(IMyService.class.getName());
IMyService service = (IMyService) context.
	getService(serviceReference);