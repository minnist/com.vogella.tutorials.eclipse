package com.example.e4.rcp.todo.parts;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.dialogs.filteredtree.FilteredTree;
import org.eclipse.e4.ui.dialogs.filteredtree.PatternFilter;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.example.e4.rcp.todo.databinding.DelegatingDescriptionProperty;
import com.example.e4.rcp.todo.databinding.DelegatingLabelProperty;
import com.example.e4.rcp.todo.databinding.DelegatingObservableCellLabelProvider;
import com.example.e4.rcp.todo.databinding.TagTreeListProperty;
import com.example.e4.rcp.todo.events.MyEventConstants;
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

		// More code
		// ...
		// ...

		filteredTree = new FilteredTree(parent,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, new PatternFilter());
		filteredTree.getViewer().getTree().setHeaderVisible(true);

		ObservableListTreeContentProvider observableContentProvider =
				new ObservableListTreeContentProvider(new TagTreeListProperty()
						.listFactory(), null);
		filteredTree.getViewer().setContentProvider(observableContentProvider);

		TreeViewerColumn labelViewerColumn = new
				TreeViewerColumn(filteredTree.getViewer(), SWT.NONE);
		labelViewerColumn.getColumn().setWidth(200);
		labelViewerColumn.getColumn().setText("Label");

		DelegatingLabelProperty labelProperty = new DelegatingLabelProperty();
		labelViewerColumn.
			setLabelProvider(new DelegatingObservableCellLabelProvider(observableContentProvider.
					getKnownElements(), labelProperty));

		TreeViewerColumn descriptionViewerColumn = new
				TreeViewerColumn(filteredTree.getViewer(), SWT.NONE);
		descriptionViewerColumn.getColumn().setWidth(200);
		descriptionViewerColumn.getColumn().setText("Description");

		DelegatingDescriptionProperty descriptionProperty =
				new DelegatingDescriptionProperty();
		descriptionViewerColumn.
			setLabelProvider(new DelegatingObservableCellLabelProvider(observableContentProvider.
					getKnownElements(), descriptionProperty));

		filteredTree.getViewer().setInput(todoService.getRootTag());
	}

}