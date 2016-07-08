
package de.vogella.e4.todo.provider;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.vogella.e4.todo.model.Category;
import de.vogella.e4.todo.model.ITodoService;

public class TodoContentProvider implements ITreeContentProvider {

	private ITodoService todoService;

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.todoService = (ITodoService) newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return todoService.getCategories().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Category category = (Category) parentElement;
		return category.getTodos().toArray();
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Category) {
			return true;
			
		}
		return false;
	}

}

		