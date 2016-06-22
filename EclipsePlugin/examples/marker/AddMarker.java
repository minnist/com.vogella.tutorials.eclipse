package de.vogella.plugin.markers.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.e4.ui.services.IServiceConstants;

public class AddMarker {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		if (selection == null) {
			return;
		}
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof IJavaProject) {
			IJavaProject type = (IJavaProject) firstElement;
			writeMarkers(type);
		}
	}

	private void writeMarkers(IJavaProject type) {
		try {
			IResource resource = type.getUnderlyingResource();
			IMarker marker = resource.createMarker(IMarker.TASK);
			marker.setAttribute(IMarker.MESSAGE, "This a a task");
			marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
