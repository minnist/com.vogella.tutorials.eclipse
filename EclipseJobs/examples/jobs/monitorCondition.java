protected IStatus run(IProgressMonitor monitor) {
	// convert to SubMonitor and set total number of work units
	SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
	
	if(taskNeedsPreconfiguration(task)) {
		// Takes 30 % of the work
		preConfigureTask(task, subMonitor.split(30));
	}
	
	// ensure only 70 % of the work remains
	subMonitor.setWorkRemaining(70);
	
	// do the rest of the work
	workOnTask(task, subMonitor.split(70));
	
	return Status.OK_STATUS;
}