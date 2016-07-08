@Test
public void testTableRowAmount() {

	SWTBotTable table = bot.table();
	int rowCount = 3;
	// choose a longer timeout than the default, because loading table contents takes longer
	int timeout = 10000;
	// check every second, if the condition is fulfilled
	int interval = 1000;
	bot.waitUntil(Conditions.tableHasRows(table, rowCount), timeout, interval);

	// ... continue working with the table rows
}