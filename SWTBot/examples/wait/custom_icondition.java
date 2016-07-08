@Test
public void testPerspectiveChange() {

	final String adminPerspectiveId = "com.example.adminperspective";
	// wait until admin perspective becomes active
	bot.waitUntil(new DefaultCondition() {

		@Override
		public boolean test() throws Exception {
			return adminPerspectiveId.equals(this.modelService.getActivePerspective(this.window));
		}

		@Override
		public String getFailureMessage() {
			return adminPerspectiveId + " has not become active in time";
		}
	});

	final String mainPerspectiveId = "com.example.mainperspective";
	// alternatively wait as long as the main perspective is still active
	bot.waitWhile(new DefaultCondition() {

		@Override
		public boolean test() throws Exception {
			return mainPerspectiveId.equals(this.modelService.getActivePerspective(this.window));
		}

		@Override
		public String getFailureMessage() {
			return mainPerspectiveId + " remains active for too long";
		}
	});
	
	// ... continue testing the perspectives contents
}