// customized MessageDialog with configured buttons
MessageDialog dialog = new MessageDialog(shell, "My Title", null,
    "My message", MessageDialog.ERROR, new String[] { "First",
	"Second", "Third" }, 0);
int result = dialog.open();
System.out.println(result);
