
package savetest;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.part.ViewPart;

public class SaveView extends ViewPart implements ISaveablePart {

	protected boolean dirty= false;

	public SaveView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		Text text = new Text(parent, SWT.BORDER);
		text.setText("Hello");
		text.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				dirty = true; 
				// make sure that Eclipse knows that the view is changed.
				firePropertyChange(ISaveablePart.PROP_DIRTY);
				
			}
			
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}


	@Override
	public void doSave(IProgressMonitor monitor) {
		System.out.println("Imagine a  very complex saving here...");
		dirty= false;
		firePropertyChange(ISaveablePart.PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public boolean isSaveOnCloseNeeded() {
		return true;
	}

}
