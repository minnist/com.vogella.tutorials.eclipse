public class ResourceUsingLabelProvider extends LabelProvider {

    private ResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

    @Override
    public Image getImage(Object element) {
        if (element instanceof Task) {
            Bundle bundle = FrameworkUtil.getBundle(this.getClass());
            // use the org.eclipse.core.runtime.Path as import
            URL url = FileLocator.find(bundle, new Path("icons/task.png"), null);
            ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);

            // return the image being created by the resourceManager
            return resourceManager.createImage(imageDescriptor);
        }

        return super.getImage(element);
    }

    @Override
    public void dispose() {
        super.dispose();

        // dispose the ResourceManager yourself
        resourceManager.dispose();
    }
}