@Persist
public void save(MDirtyable dirty, ITodoService todoService) {
	// save changes via ITodoService for example
	todoService.saveTodo(todo);
	// save was successful
	dirty.setDirty(false);
}