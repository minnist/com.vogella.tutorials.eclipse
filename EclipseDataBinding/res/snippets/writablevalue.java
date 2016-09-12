	
WritableValue value = new WritableValue();

// create the binding
DataBindingContext ctx = new DataBindingContext();
IObservableValue target = WidgetProperties.
	text(SWT.Modify).observe(text);
IObservableValue model = BeanProperties.value("firstName").
		observeDetail(value);

ctx.bindValue(target, model);
		
// create a Person object called p
Person p = new Person();

// make the binding valid for this new object
value.setValue(p);
