package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static stepdefinition.SharedSD.getDriver;


public class Base {
    public static WebElement webAction(By locator) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(50)) // max time
                .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ArithmeticException.class)
                .ignoring(NullPointerException.class)
                .ignoring(Exception.class)
                .withMessage(
                        "WebDriver waited for 50 seconds but still " +
                                "could not find the element therefore " +
                                "Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public void clickOn(By locator)
    {
        //driver.findElement(locator).click()
        //getDriver().findElement(locator).click();
        webAction(locator).click();
        // element → driver.findElement(locator) → webAction(locator)
    }

    public void setValue(By locator,String value)
    {
        webAction(locator).sendKeys(value);
    }

    public String getTextFromElement(By locator)
    {
        return webAction(locator).getText();
    }

    public void selectFromDropDown(By locator,String value)
    {
        WebElement element  = webAction(locator); //driver.findElement(locator)
        Select sel = new Select(element);
        sel.selectByVisibleText(value);
    }

    public void selectFromDropDown(By locator,int i)
    {
        WebElement element  = webAction(locator); //driver.findElement(locator)
        Select sel = new Select(element);
        sel.selectByIndex(i);
    }
    
    public ArrayList<String> getElementTextList(By locator)
    {
        List<WebElement> elementList = getDriver().findElements(locator);

        ArrayList<String> textList = new ArrayList<>();

        for (int i=0;i<elementList.size();i++)
            textList.add(elementList.get(i).getText());

        return textList;
    }
}
