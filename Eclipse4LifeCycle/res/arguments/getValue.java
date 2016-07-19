private String getArgValue(String argName, IApplicationContext appContext,
			boolean singledCmdArgValue) {
	// Is it in the arg list ?
	if (argName == null || argName.length() == 0)
		return null;

	if (singledCmdArgValue) {
		for (String arg : args) {
			if (("-" + argName).equals(arg))
				return "true";
		}
		return "false";
	} 
	// not a singleCmdArgValue
	for (int i = 0; i < args.length; i++) {
		if (("-" + argName).equals(args[i]) && i + 1 < args.length)
			return args[i + 1];
	}
}
