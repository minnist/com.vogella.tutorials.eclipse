// if person is a POJO
IObservableValue myModel = PojoProperties.value("firstName").
	observe(person)
	
// prefer using beans if your data model provides property change support	
IObservableValue myModel = BeansProperties.value("firstName").
	observe(person)