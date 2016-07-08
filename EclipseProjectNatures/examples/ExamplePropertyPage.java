import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

public class ExamplePropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

	@Override
	protected Control createContents(Composite parent) {
		
		// There will be no default, therefore remove default button
		noDefaultButton();
		
		Label label = new Label(parent, SWT.NONE);
		label.setText("PropertyPage example.");
		
		return label;
	}

}
