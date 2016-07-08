package com.example.e4.rcp.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.dialogs.filteredtree.FilteredTree;
import org.eclipse.e4.ui.dialogs.filteredtree.PatternFilter;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.example.e4.rcp.todo.model.ITodoService;
import com.example.e4.rcp.todo.model.Tag;
import com.example.e4.rcp.todo.model.Todo;

public class TagOverviewPart {

	@Inject
	private ITodoService todoService;

	private FilteredTree filteredTree;

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Button button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// update the tree content, whenever the button is pressed
				filteredTree.getViewer().setInput(todoService.getRootTag());
			}
		});
		button.setText("Load Data");

		filteredTree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER,
				new PatternFilter());
		filteredTree.getViewer().getTree().setHeaderVisible(true);

		filteredTree.getViewer().setContentProvider(new TagTreeContentProvider());

		TreeViewerColumn labelViewerColumn = new TreeViewerColumn(filteredTree.getViewer(), SWT.NONE);
		labelViewerColumn.getColumn().setWidth(200);
		labelViewerColumn.getColumn().setText("Label");
		labelViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Todo) {
					return ((Todo) element).getSummary();
				}
				return ((Tag<?>) element).getLabel();
			}
		});

		TreeViewerColumn descriptionViewerColumn = new TreeViewerColumn(filteredTree.getViewer(), SWT.NONE);
		descriptionViewerColumn.getColumn().setWidth(200);
		descriptionViewerColumn.getColumn().setText("Description");
		descriptionViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Todo) {
					return ((Todo) element).getDescription();
				}
				// Tag object do not have a description
				return super.getText(element);
			}
		});

		filteredTree.getViewer().setInput(todoService.getRootTag());
	}

	private class TagTreeContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Tag) {
				return ((Tag<?>) parentElement).getTaggedElements().toArray();
			}

			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return (element instanceof Tag) && (!(((Tag<?>) element).getTaggedElements().isEmpty()));
		}
	}

}