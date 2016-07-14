import org.eclipse.e4.ui.di.Focus;

// more code

@Focus
private void setFocus() {
	System.out.println(this.getClass().getSimpleName() 
			+ " @Focus method called");
}