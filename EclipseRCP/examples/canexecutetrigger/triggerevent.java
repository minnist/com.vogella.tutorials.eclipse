// evaluate all @CanExecute methods
eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);

// evaluate a context via a selector 
Selector s = (a selector that an MApplicationElement or an ID);
eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, s);

//See  https://bugs.eclipse.org/bugs/show_bug.cgi?id=427465 for details 