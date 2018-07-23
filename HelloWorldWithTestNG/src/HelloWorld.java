import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HelloWorld {

	private static AppiumDriver driver;

	@Before
	public void AndroidConfig() {
		System.out.println("Starting Android App");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, "");
		caps.setCapability("deviceName", "Redmi");
		caps.setCapability("udid", "2d86975d7ce5"); // Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.2");
		caps.setCapability("appPackage", "app.globallogic.com.glo");
		caps.setCapability("appActivity", "app.globallogic.com.glo.view.activities.Splash");

		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@After
	public void stopApplication() {
		driver.quit();
	}

	@Test
	public void LoginTest() {
		AndroidConfig();

		driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("rehan.parvez");
		driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(Constant.MyP);
		driver.findElement(By.xpath("//*[@text='Login']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void Search() {
		AndroidConfig();
		//app.globallogic.com.glo:id/action_search 
		//*[@text='action_search']"

		//driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("rehan.parvez");
		//driver.findElement(By.xpath("//*[@text='Password']")).sendKeys(Constant.MyP);
		driver.findElement(By.xpath("//*[@text='action_search']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
