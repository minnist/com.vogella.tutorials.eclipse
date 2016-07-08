
package writeWebpage;

import java.util.Iterator;

import datamodel.website.MyWeb;
import datamodel.website.Webpage;

public class LoadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Loading the existing model
		EMFModelLoad loader = new EMFModelLoad();
		MyWeb myWeb = loader.load();
		// Accessing the model information
		System.out.println(myWeb.getDescription());
		System.out.println(myWeb.getTitle());
		// Lets see what info the webpage has
		for (Iterator<Webpage> iterator = myWeb.getPages().iterator(); iterator
				.hasNext();) {
			Webpage page = iterator.next();
			System.out.println("Name : " + page.getName());
			// We could also iterate over the Articles...
		}
	}
}
