public Object start() {
  // get Bundle Information
  Bundle bundle = FrameworkUtil.getBundle(getClass());
  BundleContext bundleContext = bundle.getBundleContext();
  IEclipseContext eclipseCtx =   
      EclipseContextFactory.getServiceContext(bundleContext);

  // fill Context with information using set(String,Object)
  // ....
  
  // create instance of class
  ContextInjectionFactory.make(MyPart.class, eclipseCtx);
}
