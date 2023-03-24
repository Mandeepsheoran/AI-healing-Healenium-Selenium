/**
 * 
 */
package org.igt.demo.uitests;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.igt.demo.annotations.FrameworkAnnotations;
import org.igt.demo.drivers.DriverManager;
import org.igt.demo.enums.LogType;
import org.igt.demo.enums.PropertiesType;
import org.igt.demo.pompages.BasePage;
import org.igt.demo.pompages.NotificationPage;
import org.igt.demo.utils.DateFormatUtils;
import org.igt.demo.utils.PropertyUtils;
import static org.igt.demo.enums.LogType.INFO;
import static org.igt.demo.reports.FrameworkLogger.log;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Apr 4, 2022
 * 
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see
 */
public class HealeniumWebTest extends BaseTest{


	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentASIADateTimeFormat() + "]");
	}

	@Test(description = "Healenium enabled test", priority = 1)
	@FrameworkAnnotations(author = "Mandeep", category = "SMOKE", methodType = "Web")
	public void autoHealingTest() throws InterruptedException {
		SelfHealingDriver healdriver = SelfHealingDriver.create(DriverManager.getDriver());
		Thread.sleep(5000);
		healdriver.findElement(By.name("Channel Name")).sendKeys("Mandeep");
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Cats']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Birds']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Horses']")).click();
	}

	@DisableHealing
	@Test(description = "Healenium disabled test", priority = 2)
	@FrameworkAnnotations(author = "Mandeep", category = "SMOKE", methodType = "Web")
	public void aiHealingDisabled() throws InterruptedException {

		SelfHealingDriver healdriver = SelfHealingDriver.create(DriverManager.getDriver());
		healdriver.get("http://127.0.0.1:5500/samplepage.html");
		healdriver.findElement(By.name("Channel Name")).sendKeys("Mandeep");
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Cats']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Birds']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Horses']")).click();
	}

}
