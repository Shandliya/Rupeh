package imdb;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PomRepository.HomePage;
import genericUtility.BaseClass;

public class ImdbLink extends BaseClass {
		@Test

		public void pushpaMovieTest() throws IOException, InterruptedException {

			
			String movie = excelUtility.getDataFromExcel(1, 1, "Sheet1");
			String url = fileUtility.getDataFromProperty("url");
			String browser = fileUtility.getDataFromProperty("browser");

			WebDriver driver=webdriverUtility.setupDriver(browser);
			webdriverUtility.maximizeBrowser();
			driver.get(url);
			webdriverUtility.implicitWait(10);
			HomePage home=new HomePage(driver);
			home.enterMovieName(movie);
			home.clickOnMovie();	
			WebElement element = driver.findElement(By.xpath("//span[.='Details']"));
			jsUtility.initiallizeJSExecutor(driver);
			jsUtility.scrollTillElement(element);
			String country = home.getCountryName();
			String release = home.getReleaseDate();
			System.out.println(country);
			System.out.println(release);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//img[@src='https://m.media-amazon.com/images/S/al-eu-726f4d26-7fdb/cca46258-4f6b-4f56-a7c4-19dfa413079b.jpg']"))));
			webdriverUtility.takeScreenShotPage(url, javaUtility);
			driver.quit();
		}
	}
