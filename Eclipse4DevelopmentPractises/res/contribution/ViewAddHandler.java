
package de.vogella.e4.rcp.modelcontribution.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.services.context.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MPartDescriptor;
import org.eclipse.e4.ui.model.application.MUIElement;
import org.eclipse.e4.ui.model.application.MWindow;
import org.eclipse.e4.workbench.modeling.EPartService;
import org.eclipse.e4.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.workbench.ui.IWorkbench;
import org.eclipse.emf.common.util.EList;

import de.vogella.e4.rcp.modelcontribution.parts.Part3;

public class ViewAddHandler {
	@Inject private IEclipseContext context; 
	@Inject private EPartService service;
	
	public void execute(IWorkbench workbench) {
//		MWindow window = (MWindow) context.get( EPartService.PART_SERVICE_ROOT );
		MWindow window =  (MWindow) context.get(MWindow.class.getName());
		MApplication app = (MApplication) (MUIElement) window.getParent();
		EList<MPartDescriptor> descriptorList = app.getDescriptors();
		for( MPartDescriptor partDesc: descriptorList  ){
			System.out.println(partDesc.getId());
			if( partDesc.getId().equals( Part3.ID ) ){
				service.showPart( partDesc.getId(), PartState.ACTIVATE );
		               break;
		        }
		}
	}
}


