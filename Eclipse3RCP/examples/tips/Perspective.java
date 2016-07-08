
package errrortest;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.addStandaloneView("org.eclipse.pde.runtime.LogView", false,
				IPageLayout.LEFT, 0.25f, editorArea);
	}
}
