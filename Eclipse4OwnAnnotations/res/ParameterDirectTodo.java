// more code

// add this to one of your parts
@Inject
public void setTodo(@DirectTodo(id=1) java.util.Optional<Todo> todo) {
	// Printing the received t to the console
	todo.ifPresent(t-> System.out.println(t.getSummary()));
}