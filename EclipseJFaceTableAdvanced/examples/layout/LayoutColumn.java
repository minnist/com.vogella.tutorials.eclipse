
// fixed size
tableColumnLayout.
	setColumnData(colFirstName.getColumn(), 
			new ColumnPixelData(50));

// alternatively use relative size
// last parameter defines if the column is allowed 
// to be resized
tableColumnLayout.
	setColumnData(colFirstName.getColumn(), 
			new ColumnWeightData(20, 200, true));
