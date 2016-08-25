Command command = commandService.getCommand("com.example.mycommand");

// check if the command is defined
System.out.println(command.isDefined());

// activate handler, assumption: the AboutHandler() class exists already
handlerService.activateHandler("com.example.mycommand", 
		new AboutHandler());

// prepare execution of command
ParameterizedCommand cmd =
	commandService.createCommand("com.example.mycommand", null);

// check if the command can get executed
if (handlerService.canExecute(cmd)){
	// execute the command
	handlerService.executeHandler(cmd);
}


