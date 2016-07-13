
package addactiontoview.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

import addactiontoview.views.SampleView;

public class PrintAction implements IViewActionDelegate {
	SampleView myView;

	public void init(IViewPart view) {
		this.myView = (SampleView) view;
	}

	@Override
	public void run(IAction action) {
		MessageDialog
				.openInformation(myView.getViewSite().getShell(),
						"Information",
						"Very well, you did it, you did add an action to this view. You are my hero!");

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
