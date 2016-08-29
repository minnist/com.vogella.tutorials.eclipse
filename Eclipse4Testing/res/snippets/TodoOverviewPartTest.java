
package com.example.e4.rcp.todo.parts;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TodoOverviewPartTest {
	public static void main(String... main) {
		Display display = new Display();
		Shell shell = new Shell(display);
		TodoOverviewPart part = new TodoOverviewPart();
		part.createControls(shell);
		shell.open();
		// create and check the event loop
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}
}