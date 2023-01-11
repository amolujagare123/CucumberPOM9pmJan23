package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

public class HotelsSD {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();
    @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {

    }
    @Then("I verify {string} is within the search result")
    public void i_verify_is_within_the_search_result(String expectedHotelName) {

        ArrayList<String> hotelList = hotelsSearchResult.getHotelsList();

        boolean flag = false;

        for (String hotel:hotelList) {
            System.out.println(hotel);

            if (hotel.equalsIgnoreCase(expectedHotelName))
            {
                flag = true;
            }

        }
        Assert.assertTrue("Given hotel is not there in the hotel list",flag);
    }

}
