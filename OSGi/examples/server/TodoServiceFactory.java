package com.example.e4.rcp.todo.services;

import com.example.e4.rcp.todo.model.ITodoService;
import com.example.e4.rcp.todo.services.internal.MyTodoServiceImpl;

/**
 * factory provides access to the todo service provider
 * 
 */
public class TodoServiceFactory {

	private static ITodoService todoService = new MyTodoServiceImpl();

	public static ITodoService getInstance() {
		return todoService;
	}

}