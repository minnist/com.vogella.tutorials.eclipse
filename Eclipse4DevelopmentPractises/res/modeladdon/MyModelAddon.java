
package com.example.e4.rcp.todo.addons;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;

public class MyModelAddon {
	@PostConstruct
	public void init(IEclipseContext context) {
		// inject IEclipseContext comes from the application
		context.set("test1", "Hello");
	}
}
