// tracks the active part
@Inject
@Optional
public void receiveActivePart(
	@Named(IServiceConstants.ACTIVE_PART) MPart activePart) {
	if (activePart != null) {
		System.out.println("Active part changed "
				+ activePart.getLabel());
	}
}