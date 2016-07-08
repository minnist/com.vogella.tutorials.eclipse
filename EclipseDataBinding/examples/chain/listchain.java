IObservableValue viewerSelectionSummaryObservable = 
	ViewerProperties.singleSelection()
    .value(BeanProperties.value("summary", String.class))
    .observe(viewer);