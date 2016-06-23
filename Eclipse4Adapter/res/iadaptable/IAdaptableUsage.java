GermanPlugConnector plugConnector = //.. create a GermanPlugConnector
UKElectricalSocket electricalSocket = new UKElectricalSocket();

if(plugConnector instanceof IAdaptable) {
	IAdaptable adaptable = (IAdaptable) plugConnector;
	UKPlugConnector ukAdapter = adaptable.getAdapter(UKPlugConnector.class);
	if(ukAdapter != null) {
		electricalSocket.plugIn(ukAdapter);
	}
}