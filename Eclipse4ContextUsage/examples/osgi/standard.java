
public Object start() {
  // get bundle information
  Bundle bundle = FrameworkUtil.getBundle(getClass());
  BundleContext bundleContext = bundle.getBundleContext();
  IEclipseContext eclipseCtx =   
      EclipseContextFactory.getServiceContext(bundleContext);

  // fill context with information using set(String,Object)
  // ....
  
  // create instance of class
  ContextInjectionFactory.make(MyPart.class, eclipseCtx);
}
