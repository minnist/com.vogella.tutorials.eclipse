package de.vogella.plugin.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import de.vogella.plugin.adapter.model.Todo;

public class TodoAdapterFactory implements IAdapterFactory {

	// use a static final field so that the adapterList is only instanciated once
	private static final Class<?>[] adapterList = new Class<?>[] { IPropertySource.class };

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adapterType== IPropertySource.class && adaptableObject instanceof Todo){
			return adapterType.cast(new TodoPropertySource((Todo) adaptableObject));
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapterList;
	}

}
