public class GermanPlugConnectorImpl implements GermanPlugConnector, IAdaptable {

	@Override
	public void getElectricity() {
		// pass the electricity to a device
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (UKPlugConnector.class.equals(adapter)) {
			return adapter.cast(new GermanToUKAdapter(this));
		} else if (SwissPlugConnector.class.equals(adapter)) {
			return adapter.cast(new GermanToSwissAdapter(this));
		} else if (adapter != null && adapter.isInstance(this)) {
			return this;
		}
		return null;
	}

}