private class MyLazyContentProvider implements ILazyContentProvider {
  private TableViewer viewer;
  private Person[] elements;

  public MyLazyContentProvider(TableViewer viewer) {
    this.viewer = viewer;
  }

  public void dispose() {
  }

  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    this.elements = (Person[]) newInput;
  }

  public void updateElement(int index) {
    viewer.replace(elements[index], index);
  }
}
