package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinition.SharedSD.getDriver;

public class HotelsSearchResult extends Base {

    By hotels = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelsList()
    {
        return getElementTextList(hotels);
    }

    public void clickStarRating(String star)
    {
        By rating = By.xpath("//div[@data-filters-group='class']//input[@name='class="+star+"']");
        clickOn(rating);

    }

    By totalRatings = By.xpath("//div[@data-testid='rating-stars']");
    By totalStars = By.xpath("//div[@data-testid='rating-stars']/span");

    public int getTotalRatings()
    {
       return  getDriver().findElements(totalRatings).size();
    }

    public int getTotalStars()
    {
        return  getDriver().findElements(totalStars).size();
    }

}
