package com.company.e4.renderer.swt;

import org.eclipse.e4.ui.internal.workbench.swt.AbstractPartRenderer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory;

public class MyRenderderFactory extends WorkbenchRendererFactory {

	private MyStackRenderer stackRenderer;
//	private MyPartRenderer partRenderer;

	@Override
	public AbstractPartRenderer getRenderer(MUIElement uiElement, Object parent) {
		if (uiElement instanceof MPartStack) {
			if (stackRenderer == null) {
				stackRenderer = new MyStackRenderer();
				super.initRenderer(stackRenderer);
			}

			return stackRenderer;
		}
//		else if (uiElement instanceof MPart) {
//			if (partRenderer == null) {
//				partRenderer = new MyPartRenderer();
//				super.initRenderer(partRenderer);
//			}
//			
//			return partRenderer;
//		}

		return super.getRenderer(uiElement, parent);
	}
}
