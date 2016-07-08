
package de.vogella.emf.webpage.model;

import java.util.List;

/**
 * @model
 */
public interface MyWeb {
	/**
	 * @model default=""
	 */
	public String getName();
	/**
	 * @model default=""
	 */
	public String getTitle();
	/**
	 * @model default=""
	 */
	public String getDescription();

	/**
	 * @model default=""
	 */
	public String getKeywords();
	/**
	 * @model containment="true"
	 */
	public List<Webpage> getPages();
}

	