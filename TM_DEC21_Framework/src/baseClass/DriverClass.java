package baseClass;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import libraries.Utils;
import reports.Generate_Reports;

public class DriverClass extends Utils {

//	public DriverClass(String excelPath, String sheetName) {
//		super(excelPath, sheetName);
//		// TODO Auto-generated constructor stub
//	}

	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("******  Intializing Test Suite *******");
		Generate_Reports genreport = new Generate_Reports();
		Generate_Reports.intializeReports();

		System.out.println("******  Test Suite is intialized sucessfully *******");

	}

	@BeforeMethod
	public void launchBrowser(Method method1){
		try {
			CurrentTestCaseName = method1.getName();
			Generate_Reports.startTest(CurrentTestCaseName);
			System.out.println("<<TestStart>> TestCase Name   " + CurrentTestCaseName + "  <<TestStart>>");
			Browser = Browser.toUpperCase();

			switch (Browser) {
			case "FF":
				System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\Geecko\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			case "CHROME":
				System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//========================================================================	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		System.out.println("<<TestSuccess>> TestCase Name   " + CurrentTestCaseName + "  <<TestSuccess>>");
		System.out.println();

	}

	@AfterSuite
	public void toEnd() {
		try {
			Generate_Reports genreport = new Generate_Reports();
			genreport.flushReport();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Generate_Reports.resultfile);
		driver.navigate().refresh();

	}

}
