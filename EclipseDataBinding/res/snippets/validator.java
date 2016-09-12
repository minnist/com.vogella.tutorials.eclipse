import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.ValidationStatus;

// converter as before
IConverter convertToStringArray = IConverter.create(String.class, String[].class,
		(o1) -> ((String) o1).split(","));

// ensure perl is not accepted as programming language
UpdateValueStrategy updateStrategy = UpdateValueStrategy.create(convertToStringArray);
updateStrategy.setAfterGetValidator((o1) -> {
	String s = (String) o1;
	if (!s.contains("Perl")) {
		return ValidationStatus.ok();
	}
	return ValidationStatus.error("Perl is not a programming language");

});

Binding bindValue = 
	ctx.bindValue(widgetValue, modelValue, updateStrategy, null);