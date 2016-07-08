package com.vogella.rcp.custom.widgets.widget.gameboy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.vogella.rcp.custom.widgets.widget.listener.HoverCheck;

public class GameboyWidget extends Canvas {

	private ResourceManager resourceManager;

	private Collection<GameboySelectionListener> gameboySelectionListeners = new ArrayList<GameboySelectionListener>();

	private HoverCheck buttonAHoverCheck;
	private HoverCheck buttonBHoverCheck;

	private Image gameBoyImage;

	public GameboyWidget(Composite parent, int style) {
		super(parent, style);
		resourceManager = new LocalResourceManager(
				JFaceResources.getResources(), this);

		Point purpleButtonsSize = new Point(40, 40);
		setupButtonHoverChecks(purpleButtonsSize);

		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				paint(e);
			}
		});

		addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (buttonAHoverCheck.isHovering()) {
					System.out.println("Button A was clicked");
					fireGameboySelectionChanged(new GameboySelectionEvent(this,
							GameboySelectionEvent.BUTTON_A));
				} else if (buttonBHoverCheck.isHovering()) {
					System.out.println("Button B was clicked");
					fireGameboySelectionChanged(new GameboySelectionEvent(this,
							GameboySelectionEvent.BUTTON_B));
				}
			}
		});
	}

	private void setupButtonHoverChecks(Point buttonsSize) {
		buttonAHoverCheck = new HoverCheck(this, new Point(266, 330),
				buttonsSize);
		buttonAHoverCheck.addHoverListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (Boolean.TRUE.equals(evt.getNewValue())) {
					GameboyWidget.this.setCursor(getDisplay().getSystemCursor(
							SWT.CURSOR_HAND));
				} else {
					GameboyWidget.this.setCursor(null);
				}
			}
		});

		buttonBHoverCheck = new HoverCheck(this, new Point(211, 353),
				buttonsSize);
		buttonBHoverCheck.addHoverListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (Boolean.TRUE.equals(evt.getNewValue())) {
					GameboyWidget.this.setCursor(getDisplay().getSystemCursor(
							SWT.CURSOR_HAND));
				} else {
					GameboyWidget.this.setCursor(null);
				}
			}
		});
	}

	protected void paint(PaintEvent e) {
		GC gc = e.gc;
		Bundle bundle = FrameworkUtil.getBundle(getClass());
		URL imgUrl = FileLocator.find(bundle, new Path("images/gameboy.jpg"),
				null);
		ImageDescriptor imgDescriptor = ImageDescriptor.createFromURL(imgUrl);
		gameBoyImage = resourceManager.createImage(imgDescriptor);
		gc.drawImage(gameBoyImage, 10, 10);
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		Rectangle bounds = gameBoyImage.getBounds();

		// Just return the size of the Gameboy image
		return new Point(bounds.width, bounds.height);
	}

	public void addGameboySelectionListener(
			GameboySelectionListener selectionListener) {
		gameboySelectionListeners.add(selectionListener);
	}

	public void removeGameboySelectionListener(
			GameboySelectionListener selectionListener) {
		gameboySelectionListeners.remove(selectionListener);
	}

	protected void fireGameboySelectionChanged(
			GameboySelectionEvent selectionEvent) {
		for (GameboySelectionListener gameboySelectionListener : gameboySelectionListeners) {
			gameboySelectionListener.gameboyButtonSelected(selectionEvent);
		}
	}
}
