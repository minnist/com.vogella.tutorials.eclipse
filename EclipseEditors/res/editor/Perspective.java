import org.eclipse.ui.IPageLayout;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		//layout.setEditorAreaVisible(false);
		layout.setFixed(true);
	}

}
