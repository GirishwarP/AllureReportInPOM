package com.YOU.qa.util;

import java.util.Iterator;
import java.util.Set;

import com.YOU.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long Page_Load_TimeOut = 40;
	public static long Implicit_Wait = 20;	
	
	public static String getWindowID() {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();

		while (iterator.hasNext()) {
			String childWindow = iterator.next();

			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				return childWindow;
			}
		}
		return parentWindow;
	}
}
