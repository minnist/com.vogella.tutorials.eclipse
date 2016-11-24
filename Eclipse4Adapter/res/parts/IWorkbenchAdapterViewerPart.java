public void createPartControl(Composite parent) {
	
	TableViewer tableViewer = new TableViewer(parent);
	tableViewer.setContentProvider(ArrayContentProvider.getInstance());
	tableViewer.setLabelProvider(new WorkbenchLabelProvider()); #<1>
	
	getViewSite().setSelectionProvider(tableViewer);
	
	tableViewer.setInput(createTodoModel());
}

private List<Object> createTodoModel() {
	ArrayList<Object> list = new ArrayList<>();
	list.add(new Todo("First Todo", "Bla"));
	list.add(new Todo("Second Todo", "Bla bla"));
	list.add(new Todo("Third Todo", "Bla bla bla"));
	list.add(new Todo("Fourth Todo", "Bla bla bla bla"));
	return list;
}