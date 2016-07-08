IProject project = // get project...
IProjectDescription description = project.getDescription();

String[] natures = description.getNatureIds();
String[] newNatures = new String[natures.length + 1];
System.arraycopy(natures, 0, newNatures, 0, natures.length);
newNatures[natures.length] = ExampleProjectNature.NATURE_ID;

// validate the natures
IWorkspace workspace = ResourcesPlugin.getWorkspace();
IStatus status = workspace.validateNatureSet(newNatures);

// only apply new nature, if the status is ok
if (status.getCode() == IStatus.OK) {
	description.setNatureIds(newNatures);
	project.setDescription(description, null);
}