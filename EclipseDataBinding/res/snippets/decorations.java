// The following code assumes that a Validator is already defined
Binding bindValue = 
  ctx.bindValue(widgetValue, modelValue, strategy, null);

// add some decorations to the control
ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);