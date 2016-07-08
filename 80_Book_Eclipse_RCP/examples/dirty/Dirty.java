// more import statements 

// relevant databinding import statements
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.e4.core.di.annotations.Optional;

//more import statements 

// define dirty as field
@Inject MDirtyable dirtyable;

private boolean dirty;

// more code in TodoDetailsPart
// ...
// ...

@PostConstruct
public void createControls(Composite parent) {

	// more UI creation code in TodoDetailsPart
	// ...
	// ...

	bindData();

	updateUserInterface(todo);
}

private void bindData() {
	// check if the user interface is available
	// this assumes that a widget field is called "summary"
	if (txtSummary != null && !txtSummary.isDisposed()) {

		ISideEffectFactory sideEffectFactory = WidgetSideEffects.createFactory(txtSummary);

		IObservableValue<String> target = WidgetProperties.text(SWT.Modify).observe(txtSummary);
		IObservableValue<String> observeSummary = PojoProperties.value(Todo.FIELD_SUMMARY).observeDetail(observableTodo);
		
		sideEffectFactory.create(observeSummary::getValue, target::setValue);
		sideEffectFactory.create(target::getValue, summary -> {
			observeSummary.setValue(summary);
			if (dirtyable!=null) {
				dirtyable.setDirty(dirty);
			}
		});

		target = WidgetProperties.text(SWT.Modify).observe(txtDescription);
		IObservableValue<String> observeDescription = PojoProperties.value(Todo.FIELD_DESCRIPTION).observeDetail(observableTodo);
		sideEffectFactory.create(observeDescription::getValue, target::setValue);
		sideEffectFactory.create(target::getValue, description -> {
			observeDescription.setValue(description);
			if (dirtyable!=null) {
				dirtyable.setDirty(dirty);
			}
		});

		IObservableValue<Boolean> booleanTarget = WidgetProperties.selection().observe(btnDone);
		IObservableValue<Boolean> observeDone = PojoProperties.value(Todo.FIELD_DONE).observeDetail(observableTodo);
		sideEffectFactory.create(observeDone::getValue, booleanTarget::setValue);
		sideEffectFactory.create(booleanTarget::getValue, done -> {
			observeDone.setValue(done);
			if (dirtyable!=null) {
				dirtyable.setDirty(dirty);
			}
		});

		IObservableValue<Date> observeSelectionDateTimeObserveWidget = WidgetProperties.selection()
				.observe(dateTime);
		IObservableValue<Date> observeDueDate = PojoProperties.value(Todo.FIELD_DUEDATE).observeDetail(observableTodo);
		sideEffectFactory.create(observeDueDate::getValue, date -> {
			if(date != null) {
				observeSelectionDateTimeObserveWidget.setValue(date);
			}
		});
		sideEffectFactory.create(observeSelectionDateTimeObserveWidget::getValue, dueDate -> {
			observeDueDate.setValue(dueDate);
			if (dirtyable!=null) {
				dirtyable.setDirty(dirty);
			}
		});
	}
}

//UPDATED METHOD
private void updateUserInterface(java.util.Optional<Todo> todo) {

	// check if Todo is present
	if (todo.isPresent()) {
		enableUserInterface(true);
	} else {
		enableUserInterface(false);
		return;
	}

	// Check if the user interface is available
	// this assumes that a widget field is called "summary"
	if (txtSummary != null && !txtSummary.isDisposed()) {
		CompositeSideEffect compositeSideEffect = (CompositeSideEffect) txtSummary
				.getData(CompositeSideEffect.class.getName());
		compositeSideEffect.pause();
		dirty = false;
		this.observableTodo.setValue(todo.get());
		compositeSideEffect.resumeAndRunIfDirty();
		dirty = true;
	}
}

}