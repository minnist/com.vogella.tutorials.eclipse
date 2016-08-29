
package testing;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CreateContextText {
	@Test
	public void testCreation() {
		IEclipseContext context = EclipseContextFactory.create();
		// prepare the context for the test
		context.set("myvalue1", "For testing");
		// more things, for example a LayoutManager
		MyClass test = ContextInjectionFactory.make(MyClass.class, context);
	}
}
