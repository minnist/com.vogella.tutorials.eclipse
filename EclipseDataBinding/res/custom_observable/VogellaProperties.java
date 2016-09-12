package com.vogella.operationhistory.databinding;

import org.eclipse.core.databinding.property.value.IValueProperty;

public class VogellaProperties {

	private VogellaProperties() {
	}

	public static IValueProperty vogellaProperty() {
		// return a vogella property, which can handle different vogella
		// properties
		return new VogellaDelegatingValueProperty();
	}
}
