public class UKPlugConnectorAdapterFactory implements IAdapterFactory {

	public static final Class<?>[] adapterList = new Class[] { UKPlugConnector.class };

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (UKPlugConnector.class.equals(adapterType) && 
				adaptableObject instanceof GermanPlugConnector) {
			return adapterType.cast(new GermanToUKAdapter((GermanPlugConnector) adaptableObject));
		} else if (SwissPlugConnector.class.equals(adapterType) 
				&& adaptableObject instanceof GermanPlugConnector) {
			return adapterType.cast(new GermanToSwissAdapter((GermanPlugConnector) adaptableObject));
		} else if (adapterType != null && adapterType.isInstance(adaptableObject)) {
			return adapterType.cast(adaptableObject);
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return adapterList;
	}

}