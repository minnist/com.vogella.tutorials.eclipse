Button button =  new Button(shell, SWT.PUSH);

//register listener for the selection event
button.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent e) {
        System.out.println("Called!");
    }
});