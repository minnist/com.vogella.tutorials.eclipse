public class VogellaDelegatingValueProperty extends DelegatingValueProperty {

	public VogellaDelegatingValueProperty() {
		this(null);
	}

	public VogellaDelegatingValueProperty(Object valueType) {
		super(valueType);
	}

	@Override
	protected IValueProperty doGetDelegate(Object source) {
		// return appropriate IValueProperty according to the given source,
		// which is passed, when the observe method is called
		if(source instanceof CustomWidget) {
			return new CustomWidgetProperty();
		}else if (source instanceof DateTime) {
			return new DateTimeSelectionProperty();
		}
		
		return null;
	}
}
