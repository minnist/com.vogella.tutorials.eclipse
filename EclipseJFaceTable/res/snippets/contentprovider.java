
// this code is placed after the definition of 
// the viewer

// set the content provider
viewer.setContentProvider(ArrayContentProvider.getInstance());

// provide the input to the viewer
// setInput() calls getElements() on the 
// content provider instance
viewer.setInput(someData...);