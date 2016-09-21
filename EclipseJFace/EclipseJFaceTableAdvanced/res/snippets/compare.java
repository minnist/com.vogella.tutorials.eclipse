
// sort according to due date
viewer.setComparator(new ViewerComparator() {
	public int compare(Viewer viewer, Object e1, Object e2) {
		Todo t1 = (Todo) e1;
		Todo t2 = (Todo) e2;
		return t1.getDueDate().compareTo(t2.getDueDate());
	};
});