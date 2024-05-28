package amazonSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
		signInButton.click();
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
		emailField.sendKeys(" ");
		driver.findElement(By.id("continue")).click();
		WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password")));
		passwordField.sendKeys(" ");
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		searchBox.sendKeys("laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement product1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")));
		product1.click();
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
		addToCartButton.click();
		WebElement proceedToCheckoutButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.id("hlb-ptc-btn-native")));
		proceedToCheckoutButton.click();
		WebElement addressContinueButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.name("shipToThisAddress")));
		addressContinueButton.click();
		driver.quit();

	}

}
