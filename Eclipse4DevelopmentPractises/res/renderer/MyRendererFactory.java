
package de.vogella.e4.renderer.maps;

import org.eclipse.e4.ui.internal.workbench.swt.AbstractPartRenderer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.renderers.swt.ContributedPartRenderer;
import org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory;

import extension.ExtensionFactory;
import extension.MyMap;
import extension.MyPart;


public class MyRendererFactory extends WorkbenchRendererFactory {

	private MyMapRenderer mapRenderer;
	private ContributedPartRenderer partRenderer;
	
	@Override
	public AbstractPartRenderer getRenderer(MUIElement uiElement, Object parent) {
		
		if (uiElement instanceof MyMap) {
			if (mapRenderer == null) {
				mapRenderer = new MyMapRenderer();
				super.initRenderer(mapRenderer);
			}
			return mapRenderer;
		}
		if(uiElement instanceof MyPart){
			if(partRenderer == null){
				partRenderer = new ContributedPartRenderer();
				super.initRenderer(partRenderer);
			}
			return partRenderer;
		}
		
		return super.getRenderer(uiElement, parent);
	}

	
}
