// todo is an object available in the wizard

private TodoWizardPage1 page1 = new TodoWizardPage1(todo);
private TodoWizardPage2 page2 = new TodoWizardPage2();
private TodoWizardPage3 specialPage = new TodoWizardPage3(todo);

@Override
public void addPages() {
  addPage(page1);
  addPage(page2);
  addPage(specialPage);
}

@Override
public IWizardPage getNextPage(IWizardPage currentPage) {
    if (todo.isDone()) {
       return specialPage;
    }
    if (currentPage == page1) {
        return page2;
    }
    return null;
}