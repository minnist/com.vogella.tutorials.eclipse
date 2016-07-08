package com.example.e4.rcp.todo.services.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;

import com.example.e4.rcp.todo.model.ITodoService;

public class TodoServiceContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		
		// create instance of ITodoService with dependency injection
		ITodoService todoService = 
				ContextInjectionFactory.make(MyTodoServiceImpl.class, context);
		
		// add instance of ITodoService to context so that
		// test next caller gets the same instance
		MApplication app = context.get(MApplication.class);
		IEclipseContext appCtx = app.getContext();
		appCtx.set(ITodoService.class, todoService);
		
		// in case the ITodoService is also needed in the OSGi layer, e.g.
		// by other OSGi services, register the instance also in the OSGi service layer
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		bundleContext.registerService(ITodoService.class, service, null);

		// return model for current invocation 
		// next invocation uses object from application context
		return todoService;
	}
}
