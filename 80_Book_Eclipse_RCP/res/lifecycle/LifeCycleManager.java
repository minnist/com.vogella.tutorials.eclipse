package com.example.e4.rcp.todo.lifecycle;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import com.example.e4.rcp.todo.dialogs.PasswordDialog;

// for a extended example see
// https://bugs.eclipse.org/382224
public class LifeCycleManager {
	@PostContextCreate
	void postContextCreate() {
		final Shell shell = new Shell(SWT.SHELL_TRIM);
		PasswordDialog dialog = new PasswordDialog(shell);
		if (dialog.open()!=Window.OK){
			// close the application
			System.exit(-1);
		}
	}
}
