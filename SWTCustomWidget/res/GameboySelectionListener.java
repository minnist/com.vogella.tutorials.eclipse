package com.vogella.rcp.custom.widgets.widget.gameboy;

import java.util.EventListener;

/**
 * This listener is used to be registered for the {@link GameboyWidget} and will
 * be invoked every time a button on the {@link GameboyWidget} is selected.
 *
 */
public interface GameboySelectionListener extends EventListener {

	public void gameboyButtonSelected(
			GameboySelectionEvent gameboySelectionEvent);
}
