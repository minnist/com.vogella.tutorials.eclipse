package com.vogella.rcp.custom.widgets.widget;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class ResourceManagerCanvas extends Canvas {

	private ResourceManager resourceManager;

	public ResourceManagerCanvas(Composite parent, int style) {
		super(parent, style);
		// The LocalResourceManager attaches the DisposeHandler to the Canvas for you
		resourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
		
		// Always create colors, fonts and images with the ResourceManager instance
		Color orange = resourceManager.createColor(new RGB(255, 191, 0));
		Font boldArialFont = resourceManager.createFont(FontDescriptor.createFrom("Arial", 12, SWT.BOLD));

		// Draw your widget.....
	}

}
