
package mymodel;

import org.eclipse.emf.ecore.EObject;
/**
 * @model
 */
public interface IPerson extends EObject {
	/**
	 * @model default="";
	 */
	public String getLastname();
}

