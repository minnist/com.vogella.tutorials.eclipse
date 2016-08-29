
button.addSelectionListener(new SelectionAdapter() {
	@Override
	public void widgetSelected(SelectionEvent e) {
		IHandlerService handlerService = (IHandlerService) getSite()
			.getService(IHandlerService.class);
		try {
			handlerService.executeCommand("add.command", null);
			} catch (Exception ex) {
					throw new RuntimeException("add.command not found");
			}
		}
	});
