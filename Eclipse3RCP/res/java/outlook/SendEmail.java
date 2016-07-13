
package outlooktest;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class SendEmail implements IWorkbenchWindowActionDelegate {

	private Shell shell;

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		shell = window.getShell();
	}

	@Override
	public void run(IAction action) {
		Display display = Display.getCurrent();
		Shell shell = new Shell(display);

		OleFrame frame = new OleFrame(shell, SWT.NONE);
		// This should start outlook if it is not running yet
		OleClientSite site = new OleClientSite(frame, SWT.NONE, "OVCtl.OVCtl");
		site.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);

		// now get the outlook application
		OleClientSite site2 = new OleClientSite(frame, SWT.NONE,
				"Outlook.Application");
		OleAutomation outlook = new OleAutomation(site2);
		// 
		OleAutomation mail = invoke(outlook, "CreateItem", 0 /* Mail item */)
				.getAutomation();
		setProperty(mail, "To", ""); /* Empty but could also be predefined */
		setProperty(mail, "BodyFormat", 2 /* HTML */);
		setProperty(mail, "Subject", "Top News for you");
		setProperty(mail, "HtmlBody",
				"<html>Hello<p>, please find some infos here.</html>");
		OleAutomation attachments = getProperty(mail, "Attachments");
		invoke(attachments, "Add", "c:/temp/test.txt");
		invoke(mail, "Display" /* or "Send" */);
	}

	private static OleAutomation getProperty(OleAutomation auto, String name) {
		Variant varResult = auto.getProperty(property(auto, name));
		if (varResult != null && varResult.getType() != OLE.VT_EMPTY) {
			OleAutomation result = varResult.getAutomation();
			varResult.dispose();
			return result;
		}
		return null;
	}

	private static Variant invoke(OleAutomation auto, String command,
			String value) {
		return auto.invoke(property(auto, command),
				new Variant[] { new Variant(value) });
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	private static Variant invoke(OleAutomation auto, String command) {
		return auto.invoke(property(auto, command));
	}

	private static Variant invoke(OleAutomation auto, String command, int value) {
		return auto.invoke(property(auto, command),
				new Variant[] { new Variant(value) });
	}

	private static boolean setProperty(OleAutomation auto, String name,
			String value) {
		return auto.setProperty(property(auto, name), new Variant(value));
	}

	private static boolean setProperty(OleAutomation auto, String name,
			int value) {
		return auto.setProperty(property(auto, name), new Variant(value));
	}

	private static int property(OleAutomation auto, String name) {
		return auto.getIDsOfNames(new String[] { name })[0];
	}

}
