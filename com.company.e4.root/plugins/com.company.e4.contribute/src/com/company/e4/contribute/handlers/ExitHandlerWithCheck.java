package com.company.e4.contribute.handlers;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.Dialog;

import com.company.e4.contribute.dialogs.ExitDialog;

public class ExitHandlerWithCheck {

	@Execute
	public void execute(IEclipseContext context, IWorkbench workbench) {
		ExitDialog dialog = ContextInjectionFactory.make(ExitDialog.class, context);
		if (dialog.open() == Dialog.OK) {
			workbench.close();
		}
	}
}
