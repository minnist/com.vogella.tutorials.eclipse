Job job = Job.create("CancelAbleJob", monitor -> {
	SubMonitor subMonitor = SubMonitor.convert(monitor, todos.size());
	
	for (Todo todo : todos) {
		processTodo(subMonitor.split(1), todo);
	}
	
	// no return value needed when using an ICoreRunnable (since Neon)
});
job.schedule();