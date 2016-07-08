import java.util.Map;
// more code
// assumes that ITodoService is injected somewhere as todoService

@Inject
@Optional
private void subscribeTopicTodoAllTopics
	(@UIEventTopic(MyEventConstants.TOPIC_TODO_ALLTOPICS) Map<String, String> event) {
	if (viewer != null) {
	    // code if you use databinding for your viewer
		writableList.clear();
		todoService.getTodos(writableList::addAll);
		// if you do not use databinding, use the following snippet:
		// todoService.getTodos(viewer::setInput);
	}
}
