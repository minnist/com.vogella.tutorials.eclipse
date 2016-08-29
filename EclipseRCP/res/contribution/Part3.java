
package de.vogella.e4.rcp.modelcontribution.parts;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Part3 {
	public final static String ID = "de.vogella.e4.rcp.modelcontribution.parts.Part3";
	@Inject
	public Part3(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Part3");
	}

}
