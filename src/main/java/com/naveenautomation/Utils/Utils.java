package com.naveenautomation.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomation.base.TestBase;

public class Utils extends TestBase {

	public static int getRandomInteger(int length) {
		Random random = new Random();
		return random.nextInt(length);
	}

	public static String getRandomString(int length) {
		return RandomStringUtils.random(length);
	}

	public static String getRandomEmail() {
		String suffix = RandomStringUtils.random(5);
		return "testemail_" + suffix + "@gmail.com";
	}

	public static String getRandomPassword() {
		return "Password" + new Random().nextInt(1);
	}

	public static Date getCurrentTime() {
		return new Date();
	}

	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String takeScreenShot(String testName) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("/home/sanil/eclipse-workspace/naveenautomationassignment/FailedTestScreenShots/" + testName + "_" + timeStamp + ".jpg");
		try {
			FileUtils.copyFile(screenshotFile, destFile);
			System.out.println(destFile.getAbsolutePath());
			return destFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}

}