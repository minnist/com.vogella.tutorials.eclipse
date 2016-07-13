
package savetest;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    private IWorkbenchAction saveAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	saveAction = ActionFactory.SAVE.create(window);
    	register(saveAction);
    	
    
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
    	fileMenu.add(saveAction);
    	menuBar.add(fileMenu);
    }
    
}
