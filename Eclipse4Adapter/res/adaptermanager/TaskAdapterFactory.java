package com.vogella.ide.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

import com.vogella.ide.adapter.model.Task;

public class TaskAdapterFactory2 implements IAdapterFactory {

	// make the adapterList a static constant, so that it is only created once
	private static final Class<?>[] adapterList = new Class<?>[] { IWorkbenchAdapter.class };

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adaptableObject instanceof Task) {
			if (IWorkbenchAdapter.class.equals(adapterType)) {
				return adapterType.cast(new IWorkbenchAdapter() {
					
					@Override
					public Object getParent(Object o) {
						// no parent, we intent to use a TableViewer
						return null;
					}

					@Override
					public String getLabel(Object o) {
						if (o instanceof Task) {
							return ((Task) o).getSummary();
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
		}

		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapterList;
	}

}
