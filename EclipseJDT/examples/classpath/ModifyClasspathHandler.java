package de.vogella.jdt.addclasspath.handlers;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class ModifyClasspathHandler {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection)
			throws JavaModelException {
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof IJavaElement) {

			// Get the selected IJavaProject
			final IJavaElement javaElement = (IJavaElement) firstElement;

			Job job = new Job("Setting the classpath") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					IJavaProject javaProject = javaElement.getJavaProject();

					// Test the best and get the IClasspathEntry for mockito-core
					Path path = new Path(
							"/home/simon/.m2/repository/org/mockito/mockito-core/1.8.4/mockito-core-1.8.4.jar");
					IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(path, null, null);

					try {
						// add the classpath to mockito-core for the java project
						javaProject.setRawClasspath(new IClasspathEntry[] { libraryEntry }, monitor);
					} catch (JavaModelException e) {
						Bundle bundle = FrameworkUtil.getBundle(getClass());
						return new Status(Status.ERROR, bundle.getSymbolicName(),
								"Could not set classpath to Java project: " + javaProject.getElementName(), e);
					}
					return Status.OK_STATUS;
				}
			};

			job.schedule();
		}
	}

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		return selection.getFirstElement() instanceof IJavaElement;
	}

}
