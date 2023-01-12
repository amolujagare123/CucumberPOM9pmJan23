package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

import static stepdefinition.SharedSD.getDriver;

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

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars) // "5 stars"
    {
            hotelsSearchResult.clickStarRating(stars.split(" ")[0]);
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) // "5 stars"
             {
                 getDriver().navigate().refresh();
        int expected = Integer.parseInt(stars.split(" ")[0]) ; // 5
        int actual = hotelsSearchResult.getTotalStars() / hotelsSearchResult.getTotalRatings() ;

                 System.out.println("expected="+expected);
                 System.out.println("actual="+actual);
                 Assert.assertEquals("Star rating does not match",expected,actual);

    }


}
