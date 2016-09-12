GridLayout layout = new GridLayout(2, false);
// parent is a Composite
parent.setLayout(layout);
Label lblPleaseEnterA = new Label(parent, SWT.NONE);
lblPleaseEnterA.setText("Please enter a value:");
		
Text text = new Text(parent, SWT.BORDER);
GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
gd_text.horizontalIndent = 8;
text.setLayoutData(gd_text);
GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);

// create the decoration for the text component
final ControlDecoration deco = new ControlDecoration(text, SWT.TOP
	| SWT.LEFT);

// use an existing image
Image image = FieldDecorationRegistry.getDefault()
	.getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION)
	.getImage();

// set description and image
deco.setDescriptionText("Use CTRL + SPACE to see possible values");
deco.setImage(image);

// always show decoration
deco.setShowOnlyOnFocus(false);

// hide the decoration if the text component has content
text.addModifyListener(new ModifyListener() {
	@Override
	public void modifyText(ModifyEvent e) {
		Text text = (Text) e.getSource();
		if (!text.getText().isEmpty()) {
			 deco.hide();
		} else {
			 deco.show();
		}
			}
});

// help the user with the possible inputs
// "." and "#" activate the content proposals
char[] autoActivationCharacters = new char[] { '.', '#' };
KeyStroke keyStroke;
//
try {
	keyStroke = KeyStroke.getInstance("Ctrl+Space");
	ContentProposalAdapter adapter = new ContentProposalAdapter(text,
		new TextContentAdapter(),
		new SimpleContentProposalProvider(new String[] {
			"ProposalOne", "ProposalTwo", "ProposalThree" }),
			keyStroke, autoActivationCharacters);
		} catch (ParseException e1) {
	e1.printStackTrace();
}
