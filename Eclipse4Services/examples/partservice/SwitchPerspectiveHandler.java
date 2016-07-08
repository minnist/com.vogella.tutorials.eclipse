package com.example.e4.rcp.todo.handlers;

import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class SwitchPerspectiveHandler {
	@Execute
	public void execute(MApplication app, EPartService partService, 
			EModelService modelService) {
		MPerspective element = 
				(MPerspective) modelService.find("secondperspective", app);
		// now switch perspective
		partService.switchPerspective(element);
	}
}
