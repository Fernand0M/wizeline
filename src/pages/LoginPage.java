package pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//button[@class='btn btn-lg btn-primary button-login']")
    private WebElement btnLogin1;
	
	@FindBy(name="login.username")
    private WebElement txtuserName;
	
	@FindBy(name="login.password")
    private WebElement txtpassword;
	
	
	
	public void login(String username, String password) {
		
		
		btnLogin1.click();
		txtuserName.sendKeys(username);
		txtpassword.sendKeys(password);
		btnLogin1.click();
		verifyTextIsPresent("My Notes",2);
	}
	

	protected boolean verifyTextIsPresent(String strText, int strindex) {
		String xPathExpression = "(//*[contains(text(),'" + strText + "')])["+strindex+"]";
		WebElement objText;
		if (!IsElementPresent(By.xpath(xPathExpression))) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return false;
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		objText = driver.findElement(By.xpath(xPathExpression));
		if (objText.isDisplayed() && objText.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	protected boolean IsElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

}
