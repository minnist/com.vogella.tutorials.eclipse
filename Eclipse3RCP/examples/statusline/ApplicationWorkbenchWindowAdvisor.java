
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
    //...
    @Override
    public void preWindowOpen() {
    	// ....
        configurer.setShowStatusLine(false);
    }
}
