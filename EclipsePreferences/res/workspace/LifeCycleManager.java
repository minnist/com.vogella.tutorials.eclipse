import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;

public class LifeCycleManager {

	@PostContextCreate
	public void postContextCreate() throws IllegalStateException, IOException {
		// Show login dialog to the user
		String userName = // get username from login dialog;

		// check if the instance location is already set,
		// otherwise setting another one will throw an IllegalStateException
		if (!Platform.getInstanceLocation().isSet()) {
			String defaultPath = System.getProperty("user.home");

			// build the desired path for the workspace
			String path = defaultPath + "/" + userName + "/workspace/";
			URL instanceLocationUrl = new URL("file", null, path);
			Platform.getInstanceLocation().set(instanceLocationUrl, false);
		}
	}

}
