TableViewerColumn colHelloAndIcon = new TableViewerColumn(viewer, SWT.NONE);
colHelloAndIcon.getColumn().setText("Column 1");
colHelloAndIcon.getColumn().setWidth(200);


// ICON is an Image 
colHelloAndIcon.setLabelProvider(new OwnerDrawLabelProvider() {
			@Override
			protected void measure(Event event, Object element) {
				Rectangle rectangle = ICON.getBounds();
				event.
				setBounds(new Rectangle(
						event.x, 
						event.y, 
						rectangle.width + 200 , 
						rectangle.height));
			}

			@Override
			protected void paint(Event event, Object element) {
				Rectangle bounds = event.getBounds();
				event.gc.drawText("Hello", bounds.x, bounds.y);
				Point point = event.gc.stringExtent("Hello");
				event.gc.drawImage(ICON, bounds.x + 5 + point.x, bounds.y);
			}
			
		});