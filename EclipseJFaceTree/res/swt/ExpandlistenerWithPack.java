// the viewer field is an already configured TreeViewer
Tree tree = (Tree) viewer.getControl();

Listener listener = new Listener() {

   @Override
   public void handleEvent(Event event) {
      TreeItem treeItem = (TreeItem)event.item;
      final TreeColumn[] treeColumns treeItem.getParent().getColumns();
      display.asyncExec(new Runnable() {

         @Override
         public void run() {
            for (TreeColumn treeColumn : treeColumns)
                 treeColumn.pack();
         }
      });
   }
};

tree.addListener(SWT.Expand, listener);