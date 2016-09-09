				
package de.vogella.e4.rcp.modelcontribution.parts;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Part2 {
	@Inject
	public Part2(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Part2");
	}

}

