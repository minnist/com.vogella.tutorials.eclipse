public class CustomWidgetProperty extends WidgetValueProperty {

	@Override
	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue(Object source) {
		if(source instanceof CustomWidget) {
			return ((CustomWidget) source).getText();
		}
		
		return "";
	}

	@Override
	protected void doSetValue(Object source, Object value) {
		if(source instanceof CustomWidget && value instanceof String) {
			((CustomWidget) source).setText((String) value);
		}
	}
}
