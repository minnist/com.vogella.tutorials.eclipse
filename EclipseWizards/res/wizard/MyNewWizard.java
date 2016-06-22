package de.vogella.rcp.intro.wizards.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class MyWizard extends Wizard implements INewWizard {

	// ...
	// other MyWizard code
	// ...
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// initialize wizard with workbench and the current selection
		
	}
}
