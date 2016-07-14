
package de.vogella.e4.rcp.first.parts;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class View1 {

	private final Composite parent;

	// e4 will inject the composite "parent" into the view
	@Inject
	public View1(Composite parent) {
		// the following is standard SWT Stuff
		this.parent = parent;
		
		final GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);
		
		createLable("Release");
		createText("E4");
		createLable("Purpose");
		createText("Doing awesome stuff");
	}

	// Standard SWT Stuff
	private void createLable(String text) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalIndent = 20;
		label.setLayoutData(gridData);
	}

	// Standard SWT Stuff
	private void createText(String text) {
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		Text textField = new Text(parent, SWT.NONE);
		textField.setText(text);
		textField.setLayoutData(gridData);
	}

}
