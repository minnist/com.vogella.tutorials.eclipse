String yourKey ="key1";

// modelObject is the model object 
// retrieved via dependency injection (e.g. a MPart)

// get the state by the yourKey key
String state = modelObject.getPersistedState().get(yourKey);

// store the state
modelObject.getPersistedState().put(yourKey, state)