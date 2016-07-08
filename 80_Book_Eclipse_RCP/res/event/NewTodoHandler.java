package com.example.e4.rcp.todo.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import com.example.e4.rcp.todo.events.MyEventConstants;
import com.example.e4.rcp.todo.model.ITodoService;
import com.example.e4.rcp.todo.model.Todo;
import com.example.e4.rcp.todo.wizards.TodoWizard;

public class NewTodoHandler {
    @Execute
    public void execute(Shell shell, ITodoService todoService, IEventBroker broker) {
        // use -1 to indicate a not existing id
        Todo todo = new Todo(-1);
        WizardDialog dialog = new WizardDialog(shell, new TodoWizard(todo));
        if (dialog.open() == WizardDialog.OK) {
            todoService.saveTodo(todo);
            // asynchronously
            String todoId = String.valueOf(todo.getId());
            broker.post(MyEventConstants.TOPIC_TODO_NEW,
                    createEventData(MyEventConstants.TOPIC_TODO_NEW, todoId));
        }
    }

    private Map<String, String> createEventData(String topic, String todoId) {
        Map<String, String> map = new HashMap<>();
        // in case the receiver wants to check the topic
        map.put(MyEventConstants.TOPIC_TODO, topic);
        // which todo has changed
        map.put(Todo.FIELD_ID, todoId);
        return map;
    }

}