package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult extends Base {

    By hotels = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelsList()
    {
        return getElementTextList(hotels);
    }
}
