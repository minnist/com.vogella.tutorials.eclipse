@Inject IEventBroker broker;
...
// synchronously sending a todo
// the calling code is blocked until delivery

broker.send(MyEventConstants.TOPIC_TODO_NEW, newTodo);