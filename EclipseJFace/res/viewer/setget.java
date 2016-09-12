// you can select an object directly via the domain object
Person person = persons[0];
viewer.setSelection(new StructuredSelection(person));

// retrieves the selection, returns the data model object
IStructuredSelection selection = viewer.getStructuredSelection();
Person p = (Person) selection.getFirstElement();