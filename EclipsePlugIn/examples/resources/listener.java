
// add listener
project.getWorkspace().addResourceChangeListener(listener);

// Remove listener
project.getWorkspace().removeResourceChangeListener(listener);

// Example resource listener
private IResourceChangeListener listener = new IResourceChangeListener() {
		public void resourceChanged(IResourceChangeEvent event) {

		if (event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE) {
				if (event.getResource().equals(project)) {
					// Project deleted or closed
					// do something
				}
				return;
			}

			if (resource == null)
				return;

			IResourceDelta delta = event.getDelta().findMember(new Path(resource.getURI().toPlatformString(false)));
			if (delta == null) {
				return;
			}

			if (delta.getKind() == IResourceDelta.REMOVED) {
				// Resource delete
				// do something
			}
		}

	};