
// create new Context
DataBindingContext ctx = new DataBindingContext();

// define the IObservables
IObservableValue target = WidgetProperties.text(SWT.Modify).
	observe(firstName);
IObservableValue model= BeanProperties.
	value(Person.class,"firstName").observe(person);

// connect them
ctx.bindValue(target, model);
