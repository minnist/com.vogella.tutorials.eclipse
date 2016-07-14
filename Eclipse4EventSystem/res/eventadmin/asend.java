@Inject IEventBroker broker;

...
// asynchronously
broker.post(MyEventConstants.TOPIC_TODO_NEW, 
		new Event(MyEventConstants.TOPIC_TODO_NEW, 
				new HashMap<String, String>());