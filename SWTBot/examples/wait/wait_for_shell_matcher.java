@Test
public void testShellOpened() {
	// open a shell with "Shell text" as text...

	// create a shellMatcher to wait for the previously opened shell
	Matcher<Shell> shellMatcher = WithText.withTextIgnoringCase("Shell text");
	// wait until the shell is opened
	bot.waitUntil(Conditions.waitForShell(shellMatcher));text
}