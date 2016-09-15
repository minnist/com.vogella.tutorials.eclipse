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

private void preConfigureTask(Task task, IProgressMonitor monitor) {
	SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
	subMonitor.setTaskName("Preconfiguring Task " + task.getSummary());
	
	// ... do the configuration
}

private void workOnTask(Task task, IProgressMonitor monitor) {
	SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
	subMonitor.setTaskName("Work on Task " + task.getSummary());
	
	SubMonitor loopRelatedTasksMonitor = subMonitor.split(80);
	
	// get related tasks from a service, which should also be preconfigured
	List<Task> relatedTasks = taskService.findRelatedTasks(task);
	
	// setWorkRemaining can also be applied, if the actual work is determined later
	loopRelatedTasksMonitor.setWorkRemaining(relatedTasks.size());
	
	for (Task relatedtask : relatedTasks) {
		preConfigureTask(relatedtask, loopRelatedTasksMonitor.split(1));
	}

	// ... do work on the actual task with the remaining 20 %
	doWorkOnActualTask(task, subMonitor.split(20));
}