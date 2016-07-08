package com.example.e4.rcp.todo.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class FindPerspectiveHandler {
	@Execute
	public void execute(MApplication application, EModelService service) {
		// search for a part with the following ID
		String ID = "com.example.e4.rcp.parts.tododetail";
		MUIElement element = service.find(ID, application);
		MPerspective perspective = service.getPerspectiveFor(element);
		System.out.println(perspective);
		// TODO do something useful with the perspective
	}
}