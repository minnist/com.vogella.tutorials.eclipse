

package writeWebpage;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import datamodel.website.MyWeb;
import datamodel.website.WebsitePackage;
import datamodel.website.impl.WebsitePackageImpl;

public class EMFModelLoad {
	public MyWeb load() {
		// Initialize the model
		WebsitePackage.eINSTANCE.eClass();
		
		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("website", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(URI
				.createURI("website/My.website"), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		MyWeb myWeb = (MyWeb) resource.getContents().get(0);
		return myWeb;
	}

}
