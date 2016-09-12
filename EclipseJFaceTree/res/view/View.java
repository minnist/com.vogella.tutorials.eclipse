package de.vogella.jface.treeviewer;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.vogella.jface.treeviewer.model.TodoMockModel;
import de.vogella.jface.treeviewer.provider.TodoContentProvider;
import de.vogella.jface.treeviewer.provider.TodoLabelProvider;

public class View {
	public static final String ID = "de.vogella.jface.treeviewer.view";
	private TreeViewer viewer;

	@PostConstruct
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new TodoContentProvider());
		viewer.setLabelProvider(new TodoLabelProvider());
		// Expand the tree
		viewer.setAutoExpandLevel(2);
		// provide the input to the ContentProvider
		viewer.setInput(new TodoMockModel());

		// add a doubleclicklistener
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				TreeViewer viewer = (TreeViewer) event.getViewer();
				IStructuredSelection thisSelection = (IStructuredSelection) event
						.getSelection();
				Object selectedNode = thisSelection.getFirstElement();
				viewer.setExpandedState(selectedNode,
						!viewer.getExpandedState(selectedNode));
			}
		});

		viewer.getTree().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					final IStructuredSelection selection = viewer
							.getStructuredSelection();
					if (selection.getFirstElement() instanceof Todo) {
						Todo o = (Todo) selection.getFirstElement();
						// TODO Delete the selected element from the model
					}

				}
			}
		});

	}

	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}