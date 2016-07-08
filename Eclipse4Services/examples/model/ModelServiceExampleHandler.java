package de.vogella.e4.modelservice.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.widgets.Display;


public class ModelServiceExampleHandler {
	
	@Execute
	public void execute(MApplication application, EModelService service, Display display) {
		System.out.println("Got Model Service: " + (service != null));
		// alternatively get the model service from the application
		EModelService modelService = (EModelService) application.getContext()
				.get(EModelService.class.getName());
		// both services are identical
		System.out.println("Got Model Service: " + (service != modelService));
		// find objects by ID
		List<MPart> findElements = service.findElements(application, "mypart",
				MPart.class, null);
		System.out.println("Found part(s) : " + findElements.size());
		// find objects by type
		List<MPart> parts = service.findElements(application, null,
				MPart.class, null);
		System.out.println("Found parts(s) : " + parts.size());
		// find objects by tags
		List<String> tags = new ArrayList<String>();
		tags.add("justatag");
		List<MUIElement> elementsWithTags = modelService.findElements(application, null,
				null, tags);
		System.out.println("Found parts(s) : " + elementsWithTags.size());
		// get the MWindow and change its size
		List<MWindow> windows = modelService.findElements(application, null, MWindow.class,
				 null);
		if (windows.size()>=1){
			 MWindow mWindow = windows.get(0);
			 System.out.println("Got the window");
			for (int i = mWindow.getWidth(); i >= mWindow.getWidth() - 100; i--) {
				while (!display.readAndDispatch()){
					mWindow.setWidth(i);
					wait10();
				}
			}
		}
	}
	private void wait10(){
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
