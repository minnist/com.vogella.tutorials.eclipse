public class CustomWidget extends Canvas {
	
	private String text;
	private Point textExtent;

	public CustomWidget(Composite parent) {
		super(parent, SWT.NONE);
		addPaintListener(new PaintListener() {
			

			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				
				// draw the text, which can be set
				String textValue = getText() != null ? getText() : "Good Default";
				gc.drawText(textValue, 5, 5);
				textExtent = gc.textExtent(textValue);
			}
		});
	}
	
	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		checkWidget();
		return textExtent != null ? textExtent : new Point(30, 12);
	}

	public String getText() {
		checkWidget();
		return text;
	}

	public void setText(String text) {
		checkWidget();
		this.text = text;
		redraw();
	}

}
