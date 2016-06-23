public class SamplePart {
	
	@Inject
	private Adapter adapter;
	
	public IResource getResource(Object element) {
		return adapter.adapt(element, IResource.class);
	}
}