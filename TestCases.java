
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCases {

	public static WebDriver driver;
    @Test
	public static void OpeningBrowser() {

		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

    @Test
	public static void OpenUrl() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://eagercrow.com/Home");

	}

    @Test
	public static void to_Hit_SignIn_Button() {

		WebDriverWait wait2 = new WebDriverWait(driver, 150);

		WebElement element = driver.findElement(By.xpath("//a[text()='Sign In']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@class='color0-hov selected']")).click();
		wait2.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
    }

    @Test
	public static void Sign_In_Email()
	{
		 
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//span[contains(text(),'Sign in with email')]")).click();
			driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("suraj@gmail.com");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xyz");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			System.out.println(driver.findElement(By.xpath
					("//p[@class='firebaseui-error firebaseui-text-input-error firebaseui-id-password-error']")).getText());
            driver.findElement(By.xpath("//a[@class='firebaseui-link firebaseui-id-secondary-link']"))
            .click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//button[@data-upgraded=',MaterialButton']")).click();
			//driver.findElement(By.xpath("//h2[@class='l-text2 t-center']")).click();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//input[@name='name']")).click();
			//driver.findElement(By.xpath("//input[@name='name']")).sendKeys("suraj gunjal");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//driver.findElement(By.xpath("//input[@type='password']")).click();
			//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("suraj111g");
			//driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.findElement(By.xpath("//div[@class='firebaseui-textfield mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded is-dirty firebaseui-textfield-invalid']")).getText();

			 }
    
    
   /* public static void correct_Email_incorrect_PW()
    {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xyz");
		driver.findElement(By.xpath("//button[@type='submit']")).click();


    } */
    
    public static void main(String[] args)
    {
    	TestCases.OpeningBrowser();
    	TestCases.OpenUrl();
    	TestCases.to_Hit_SignIn_Button();
    	TestCases.Sign_In_Email();
    	//TestCases.correct_Email_incorrect_PW();
    }
}
