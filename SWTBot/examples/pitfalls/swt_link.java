Link link = new Link(parent, SWT.NONE);
// add the <a> tags to visualize a underlined clickable blue hyperlink
link.setText("<a>www.vogella.com</a>");
link.addSelectionListener(new SelectionAdapter() {
	@Override
	public void widgetSelected(SelectionEvent e) {
		// ... open browser and go to vogella.com
	}
});