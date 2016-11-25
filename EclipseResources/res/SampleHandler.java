package com.vogella.eclipse.resourcesapi.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class SampleHandler {

	@Execute
	public void execute() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		List<IEditorReference> editorsToBeClosed = new ArrayList<>();
		Map<IFile, IEditorReference> fileEditors = new HashMap<>();
		
		for (IEditorReference editorReference : editorReferences) {
			try {
				IEditorInput editorInput = editorReference.getEditorInput();
				if (editorInput instanceof IFileEditorInput) {
					IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
					IFile file = fileEditorInput.getFile();
					fileEditors.put(file, editorReference);
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}

		}
		activePage.closeEditors(editorReferences, true);

		// Get all projects in the workspace
		IProject[] projects = root.getProjects();
		// Loop over all projects
		for (IProject project : projects) {
			try {
				List<IFile> projectfiles = findAllProjectFiles(project);
				for (IResource resource : projectfiles) {
					if (fileEditors.containsKey(resource)) {
						editorsToBeClosed.add(fileEditors.get(resource));
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		IEditorReference[] editorToBeClosed = new IEditorReference[editorsToBeClosed.size()];
		editorToBeClosed = editorsToBeClosed.toArray(editorToBeClosed);
		activePage.closeEditors(editorToBeClosed, true);
		
		return null;
	}

	private List<IFile> findAllProjectFiles(IContainer container) throws CoreException {
		IResource[] members = container.members();
		List<IFile> list = new ArrayList<>();

		for (IResource member : members) {
			if (member instanceof IContainer) {
				IContainer c = (IContainer) member;
				list.addAll(findAllProjectFiles(c));
			} else if (member instanceof IFile) {
				list.add((IFile) member);
			}
		}
		return list;
	}

}
