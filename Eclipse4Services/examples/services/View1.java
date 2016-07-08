
package de.vogella.e4.rcp.first.parts;

import javax.inject.Inject;

import org.eclipse.e4.core.services.Logger;
import org.eclipse.e4.core.services.annotations.PostConstruct;
import org.eclipse.e4.core.services.context.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class View1 {
	
	@Inject private Logger logger;
	@Inject private IEclipseContext context;
	@Inject private Composite parent;
	
	// PostConstruct ensures that the dependency injection has been finished 
	// this method is called 
	@PostConstruct
	public void init() {
		// If you do not inject the Logger you could alternatively 
		// get it via the IEclipseContext with the following statement
		// Logger log= (Logger) context.get(Logger.class.getName());
		System.out.println(context!=null);
		System.out.println(logger!=null);
		logger.info("UI will start to build");
		
		Label label = new Label(parent, SWT.NONE);
		label.setText("E4 is new");
		Text text = new Text(parent, SWT.NONE);
		text.setText("and different");
	}

}
