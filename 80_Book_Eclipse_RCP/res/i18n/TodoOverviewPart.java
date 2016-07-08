@PostConstruct
public void createControls(Composite parent, 
		EMenuService menuService, @Translation Messages message) {
	
	// more source code
		
	// new 
	translateTable(message);

}

// more source code
	
@Inject
public void translateTable(@Translation Messages message){
	if (viewer !=null && !viewer.getTable().isDisposed()) {
		colSummary.getColumn().setText(message.todo_summary);
		colDescription.getColumn().setText(message.todo_description);
	}
}