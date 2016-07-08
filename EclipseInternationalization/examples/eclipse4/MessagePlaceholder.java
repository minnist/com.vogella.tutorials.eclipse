public class Messages {
	public String labelWithPlaceholder1 = {0} says {1}
	public String labelWithPlaceholder2 = {0} says {1}
	
	// initialize the first message
	
	@PostConstruct
	public void format() {
		labelWithPlaceholder2 = 
				MessageFormat.
					format(labelWithPlaceholder2, "Test", "this is fun.");
	}
}