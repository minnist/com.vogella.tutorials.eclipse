// even though only www.vogella.com is shown in the UI this won't work
SWTBotLink vogellaLink = bot.link("www.vogella.com");

// this is the valid way to access the Link
SWTBotLink vogellaLink = bot.link("<a>www.vogella.com</a>");