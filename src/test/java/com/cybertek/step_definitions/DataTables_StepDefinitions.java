package com.cybertek.step_definitions;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {

    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {

        System.out.println("listOfFruits.size() = " + listOfFruits.size());
        System.out.println("listOfFruits = " + listOfFruits);

    }

    LibraryLoginPage loginPage = new LibraryLoginPage();

    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {

        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);

    }
    @When("user enters username and password as below")
    public void user_enters_username_and_password_as_below(Map<String, String> loginInfo) {

        loginPage.emailInput.sendKeys(loginInfo.get("username"));
        loginPage.passwordInput.sendKeys(loginInfo.get("password"));
        loginPage.signIn.click();
        BrowserUtils.sleep(3);

    }


    @Then("user should see title is Library")
    public void userShouldSeeTitleIsLibrary() {

        String expected = "Library";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(expected, actual);

    }
}
