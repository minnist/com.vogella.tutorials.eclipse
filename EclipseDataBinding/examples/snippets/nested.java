IObservable model = PojoProperties.value(Person.class, 
		"address.country").observe(person);