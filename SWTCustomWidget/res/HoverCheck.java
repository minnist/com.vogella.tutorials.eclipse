package com.vogella.rcp.custom.widgets.widget.listener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class HoverCheck implements Listener, DisposeListener {

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);

	private Control containerWidget;
	private Point widgetCoords;
	private Point widgetSize;

	private boolean hovering;

	public HoverCheck(Control containerWidget, Point widgetCoords,
			Point widgetSize) {
		assert (containerWidget != null);
		this.containerWidget = containerWidget;
		this.widgetCoords = widgetCoords;
		this.widgetSize = widgetSize;
		containerWidget.addDisposeListener(this);
		containerWidget.addListener(SWT.MouseMove, this);
	}

	@Override
	public void handleEvent(Event event) {
		switch (event.type) {
		case SWT.MouseMove:
			Rectangle targetBounds = containerWidget.getBounds();

			// just override the original size of the Rectangle, because the
			// getBounds() method always creates a new Rectangle instance every
			// time it gets called.
			targetBounds.x += widgetCoords.x;
			targetBounds.y += widgetCoords.y;
			targetBounds.width = widgetSize.x;
			targetBounds.height = widgetSize.y;

			if (targetBounds.contains(event.x, event.y)) {
				if (!isHovering()) {
					setHovering(true);
				}
			} else {
				if (isHovering()) {
					setHovering(false);
				}
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void widgetDisposed(DisposeEvent e) {
		if (containerWidget != null && !containerWidget.isDisposed()) {
			containerWidget.removeListener(SWT.MouseMove, this);
		}
	}

	public void addHoverListener(PropertyChangeListener hoverChangeListener) {
		changeSupport
				.addPropertyChangeListener("hovering", hoverChangeListener);
	}

	public void removeHoverListener(PropertyChangeListener hoverChangeListener) {
		changeSupport.removePropertyChangeListener("hovering",
				hoverChangeListener);
	}

	public boolean isHovering() {
		return hovering;
	}

	protected void setHovering(boolean hovering) {
		changeSupport.firePropertyChange("hovering", isHovering(),
				this.hovering = hovering);
	}
}
