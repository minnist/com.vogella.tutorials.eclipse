
package de.vogella.e4.todo.model.servicemock;

import java.util.ArrayList;
import java.util.List;

import de.vogella.e4.todo.model.Category;
import de.vogella.e4.todo.model.ITodoService;
import de.vogella.e4.todo.model.Todo;

public class TodoMockModel implements ITodoService {

	private List<Category> categories;

	public TodoMockModel() {
		categories = new ArrayList<Category>();
		Category category = new Category();
		category.setName("Programming");
		categories.add(category);
		Todo todo = new Todo("Write more about e4");
		category.getTodos().add(todo);
		todo = new Todo("Android", "Write a widget.");
		category.getTodos().add(todo);

		category = new Category();
		category.setName("Leasure");
		categories.add(category);
		todo = new Todo("Skiing");
		category.getTodos().add(todo);
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}
}
