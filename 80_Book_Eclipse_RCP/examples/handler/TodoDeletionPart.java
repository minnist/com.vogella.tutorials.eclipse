package com.example.e4.rcp.todo.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.example.e4.rcp.todo.model.ITodoService;
import com.example.e4.rcp.todo.model.Todo;

public class TodoDeletionPart {
	
	@Inject
	private ITodoService todoService;

	@Inject
	ESelectionService selectionService;

	@Inject
	EHandlerService handlerService;
	
	@Inject
	ECommandService commandService;
	
	@Inject
	IEclipseContext ctx;

	private ComboViewer viewer;

	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		viewer = new ComboViewer(parent, SWT.READ_ONLY | SWT.DROP_DOWN);
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				Todo todo = (Todo) element;
				return todo.getSummary();
			}
		});
		viewer.setContentProvider(ArrayContentProvider.getInstance());

		todoService.getTodos(this::updateViewer);

		Button button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = viewer.getStructuredSelection();
				if (!selection.isEmpty()) {
					selectionService.setSelection(selection.getFirstElement());
					
					// ensure that "com.example.e4.rcp.todo.command.remove" is 
					// the command ID which deletes Todo objects
					ParameterizedCommand cmd = 
							commandService.
							createCommand(
							"com.example.e4.rcp.todo.command.remove", 
							null);
					
					handlerService.executeHandler(cmd, ctx);
					
					// update the viewer and remove the selection
					todoService.getTodos(TodoOverviewPart.this::updateViewer);
					selectionService.setSelection(null);
				}

			}
		});
		button.setText("Delete selected");
	}

	private void updateViewer(List<Todo> todos) {
		viewer.setInput(todos);
		if (todos.isEmpty()) {
			viewer.setSelection(new StructuredSelection(todos.get(0)));
		}
	}

	@Focus
	public void focus() {
		viewer.getCombo().setFocus();
	}
}
