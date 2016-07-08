package com.vogella.e4.selectionservice.addon;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;

import com.vogella.e4.selectionservice.service.MyContextFunction;
import com.vogella.e4.selectionservice.service.MySelectionService;

public class ReplaceSelectionService {

	@PostConstruct
	public void replace(MApplication app) {
		System.out.println("Model add-on called");
		IEclipseContext appContext = app.getContext();
		appContext.set(MySelectionService.class.getName(),
				new MyContextFunction());
	}

}
