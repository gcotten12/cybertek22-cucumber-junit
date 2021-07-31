package com.cybertek.step_definitions;

import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("user lands on Wikipedia home page")
    public void user_lands_on_wikipedia_home_page() {
        String url = ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(url);
    }

    @When("user types {string} in the search box")
    public void userTypesInTheSearchBox(String arg0) {
        wikiSearchPage.searchBox.sendKeys(arg0);
    }

    @When("clicks the search button")
    public void clicks_the_search_button() {
        wikiSearchPage.searchButton.click();
    }

    @Then("user sees {string} in the wiki title")
    public void userSeesInTheWikiTitle(String arg0) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = arg0 + " - Wikipedia";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("user sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String arg0) {
        String actualHeader = wikiSearchPage.pageHeader.getText();
        // String expectedHeader = arg0;

        Assert.assertEquals(arg0, actualHeader);

    }

    @Then("user sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String arg0) {
        String actualImageHeader = wikiSearchPage.steveJobsImageHeader.getText();

        Assert.assertEquals(arg0, actualImageHeader);
    }
}
