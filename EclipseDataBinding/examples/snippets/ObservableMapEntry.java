import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.WritableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.example.e4.rcp.todo.model.Todo;

public class ObservableMapEntry {

	private static final String SECOND_ATTRIBUTE = "secondAttribute";
	private static final String FIRST_ATTRIBUTE = "firstAttribute";

	private IObservableMap attributesMap = new WritableMap();
	private DataBindingContext dbc;
	private Todo todo;

	@PostConstruct
	public void createUI(Composite parent) {
		dbc = new DataBindingContext();

		Text txtFirstAttribute = new Text(parent, SWT.BORDER);
		Text txtSecondAttribute = new Text(parent, SWT.BORDER);

		// create observables for the Text controls
		ISWTObservableValue txtFirstAttributeObservable = 
				WidgetProperties.text(SWT.Modify).observe(txtFirstAttribute);
		ISWTObservableValue txtSecondAttributeObservable = WidgetProperties.text(SWT.Modify)
				.observe(txtSecondAttribute);

		// create observables for the Map entries
		IObservableValue firstAttributeObservable = 
				Observables.observeMapEntry(attributesMap, FIRST_ATTRIBUTE);
		IObservableValue secondAttributeObservable = 
				Observables.observeMapEntry(attributesMap, SECOND_ATTRIBUTE);

		dbc.bindValue(txtFirstAttributeObservable, firstAttributeObservable);
		dbc.bindValue(txtSecondAttributeObservable, secondAttributeObservable);
	}

	@Inject
	@Optional
	public void setModel(@Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
		if (todo != null) {
			this.todo = todo;
			// set new values for the map entries from a model object
			attributesMap.put(FIRST_ATTRIBUTE, todo.getSummary());
			attributesMap.put(SECOND_ATTRIBUTE, todo.getDescription());
		}
	}

	@Persist
	public void save() {
		if (todo != null) {
			// only store the actual values on save and not directly
			todo.setSummary((String) attributesMap.get(FIRST_ATTRIBUTE));
			todo.setDescription((String) attributesMap.get(SECOND_ATTRIBUTE));
		}
	}
}
