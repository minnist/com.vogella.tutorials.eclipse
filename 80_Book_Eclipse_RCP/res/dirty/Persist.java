// dirty already injected as field 

@Persist
public void save(ITodoService todoService) {
	todoService.saveTodo(todo);
	dirtyable.setDirty(false);
}