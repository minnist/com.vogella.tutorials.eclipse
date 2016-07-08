
// create the decoration for the text UI component
final ControlDecoration deco = 
 new ControlDecoration(text, SWT.TOP | SWT.RIGHT);

// re-use an existing image
Image image = FieldDecorationRegistry.
	getDefault().
	getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).
	getImage();
// set description and image
deco.setDescriptionText("This is a tooltip text");
deco.setImage(image);
// hide deco if not in focus
deco.setShowOnlyOnFocus(true);