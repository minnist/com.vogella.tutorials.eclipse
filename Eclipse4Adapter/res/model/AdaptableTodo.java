package com.vogella.rcp.editor.example.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class Todo implements IAdaptable {
	private String summary = "";
	private String description = "";

	public Todo(String summary) {
		this.summary = summary;
	}

	public Todo(String summary, String description) {
		this.summary = summary;
		this.description = description;

	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Todo: " + summary;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (IWorkbenchAdapter.class.equals(adapter)) {
			return adapter.cast(new IWorkbenchAdapter() {

				@Override
				public Object getParent(Object o) {
					// no parent, we intent to use a TableViewer
					return null;
				}

				@Override
				public String getLabel(Object o) { #<1>
					if (o instanceof Todo) {
						return ((Todo) o).getSummary();
					}
					return null;
				}

				@Override
				public ImageDescriptor getImageDescriptor(Object object) {
					// no need for an image now
					return null;
				}

				@Override
				public Object[] getChildren(Object o) {
					// no children, we intent to use a TableViewer
					return null;
				}
			});
		}
		return null;
	}
}
