@Inject
@Optional
public void subscribeTopicLabelChange(@EventTopic(UIEvents.UILabel.TOPIC_LABEL) Event event) {
	Object element = event.getProperty(EventTags.ATTNAME);
	
	// will print "label" to the system output
	System.out.println(element);
}