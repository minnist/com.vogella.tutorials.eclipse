import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class LazyLoadingAddon implements EventHandler {
	
	@Inject
	private IEventBroker broker;

	@PostConstruct
	public void lazyLoadInContributorPerspective() {
		broker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, this);
	}

	@Override
	public void handleEvent(Event event) {
		Object property = event.getProperty(UIEvents.EventTags.NEW_VALUE);

		if (!(property instanceof MPerspective)) {
			return;
		}

		MPerspective perspective = (MPerspective) property;

		// only load the data, when this particular perspective is selected
		if ("com.example.speciallazyloaded.perspective".equals(perspective.getElementId())) {

			// loading data...

			// unsubscribe afterwards, so that the loading is only done once
			broker.unsubscribe(this);
		}
	}

}
