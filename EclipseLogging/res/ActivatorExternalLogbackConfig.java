private void configureLogbackExternal() throws JoranException, IOException {
	LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
	JoranConfigurator jc = new JoranConfigurator();
	jc.setContext(context);
	context.reset();

	// overriding the log directory property programmatically
	String logDirProperty = // ... get alternative log directory location
	context.putProperty("LOG_DIR", logDirProperty);

	// get the configuration location where the logback.xml is located
	Location configurationLocation = Platform.getConfigurationLocation();
	jc.doConfigure(configurationLocation.getURL().getPath() + "/logback.xml");
}

