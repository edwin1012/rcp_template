package com.company.e4.rcp.internal.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;

public class ThemeSwitchHandler {
	private static final String DEFAULT_THEME = "com.company.e4.rcp.theme.default";
	private static final String NOTHING_THEME = "com.company.e4.rcp.theme.nothing";

	@Inject
	private IThemeEngine engine;
	
	@Execute
	public void switchTheme() {
		if (engine.getActiveTheme().getId().equals(DEFAULT_THEME)) {
			engine.setTheme(NOTHING_THEME, true);
		}
		else {
			engine.setTheme(DEFAULT_THEME, true);
		}
	}
}