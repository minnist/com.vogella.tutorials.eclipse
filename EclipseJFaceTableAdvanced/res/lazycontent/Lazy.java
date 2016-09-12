// create your table with the virtual flag
final TableViewer v = new TableViewer(shell, SWT.VIRTUAL);

// create TableColumns with label providers as before...
// ...

v.setContentProvider(new MyLazyContentProvider(v));

// special settings for the lazy content provider
v.setUseHashlookup(true);

// create the model and set it as input
Person[] model = createModel();
v.setInput(model);
// you must explicitly set the items count
v.setItemCount(model.length);
