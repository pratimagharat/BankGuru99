package TestPractice.Guru99Bank.TestBase;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageOject {
	protected WebDriver driver;
	
	  

	public BasePageOject(WebDriver driver) {
		super();
		this.driver=driver;
		
	}
	
	public WebElement isElementClickableBy(WebElement elm)
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.elementToBeClickable(elm));
		 
	}
	
	public WebElement isElementClickableBy(By locator)
	{
        WebDriverWait wait=new WebDriverWait(driver,60);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement isElementVisible(By locator)
	{
		
		 WebDriverWait wait=new WebDriverWait(driver,60);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	

	public WebElement isElementVisible(WebElement elm)
	{
		
		 WebDriverWait wait=new WebDriverWait(driver,60);
			return wait.until(ExpectedConditions.visibilityOf(elm));
	}
	
//	fluent wait--
	
	public WebElement findelementsafely(final WebElement element)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
		
		
		WebElement foo = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver){
				return element;
			}
		});
		return foo;
	}
		
		
	public WebElement findelemntsafely(final By locator)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
		
		WebElement foo=wait.until(new Function<WebDriver,WebElement>()
				{
			
			public WebElement apply(WebDriver dirver)
			{
				return driver.findElement(locator)
;			}
				});
				return foo;
	}
	
	public void enterValueOn(By locator,String value)
	{
		findelemntsafely(locator).sendKeys(value);
			
	}
	
	public void enterValueOn(WebElement elem,String value)
	{
		findelementsafely(elem)	.sendKeys(value);
		
	}
	
	public void clickToButton(By locator,String value)
	{
		findelemntsafely(locator).click();
		
	}
	public void clickToButton(WebElement elem)
	{
		findelementsafely(elem).click();
		
	}
	public void selectdrop(WebElement elem,String value)
	{
		Select s=new Select(elem);
		s.selectByVisibleText(value);
	}
	
	public void deselectMulti(WebElement elem,String value)
	{
		Select s=new Select(elem);
		s.deselectAll();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public String getElmenetText(By locator)
	{
		return findelemntsafely(locator).getText();
	}
	
	
	public String getElmenetText(WebElement ele)
	{
		return findelementsafely(ele).getText();
	}
	
	
}
