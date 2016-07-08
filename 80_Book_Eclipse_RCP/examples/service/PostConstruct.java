@PostConstruct
public void createControls(Composite parent, ITodoService todoService) {
	todoService.getTodos(todos -> {
		System.out.println("Number of Todo objects " + todos.size());
	});
}