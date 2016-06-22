
public IWizardPage getNextPage() {
	if (condition) {
		// assumes that Wizard has method getNextPage()
		MyPageOne page = ((MyWizard) getWizard()).getNextPage();
		return page;
	}
	return super.getNextPage();
}