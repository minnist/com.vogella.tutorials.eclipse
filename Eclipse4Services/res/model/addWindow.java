// create a new window and set its size
MWindow window = modelService.createModelElement(MWindow.class);
window.setWidth(200);
window.setHeight(300);

// add the new window to the application
application.getChildren().add(window);