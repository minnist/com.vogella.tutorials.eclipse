@Inject
@Optional
private void subscribeTopicTagsChanged(@UIEventTopic
		(UIEvents.ApplicationElement.TOPIC_TAGS) Event event) {

	Object changedObj = event.getProperty(EventTags.ELEMENT);

	// this should only be applied to MToolbar elements
	if (!(changedObj instanceof MToolBar)) {
		return;
	}

	final MUIElement changedElement = (MUIElement) changedObj;

	// In case tags have been added and the new tag list contains the 
	// IPresentationEngine.HIDDEN_EXPLICITLY String, the element should be hidden
	if (UIEvents.isADD(event)) {
		if (UIEvents.contains(event, UIEvents.EventTags.NEW_VALUE, 
				IPresentationEngine.HIDDEN_EXPLICITLY)) {
			changedElement.setVisible(false);
			changedElement.setToBeRendered(false);
		}
	// If IPresentationEngine.HIDDEN_EXPLICITLY tag was removed the element should be visible again 
	} else if (UIEvents.isREMOVE(event)) {
		if (UIEvents.contains(event, UIEvents.EventTags.OLD_VALUE, 
				IPresentationEngine.HIDDEN_EXPLICITLY)) {
			changedElement.setVisible(true);
			changedElement.setToBeRendered(true);
		}
	}
}