
public class Activator implements BundleActivator {
	// ...
	public void start(BundleContext context) throws Exception {
		context.
		  registerService(
		     IMyService.class.getName(), 
		     new ServiceImpl(), null
		     );

	}
	// ...
}