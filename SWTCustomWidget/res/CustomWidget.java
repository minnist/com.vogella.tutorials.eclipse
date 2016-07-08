package com.vogella.rcp.custom.widgets.widget;

import org.eclipse.swt.widgets.Composite;

public class CustomWidget extends Composite {

	public CustomWidget(Composite parent, int style) {
		super(parent, style);
	}

	public void callFunctionalityOfCustomWidget() {
		checkWidget();

		// do custom things with the CustomWidget
	}

}
