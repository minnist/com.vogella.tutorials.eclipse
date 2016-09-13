@PostConstruct
public void createControl(MPart part) {
	Map<String, String> state = part.getPersistedState();
	String value = state.get("key");
	...
}

@PersistState
public void persistState(MPart part) {
	Map<String, String> state = part.getPersistedState();
	state.put("key", "newValue");
	...
}