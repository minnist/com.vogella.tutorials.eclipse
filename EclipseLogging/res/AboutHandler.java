package com.vogella.logging.rcp.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AboutHandler {

	private static final Logger LOG = LoggerFactory.getLogger(AboutHandler.class);

	@Execute
	public void execute(Shell shell) {
		LOG.debug("Executing about handler");
		MessageDialog.openInformation(shell, "About", "Eclipse 4 RCP Application");
	}
}
