@Inject IEventBroker broker;

...
// asynchronously
broker.post(MyEventConstants.TOPIC_TODO_NEW, todo);