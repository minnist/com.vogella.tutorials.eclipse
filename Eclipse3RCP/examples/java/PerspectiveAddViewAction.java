
package addactiontoview;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import addactiontoview.views.SampleView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.addView(SampleView.ID, IPageLayout.LEFT, 0.60f, editorArea);

	}
}
