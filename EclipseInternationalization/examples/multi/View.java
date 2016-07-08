
package de.vogella.rcp.i18n;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public void createPartControl(Composite parent) {
		Label label = new Label(parent, SWT.BORDER);
		label.setText("This is a hardcoded text");
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}
