				
package de.vogella.e4.rcp.modelcontribution.parts;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Part1 {
	@Inject
	public Part1(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Part1");
	}

}

