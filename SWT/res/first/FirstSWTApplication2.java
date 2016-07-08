// Shell can be used as container
Label label = new Label(shell, SWT.BORDER);
label.setText("This is a label:");
label.setToolTipText("This is the tooltip of this label");

Text text = new Text(shell, SWT.NONE);
text.setText("This is the text in the text widget");
text.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
text.setForeground(display.getSystemColor(SWT.COLOR_WHITE));

// set widgets size to their preferred size
text.pack();
label.pack();

