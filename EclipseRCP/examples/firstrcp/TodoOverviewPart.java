
package de.vogella.e4.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TodoOverviewPart {

	@Inject
	private Logger logger;
	@Inject
	private IEclipseContext context;

	// PostConstruct ensures that the dependency injection has been finished
	// this this method is called

	private final Composite parent;

	// e4 will inject the composite "parent" into the view
	@Inject
	public TodoOverview(Composite parent) {
		// the following is standard SWT Stuff
		this.parent = parent;
	}

	@PostConstruct
	public void buildUI() {
		logger.info("Start building UI");
		final GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);
		createLable("e4 Release");
		createText("Eclipse 4.0 SDK");
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
