package com.vogella.ide.todo;

import java.util.Date;

public class Todo {
  
  private long id;
  private String summary = "";
  private String description = "";
  private boolean done = false;
  private Date dueDate = new Date();

  public Todo(long id, String summary, String description, boolean done,
      Date dueDate) {
    this.id = id;
    this.summary = summary;
    this.description = description;
    this.done = done;
    this.dueDate = dueDate;

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
		this.dueDate = new Date(dueDate.getTime());
	}

}
