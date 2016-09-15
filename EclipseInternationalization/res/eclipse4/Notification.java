@Inject
@Optional
private void getNotified(
    @Named(TranslationService.LOCALE) Locale s) {
    System.out.println("Injected via context: " + s);
}

@Inject
@Optional
private void getNotified(
    @UIEventTopic(ILocaleChangeService.LOCALE_CHANGE) Locale s) {
    System.out.println("Injected via event broker: " + s);
}