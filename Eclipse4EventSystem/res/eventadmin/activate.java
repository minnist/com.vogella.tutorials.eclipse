
@Inject
@Optional
public void partActivation(
	@UIEventTopic(UIEvents.UILifeCycle.ACTIVATE) 
	Event event) {
	// do something
	System.out.println("Got Part");
}