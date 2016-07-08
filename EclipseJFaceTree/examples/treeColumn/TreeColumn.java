// make the table header visible to see the column's text
viewer.getTree().setHeaderVisible(true);

TreeViewerColumn viewerColumn = new TreeViewerColumn(viewer, SWT.NONE);
TreeColumn column = viewerColumn.getColumn();
column.setText("Name");
column.setWidth(300);