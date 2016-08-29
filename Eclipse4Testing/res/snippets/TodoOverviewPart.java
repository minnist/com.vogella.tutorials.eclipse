
package com.example.e4.rcp.todo.parts;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class TodoOverviewPart {
	
	@PostConstruct
	public void createControls(Composite parent){
		parent.setLayout(new GridLayout(2, false));
		Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		button.setText("Load Data");
		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		label.setText("Data not available");
		
		
	}
	
	@PreDestroy
	public void dispose(){
		
	}
}
