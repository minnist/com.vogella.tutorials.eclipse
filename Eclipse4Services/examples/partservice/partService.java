@Inject private EPartService partService;

// search part with ID "com.example.todo.rcp.parts.tododetails"
// assume that a part with this ID exists
detailsTodoPart = partService.findPart("com.example.todo.rcp.parts.tododetails");

// hide the part
partService.hidePart(detailsTodoPart);

//show the part
detailsTodoPart.setVisible(true); // required if initial not visible
partService.showPart(detailsTodoPart, PartState.VISIBLE);
	