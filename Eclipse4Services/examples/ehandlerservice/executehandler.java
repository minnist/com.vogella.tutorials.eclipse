// create parameter for the command
// optional, can be null
Map<String, String> parameters = new HashMap<String, String>();
parameters.put(Constants.SEARCH_QUERY_ID, id);

ParameterizedCommand cmd =
	commandService.createCommand("com.example.mycommand", parameters);

// execute the registered handler for the command
handlerService.executeHandler(cmd);

