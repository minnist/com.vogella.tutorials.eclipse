@Inject
public void setTodo(@Optional 
		@Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
	if (todo != null) {
		// do something with the value
	}
}
