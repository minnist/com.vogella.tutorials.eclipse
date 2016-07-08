
// set a context variable
@Inject
@Optional
public void partActivation(
	@UIEventTopic(UIEvents.UILifeCycle.ACTIVATE) 
	Event event,
	MApplication application) {
		
	// don't inject MPart and IEclipseContext! Need from root context here
	MPart activePart = (MPart) event.
			getProperty(UIEvents.EventTags.ELEMENT);
	IEclipseContext context = application.getContext();
	if (activePart != null) {
		context.set("myactivePartId", activePart.getElementId());
	}
}