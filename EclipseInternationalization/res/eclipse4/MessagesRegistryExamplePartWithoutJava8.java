package com.example.e4.rcp.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.MessageConsumer;
import org.eclipse.e4.core.services.nls.MessageFunction;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.example.e4.rcp.todo.i18n.Messages;
import com.example.e4.rcp.todo.i18n.MessagesRegistry;

public class MessagesRegistryExamplePartWithoutJava8 {
	private Label myLabel;
	
	@PostConstruct
	public void postConstruct(Composite parent, MessagesRegistry messagesRegistry) {
		// create the UI
		myLabel = new Label(parent, SWT.NONE);
		// Let the MessagesRegistry apply the correct label
		messagesRegistry.register(new MessageConsumer() {
			
			@Override
			public void accept(String value) {
				myLabel.setText(value);
			}
		}, new MessageFunction<Messages>() {

			@Override
			public String apply(Messages m) {
				return m.labelSummary;
			}
		});
	}
}
