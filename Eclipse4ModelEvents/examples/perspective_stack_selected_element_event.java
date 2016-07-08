@Inject
@Optional
public void subscribeTopicSelectedElement(@EventTopic
		(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT) Event event) {
	Object element = event.getProperty(EventTags.ELEMENT);
	Object newValue = event.getProperty(EventTags.NEW_VALUE);
	// ensure that the selected element of a perspective stack is changed and that this is a perspective
	if (!(element instanceof MPerspectiveStack) || !(newValue instanceof MPerspective)) {
		return;
	}

	MPerspectiveStack perspectiveStack = (MPerspectiveStack) element;
	MPerspective perspective = (MPerspective) newValue;

	System.out.println("Selected perspective of " + perspectiveStack + " is " + perspective.getLabel());
}