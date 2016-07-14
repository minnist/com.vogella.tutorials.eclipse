package com.example.e4.rcp.todo.handlers;

// import statements cut out
// ..

public class ExitHandler {
	@Execute
	public void execute(IWorkbench workbench) {
		workbench.close();
	}

	// NOT REQUIRED IN THIS EXAMPLE
	// just to demonstrates the usage of
	// the annotation
	@CanExecute
	public boolean canExecute() {
		return true;
	}

}