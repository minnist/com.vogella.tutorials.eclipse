final List<Task> tasks = taskService.getTasks();
Job job = new Job("My Job") {
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// convert to SubMonitor and set total number of work units
		SubMonitor subMonitor = SubMonitor.convert(monitor, tasks.size());
		for (Task task : tasks) {
			try {
				// sleep a second
				TimeUnit.SECONDS.sleep(1);

				// set the name of the current work
				subMonitor.setTaskName("I'm working on Task " + task.getSummary());
				
				// workOnTask is a method in this class which does some work
				// pass a new child with the totalWork of 1 to the mehtod
				workOnTask(task, subMonitor.split(1));
				
			} catch (InterruptedException e) {
				return Status.CANCEL_STATUS;
			}
		}
		return Status.OK_STATUS;
	}

};
job.schedule();