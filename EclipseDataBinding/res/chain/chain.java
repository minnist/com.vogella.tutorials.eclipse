IListProperty siblingNames = BeanProperties.
	value("parent").list("children").values("name");
IObservableList siblingNamesObservable = 
	siblingNames.observe(node);
