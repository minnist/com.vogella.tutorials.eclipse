
// use ObservableListContentProvider
viewer.setContentProvider(new ObservableListContentProvider());

// create sample data
List<Person> persons = createExampleData();

// wrap the input into a writable list
IObservableList input = 
   Properties.selfList(Person.class).observe(persons);

// set the IObservableList as input for the viewer
viewer.setInput(input);