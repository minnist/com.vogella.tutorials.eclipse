
package de.vogella.rcp.intro.editor;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.vogella.rcp.intro.editor.model.MyModel;
import de.vogella.rcp.intro.editor.provider.MyContentProvider;
import de.vogella.rcp.intro.editor.provider.MyLabelProvider;

public class View extends ViewPart {
	public static final String ID = "de.vogella.rcp.intro.editor.view";

	private TableViewer viewer;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		viewer.setContentProvider(new MyContentProvider(viewer));
		viewer.setLabelProvider(new MyLabelProvider());
		viewer.setInput(new MyModel());
		getSite().setSelectionProvider(viewer);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}