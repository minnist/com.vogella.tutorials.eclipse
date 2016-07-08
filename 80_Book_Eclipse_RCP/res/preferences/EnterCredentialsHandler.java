package com.example.e4.rcp.todo.handlers;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

import com.example.e4.rcp.todo.dialogs.PasswordDialog;

public class EnterCredentialsHandler {

	@Inject
	@Preference(nodePath = PreferenceConstants.NODEPATH, 
				value = PreferenceConstants.USER_PREF_KEY)
	String userPref;

	@Execute
	public void execute(Shell shell, @Preference IEclipsePreferences prefs) {
		PasswordDialog dialog = new PasswordDialog(shell);

		if (userPref != null) {
			dialog.setUser(userPref);
		}


		// get the new values from the dialog
		if (dialog.open() == Window.OK) {
			prefs.put(PreferenceConstants.USER_PREF_KEY, dialog.getUser());
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				e.printStackTrace();
			}
		}
	}

}
