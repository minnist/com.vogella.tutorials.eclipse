package com.vogella.rcp.custom.widgets.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class ComputeSizeWidget extends Composite {

	private static final int LINE_WIDTH = 30;
	private static final int LINE_HEIGHT = 2;

	public ComputeSizeWidget(Composite parent, int style) {
		super(parent, style);

		// draw a line with a width of 30 and a height of 2.
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {

		// try to consider the given hints. Here we decided to use the smallest
		// value so that the line would not be bigger than 30x2.
		// In case the SWT.DEFAULT flag for the hints is used, we simply stick to
		// the LINE_WIDTH and LINE_HEIGHT.
		int width = wHint != SWT.DEFAULT ? Math.min(wHint, LINE_WIDTH)
				: LINE_WIDTH;
		int height = hHint != SWT.DEFAULT ? Math.min(hHint, LINE_HEIGHT)
				: LINE_HEIGHT;

		return new Point(width, height);
	}
}
