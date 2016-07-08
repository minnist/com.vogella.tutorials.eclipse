// NOTE: your variable names may be different!!!

// add modification listeners to your text fields in 
// the @PostConstruct method

// this is already in your @PostConstruct method
txtSummary = new Text(parent, SWT.BORDER);
txtSummary.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

// NEW! NEW! add a ModifyListener
txtSummary.addModifyListener(new ModifyListener() {
	@Override
	public void modifyText(ModifyEvent e) {
		if (todo!=null){
			todo.setSummary(txtSummary.getText());
		}
	
	}
});

// this is already in your @PostConstruct method
Label lblDescription = new Label(parent, SWT.NONE);
lblDescription.setText("Description");

txtDescription = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
		true, 1, 1));

//NEW! NEW! ModifyListener
txtDescription.addModifyListener(new ModifyListener() {
	@Override
	public void modifyText(ModifyEvent e) {
		if (todo!=null){
			todo.setDescription(txtDescription.getText());
		}
	}
});

// more code