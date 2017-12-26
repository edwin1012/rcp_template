package com.company.e4.rcp.tests.internal.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Test;

import com.company.e4.rcp.internal.views.RightView;

public class RightViewPartTest {
	public static void main(String[] args) {
		Display display = new Display();
        Shell shell = new Shell(display);
        RightView part = new RightView();
        part.createControl(shell);
        shell.open();
        // create and check the event loop
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
	}
	
	@Test
	public void testExample() {
		Assert.assertTrue(Platform.isRunning());
	}
}
