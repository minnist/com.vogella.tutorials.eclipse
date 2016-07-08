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

public class MessagesRegistryExamplePartWithJava8 {
	
	@PostConstruct
	public void postConstruct(Composite parent, MessagesRegistry messagesRegistry) {
		// create the UI
		Label myLabel = new Label(parent, SWT.NONE);
		// Let the MessagesRegistry apply the correct label
		messagesRegistry.register(myLabel::setText, m -> m.labelSummary);
	}
}
