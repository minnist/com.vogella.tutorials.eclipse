package com.example.e4.rcp.todo.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class OpenPartHandler {

	// the following code assumes that 
	// the "com.example.e4.rcp.todo.partdescriptor.fileeditor" ID
	// is used for the part descriptor
	@Execute
	public void execute(EPartService partService) {
		
		// create a new part based on a part descriptor
		// if multiple parts of this type are allowed a new part
		// is always generated
		
		MPart part = partService
				.createPart("com.example.e4.rcp.todo.partdescriptor.fileeditor");
		part.setLabel("New Dynamic Part");
		
		 // the provided part is be shown
		partService.showPart(part, PartState.ACTIVATE);
	}
}
