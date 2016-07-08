
package de.vogella.e4.todo.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.e4.ui.workbench.IWorkbench;


public class ThemeSwitchHandler {
	@Execute
	public void switchTheme(IThemeEngine engine) {
		engine.setTheme("de.vogella.e4.todo.redtheme", true);
	}
}
