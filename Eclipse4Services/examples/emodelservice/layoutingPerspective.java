@Execute
public void execute(EModelService service, MWindow window) {
	MPartSashContainer find = (MPartSashContainer) service.
		find("mypartsashcontainer", window);
	List<MPartSashContainerElement> list = find.getChildren();

	int i = 0;
	// make the first part in the container larger
	for (MPartSashContainerElement element : list) {
		
		if (i > 0) {
			element.setContainerData("20");
		} else {
			element.setContainerData("80");
		}
		i++;
	}
}