package com.example.e4.rcp.todo.lifecycle;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

import com.example.e4.rcp.todo.dialogs.PasswordDialog;
import com.example.e4.rcp.todo.preferences.PreferenceConstants;

public class Manager {

	// example uses the optional nodePath parameter
	// allows to move the handler to another plug-in
	@Inject
	@Preference(nodePath = PreferenceConstants.NODEPATH, 
				value = PreferenceConstants.USER_PREF_KEY)
	private String user;

	@PostContextCreate
	public void postContextCreate(@Preference IEclipsePreferences prefs,
			IApplicationContext appContext, Display display) {

		final Shell shell = new Shell(SWT.SHELL_TRIM);
		PasswordDialog dialog = new PasswordDialog(shell);
		if (user != null) {
			dialog.setUser(user);
		}

		// close the static splash screen
		appContext.applicationRunning();

		// position the shell
		 setLocation(display, shell);
		
		// open the dialog
		if (dialog.open() != Window.OK) {
			// close the application
			System.exit(-1);
		} else {
			// get the user from the dialog
			String userValue = dialog.getUser();
			// store the user values in the preferences
			prefs.put(PreferenceConstants.USER_PREF_KEY, userValue );
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void setLocation(Display display, Shell shell) {
		Monitor monitor = display.getPrimaryMonitor();
		Rectangle monitorRect = monitor.getBounds();
		Rectangle shellRect = shell.getBounds();
		int x = monitorRect.x + (monitorRect.width - shellRect.width) / 2;
		int y = monitorRect.y + (monitorRect.height - shellRect.height) / 2;
		shell.setLocation(x, y);
	}
}