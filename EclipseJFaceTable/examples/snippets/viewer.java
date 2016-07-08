// define the TableViewer
viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
			| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

// create the columns 
// not yet implemented
createColumns(viewer);

// make lines and header visible
final Table table = viewer.getTable();
table.setHeaderVisible(true);
table.setLinesVisible(true);
