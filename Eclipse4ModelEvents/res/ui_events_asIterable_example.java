@Inject
@Optional
public void subscribeTopicElementContainerChildren(@EventTopic
		(UIEvents.ElementContainer.TOPIC_CHILDREN) Event event) {
	Object element = event.getProperty(EventTags.ELEMENT);
	if (!(element instanceof MPartStack)) {
		return;
	}

	if (UIEvents.isADD(event)) {
		// check new value, because we check for addition and old value will
		// be null
		Iterable<?> asIterable = UIEvents.asIterable(event, EventTags.NEW_VALUE);
		for (Object object : asIterable) {
			if (object instanceof MPart) {
				MPart part = (MPart) object;
				System.out.println("Added " + part.getLabel() + " at position: "
						+ event.getProperty(EventTags.POSITION));
			}
		}
	} else if (UIEvents.isREMOVE(event)) {
		// check old value, because we check for remove and new value will
		// be null
		Iterable<?> asIterable = UIEvents.asIterable(event, EventTags.OLD_VALUE);
		for (Object object : asIterable) {
			if (object instanceof MPart) {
				MPart part = (MPart) object;
				System.out.println("Removed " + part.getLabel() + " from position: "
						+ event.getProperty(EventTags.POSITION));
			}
		}
	}
}