@Inject
@Optional
public void subscribeTopicElementContainerChildren(@EventTopic
		(UIEvents.ElementContainer.TOPIC_CHILDREN) Event event) {
	Object element = event.getProperty(EventTags.ELEMENT);
	if (!(element instanceof MPartStack)) {
		return;
	}

	if (UIEvents.isADD(event)) {
		// check new value, because we check for addition and old value will be null
		Object newValue = event.getProperty(EventTags.NEW_VALUE);
		if (newValue instanceof MPart) {
			MPart part = (MPart) newValue;
			System.out.println("Added " + part.getLabel() + " at position: "
					+ event.getProperty(EventTags.POSITION));
		}
	} else if (UIEvents.isREMOVE(event)) {
		// check old value, because we check for remove and new value will be null
		Object oldValue = event.getProperty(EventTags.OLD_VALUE);
		if (oldValue instanceof MPart) {
			MPart part = (MPart) oldValue;
			System.out.println("Removed " + part.getLabel() + " from position: "
					+ event.getProperty(EventTags.POSITION));
		}
	}
}