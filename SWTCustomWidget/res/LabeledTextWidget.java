package com.vogella.rcp.custom.widgets.widget;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LabeledTextWidget extends Composite {

	private Label label;
	private Text text;

	public LabeledTextWidget(Composite parent, int style) {
		this(parent, style, SWT.NONE, SWT.BORDER);
	}

	public LabeledTextWidget(Composite parent, int style, int labelStyle, int textStyle) {
		super(parent, style);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(this);

		label = new Label(this, labelStyle);
		GridDataFactory.fillDefaults().applyTo(label);

		text = new Text(this, textStyle);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(getText());
	}

	public void setLabelText(String text) {
		checkWidget();
		label.setText(text);
	}

	public Text getText() {
		checkWidget();
		return text;
	}

}
