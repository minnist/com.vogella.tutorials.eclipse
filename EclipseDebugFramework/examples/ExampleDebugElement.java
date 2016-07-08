import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public abstract class ExampleDebugElement extends DebugElement {
	
	public ExampleDebugElement(IDebugTarget target) {
		super(target);
	}

	@Override
	public String getModelIdentifier() {
		return Activator.PLUGIN_ID;
	}
}
