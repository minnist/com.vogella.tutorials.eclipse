
package de.vogella.e4.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.vogella.e4.todo.model.Category;
import de.vogella.e4.todo.model.ITodoService;
import de.vogella.e4.todo.model.Todo;
import de.vogella.e4.todo.provider.TodoContentProvider;

public class TodoOverview {

	@Inject
	ESelectionService selectionService;
	@Inject
	private Logger logger;
	@Inject
	private ITodoService todoService;
	@Inject
	private EPartService service;
	

	// PostConstruct ensures that the dependency injection has been finished
	// this method is called

	private final Composite parent;
	private TreeViewer viewer;
	private MPart findPart;

	// e4 will inject the composite "parent" into the view
	@Inject
	public TodoOverview(Composite parent) {
		this.parent = parent;
	}

	@PostConstruct
	public void buildUi() {
		 findPart = service.findPart("de.vogella.e4.tododetails");
		
		
		logger.info("Start building UI");

		final GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		createLable("Number of Categories:");
		createText(String.valueOf(todoService.getCategories().size()));

		viewer = new TreeViewer(parent);
		viewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Category) {
					Category category = (Category) element;
					return category.getName();
				}
				return ((Todo) element).getSummary();
			}
		});

		viewer.setContentProvider(new TodoContentProvider());
		viewer.setInput(todoService);
		viewer.setAutoExpandLevel(2);
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		viewer.getControl().setLayoutData(gridData);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				
				IStructuredSelection selection = viewer.getStructuredSelection();
				Object firstElement = selection.getFirstElement();
				if (firstElement instanceof Category) {
					service.hidePart(findPart);
				} else {
					service.showPart(findPart, PartState.VISIBLE);
				}
				selectionService.setSelection(selection.getFirstElement());
			}
		});
		

	}

	// Standard SWT Stuff
	private void createLable(String text) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalIndent = 20;
		label.setLayoutData(gridData);
	}

	// Standard SWT Stuff
	private void createText(String text) {
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		Text textField = new Text(parent, SWT.NONE);
		textField.setText(text);
		textField.setLayoutData(gridData);
	}


}
