
Bundle bundle = FrameworkUtil.getBundle(this.getClass());
URL url = FileLocator.find(bundle, 
	new Path("path_to_file"), null);
