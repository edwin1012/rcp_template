package com.company.e4.contribute.processors;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import com.company.e4.contribute.handlers.ExitHandlerWithCheck;

public class MenuProcessor {

	@Inject
	@Named("org.eclipse.ui.file.menu")
	private MMenu menu;

	@Execute
	public void execute(EModelService modelService) {
		if (!menu.getChildren().isEmpty()) {
			List<MMenuElement> list = new ArrayList<>();
			for (MMenuElement element : menu.getChildren()) {
				if (element.getElementId() != null && element.getElementId().contains("exit")) {
					list.add(element);
				}
			}

			menu.getChildren().removeAll(list);
		}

		MDirectMenuItem menuItem = modelService.createModelElement(MDirectMenuItem.class);
		menuItem.setLabel("Another Exit");
		menuItem.setContributionURI("bundleclass://com.company.e4.contribute/"+ ExitHandlerWithCheck.class.getName());
		menu.getChildren().add(menuItem);
	}
}
