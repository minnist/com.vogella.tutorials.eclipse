// get UISynchronize injected as field
@Inject UISynchronize sync;


// more code....

// replace the existing button implementation with 
// the following code

btnLoadData = new Button(parent, SWT.PUSH);
btnLoadData.addSelectionListener(new SelectionAdapter() {
	@Override
	public void widgetSelected(SelectionEvent e) {
		Job job = new Job("loading") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// assumes you get todoService (ITodoService) injected 
				todoService.getTodos(todos -> {
					sync.asyncExec(() -> updateViewer(todos));
				});
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
});

btnLoadData.setText("Load Data");

public void updateViewer(List<Todo> list) {
	if (viewer != null) {
		// if you use databinding for the viewer
		writableList.clear();
		writableList.addAll(list);
		// in case you skipped the data binding exercise
		// use the following
		// viewer.setInput(list);
	}
}

