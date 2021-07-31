package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Etsy_StepDefinitions {

    @Given("user is on Etsy landing page")
    public void user_is_on_etsy_landing_page() {
        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);
        BrowserUtils.sleep(3);
    }
    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title is not as expected",actualTitle.equals(expectedTitle));
    }

    EtsySearchPage searchPage = new EtsySearchPage();

    @When("user types Wooden Spoon in the search bar")
    public void user_types_wooden_spoon_in_the_search_bar() {
        searchPage.searchBox.sendKeys("Wooden Spoon");
    }
    @When("user clicks to search button")
    public void user_clicks_to_search_button() {
        searchPage.searchButton.click();
    }
    @Then("user sees title is Wooden Spoon | Etsy")
    public void user_sees_title_is_wooden_spoon_etsy() {

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title is not as expected",actualTitle.equals(expectedTitle));

    }

}
