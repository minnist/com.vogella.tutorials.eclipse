import java.util.Map;

// MyEventConstants.TOPIC_TODO_UPDATE is 
// a String constant

@Inject
@Optional
private void subscribeTopicTodoUpdated
	(@UIEventTopic(MyEventConstants.TOPIC_TODO_UPDATE) 
		Todo todo) {
	if (viewer!=null) {
	    // this example assumes that you do not use data binding
		todoService.getTodos(viewer::setInput);
	}
}