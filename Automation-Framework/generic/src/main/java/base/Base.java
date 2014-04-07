package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ismailosmanjan on 4/6/14.
 */
public class Base {


    public WebDriver driver = null;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://www.cnn.com");
        //driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() throws Exception {
        //driver.close();
    }
    //UTILITY Methods
    public void navigateBack(){
        driver.navigate().back();
    }
    public void clickById(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickByTagName(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public WebElement getWebElementByCss(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));

        return element;
    }
    public List<WebElement> getWebElementsByCss(String locator1){
        List<WebElement> elementList = driver.findElements(By.cssSelector(locator1));

        return elementList;
    }

    public String getElementText(String locator){

        String st = getWebElementByCss(locator).getText();

        return st;
    }
    public List<String> getListOfString(String locator1){
        List<WebElement> elementList = getWebElementsByCss(locator1);
        List<String> list = new ArrayList<String>() ;
        for(WebElement element:elementList){
            list.add(element.getText());
        }
        return list;
    }

    public void typeByCss(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void sleep(int seconds) throws InterruptedException{
        Thread.sleep(seconds * 1000);
    }
}
