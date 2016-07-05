package com.vogella.rcp.css.custom.css;

import org.eclipse.e4.ui.css.core.dom.IElementProvider;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.w3c.dom.Element;

import com.vogella.rcp.css.custom.widget.UserProfileWidget;

public class UserProfileWidgetElementProvider implements IElementProvider {

	@Override
	public Element getElement(Object element, CSSEngine engine) {
		if(element instanceof UserProfileWidget) {
			return new UserProfileElementAdapter((UserProfileWidget) element, engine);
		}
		
		return null;
	}

}
