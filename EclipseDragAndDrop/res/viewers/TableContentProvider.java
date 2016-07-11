
package com.vogella.dnd.jface.viewers;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.vogella.dnd.jface.model.Todo;

public class TableContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		List<Todo> list = (List<Todo>) inputElement;
		return list.toArray();
	}

}
