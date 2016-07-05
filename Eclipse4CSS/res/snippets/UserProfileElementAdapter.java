package com.vogella.rcp.css.custom.css;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.swt.dom.CompositeElement;

import com.vogella.rcp.css.custom.widget.UserProfileWidget;

public class UserProfileElementAdapter extends CompositeElement {

	public UserProfileElementAdapter(UserProfileWidget composite, CSSEngine engine) {
		super(composite, engine);
	}
}
