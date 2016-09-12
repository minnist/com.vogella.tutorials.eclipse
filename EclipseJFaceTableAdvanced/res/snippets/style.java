// define column
TableViewerColumn colTesting = new TableViewerColumn(viewer, SWT.NONE);
colTesting.getColumn().setText("Testing");
colTesting.getColumn().setWidth(200);


// set label provider
colTesting.setLabelProvider(new StyledCellLabelProvider() {
	@Override
	public void update(ViewerCell cell) {
		cell.setText("This is a test (15)");
		StyleRange myStyledRange = 
				new StyleRange(16, 2, null, 
						Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
		StyleRange[] range = { myStyledRange };
		cell.setStyleRanges(range);
		super.update(cell);
	}
});