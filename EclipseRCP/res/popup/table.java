
package com.example.e4.rcp.todo.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TodoOverviewPart {

	@PostConstruct
	public void createControls(Composite parent, EMenuService menuService) {
		// more code...
		TableViewer viewer = new TableViewer(parent, SWT.FULLSELECTION | SWT.MULTI);
		
		// more code
		
		// register context menu on the table
		menuService.registerContextMenu(
				viewer.getControl(), 
				"com.example.e4.rcp.todo.popupmenu.table");
	}
}
