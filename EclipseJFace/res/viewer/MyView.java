
// the following code is executed by the method which
// creates the user interface
// assumes parent is an SWT Composite

GridLayout layout = new GridLayout(2, false);
parent.setLayout(layout);


Label label = new Label(parent, SWT.NONE);
label.setText("Select a person:");
final ComboViewer viewer = new ComboViewer(parent, SWT.READ_ONLY);

// the ArrayContentProvider object does not store any state,
// therefore, you can re-use instances

viewer.setContentProvider(ArrayContentProvider.getInstance());
viewer.setLabelProvider(new LabelProvider() {
	@Override
	public String getText(Object element) {
		if (element instanceof Person) {
			Person person = (Person) element;
			return person.getFirstName();
		}
		return super.getText(element);
	}
});

Person[] persons = new Person[] { new Person("Lars", "Vogel"),
	new Person("Tim", "Taler"), new Person("Jim", "Knopf") };

// set the input of the Viewer,
// this input is send to the content provider

viewer.setInput(persons);

// note: the order of setContentProvider and setInput is important

