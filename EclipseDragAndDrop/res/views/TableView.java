
package com.vogella.dnd.jface.view;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;

import com.vogella.dnd.jface.dnd.MyDragListener;
import com.vogella.dnd.jface.model.ContentProvider;
import com.vogella.dnd.jface.viewers.TableContentProvider;
import com.vogella.dnd.jface.viewers.TableLabelProvider;

public class TableView {


	@PostConstruct
	public void createPartControl(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		int operations = DND.DROP_COPY| DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		viewer.addDragSupport(operations, transferTypes , new MyDragListener(viewer));
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());
		viewer.setInput(ContentProvider.INSTANCE.getModel());
	}
}
