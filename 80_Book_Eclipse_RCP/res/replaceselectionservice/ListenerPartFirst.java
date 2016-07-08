package com.vogella.e4.selectionservice.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ListenerPart {

	private Label labelSelection;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		labelSelection = new Label(parent, SWT.NONE);
		labelSelection.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		labelSelection.setText("Initial test");
	}

	@Inject
	@Optional
	public void setSelection(
			@Named(IServiceConstants.ACTIVE_SELECTION) String selection) {
		if (labelSelection != null && !labelSelection.isDisposed()) {
			labelSelection.setText(selection);
		}
	}

}