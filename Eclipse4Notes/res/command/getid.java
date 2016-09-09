
@Execute
public void execute(MHandledItem item) {
  MCommand command = item.getCommand();
  // Prints out the commmand ID
  System.out.println(command.getElementId());
}

