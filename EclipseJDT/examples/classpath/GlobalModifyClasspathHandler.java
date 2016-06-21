
package de.vogella.jdt.addclasspath.handlers;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.e4.core.di.annotations.Execute;

public class GlobalModifyClasspathHandler {

	private static final String JDT_NATURE = "org.eclipse.jdt.core.javanature";
	
	@Execute
	public void execute() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		// Get all projects in the workspace
		IProject[] projects = root.getProjects();
		// Loop over all projects
		for (IProject project : projects) {
			try {
				// only work on open projects with the Java nature
				if (project.isOpen() && project.isNatureEnabled(JDT_NATURE)) {
					changeClassPath(project);
				}
			} catch (CoreException e) {
				e.printStackTrace(); 
			}
		}
	}
	
	private void changeClasspath(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] entries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[entries.length + 1];

		System.arraycopy(entries, 0, newEntries, 0, entries.length);

		// add a new entry using the path to the container
		Path junitPath = new Path(
				"org.eclipse.jdt.junit.JUNIT_CONTAINER/4");
		IClasspathEntry junitEntry = JavaCore
				.newContainerEntry(junitPath);
		newEntries[entries.length] = JavaCore
				.newContainerEntry(junitEntry.getPath());
		javaProject.setRawClasspath(newEntries, null);
	}
	
	
}
