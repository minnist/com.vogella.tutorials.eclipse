package com.example.e4.rcp.todo.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;

public class TestHandlerWithCommandInjected {
	private String parametername = "com.example.e4.rcp.todo" + 
			".commandparameter.input";
	@Execute
	public void execute(ParameterizedCommand command) {
	  Object queryId = command.getParameterMap().get(parametername);
	  // more...
	}


}