@Inject
@Optional
public void subscribeTopicPartActivation(@UIEventTopic(UIEvents.UILifeCycle.ACTIVATE) Event event) {
	
	Object element = event.getProperty(EventTags.ELEMENT);
	if (!(element instanceof MPart)) {
		return;
	}
	
	MPart part = (MPart) element;
	
	System.out.println("Part activated: " + part.getLabel());
}