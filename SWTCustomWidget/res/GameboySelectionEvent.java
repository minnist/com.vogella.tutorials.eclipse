package com.vogella.rcp.custom.widgets.widget.gameboy;

import java.util.EventObject;

public class GameboySelectionEvent extends EventObject {

	private static final long serialVersionUID = 1059740358205812736L;

	public static final int BUTTON_POWER = 0;
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_START = 3;
	public static final int BUTTON_SELECT = 4;
	public static final int BUTTON_UP = 5;
	public static final int BUTTON_DOWN = 6;
	public static final int BUTTON_LEFT = 7;
	public static final int BUTTON_RIGHT = 8;

	private int gameboyButton;

	public GameboySelectionEvent(Object source, int gameboyButton) {
		super(source);
		assert (gameboyButton < 9 && gameboyButton > -1);
		this.gameboyButton = gameboyButton;
	}

	public int getButton() {
		return gameboyButton;
	}
}
