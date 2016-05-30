package com.vogella.eclipse.text.hyperlinkdetector;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class VogellaHyperlink implements IHyperlink {

 private final IRegion fUrlRegion;

 public VogellaHyperlink(IRegion urlRegion) {
  fUrlRegion = urlRegion;
 }

 @Override
 public IRegion getHyperlinkRegion() {
  return fUrlRegion;
 }

 @Override
 public String getTypeLabel() {
  return null;
 }

 @Override
 public String getHyperlinkText() {
  return null;
 }

 @Override
 public void open() {
	 Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	 MessageDialog.openInformation(shell, "Clicked", "Clicked on vogella");
 }
}