
package de.vogella.tabletesting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import tabletesting.View;
import tabletesting.dialog.EditDialog;
import tabletesting.model.Person;

public class EditPerson extends AbstractHandler implements IHandler {

	private Viewer viewer;
	private View view;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		this.view = (View) page.findView(View.ID);
		this.viewer = this.view.getViewer();

		IStructuredSelection selection = (IStructuredSelection) view
				.getViewer().getSelection();

		List<Person> persons = new ArrayList<Person>();

		for (Iterator<Person> iterator = selection.iterator(); iterator
				.hasNext();) {
			Person person = (Person) iterator.next();
			persons.add(person);

		}
		String tempFirstName = null, tempLastName = null, tempGender = null;
		Boolean tempIsMarried = null;
		int i = 0;

		for (Person person : persons) {
			i++;
			if (i == 1) {
				tempFirstName = person.getFirstName();
				tempLastName = person.getLastName();
				tempGender = person.getGender();
				tempIsMarried = person.isMarried();
			} else {
				if (!person.getFirstName().equals(tempFirstName)) {
					tempFirstName = null;
				}
				if (!person.getLastName().equals(tempLastName)) {
					tempLastName = null;
				}
				if (tempGender != null) {
					if (!person.getGender().equals(tempGender)) {
						tempGender = null;
					}
				}
				if ((person.isMarried() ? true : false) != tempIsMarried) {
					tempIsMarried = null;
				}
			}
		}

		EditDialog dialog = new EditDialog(window.getShell());
		dialog.setPersonData(tempFirstName, tempLastName, tempGender,
				tempIsMarried);
		dialog.open();

		for (Person person : persons) {
			if (tempFirstName != null) {
				person.setFirstName(dialog.getFirstName());
			}
			if (tempLastName != null) {
				person.setLastName(dialog.getLastName());
			}
			if (tempGender != null) {
				person.setGender(dialog.getGender());
			}
			if (dialog.getIsMarried() != null) {
				if (dialog.getIsMarried()) {
					person.setMarried(true);
				} else if (!dialog.getIsMarried()) {
					person.setMarried(false);
				}
			}
		}
		this.viewer.refresh();

		return null;
	}
}
