Job job = Job.create("CancelAbleJob", monitor -> {
	SubMonitor subMonitor = SubMonitor.convert(monitor, todos.size());
	
	for (Todo todo : todos) {
		if(subMonitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}
		
		processTodo(subMonitor.newChild(1), todo);
	}
	
	return Status.OK_STATUS;
});
job.schedule();