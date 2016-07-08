
package de.vogella.emf.webpage.model;

import java.util.List;

/**
 * @model
 */
public interface Category {
	/**
	 * @model default=""
	 */
	public String getName();

	/**
	 * @model containment="true"
	 */
	public List getArticles();
}
