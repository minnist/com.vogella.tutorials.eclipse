package com.vogella.rcp.css.custom.css;

import org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler;
import org.eclipse.e4.ui.css.core.dom.properties.converters.ICSSValueConverter;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.swt.properties.AbstractCSSPropertySWTHandler;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;
import org.w3c.dom.css.CSSValue;

import com.vogella.rcp.css.custom.widget.UserProfileWidget;

public class UserProfileCSSHandler extends AbstractCSSPropertySWTHandler implements ICSSPropertyHandler {

	private static final String HEADER_COLOR = "header-background-color";

	@Override
	protected void applyCSSProperty(Control control, String property, CSSValue value, String pseudo, CSSEngine engine)
			throws Exception {
		if (control instanceof UserProfileWidget) {
			UserProfileWidget userProfileWidget = (UserProfileWidget) control;
			if (HEADER_COLOR.equalsIgnoreCase(property) && (value.getCssValueType() == CSSValue.CSS_PRIMITIVE_VALUE)) {
				Color newColor = (Color) engine.convert(value, Color.class, control.getDisplay());
				userProfileWidget.setHeaderColor(newColor);
			}
		}
	}

	@Override
	protected String retrieveCSSProperty(Control control, String property, String pseudo, CSSEngine engine)
			throws Exception {
		if (control instanceof UserProfileWidget) {
			UserProfileWidget userProfileWidget = (UserProfileWidget) control;
			if (HEADER_COLOR.equalsIgnoreCase(property)) {
				ICSSValueConverter cssValueConverter = engine.getCSSValueConverter(String.class);
				return cssValueConverter.convert(userProfileWidget.getHeaderColor(), engine, null);
			}
		}
		return null;
	}

}
