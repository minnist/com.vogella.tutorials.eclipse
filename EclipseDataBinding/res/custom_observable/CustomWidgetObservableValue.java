public class CustomWidgetObservableValue extends AbstractObservableValue
											implements ISWTObservableValue {

	private CustomWidget customWidget;

	public CustomWidgetObservableValue(CustomWidget customWidget) {
		this(customWidget, Realm.getDefault());
	}

	public CustomWidgetObservableValue(CustomWidget customWidget ,Realm realm) {
		super(realm);
		this.customWidget = customWidget;
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		return customWidget.getText();
	}
	
	@Override
	protected void doSetValue(Object value) {
		customWidget.setText(value.toString());
	}

	@Override
	public Widget getWidget() {
		// implement the ISWTObservableValue interface to enable ControlDecorationSupport
		return customWidget;
	}
}
