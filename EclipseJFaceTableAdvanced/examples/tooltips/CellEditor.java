colFirstName.setLabelProvider(new ColumnLabelProvider() {
  @Override
  public String getText(Object element) {
    Person p = (Person) element;
    return p.getFirstName();
  }

  @Override
  public String getToolTipText(Object element) {
    return "Tooltip (" + ((Person)element).getLastName() + ")";
  }

  @Override
  public Point getToolTipShift(Object object) {
    return new Point(5, 5);
  }

  @Override
  public int getToolTipDisplayDelayTime(Object object) {
    return 100; // msec
  }

  @Override
  public int getToolTipTimeDisplayed(Object object) {
    return 5000; // msec
  }

});