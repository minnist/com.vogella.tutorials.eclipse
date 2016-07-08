package com.example.e4.rcp.todo.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;

import com.example.e4.rcp.todo.model.Todo;

public class OpenEditorHandler {
	@Execute
	public void execute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
		System.out.println("Will open a new editor");
		
	}
}
