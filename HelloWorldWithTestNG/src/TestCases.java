import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPathConstants;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCases {

	private static AndroidDriver driver;

	@BeforeTest
	public void lounchAPP() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Redmi");
		capabilities.setCapability("udid", "2d86975d7ce5");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "app.globallogic.com.glo");
		capabilities.setCapability("appActivity", "app.globallogic.com.glo.view.activities.Splash");

		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		// driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 1)
	public void login() {
		System.out.println("1.	Login Test");
		driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("rehan.parvez");
		driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(Constant.MyP);
		driver.findElement(By.xpath("//*[@text='Login']")).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void SearchUser() {
		try {
			System.out.println("2.	SearchUser Test");

			driver.findElement(By.xpath(XpathConstant.SearchPath1)).click();

			System.out.println("	Clicked on Search Icon");

			driver.findElement(By.xpath(XpathConstant.SearchKeyBoard1)).sendKeys("Umesh Kamble");
			Thread.sleep(1000);
			driver.findElement(By.xpath(XpathConstant.Profile)).click();

			System.out.println("	Umesh Kamble's Profile found");

		} catch (Exception e) { // TODO Auto-generated catch block
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void Home() {
		try {
			System.out.println("3.	Home Page Test");

			driver.findElement(By.xpath(XpathConstant.Menu)).click();

			System.out.println("	Clicked on Menu Icon");

			driver.findElement(By.xpath(XpathConstant.Home)).click();

			System.out.println("	Home Page Display");

		} catch (Exception e) { // TODO Auto-generated catch block
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void Community() {
		try {
			System.out.println("4.	Community");

			driver.findElement(By.xpath(XpathConstant.Menu)).click();

			System.out.println("	Clicked on Menu Icon");

			driver.findElement(By.xpath(XpathConstant.Community)).click();

			System.out.println("	Community Page Display");

		} catch (Exception e) { // TODO Auto-generated catch block
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void Logout() {
		try {
			System.out.println("5.	Logout");

			driver.findElement(By.xpath(XpathConstant.Menu)).click();

			System.out.println("	Clicked on Menu Icon");

			driver.findElement(By.xpath(XpathConstant.Logout1)).click();
			
			System.out.println("	Clicked on Logout 1 Icon");
			driver.findElement(By.xpath(XpathConstant.Menu)).click();

			driver.findElement(By.xpath(XpathConstant.LOGOUTBUTTON)).click();
			System.out.println("	Clicked on Logout 2 Icon");
			
			System.out.println("	Clicked on Logout Icon");
			Thread.sleep(500);
			System.out.println("	Sleep");

			if (driver.findElement(By.xpath(XpathConstant.LOGOUTCONFIRMATIONMESSAGE)).isDisplayed()) {
				driver.findElement(By.xpath(XpathConstant.Yes)).click();
				System.out.println("Validation Checked");
			}
			// driver.findElement(By.xpath(XpathConstant.Yes1)).click();

			System.out.println("	Successfully Logout");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception " + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterTest
	public void stopApplication() {
		// driver.quit();
	}

}