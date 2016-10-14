
public Todo copy() {
	return new Todo(this.id, this.summary, 
			this.description, this.done,
			getDueDate());
}