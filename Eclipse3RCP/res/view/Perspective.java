
package de.vogella.rcp.intro.view;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView("de.vogella.rcp.intro.first.MyView", IPageLayout.TOP,
				IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
	}
}
