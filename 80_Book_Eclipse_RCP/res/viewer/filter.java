// TableViewer must be a field
private TableViewer viewer;

// define this new field
protected String searchString="";


@PostConstruct
public void createControls(Composite parent) {

// EXISTING CODE TO BUILD THE UPDATE BUTTON
// ...
// ...	
	
Text search = new Text(parent, SWT.SEARCH | SWT.CANCEL
		| SWT.ICON_SEARCH );

// assuming that GridLayout is used
search.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
		1, 1));
search.setMessage("Filter");

// filter at every keystroke
search.addModifyListener(new ModifyListener() {
	@Override
	public void modifyText(ModifyEvent e) {
		Text source = (Text) e.getSource();
		searchString = source.getText();
		// trigger update in the viewer
		viewer.refresh();
	}
});

// SWT.SEARCH | SWT.CANCEL is not supported under Windows7 and
// so the following SelectionListener will not work under Windows7
search.addSelectionListener(new SelectionAdapter() {
	public void widgetDefaultSelected(SelectionEvent e) {
		if (e.detail == SWT.CANCEL) {
			Text text = (Text) e.getSource();
			text.setText("");
			//
		}
	}
});

// EXISTING CODE WHICH DEFINES THE VIEWER.....
// ...
// ...
// ...

// add a filter which will search in the summary and description field
viewer.addFilter(new ViewerFilter() {
	@Override
	public boolean select(Viewer viewer, Object parentElement,
		Object element) {
		Todo todo = (Todo) element;
		return todo.getSummary().contains(searchString)
				|| todo.getDescription().contains(searchString);
		}
});