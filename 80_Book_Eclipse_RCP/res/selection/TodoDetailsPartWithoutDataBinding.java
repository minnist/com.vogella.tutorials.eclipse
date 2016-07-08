package com.example.e4.rcp.todo.parts;

//more imports 
import org.eclipse.e4.ui.services.IServiceConstants;
//more imports

// more code
// ....
// ....

// define a new field
private java.util.Optional<Todo> todo;

// more code
// ....
// ....

@PostConstruct
public void createControls(Composite parent) {
	// ... existing code for creating user interface
	// more code 
	// ....
	// ....
	// NEW! NEW ! NEW ! Add this at the end of the method
	// disable the user interface in case 
	// the Todo object is not set
	updateUserInterface(todo);
}

@Inject
public void setTodo( @Optional 
		@Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
	// remember todo as field
	this.todo = java.util.Optional.ofNullable(todo);
	// update the user interface
	updateUserInterface(this.todo);
}

// allows to disable/ enable the user interface fields
// if no todo is set
private void enableUserInterface(boolean enabled) {
	if (txtSummary != null && !txtSummary.isDisposed()) {
		txtSummary.setEnabled(enabled);
		txtDescription.setEnabled(enabled);
		dateTime.setEnabled(enabled);
		btnDone.setEnabled(enabled);
	}
}

private void updateUserInterface(java.util.Optional<Todo> todo) {
	// check if Todo is present
	if (todo.isPresent()) {
		enableUserInterface(true);
		// the following check ensures that the user interface is available,
		// it assumes that you have a text widget called "txtSummary"
		if (txtSummary != null && !txtSummary.isDisposed()) {
			enableUserInterface(true);
			txtSummary.setText(todo.get().getSummary());
			// more code to fill the widgets with data from your Todo object
			// more code
			// ....
			// ....
		}
	} else {
		enableUserInterface(false);
	}
}
