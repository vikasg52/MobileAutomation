package com.proptiger1;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class HeadLess {
	public static void Headless(FirefoxProfile profile)
	{
		String Xport= System.getProperty("Importal.xvfb.id", ":1");
		final File firefoxPath= new File(System.getProperty("Importal.deploy.firefoxPath", "/usr/bin/firefox"));
		FirefoxBinary fireFoxBinary= new FirefoxBinary(firefoxPath);
		fireFoxBinary.setEnvironmentProperty("DISPLAY", Xport);
		WebDriver driver= new FirefoxDriver(fireFoxBinary,profile);
	}

}
