
MyTitleAreaDialog dialog = new MyTitleAreaDialog(shell);
dialog.create();
if (dialog.open() == Window.OK) {
	System.out.println(dialog.getFirstName());
	System.out.println(dialog.getLastName());
}
