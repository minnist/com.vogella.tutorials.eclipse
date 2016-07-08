@Inject
public void setTodo( @Optional 
		@Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
	// remember todo as field
	this.todo = java.util.Optional.ofNullable(todo);
	// update the user interface
	updateUserInterface(this.todo);
}