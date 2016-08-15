public class CrownRegion
{

  public static void main(String[] args)
  {
    final Display display = new Display();
    // Shell must be created with style SWT.NO_TRIM
    final Shell shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
    shell.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));

    // Create a region that looks like a crown
    Region region = new Region();
    region.add(0, 0, 300, 150);
    // subtract for the spikes of the crown
    region.subtract(new int[] { 2, 0, 75, 75, 150, 0, 225, 75, 298, 0 });
    shell.setRegion(region);
    Rectangle size = region.getBounds();
    shell.setSize(size.width, size.height);

    // center the shell on the display
    Rectangle bounds = display.getBounds();
    shell.setLocation(bounds.x / 2 - 150, bounds.y / 2 + 75);

    shell.open();

    while (!shell.isDisposed())
    {
      if (!display.readAndDispatch())
        display.sleep();
    }
    region.dispose();
    display.dispose();
  }
}