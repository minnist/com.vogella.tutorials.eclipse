package com.example.e4.rcp.todo.parts;

// NOTE: the import statements have been removed from
// this example

public class TodoDeletionPart {
	
	@Inject
	private ITodoService todoService;
	
	private ComboViewer viewer;

	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		viewer = new ComboViewer(parent, SWT.READ_ONLY);
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				Todo todo = (Todo) element;
				return todo.getSummary();
			}
		});
		viewer.setContentProvider(ArrayContentProvider.getInstance());

		todoService.getTodos(this::updateViewer);

		Button button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = viewer.getStructuredSelection();
				if (!selection.isEmpty()) {
					Todo firstElement = (Todo) selection.getFirstElement();
					todoService.deleteTodo(firstElement.getId());
					todoService.getTodos(TodoDeletionPart.this::updateViewer);
				}

			}
		});
		button.setText("Delete selected");
	}

	private void updateViewer(List<Todo> todos) {
		viewer.setInput(todos);
		if (!todos.isEmpty()) {
			viewer.setSelection(new StructuredSelection(todos.get(0)));
		}
	}

	@Focus
	public void focus() {
		viewer.getControl().setFocus();
	}
}
