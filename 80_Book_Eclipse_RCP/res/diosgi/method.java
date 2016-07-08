/@Inject ITodoService todoService;/
@Inject
public void setTodoService(@Optional ITodoService todoService){
  this.todoService = todoService;
  // TODO reload data
}