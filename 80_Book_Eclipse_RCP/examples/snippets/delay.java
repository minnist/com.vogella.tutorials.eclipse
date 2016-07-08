@Override
public void getTodos(Consumer<List<Todo>> todosConsumer) {
	// Simulate Server access delay
	try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	// always return a new copy of the data
	todosConsumer.accept(model.stream().map(t -> t.copy()).collect(Collectors.toList()));
}
