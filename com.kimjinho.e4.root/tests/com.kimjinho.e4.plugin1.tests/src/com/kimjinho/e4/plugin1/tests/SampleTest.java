package com.kimjinho.e4.plugin1.tests;

import org.eclipse.core.runtime.Platform;
import org.junit.Assert;
import org.junit.Test;

public class SampleTest {

	@Test
	public void shouldTest() {
		Assert.assertTrue(Platform.isRunning());
	}
}
