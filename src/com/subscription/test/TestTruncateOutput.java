package com.subscription.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.subscription.controller.SubscriptionController;

public class TestTruncateOutput {
	
	SubscriptionController subController = new SubscriptionController();

	@Test
	public void testOutputLength24() {
		assertEquals("ABC... (truncated) ...YZ", new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 24));
	}

	@Test
	public void testOutputLength23() {
		assertEquals("AB... (truncated) ...YZ", new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 23));
	}
	
	@Test
	public void testOutputLength4() {
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 4));
	}
	
	@Test
	public void testOutputLength26() {
		assertEquals("ABCD... (truncated) ...XYZ", new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26));
	}

	@Test
	public void testOutputLength30() {
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", new SubscriptionController().truncate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 30));
	}

}
