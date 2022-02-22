package reports;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import libraries.Utils;

public class Generate_Reports extends Utils {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static String resultfile;
	public static ExtentSparkReporter sparkReporter;
	public static String ReportFolder;
	public static Method method;

	public static void intializeReports() {

		extent = new ExtentReports();
		resultfile = createResultFolder() + "\\TestSummaryReport.html";
		sparkReporter = new ExtentSparkReporter(resultfile);
		extent.attachReporter(sparkReporter);
		extent.addTestRunnerOutput(resultfile);
		extent.setSystemInfo("Project Name", "Testing Masters Trainging Project");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Sprint name", "Sprint 1");
	}

	public static void startTest(String testcasename) {
		test = extent.createTest(testcasename);
	}

	public void flushReport() {
		extent.flush();
	}

	public static void logEvent(String status, String Description) {
		switch (status.toLowerCase()) {
		case "pass":
			test.log(Status.PASS, Description);
			break;

		case "fail":
//			String path = takeScreenShot();
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			break;

		case "warning":
			test.log(Status.WARNING, Description);
			break;
		case "info":
			test.log(Status.INFO, Description);
			break;

		default:
			break;
		}

	}

	private static String getScreenShot() {
		TakesScreenshot sht = (TakesScreenshot) Utils.driver;

		
//		String screenshot = sht.getScreenshotAs(OutputType.BASE64);
//
//		return "data:image/png;base64," + screenshot;
		
		
		File screenshot = sht.getScreenshotAs(OutputType.FILE);

		return screenshot + ".png";

	}

	private static String takeScreenShot() {
		String directory = createResultFolder();
		String Destination;
		try {
			File sourceFile = ((TakesScreenshot) Utils.driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(sourceFile, new File(directory + ".png"));
			FileUtils.copyFile(sourceFile, new File(directory + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Destination = directory + ".png";
		return Destination;
	}

	private static String createResultFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");

		String path = "";

		File f = new File(System.getProperty("user.dir") + "\\Results\\" + sdf.format(new Date()).replace("/", "")
				+ "\\TestSummaryReport.html");

		if (!f.exists()) {

			f.mkdirs();
			path = System.getProperty("user.dir") + "\\Results\\" + sdf.format(new Date()).replace("/", "")
					+ "\\TestSummaryReport.html";
		} else {
			path = System.getProperty("user.dir") + "\\Results\\" + sdf.format(new Date()).replace("/", "")
					+ "\\TestSummaryReport.html";
		}

		return path;
	}
}
