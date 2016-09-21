
package tabletesting.dialog;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EditDialog extends TitleAreaDialog {

	private Text text1;
	private Text text2;
	private Button button1;
	private Combo combo1;
	private String firstName;
	private String lastName;
	private String gender;
	private Boolean isMarried;

	public EditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Edit a Person");
		setMessage("Please enter the new data for the person",
				IMessageProvider.INFORMATION);
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		parent.setLayout(layout);
		Label label1 = new Label(parent, SWT.NONE);
		label1.setText("First Name");
		text1 = new Text(parent, SWT.BORDER);
		if (firstName != null) {
			text1.setText(firstName);
		} else {
			text1.setEnabled(false);
		}
		Label label2 = new Label(parent, SWT.NONE);
		label2.setText("Last Name");
		text2 = new Text(parent, SWT.BORDER);
		if (lastName != null) {
			text2.setText(lastName);
		} else {
			text2.setEnabled(false);
		}
		Label label3 = new Label(parent, SWT.NONE);
		label3.setText("Gender");
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gd.horizontalAlignment = GridData.FILL;
		gd.horizontalSpan = 2;
		combo1 = new Combo(parent, SWT.READ_ONLY);
		combo1.add(" ");
		combo1.add("male");
		combo1.add("female");

		if (gender == null) {
			combo1.setText(" ");
		} else {
			combo1.setText(gender);
		}

		button1 = new Button(parent, SWT.CHECK);
		button1.setText("Is married?");
		button1.setLayoutData(gd);
		if (isMarried != null) {
			button1.setSelection(isMarried);
		} else {
			button1.setSelection(true);
			button1.setGrayed(true);
			button1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					button1.setGrayed(false);
				}
			});
		}
		return parent;

	}

	public void setPersonData(String firstName, String lastName, String gender,
			Boolean isMarried) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.isMarried = isMarried;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		((GridLayout) parent.getLayout()).numColumns++;
		Button button = new Button(parent, SWT.PUSH);
		button.setText("OK");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				firstName = text1.getText();
				lastName = text2.getText();
				if (!combo1.getText().equals(" ")) {
					gender = combo1.getItem(combo1.getSelectionIndex());
				}
				if (!button1.getGrayed()) {
					isMarried = button1.getSelection();
				} else {
					isMarried = null;
				}
				close();

			}
		});
	}
}