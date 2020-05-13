package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Config {
	public static WebDriver driver;
	public static void openBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
          break;
		case "IE":
          WebDriverManager.iedriver().setup();
          driver=new InternetExplorerDriver();
          break;
		default:
			System.out.println("Invalid browsername"+browsername);
			break;
		}
	}

}
