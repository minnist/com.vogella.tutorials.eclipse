
package com.example.e4.rcp.todo.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveHandler {

	@Execute
	void execute(EPartService partService) {
		partService.saveAll(false);
	}
}
