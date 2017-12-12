package com.company.e4.plugin1.tests;

import org.eclipse.core.runtime.Platform;
import org.junit.Assert;
import org.junit.Test;

public class TestSample {

	@Test
	public void shouldBeTest() {
		Assert.assertTrue(Platform.isRunning());
	}
}
