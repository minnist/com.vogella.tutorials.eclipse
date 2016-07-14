private static final String UPDATE ="update";

// get the IEventBroker injected
@Inject
IEventBroker broker;

// somewhere in you code you do something 
// performance intensive

button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Runnable runnable = new Runnable() {
					public void run() {
						for (int i = 0; i < 10; i++) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// send out an event to update
							// the UI
							broker.send(UPDATE, i);
						}
					}
				};
				new Thread(runnable).start();
			}
		});



// more code
// ....


// get notified and sync automatically
// with the UI thread

@Inject @Optional
public void  getEvent(@UIEventTopic(UPDATE) int i) {
	// text1 is a SWT Text field
	text1.setText(String.valueOf(i));
	System.out.println(i);
}